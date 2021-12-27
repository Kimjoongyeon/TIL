package com.example.EverydayTraining.diner.service;



import com.example.EverydayTraining.diner.DTO.MemberDto;
import com.example.EverydayTraining.diner.DTO.MemberRequest;
import com.example.EverydayTraining.diner.entity.Member;
import com.example.EverydayTraining.diner.entity.MemberAuth;
import com.example.EverydayTraining.diner.repository.MemberAuthRepository;
import com.example.EverydayTraining.diner.repository.MemberRepository;
import com.example.EverydayTraining.diner.utility.PythonRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@Lazy
@Slf4j
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberRepository repository;

    @Autowired
    private MemberAuthRepository authRepository;

    @Autowired
    private PasswordEncoder encoder;


    @Override
    public void register(MemberRequest memberRequest) throws Exception {
        String encodedPassword = encoder.encode(memberRequest.getPassword());
        memberRequest.setPassword(encodedPassword);

        MemberAuth authEntity = new MemberAuth(memberRequest.getAuth());
        Member memberEntity = new Member(memberRequest.getUserId(), memberRequest.getPassword(), memberRequest.getEmail(),
                memberRequest.getName(),memberRequest.getBirth(), memberRequest.getSex(), memberRequest.getPhone(), memberRequest.getPause());
        memberEntity.addAuth(authEntity);

        repository.save(memberEntity);
    }

    @Override
    public void pause(Member member, String userId) throws Exception {
        if(member.getPause()==0) {
            member.setPause(1);
        }
        else{
            member.setPause(0);
        }
        repository.save(member);
    }
    @Override
    public MemberRequest login(MemberRequest memberRequest) throws Exception {
        Optional<Member> maybeMember = repository.findByUserId(memberRequest.getUserId());

        if (maybeMember == null) {
            log.info("login(): 그런 사람 없다.");
            return null;
        }

        Member loginMember = maybeMember.get();

        if (!encoder.matches(memberRequest.getPassword(), loginMember.getPassword())) {
            log.info("login(): 비밀번호 잘못 입력하였습니다.");
            return null;
        }

        Optional<MemberAuth> maybeMemberAuth =
                authRepository.findByMemberNo(loginMember.getMemberNo());

        if (maybeMemberAuth == null) {
            log.info("auth 없음");
            return null;
        }

        MemberAuth memberAuth = maybeMemberAuth.get();
        MemberRequest response = new MemberRequest(
                memberRequest.getUserId(),
                memberRequest.getPassword(),
                memberAuth.getAuth());

        return response;
    }

    @Override
    public boolean checkUserIdValidation(String userId) throws Exception {
        Optional<Member> maybeMember = repository.findByUserId(userId);

        if (maybeMember == null)
        {
            log.info("login(): 그런 사람 없다.");
            return false;
        }

        return true;
    }

    @Override
    public boolean checkDuplicateId(String userId) throws Exception {
        Optional<Member> checkmember = repository.findByUserId(userId);
        if (checkmember.isPresent()) {
            log.info("가입가능한 아이디입니다");

            return false;
        }
        return true;

    }
    @Override
    public Optional<Member> findByAuth(Long memberNo) {
        return repository.findByAuth(memberNo);
    }


    // -- 회원정보 확인, 수정, 탈퇴, 아이디찾기, 비밀번호찾기(변경) --

    // 가입 시 이메일 인증하기(이미 사용중인지 확인 후 없는 이메일이면 인증 진행)
    @Override
    public String checkEmail(String email) throws Exception {
        Optional<Member> maybeUser = repository.findByEmail(email);

        if (!maybeUser.isPresent()) {
            String code = randomCode();

            String result = new PythonRequest().checkEmail(email, code);
            log.info(result);

            return code;
        }

        return "AlreadyUser";
    }

    // 이메일 인증하기 위한 6자리 랜덤 코드 생성
    private String randomCode() {
        Random random = new Random();
        String code = "";

        for (int i = 0; i < 6; i++) {
            // 0 ~ 9까지의 랜덤 숫자를 String으로
            String randNum = Integer.toString(random.nextInt(10));
            code += randNum;
        }

        return code;
    }

    // 마이페이지에서 회원정보 확인, 변경 전 비밀번호 확인하기
    @Override
    public Boolean checkPassword(MemberDto memberDto) throws Exception {
        Optional<Member> checkMember = repository.findByUserId(memberDto.getUserId());

        String memberPassword = checkMember.get().getPassword();

        if(!encoder.matches(memberDto.getPassword(), memberPassword)) {
            log.info("fail pw");
            return false;
        }

        log.info("success pw");
        return true;
    }

    // 회원정보 불러오기
    @Override
    public Optional<Member> userInfo(String userId) throws Exception {
        return repository.findByUserId(userId);
    }

    // 아이디로 회원 검색하고 없을 시 null 반환
    @Override
    public Member findById(String userId) throws Exception {
        Member member = repository.findByUserId(userId).orElse(null);

        return member;
    }

    // 회원정보 변경하기(비밀번호는 암호화 해서 저장)
    @Override
    public void modify(Member member, MemberDto memberDto) throws Exception {
        String encodedPassword = encoder.encode(memberDto.getPassword());
        memberDto.setPassword(encodedPassword);

        member.modifyMember(memberDto);

        repository.save(member);
    }

    // 회원 탈퇴하기
    @Override
    public void remove(Member member) throws Exception {
        repository.delete(member);
    }

    // 이메일로 회원 검색하고 없을 시 null 반환
    @Override
    public Member findByEmail(String email) throws Exception {
        Member member = repository.findByEmail(email).orElse(null);

        return member;
    }

    // 회원 아이디 찾기
    @Override
    public String findingUserId(MemberDto memberDto) throws Exception {
        String email = memberDto.getEmail();

        Optional<Member> maybeUser = repository.findByEmail(email);

        if (!maybeUser.isPresent()) return "NotFindUser";

        String userId = maybeUser.get().getUserId();

        String result = new PythonRequest().findUserId(userId, email);

        log.info(result);

        return result;
    }

    // 회원 비밀번호 찾기(재설정)
    @Override
    public String findingUser(MemberDto memberDto) throws Exception {
        String email = memberDto.getEmail();

        Optional<Member> maybeUser = repository.findByEmail(email);

        String userId;

        if (!maybeUser.isPresent()) {
            log.info("not find user");
            return "NotFindUser";
        } else {
            userId = maybeUser.get().getUserId();

            if (!userId.equals(memberDto.getUserId())) {
                log.info("not match id");
                return "NotMatchId";
            }
        }

        String result = new PythonRequest().findUserPw(userId, email);

        log.info(result);
        return result;
    }

    // 비밀번호 재설정
    @Override
    public void modifyPw(Member member, MemberDto memberDto) throws Exception {
        String encodedPassword = encoder.encode(memberDto.getPassword());
        memberDto.setPassword(encodedPassword);

        member.modifyPassword(memberDto);

        repository.save(member);
    }

    // 관리자 권한주기
    @Override
    public void host(String userId) throws Exception {
        Member member = repository.findByUserId(userId).orElse(null);

        MemberAuth memberAuth = authRepository.findByMemberNo(member.getMemberNo()).orElse(null);

        memberAuth.setAuth("관리자");

        authRepository.save(memberAuth);
    }

    @Override
    public List<Member> list() throws Exception {
        List<Member> members = repository.findAll();
        return members;
    }
}
