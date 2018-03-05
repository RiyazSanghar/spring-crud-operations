package com.jpa.config;

import com.jpa.service.CustomUserDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableJpaRepositories(basePackages = "com.jpa.repository")
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private final Logger logger = LoggerFactory.getLogger(SecurityConfiguration.class);


	@Autowired
	private CustomUserDetailService userDatailsService;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		logger.info("Inside Security Configurer Method Authentication Builder");
		auth
				.userDetailsService(userDatailsService)
				.passwordEncoder(getPasswordEncoder());

	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {

		logger.info("Inside Security Configurer Method HTTP Security");

		httpSecurity
				.authorizeRequests()
				.anyRequest()
				.fullyAuthenticated()
				.and()
				.httpBasic()
				.and()
				.csrf()
				.disable();


	}

	private PasswordEncoder getPasswordEncoder()
	{

		logger.info("Inside Password Encoder");
		return new PasswordEncoder() {
			@Override
			public String encode(CharSequence charSequence) {
				return (charSequence.toString());
			}

			@Override
			public boolean matches(CharSequence charSequence, String s) {
				return true;
			}
		};
	}


	/*@Bean
	public CustomFilter customFilter()
	{
		return new CustomFilter();
	}*/
}
