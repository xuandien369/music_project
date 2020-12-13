package com.xuandien369.controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xuandien369.UserNotFoundException;
import com.xuandien369.entity.User;
import com.xuandien369.service.UserService;
import com.xuandien369.utils.Utility;

import net.bytebuddy.utility.RandomString;

@Controller
public class ForgotPasswordController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@GetMapping("/forgot_password")
	public String showForgotPassword(Model model) {
		return "forgotpassword";
	}
	@PostMapping("/forgot_password")
	public String processForgotPassword(HttpServletRequest request,Model model) {
		String email = request.getParameter("email");
		String token =  RandomString.make(45);
		
		try {
			userService.updateResetPassword(token, email);
			String resetPasswordLink = Utility.getSiteURL(request)+"/reset_password?token="+token;
			
			sendEmail(email,resetPasswordLink);
		} catch (UserNotFoundException ex) {
			model.addAttribute("message",ex.getMessage());
		} catch (UnsupportedEncodingException |MessagingException ex ) {
			model.addAttribute("message","Error while sending email.");
		}
	
		return "forgotpassword";
	}
	private void sendEmail(String email, String resetPasswordLink) throws UnsupportedEncodingException, MessagingException {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		
		helper.setFrom("xuandien369@music.com","XuanDienMusic Support");
		helper.setTo(email);
		String subject="Here's the link to reset your password";
		String content = "<p>Hello,</p>"
				+"<p>You have requested to reset your password</p>"
				+"<p>Click the link below to change your password: </p>"
				+"<p><b><a href='"+resetPasswordLink+"'>Change my password</a></b></p>"
				+"<p>Ignore this email if you do remember your password,or you have not made the request</p>";
		helper.setText(content,true);
		helper.setSubject(subject);
		mailSender.send(message);
	}
	@GetMapping("/reset_password")
	public String showResetPassWordForm(@RequestParam("token")String token,Model model) {
		User user = userService.getUserToken(token);
		if(user == null) {
			model.addAttribute("message", "Invalid Token");
			return "invalidtoken"; 
		}
		model.addAttribute("token", token);
		return "reset_password_form";
	}
	@PostMapping("/reset_password")
	public String processResetPassWordForm(@RequestParam("token")String token,@RequestParam("password") String password,Model model) {
		User user = userService.getUserToken(token);
		if(user == null) {
			model.addAttribute("message", "Invalid Token");
		}
		else {
			userService.updatePassword(user, password);
			model.addAttribute("message", "You have successfully changed your password");
		}
		return "invalidtoken";
	}
}
