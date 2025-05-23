package com.pard.practice_tomorrow.member.repository;

import com.pard.seminar5.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {
    Optional<Member> findByEmail(String email);
}

