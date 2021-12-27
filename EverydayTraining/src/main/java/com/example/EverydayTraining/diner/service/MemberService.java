package com.example.EverydayTraining.diner.service;

import com.example.EverydayTraining.diner.DTO.MemberDto;
import com.example.EverydayTraining.diner.DTO.MemberRequest;
import com.example.EverydayTraining.diner.entity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    public void register(MemberRequest memberRequest) throws Exception;
    public MemberRequest login(MemberRequest memberRequest) throws Exception;
    public boolean checkUserIdValidation(String UserId) throws Exception;
    public boolean checkDuplicateId(String UserId) throws Exception;
    public Optional<Member> findByAuth(Long memberNo);
    public void pause (Member member, String userId) throws Exception;

    // -- 회원정보 확인, 수정, 탈퇴, 아이디찾기, 비밀번호찾기(변경), 이메일 인증 --
    String checkEmail(String email) throws Exception;
    Boolean checkPassword(MemberDto memberDto) throws Exception;
    Optional<Member> userInfo(String userId) throws Exception;
    Member findById(String userId) throws Exception;
    void modify(Member member, MemberDto memberDto) throws Exception;
    void remove(Member member) throws Exception;
    Member findByEmail(String email) throws Exception;
    String findingUserId(MemberDto memberDto) throws Exception;
    String findingUser(MemberDto memberDto) throws Exception;
    void modifyPw(Member member, MemberDto memberDto) throws Exception;
    List<Member> list() throws Exception;
    public void host(String userId) throws Exception;
}
