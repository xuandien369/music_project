package com.xuandien369.oauth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.xuandien369.entity.AuthenticationProvider;
import com.xuandien369.entity.User;
import com.xuandien369.service.UserService;

@Component
public class OAuth2LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	@Autowired
	private UserService userService;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
		Authentication authentication) throws IOException, ServletException {
		CustomOAuth2User oauth2User = (CustomOAuth2User) authentication.getPrincipal();
		if(oauth2User.getProvider().equals(AuthenticationProvider.GITHUB)) {
			String loginName = oauth2User.getLogin();
			User user = userService.getUserByUsernameAndProvider(loginName, AuthenticationProvider.GITHUB);
			if(user == null) {
				userService.registerNewUserAfterOAuthLoginSuccess(loginName,AuthenticationProvider.GITHUB);
			}
		}else if(oauth2User.getProvider().equals(AuthenticationProvider.FACEBOOK)) {
			String Email = oauth2User.getEmail();
			User user = userService.getUserByUsernameAndProvider(Email,AuthenticationProvider.FACEBOOK);
			if(user == null) {
				userService.registerNewUserAfterOAuthLoginSuccess(Email,AuthenticationProvider.FACEBOOK);
			}
		}else if(oauth2User.getProvider().equals(AuthenticationProvider.GOOGLE)) {
			String Email = oauth2User.getEmail();
			User user = userService.getUserByUsernameAndProvider(Email, AuthenticationProvider.GOOGLE);
			if(user == null) {
				userService.registerNewUserAfterOAuthLoginSuccess(Email,AuthenticationProvider.GOOGLE);
			}
		}
		super.onAuthenticationSuccess(request, response, authentication);
	}

		

}
