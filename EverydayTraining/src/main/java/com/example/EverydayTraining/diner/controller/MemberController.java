package com.example.EverydayTraining.diner.controller;

import com.example.EverydayTraining.diner.DTO.MemberDto;
import com.example.EverydayTraining.diner.DTO.MemberRequest;
import com.example.EverydayTraining.diner.controller.session.UserInfo;
import com.example.EverydayTraining.diner.entity.Member;
import com.example.EverydayTraining.diner.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/member")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@Slf4j
public class MemberController {

    @Autowired
    private MemberService service;

    private UserInfo info;

    private HttpSession session;

    @PostMapping("/register")
    public Object Register(
            @Validated @RequestBody MemberRequest memberRequest) throws Exception {
        log.info("jpaRegister(): " + memberRequest.getUserId() + ", " + memberRequest.getPassword() + ", " +
                (memberRequest.getAuth().equals("사업자") ? "ROLE_BUSINESS" : "ROLE_INDIVIDUAL"));

        boolean checkId = false;
        checkId = service.checkDuplicateId(memberRequest.getUserId());

        if (checkId == true) {
            log.info("success");
            log.info(memberRequest.getUserId());
            service.register(memberRequest);
            return new ResponseEntity<Boolean>(HttpStatus.OK);
        } else {
            log.info("duuplicate");
            log.info(memberRequest.getUserId());
            return false;
        }
    }

    @PostMapping("/login")
    public ResponseEntity<UserInfo> jpaLogin(
            @RequestBody MemberRequest memberRequest,
            HttpServletRequest request
    ) throws Exception {

        log.info("jpaLogin() - userId: " + memberRequest.getUserId() + ", password: " + memberRequest.getPassword());

        MemberRequest memberResponse = service.login(memberRequest);

        if (!memberResponse.equals(null)) {
            log.info("Login Success");
            // 세션 할당
            info = new UserInfo();
            info.setUserId(memberResponse.getUserId());
            info.setAuth(memberResponse.getAuth());
            log.info("Session Info: " + info);

            session = request.getSession();
            session.setAttribute("member", info);
        } else {
            log.info("Login Failure");
            info = null;
        }

        return new ResponseEntity<UserInfo>(info, HttpStatus.OK);
    }

    // --------------------------------------------------------------------------------------------

    // 가입가능한 아이디인지 확인하기
    @PostMapping("/checkId/{userId}")
    public ResponseEntity<Boolean> checkId(@PathVariable("userId") String userId) throws Exception {
        log.info("Check Id");

        Boolean isSuccess = service.checkDuplicateId(userId);

        return new ResponseEntity<>(isSuccess, HttpStatus.OK);
    }

    // 이메일 인증하기
    @PostMapping("/checkEmail/{email}")
    public ResponseEntity<String> checkEmail(@PathVariable("email") String email) throws Exception {
        log.info("Check Email");

        String result = service.checkEmail(email);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // 마이페이지 회원정보 확인 전 비밀번호 확인하기
    @PostMapping("/checkPw")
    public ResponseEntity<Boolean> checkPassword(@RequestBody MemberDto memberDto) throws Exception {
        log.info("Check Password");

        Boolean isSuccess = service.checkPassword(memberDto);

        return new ResponseEntity<Boolean>(isSuccess, HttpStatus.OK);
    }

    // 마이페이지 회원정보 확인하기
    @GetMapping("/mypage/{userId}")
    public ResponseEntity<Optional<Member>> userInfo(@PathVariable("userId") @RequestBody String userId) throws Exception {

        Optional<Member> result = service.userInfo(userId);

        return new ResponseEntity<Optional<Member>>(result, HttpStatus.OK);
    }

    // 마이페이지 회원정보 수정하기
    @PatchMapping("/mypage/modify/{userId}")
    public ResponseEntity<Void> modify(@PathVariable("userId") String userId, @RequestBody MemberDto memberDto) throws Exception {
        Member member = service.findById(userId);

        service.modify(member, memberDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 마이페이지 회원탈퇴 하기
    @DeleteMapping("/mypage/remove/{userId}")
    public ResponseEntity<Void> remove(@PathVariable("userId") String userId) throws Exception {
        Member member = service.findById(userId);

        service.remove(member);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 아이디 찾기
    @PostMapping("/findingUserId")
    public ResponseEntity<String> findId(@RequestBody MemberDto memberDto) throws Exception {
        String userId = service.findingUserId(memberDto);

        return new ResponseEntity<>(userId, HttpStatus.OK);
    }

    // 회원인지 확인하기(비밀번호 재설정 전)
    @PostMapping("/findingUser")
    public ResponseEntity<String> findUser(@RequestBody MemberDto memberDto) throws Exception {
        String findUser = service.findingUser(memberDto);

        return new ResponseEntity<>(findUser, HttpStatus.OK);
    }

    // 비밀번호 재설정하기(비밀번호 찾기)
    @PatchMapping("/modifyPw/{userId}")
    public ResponseEntity<Void> modifyPw(@PathVariable("userId") String userId, @RequestBody MemberDto memberDto) throws Exception {
        Member member = service.findById(userId);

        service.modifyPw(member, memberDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    //회원 목록 출력하기
    @GetMapping("/memberlists")
    public ResponseEntity lists() throws Exception {
        log.info("Member Lists");

        List<Member> members = service.list();

        return new ResponseEntity<>(members, HttpStatus.OK);
    }
    //관리자 회원삭제, 다중삭제
    @DeleteMapping("/remove/{selected}")
    public ResponseEntity<Void> removeMember(@PathVariable("selected") String userId) throws Exception {
        Member member = service.findById(userId);

        service.remove(member);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/pause/{selected}")
    public ResponseEntity<Void> pauseMember(@PathVariable("selected") String userId) throws Exception {
        Member member = service.findById(userId);

        service.pause(member,userId);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping("/host/{selected}")
    public ResponseEntity<Void> hostMember(@PathVariable("selected") String userId) throws Exception {
        service.host(userId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
