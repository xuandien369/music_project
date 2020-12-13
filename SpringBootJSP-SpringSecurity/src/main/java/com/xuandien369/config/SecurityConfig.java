package com.xuandien369.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.xuandien369.oauth.CustomOAuth2UserService;
import com.xuandien369.oauth.OAuth2LoginSuccessHandler;
import com.xuandien369.service.UserDetailsServiceImpl;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
		@Autowired
		private CustomOAuth2UserService oauth2UserService;
		@Autowired
		private OAuth2LoginSuccessHandler oauth2Handler;
	
	  	@Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	        return bCryptPasswordEncoder;
	    }
	  	
	  	@Bean
	  	public UserDetailsService detailsService() {
	  		return new UserDetailsServiceImpl();
	  	}
	  	@Bean
	  	public DaoAuthenticationProvider authenticationProvider() {
	  		DaoAuthenticationProvider DaoAuthenticationProvider = new DaoAuthenticationProvider();
	  		DaoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
	  		DaoAuthenticationProvider.setUserDetailsService(detailsService());
	  		return DaoAuthenticationProvider;
	  	}

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.authenticationProvider(authenticationProvider());
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {

				http.authorizeRequests()
					.antMatchers("/oauth2/**","/","home","/login2","/api/**","/contact/**","/forgot_password/**","/reset_password","/song/**","/MusicStorage/**").permitAll()
					.antMatchers("/user/**").hasAnyAuthority("ADMIN","USER")
					.antMatchers("/admin/**","/manage").hasAnyAuthority("ADMIN")
					.anyRequest().authenticated()
					.and()
					.formLogin()
					.loginProcessingUrl("/JSSLogin")
					.loginPage("/login")
					// .defaultSuccessUrl("/user",true) true co nghia la sau khi dang nhap thanh cong se luon luon vao url nay
					.defaultSuccessUrl("/",true)
					.failureUrl("/login?message=error")
			        .usernameParameter("username")
			        .passwordParameter("password")
			        .permitAll()
			        .and()
			        .oauth2Login()
			        	.loginPage("/login")
			        	.userInfoEndpoint().userService(oauth2UserService)
			        	.and()
			        	.successHandler(oauth2Handler)
					.and()
					.logout()
					.logoutUrl("/j_spring_security_logout")
					.logoutSuccessUrl("/login?message=logout")
					.permitAll()
					.and() 
					.exceptionHandling().accessDeniedPage("/403")
					.and()
					.rememberMe().key("xuandien369").tokenValiditySeconds(1*24*60*60).userDetailsService(detailsService())
					.and()
					.csrf().disable()
					;				
		}
	
	 @Override public void configure(WebSecurity web) throws Exception 
	 { 
		 web.ignoring() .antMatchers("/resources/**");	
	 }  	
}
