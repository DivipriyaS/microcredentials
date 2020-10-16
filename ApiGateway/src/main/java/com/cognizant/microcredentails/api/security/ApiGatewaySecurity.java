package com.cognizant.microcredentails.api.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ApiGatewaySecurity extends WebSecurityConfigurerAdapter {

	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}userkey").roles("USER")
                .and()
                .withUser("admin").password("{noop}adminkey").roles("USER", "ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        	http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/premiumService/**").hasRole("USER")
				.antMatchers(HttpMethod.POST, "/api/claimService/**").hasRole("USER")
                .and()
                .csrf().disable()
                .formLogin().disable();
        
    }
}
