package com.xuandien369.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.xuandien369.dto.SongDTO;
import com.xuandien369.entity.Song;

@Component
public class Converter {
	public SongDTO toDTO(Song songEntity) {
		SongDTO DTO = new SongDTO();
		DTO.setId(songEntity.getId());
		DTO.setName(songEntity.getName());
		DTO.setSinger(songEntity.getSinger());
		DTO.setSourceName(songEntity.getPath());
		DTO.setCategoryName(songEntity.getCategorySong().getName());
		return DTO;
	}
	public List<SongDTO> toListDTO(List<Song> listSongEntity) {
		return listSongEntity.stream().map(p -> toDTO(p)).collect(Collectors.toList());
	}
}
