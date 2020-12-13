package com.xuandien369.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xuandien369.converter.Converter;
import com.xuandien369.entity.MyUserDetails;
import com.xuandien369.oauth.CustomOAuth2User;
import com.xuandien369.service.CategorySongService;
import com.xuandien369.service.SongService;
import com.xuandien369.service.UserService;

@Controller
@RequestMapping("/manage")
public class ManageController {
	@Autowired
	private SongService songService;
	@Autowired
	private CategorySongService categorySongService;
	@Autowired
	private UserService userService;
	
	@GetMapping
	public String manage(Model model){
		model.addAttribute("ListCategory", categorySongService.listAll());
		Integer id = 0;
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	if(!authentication.getName().equalsIgnoreCase("anonymousUser")) {
    		String packagexd = authentication.getPrincipal().getClass().getName();
    		String classxd = packagexd.substring(packagexd.lastIndexOf('.')+1);
    		if(classxd.equalsIgnoreCase("CustomOAuth2User")) {
    			CustomOAuth2User oauth2User = (CustomOAuth2User) authentication.getPrincipal();
    			id = userService.getUserByUsernameAndProvider(oauth2User.getName(),oauth2User.getProvider()).getId();
    		
    		}else if(classxd.equalsIgnoreCase("MyUserDetails")){
    			MyUserDetails oauth2User = (MyUserDetails) authentication.getPrincipal();
    			id = userService.getUserByUsernameAndProvider(oauth2User.getUsername(),oauth2User.getProvider()).getId();
    		}
    		model.addAttribute("idne", id);
    	}
		return "/song/managementpage";
	}

}
