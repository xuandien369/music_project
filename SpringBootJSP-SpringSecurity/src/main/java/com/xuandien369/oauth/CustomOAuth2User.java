package com.xuandien369.oauth;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.xuandien369.entity.AuthenticationProvider;
import com.xuandien369.entity.User;

public class CustomOAuth2User implements OAuth2User{

	private OAuth2User user;
	private User localUser;
	private AuthenticationProvider provider;
	
	public CustomOAuth2User(OAuth2User user,User localuser,AuthenticationProvider providerr) {
		this.user = user;
		this.localUser = localuser;
		this.provider = providerr;
	}
	public CustomOAuth2User(OAuth2User user,AuthenticationProvider providerr) {
		this.user = user;
		this.provider = providerr;
	}
	
	public AuthenticationProvider getProvider() {
		return provider;
	}
	public void setProvider(AuthenticationProvider provider) {
		this.provider = provider;
	}
	public OAuth2User getUser() {
		return user;
	}


	public void setUser(OAuth2User user) {
		this.user = user;
	}



	public User getLocalUser() {
		return localUser;
	}


	public void setLocalUser(User localUser) {
		this.localUser = localUser;
	}


	@Override
	public Map<String, Object> getAttributes() {
		
		return user.getAttributes();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return user.getAuthorities();
	}
	//GITHUB,FACEBOOK
	@Override
	public String getName() {
		String name="";
		if(provider.equals(AuthenticationProvider.FACEBOOK)||provider.equals(AuthenticationProvider.GOOGLE) ) {
			name = user.getAttribute("email");
		}else if(provider.equals(AuthenticationProvider.GITHUB)) {
			name = user.getAttribute("login");
		}
		return name;
	}	
	
	//GITHUB
	public String getLogin() {	
		return user.getAttribute("login");
	}
	//FACEBOOK
	public String getEmail() {	
		return user.getAttribute("email");
	}
	//GITHUB,FACEBOOK
	public String getUsername() {	
		return user.getAttribute("name");
	}
}
