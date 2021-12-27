package com.example.EverydayTraining.diner.repository;

import com.example.EverydayTraining.diner.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("select m from Member m join fetch m.authList where m.memberNo = :memberNo")
    Optional<Member> findByAuth(Long memberNo);

    Optional<Member> findByUserId(String userId);

    Optional<Member> findByEmail(String email);

    @Query("UPDATE Member b set b.pause = :pause where b.userId = :userId")
    void pause(String userId, String pause);

    List<Member> findAll();
}
