package com.xuandien369.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ContactController {
	
	@Autowired
	private JavaMailSender mailSender; 
	
	@GetMapping("/contact")
	public String getContact(HttpServletRequest request) {
		return "contact";
	}
	@PostMapping("/contact")
	public String postContact(HttpServletRequest req,
			@RequestParam("attachment") MultipartFile file) throws MessagingException {
		String fullName = req.getParameter("fullname");
		String content = req.getParameter("content");
		String emailne = req.getParameter("emailne");
		
		MimeMessage message = 	mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message,true);
		
		
		String mailSubject = fullName + " Đã gửi tin nhắn cho bạn !!!!!";
		String mailContent = "<p><b>Content:</b> "+content+"</p>";
		mailContent+="<hr><img src='cid:logoImage' />";
		
		helper.setFrom("xuandien369@music.com");
		helper.setTo(emailne);
		helper.setSubject(mailSubject);
		helper.setText(mailContent,true);
		
		ClassPathResource resource = new ClassPathResource("/static/images/liverpool.png");
		helper.addInline("logoImage", resource);
		
		if(!file.isEmpty()) {
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			InputStreamSource source = new InputStreamSource() {
				
				@Override
				public InputStream getInputStream() throws IOException {
					// TODO Auto-generated method stub
					return file.getInputStream();
				}
			};
			helper.addAttachment(fileName, source);
		}
		
		mailSender.send(message);
		return "message";
	}
}
