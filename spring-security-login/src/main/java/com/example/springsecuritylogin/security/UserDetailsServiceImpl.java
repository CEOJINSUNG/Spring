package com.example.springsecuritylogin.security;

import com.example.springsecuritylogin.model.Member;
import com.example.springsecuritylogin.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findById(username)
            .orElseThrow(() -> new UsernameNotFoundException("등록되지 않은 사용자 입니다."));
        return new UserDetailsImpl(member);
    }
}
