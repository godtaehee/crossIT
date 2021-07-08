package com.crossit.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.sql.DataSource;


@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


	@Autowired
	DataSource dataSource;


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

		http.logout()
			.logoutUrl("/user/logout")
			.logoutSuccessUrl("/")
			.invalidateHttpSession(true);
	}

	@Bean
	public AuthenticationSuccessHandler successHandler() {
		return new CustomLoginSuccessHandler();
	}


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.jdbcAuthentication()
			.dataSource(dataSource)
			// 사용자 정보를 가져오기
			.usersByUsernameQuery("select nickname id , password, 1 enabled from member where nickname =?")
			// 그 사용자의 역할 정보를 가져오기
			.authoritiesByUsernameQuery("select nickname id, 'ROLE_USER' roleId from member where nickname =?");

	}

}
