package com.jpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@EnableJpaRepositories
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
				.withUser("anand").password("anand123").roles("USER")
				.and().withUser("prachi").password("anand123").roles("ADMIN");

	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
				.authorizeRequests()
				.anyRequest()
				.fullyAuthenticated()
				.and()
				//.addFilterBefore(customFilter(), BasicAuthenticationFilter.class)
				//.fullyAuthenticated()
				.httpBasic();
		httpSecurity.csrf().disable();
	}


	@Bean
	public CustomFilter customFilter()
	{
		return new CustomFilter();
	}
}
