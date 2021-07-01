package com.crossit.configuration;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{


	@Autowired
	DataSource dataSource;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers("/admin/**").hasAnyRole("USER")
				.and()
				.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/login")
				.successHandler(successHandler())
				.and()
				.csrf()
				.disable();
	}

	@Bean
	public AuthenticationSuccessHandler successHandler(){
		System.out.println("---------------------------------??--------------------");
		return new CustomLoginSuccessHandler();
	}


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
				.jdbcAuthentication()
				.dataSource(dataSource)
				.passwordEncoder(passwordEncoder())
				// 사용자 정보를 가져오기
				.usersByUsernameQuery("select nickname id , password, 1 enabled from member where nickname =?")
				// 그 사용자의 역할 정보를 가져오기
				.authoritiesByUsernameQuery("select nickname id, 'ROLE_USER' roleId from member where nickname =?");

	}
}
