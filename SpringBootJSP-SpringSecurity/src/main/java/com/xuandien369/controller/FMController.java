package com.xuandien369.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xuandien369.entity.FavoriteMusic;
import com.xuandien369.entity.MyUserDetails;
import com.xuandien369.oauth.CustomOAuth2User;
import com.xuandien369.service.FMService;
import com.xuandien369.service.UserService;
import com.xuandien369.utils.SecurityUtils;

@Controller
@RequestMapping("/favoritesong")
public class FMController {
				
		@Autowired
		private FMService fmService;
		
		@Autowired
		private UserService userService;
		@Autowired
		private SecurityUtils securityUtils;
		
		@GetMapping("/{userid}")
		public String getAll(@PathVariable("userid") Integer userid,Model model){
			List<FavoriteMusic>  x = fmService.findByUserID(userService.findByID(userid));
			Integer id = 0;
			model.addAttribute("favoritesListSong", x);
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
	    		model.addAttribute("idne",id);
	    	}
			return "/song/favoritesong";
		}
		@PostMapping("/add")
		public String addFMS(@RequestParam("fmname") String fmname){
			 Integer id = 0;
			List<FavoriteMusic> FMAll = fmService.findAll();
			List<String> FMAllString = FMAll.stream().map(m->m.getName()).collect(Collectors.toList());
			if(!FMAllString.contains(fmname)) {
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
					  FavoriteMusic FM = new FavoriteMusic();
					  FM.setName(fmname);
					  FM.setUserId(userService.findByID(id));
					  fmService.addFM(FM);	
		    	}
			}else {
				System.out.println("Tên đã tồn tại!");
				
			}
			return "redirect:/favoritesong/"+id;
		}
		@GetMapping("/delete/{FMid}")
		@ResponseBody
		public String deleteFMS(@PathVariable("FMid") Integer FMid){
			fmService.deleteFM(fmService.findByID(FMid));
//			return "redirect:/favoritesong/"+SecurityUtils.getPrincipal().getId();
			return "Success";
		}
		
		@GetMapping("/details/{FMid}")
		public String getByFM(@PathVariable("FMid") Integer FMid,Model model){
			Integer id = 0;
			model.addAttribute("FMid", FMid);
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
			return "/song/favoritesongdetails";
		}
}
