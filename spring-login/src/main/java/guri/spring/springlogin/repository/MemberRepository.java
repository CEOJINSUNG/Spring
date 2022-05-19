package guri.spring.springlogin.repository;

import guri.spring.springlogin.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}