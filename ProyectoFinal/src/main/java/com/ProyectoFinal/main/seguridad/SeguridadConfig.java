package com.ProyectoFinal.main.seguridad;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SeguridadConfig extends WebSecurityConfigurerAdapter{
	
	
	private final UserDetailsService userDetailsService;
	private final CustomSuccessHandler customSuccessHandler;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// @formatter:off
		
		http
			.authorizeRequests()
				.antMatchers("/css/**", "/js/**","/Img/**","/Jquery/**", "/", "/Public/**", "/h2-console/**").permitAll()
				.antMatchers(HttpMethod.POST,"/login").permitAll()
				.antMatchers("/Admin/**").hasRole("ADMIN")
				.antMatchers("/User/**").hasRole("USER")
				//.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/User/")
				.loginProcessingUrl("/login").permitAll()
				.successHandler(customSuccessHandler)
				.permitAll()
				.and()
			.logout()
				.logoutUrl("/logout")
				.permitAll();
	
		
		http.csrf().disable();
		http.headers().frameOptions().disable();
	
	}

}
