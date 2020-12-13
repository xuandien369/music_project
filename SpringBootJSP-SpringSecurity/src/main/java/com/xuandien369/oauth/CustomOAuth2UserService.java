package com.xuandien369.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.xuandien369.entity.AuthenticationProvider;
import com.xuandien369.entity.User;
import com.xuandien369.service.UserService;
@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService{

	@Autowired
	private UserService userService;
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {		
//		OAuth2User ouser = super.loadUser(userRequest);
		CustomOAuth2User x ;
		User userr=null;
		String clientName  = userRequest.getClientRegistration().getClientName();
		String username="";
		AuthenticationProvider authenticationProvider=null;
		if(clientName.equalsIgnoreCase("facebook")) {
			authenticationProvider = authenticationProvider.FACEBOOK;
			userr = userService.getUserByUsernameAndProvider(super.loadUser(userRequest).getAttribute("email"), authenticationProvider);
			username=super.loadUser(userRequest).getAttribute("email");
			
		}else if(clientName.equalsIgnoreCase("github")){
			 authenticationProvider = authenticationProvider.GITHUB;
			 userr = userService.getUserByUsernameAndProvider(super.loadUser(userRequest).getAttribute("login"), authenticationProvider);
				username=super.loadUser(userRequest).getAttribute("login");
		}
		else if(clientName.equalsIgnoreCase("google")){
			 authenticationProvider = authenticationProvider.GOOGLE;
			 userr = userService.getUserByUsernameAndProvider(super.loadUser(userRequest).getAttribute("email"), authenticationProvider);
				username=super.loadUser(userRequest).getAttribute("email");
		}	
		
		if(userr == null) {
			x = new CustomOAuth2User(super.loadUser(userRequest),authenticationProvider);
		}else {
			 x = new CustomOAuth2User(super.loadUser(userRequest),userService.getUserByUsernameAndProvider(username, authenticationProvider),authenticationProvider);
		}
		return x; 
	}

	
}
