package com.example.springjpaauditing;

import com.example.springjpaauditing.audit.AuditorAwareImpl;
import com.example.springjpaauditing.repository.UserRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class SpringJpaAuditingApplication {


	@Bean
	public AuditorAware<String> auditorAware() {
		return new AuditorAwareImpl();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaAuditingApplication.class, args);
	}

}
