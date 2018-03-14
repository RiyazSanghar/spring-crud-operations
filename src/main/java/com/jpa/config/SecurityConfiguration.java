package com.jpa.config;

import com.jpa.security.JwtAuthenticationEntryPoint;
import com.jpa.security.JwtAuthenticationProvider;
import com.jpa.security.JwtAuthenticationTokenFilter;
import com.jpa.security.JwtSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import java.util.Collections;


@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


	@Autowired
	private JwtAuthenticationProvider authenticationProvider;

	@Autowired
	private JwtAuthenticationEntryPoint entryPoint;

	@Bean
	public AuthenticationManager authenticationManager()
	{
		return new ProviderManager(Collections.singletonList(authenticationProvider));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.csrf().disable();
		http
				.authorizeRequests().antMatchers("/token/**").permitAll()
				.and()
				.authorizeRequests()
				.anyRequest().fullyAuthenticated()
				.and()
				.exceptionHandling().authenticationEntryPoint(entryPoint)
				.and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http
				.addFilterBefore(authenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);

		http.headers().cacheControl();

	}

	@Bean
	public JwtAuthenticationTokenFilter authenticationTokenFilter()
	{
		JwtAuthenticationTokenFilter filter= new JwtAuthenticationTokenFilter();
		filter.setAuthenticationManager(authenticationManager());
		filter.setAuthenticationSuccessHandler(new JwtSuccessHandler());
		return  filter;
	}
}
