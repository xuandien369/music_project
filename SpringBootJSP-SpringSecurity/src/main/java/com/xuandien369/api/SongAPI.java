	package com.xuandien369.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xuandien369.converter.Converter;
import com.xuandien369.dto.SongDTO;
import com.xuandien369.entity.FavoriteMusic;
import com.xuandien369.entity.FavoriteMusicDetails;
import com.xuandien369.service.FMDetailsService;
import com.xuandien369.service.FMService;
import com.xuandien369.service.SongService;

@RestController
@RequestMapping("/api")
public class SongAPI {

	@Autowired
	private SongService songService;
	
	@Autowired
	private FMService fmService;
	
	@Autowired
	private Converter converter;
	
	@Autowired
	private FMDetailsService FMDService;
	
	@GetMapping(value = "/song")
	public List<SongDTO> getAll(){
		
		return converter.toListDTO(songService.listAll());
	}	
	
	@PostMapping(value = "/addfavoritesong/{id}/{songid}")
	public String addFS(@PathVariable("id") Integer id,@PathVariable("songid") Integer songid){
		List<FavoriteMusicDetails> detailsAll =  FMDService.findByFMId(fmService.findByID(id));
		List<String> FMDAllString = detailsAll.stream().map(m->m.getSongId().getName()).collect(Collectors.toList());
		if(!FMDAllString.contains(songService.findByID(songid).getName())) {
			FavoriteMusicDetails details = new FavoriteMusicDetails();
			details.setSongId(songService.findByID(songid));
			details.setFMId(fmService.findByID(id));
			FMDService.AddFMD(details);
			return "Thành công !!!!!";	
		}
		return "Đã tồn tại !!!!!";
	}
	//p.getSongId()
	@GetMapping("/details/{FMid}")
	public List<SongDTO> getByFM(@PathVariable("FMid") Integer FMid,Model model){
		FavoriteMusic favoriteMusicList = fmService.findByID(FMid);
		Set<FavoriteMusicDetails> details = favoriteMusicList.getFavoriteMusicDetails();
		List<FavoriteMusicDetails> detailsList =new ArrayList<FavoriteMusicDetails>(details);
		Collections.sort(detailsList, (x1, x2) -> x1.getId() - x2.getId());
		List<SongDTO> cc = detailsList.stream().map(p -> converter.toDTO(p.getSongId())).collect(Collectors.toList());
		return cc;
	}
}
