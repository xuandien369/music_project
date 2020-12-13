package com.xuandien369.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.xuandien369.entity.FavoriteMusic;
import com.xuandien369.entity.User;

public interface FMReponsitory extends JpaRepository<FavoriteMusic, Integer>{
	
	@Query("SELECT e FROM FavoriteMusic e WHERE e.userId = :userid")
	 List<FavoriteMusic> findByUserId(@Param("userid") User userid);

}
