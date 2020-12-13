package com.xuandien369.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.xuandien369.entity.AuthenticationProvider;
import com.xuandien369.entity.MyUserDetails;
import com.xuandien369.entity.User;
import com.xuandien369.reponsitory.UserReponsitory;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserReponsitory userReponsitory;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userReponsitory.getUserByUsernameAndProvider(username,AuthenticationProvider.LOCAL);
		if(user == null) {
			throw new UsernameNotFoundException("Could not find user");
		}
		return new MyUserDetails(user,AuthenticationProvider.LOCAL);
	}

}
