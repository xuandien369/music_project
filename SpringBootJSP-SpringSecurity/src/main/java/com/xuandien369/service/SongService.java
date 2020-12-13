package com.xuandien369.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.xuandien369.entity.Song;
import com.xuandien369.reponsitory.SongReponsitory;

@Service
@Transactional
public class SongService {
	@Autowired
	private SongReponsitory songRepo;
	
    public List<Song> listAll() {
        return (List<Song>) songRepo.findAll();
    }
    public Song findByID(Integer id) { 
        return songRepo.findById(id).get();
    }
    public void addSong(Song song) { 
    	songRepo.save(song); 
    }
	public  Long countTheNumberOfElements() {
		return songRepo.count();
	}
	public  Page<Song> getAllSongPageable(Pageable pageable){
		return songRepo.findSong(pageable);
	}
}
