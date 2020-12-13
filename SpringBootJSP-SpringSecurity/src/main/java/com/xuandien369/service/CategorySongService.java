package com.xuandien369.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuandien369.entity.CategorySong;
import com.xuandien369.entity.Song;
import com.xuandien369.reponsitory.CategorySongReponsitory;
import com.xuandien369.reponsitory.SongReponsitory;

@Service
@Transactional
public class CategorySongService {
	@Autowired
	private CategorySongReponsitory categorySongRepo;
	
    public List<CategorySong> listAll() {
        return (List<CategorySong>) categorySongRepo.findAll();
    }
    public CategorySong findByID(Integer id) {
        return categorySongRepo.findById(id).get();
    }
}
