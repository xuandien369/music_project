package com.xuandien369;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
	public static void main(String[] args) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String rawPassword = "113";
		String endcodePassword = bCryptPasswordEncoder.encode(rawPassword);
		System.out.println(endcodePassword);
	}

}
