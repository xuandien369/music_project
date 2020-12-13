package com.xuandien369.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.xuandien369.UserNotFoundException;
import com.xuandien369.entity.AuthenticationProvider;
import com.xuandien369.entity.User;
import com.xuandien369.reponsitory.UserReponsitory;

@Service
@Transactional
public class UserService {
	@Autowired
	private UserReponsitory userReponsitory;
	
	public User findByID(Integer id) {
		User x = userReponsitory.findById(id).get();
		return x;
	}
	
	public void updateResetPassword(String token,String email) throws UserNotFoundException {
		User user = userReponsitory.findByEmail(email);
		if(user!=null) {
			user.setResetPassordToken(token);
			userReponsitory.save(user);
		}else {
			throw new UserNotFoundException("Could not find any user with email "+email);
		}
	}
	
	public User getUserToken(String resetPasswordToken) {
		return userReponsitory.findByResetPassordToken(resetPasswordToken);
	}
	
	public void updatePassword(User user,String newPassword) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();	
		String endcodedPassword = bCryptPasswordEncoder.encode(newPassword);
		user.setPassword(endcodedPassword);
		user.setResetPassordToken(null);
		userReponsitory.save(user);
	}
	
	public User getUserByUsername(String username) {
		return userReponsitory.getUserByUsername(username);
	}
	public User getUserByUsernameAndProvider(String username, AuthenticationProvider provider) {
		return userReponsitory.getUserByUsernameAndProvider(username, provider);
	}

	public void registerNewUserAfterOAuthLoginSuccess(String loginname,AuthenticationProvider provider) {
		User user = new User();
		user.setUsername(loginname);
		user.setEnabled(true);
		user.setAuthProvider(provider);
		userReponsitory.save(user);
	}
}
