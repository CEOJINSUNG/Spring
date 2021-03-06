package guri.spring.springlogin.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity // 기본적인 Web 보안 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests() // HttpServletRequest를 사용하는 요청들에 대한 접근제한을 설정
            .antMatchers("/api/hello") // /api/hello 에 대한 요청은 인증없이 접근을 허용
            .permitAll()
            .anyRequest()
            .authenticated(); // 나머지 요청들은 모두 인증되어야 함
    }
}
