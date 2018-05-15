package com.csinfotechbd.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private CustomAuthenticationProvider authProvider;
	
	@Autowired
	private CustomAccessDeniedHandler accessDeniedHandler;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.authorizeRequests().antMatchers("/resources/admin/**").permitAll();
		
		//http.authorizeRequests().antMatchers("/resources/static/**").permitAll();
		//http.authorizeRequests().antMatchers("/admin/access-denied").permitAll();
		//http.authorizeRequests().antMatchers("/admin").hasAuthority("ADMIN").anyRequest().authenticated().and().exceptionHandling().accessDeniedHandler(accessDeniedHandler);
		http.authorizeRequests().antMatchers("/**").permitAll();
	}

	/*@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("")
	}
	*/
	


}
