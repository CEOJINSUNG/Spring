package com.example.springsecuritylogin.service;

import com.example.springsecuritylogin.model.JwtRequestDto;
import com.example.springsecuritylogin.model.JwtResponseDto;
import com.example.springsecuritylogin.model.Member;
import com.example.springsecuritylogin.model.MemberSignupRequestDto;
import com.example.springsecuritylogin.repository.MemberRepository;
import com.example.springsecuritylogin.security.JwtTokenProvider;
import com.example.springsecuritylogin.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    public JwtResponseDto login(JwtRequestDto request) throws Exception {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        return createJwtToken(authentication);
    }

    public JwtResponseDto createJwtToken(Authentication authentication) {
        UserDetailsImpl principal = (UserDetailsImpl) authentication.getPrincipal();
        String token = jwtTokenProvider.generateToken(principal);
        return new JwtResponseDto(token);
    }

    public String signup(MemberSignupRequestDto request) {
        boolean existMember = memberRepository.existsById(request.getEmail());

        // 이미 회원이 존재하는 경우
        if (existMember) return null;

        Member member = new Member(request);
        member.encryptPassword(passwordEncoder);

        memberRepository.save(member);
        return member.getEmail();
    }

//    public String login(JwtRequestDto request) throws Exception {
//        Authentication authentication = authenticationManager.authenticate(
//            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
//        );
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        UserDetailsImpl principal = (UserDetailsImpl) authentication.getPrincipal();
//        return principal.getUsername();
//    }

}
