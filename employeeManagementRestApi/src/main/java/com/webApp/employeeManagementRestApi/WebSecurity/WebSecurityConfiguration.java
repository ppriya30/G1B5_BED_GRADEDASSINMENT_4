package com.webApp.employeeManagementRestApi.WebSecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.webApp.employeeManagementRestApi.Service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(myAuthenticationProvider());
	}

	@Bean
	public DaoAuthenticationProvider myAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailService());
		provider.setPasswordEncoder(passwordEncoder());

		return provider;
	}

	@Bean
	public UserDetailsService userDetailService() {
		return new UserDetailsServiceImpl();

	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/Employee/addrole", "/Employee/adduser").permitAll()
				.antMatchers("/Employee/list", "/Employee/employeeById", "/Employee/update", "/Employee/delete",
						"/Employee/sortByFirstName", "/Employee/getfirstNameList")
				.hasAnyAuthority("USER", "ADMIN").antMatchers("/Employee/addemployee").hasAuthority("ADMIN")
				.anyRequest().authenticated().and().httpBasic().and().cors().and().csrf().disable();
	}

}
