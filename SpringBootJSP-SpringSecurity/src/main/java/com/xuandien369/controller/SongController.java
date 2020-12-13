package com.xuandien369.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.xuandien369.converter.Converter;
import com.xuandien369.dto.SongDTO;
import com.xuandien369.entity.CategorySong;
import com.xuandien369.entity.MyUserDetails;
import com.xuandien369.entity.Song;
import com.xuandien369.oauth.CustomOAuth2User;
import com.xuandien369.service.CategorySongService;
import com.xuandien369.service.SongService;
import com.xuandien369.service.UserService;
import com.xuandien369.utils.SecurityUtils;

@Controller
@RequestMapping("/song")
public class SongController {
	@Autowired
	private SongService songService;
	@Autowired
	private Converter converter;
	@Autowired
	private CategorySongService categorySongService;
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/{id}")
	public String getByID(@PathVariable("id") Integer id,Model model){
		SongDTO x = converter.toDTO(songService.findByID(id));
		Integer iduser=0;
		model.addAttribute("SongModel", x);
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	if(!authentication.getName().equalsIgnoreCase("anonymousUser")) {
    		String packagexd = authentication.getPrincipal().getClass().getName();
    		String classxd = packagexd.substring(packagexd.lastIndexOf('.')+1);
    		if(classxd.equalsIgnoreCase("CustomOAuth2User")) {
    			CustomOAuth2User oauth2User = (CustomOAuth2User) authentication.getPrincipal();
    			iduser = userService.getUserByUsernameAndProvider(oauth2User.getName(),oauth2User.getProvider()).getId();
    		
    		}else if(classxd.equalsIgnoreCase("MyUserDetails")){
    			MyUserDetails oauth2User = (MyUserDetails) authentication.getPrincipal();
    			iduser = userService.getUserByUsernameAndProvider(oauth2User.getUsername(),oauth2User.getProvider()).getId();
    		}
    		model.addAttribute("idne", iduser);
    	}
		return "/song/songdetails";
	}		
	
	@PostMapping(value = "/addSong")
	public String addSong(Model model, @ModelAttribute Song song,@RequestParam("categorySongID") 
	Integer categorySongID,@RequestParam("fileMusic") MultipartFile fileMusic){	
		CategorySong categorySong = categorySongService.findByID(categorySongID);
		song.setCategorySong(categorySong);
		String nameCleanPath = StringUtils.cleanPath(fileMusic.getOriginalFilename());
		song.setPath(nameCleanPath);
		songService.addSong(song);
		String uploadDir ="./MusicStorage";
		
		Path uploadPath = Paths.get(uploadDir);
		try {
			if(!Files.exists(uploadPath)) {
				Files.createDirectories(uploadPath);
			}
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		
		try(InputStream inputStream = fileMusic.getInputStream()) {
			Path filePath = uploadPath.resolve(nameCleanPath);
			System.out.println(filePath.toFile().getAbsolutePath());
			Files.copy(inputStream, filePath,StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
//			throw new IOException("Could not save uploaded file: " +nameCleanPath);
			e.printStackTrace();
		}	
		return "redirect:/manage";
	}
}
