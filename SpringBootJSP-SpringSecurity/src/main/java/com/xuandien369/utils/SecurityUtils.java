package com.xuandien369.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.xuandien369.entity.User;
import com.xuandien369.service.UserService;

@Component
public class SecurityUtils {
		@Autowired
		private UserService userService;
		
		 public Integer getCurrentUserID(String name) {
			User findUser = userService.getUserByUsername(name);
		return findUser.getId();
	}
}
