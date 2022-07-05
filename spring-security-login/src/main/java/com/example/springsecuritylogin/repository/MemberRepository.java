package com.example.springsecuritylogin.repository;

import com.example.springsecuritylogin.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
}
