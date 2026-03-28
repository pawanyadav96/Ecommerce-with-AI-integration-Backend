package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
//By doing that we are saying dont go for the default flow 


//Spring 6 all is spring 6
public class SecurityConfig {
	@Autowired
	private UserDetailsService userdetailservice;
	@Bean
	public SecurityFilterChain securityfilterchain (HttpSecurity http)
	{
		
		http.csrf(customizer ->customizer.disable());
		http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
		
//		http.formLogin(Customizer.withDefaults());
//		To allow postman , if not we will get the html form in postman
		http.httpBasic(Customizer.withDefaults());
		http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		return http.build();
	}
	
//	@Bean
//	public UserDetailsService userDetailsService()
//	{
//		UserDetails user1= User
//				.withDefaultPasswordEncoder()
//				.username("renu")
//				.password("renu")
//				.roles("USER")
//				.build();
//		UserDetails user2= User
//				.withDefaultPasswordEncoder()
//				.username("shilpi")
//				.password("shilpi")
//				.roles("ADMIN")
//				.build();
//		UserDetails user3= User
//				.withDefaultPasswordEncoder()
//				.username("sonali")
//				.password("sonali")
//				.roles("USER")
//				.build();
//		
//		return new InMemoryUserDetailsManager(user1,user2,user3);
//	}
	
	
//	To use database for user pass word and name 
	
	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userdetailservice);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return provider;
	}

}
