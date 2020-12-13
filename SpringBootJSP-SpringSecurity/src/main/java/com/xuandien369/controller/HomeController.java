package com.xuandien369.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.xuandien369.converter.Converter;
import com.xuandien369.dto.SongDTO;
import com.xuandien369.entity.FavoriteMusic;
import com.xuandien369.entity.MyUserDetails;
import com.xuandien369.entity.Song;
import com.xuandien369.entity.User;
import com.xuandien369.oauth.CustomOAuth2User;
import com.xuandien369.service.FMDetailsService;
import com.xuandien369.service.FMService;
import com.xuandien369.service.SongService;
import com.xuandien369.service.UserService;
import com.xuandien369.utils.SecurityUtils;

@Controller
public class HomeController {
	
	@Autowired
	private Converter converter;
	@Autowired
	private SongService songService;
	@Autowired
	private FMService fmService;
	
	@Autowired
	private FMDetailsService FMDService;
	
	@Autowired
	private UserService userService;
	
    @RequestMapping(value = { "/home" })
    public String Home() {
       return "home";
    }
	@GetMapping(value = {"/","/allsongs"})
	public String getAll(Model model,
			@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
			@RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
			@RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
			@RequestParam(name = "currentPage", required = false, defaultValue = "1") Integer currentPage){
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
    		model.addAttribute("idne",id);
    		List<FavoriteMusic>  currentUserFMList = fmService.findByUserID(userService.findByID(id));
    		model.addAttribute("currentUserFMList", currentUserFMList);
    		model.addAttribute("favoritesListSong", id);
    	}
		if (page > 0) {
			currentPage = page + 1;
		}
		Sort sortable = null;
		if (sort.equals("ASC")) {
			sortable = Sort.by("id").ascending();
		}
		if (sort.equals("DESC")) {
			sortable = Sort.by("id").descending();
		}
		Pageable pageable = PageRequest.of(page,size, sortable);
		Page<Song> songPage  = songService.getAllSongPageable(pageable);
		model.addAttribute("totalPage", songPage.getTotalPages());
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("ListSong", converter.toListDTO(songPage.getContent()));

		return "/song/songhome";
	}
    
    @RequestMapping("/login")
    public String login(@RequestParam(value = "message", required = false) final String message,Model model) {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	if(authentication == null || authentication instanceof AnonymousAuthenticationToken ) {
        	if(message !=null) {
            	if(message.equalsIgnoreCase("error")) {
            		model.addAttribute("message", "Username or password invalid!");
            	}
            	else if(message.equalsIgnoreCase("logout")) {
            		model.addAttribute("message", "Logout success!");
            	}
        	}
    		 return "login";
    	}
      return "redirect:/";
    }
    @RequestMapping("/403")
    public String bonkhongba() {
    	
    	return"/403";
    }
}
