package com.xuandien369.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.xuandien369.entity.FavoriteMusic;
import com.xuandien369.entity.FavoriteMusicDetails;
import com.xuandien369.reponsitory.FMDetailsReponsitory;

@Service
@Transactional
public class FMDetailsService {
	@Autowired
	private FMDetailsReponsitory reponsitory;
	
	public void AddFMD(FavoriteMusicDetails entity) {
		reponsitory.save(entity);
	}
	public List<FavoriteMusicDetails> findByFMId(FavoriteMusic FMId){
		return reponsitory.findByFMId(FMId);
	}
}
