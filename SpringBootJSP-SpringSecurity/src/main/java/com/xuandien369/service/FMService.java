package com.xuandien369.service;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuandien369.entity.FavoriteMusic;
import com.xuandien369.entity.User;
import com.xuandien369.reponsitory.FMReponsitory;

@Service
@Transactional
public class FMService {
	@Autowired
	private FMReponsitory fmReponsitory;
	
    public List<FavoriteMusic> findByUserID(User userid) { 
    	
    	List<FavoriteMusic>  x = fmReponsitory.findByUserId(userid);
        return fmReponsitory.findByUserId(userid);
    }
    public void addFM(FavoriteMusic favoriteMusic) { 
    		fmReponsitory.save(favoriteMusic);
    }
    public void deleteFM(FavoriteMusic favoriteMusic) { 
		fmReponsitory.delete(favoriteMusic);
    }
    public FavoriteMusic findByID(Integer id) {    		
    	return fmReponsitory.findById(id).get();
    }
    public List<FavoriteMusic> findAll() {    		
    	return fmReponsitory.findAll();
    }
}
