package com.xuandien369.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.xuandien369.entity.FavoriteMusic;
import com.xuandien369.entity.FavoriteMusicDetails;

public interface FMDetailsReponsitory extends JpaRepository<FavoriteMusicDetails, Integer>{
	
	@Query("SELECT e FROM FavoriteMusicDetails e WHERE e.FMId = :FMId")
	 List<FavoriteMusicDetails> findByFMId(@Param("FMId") FavoriteMusic FMId);
}
