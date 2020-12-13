package com.xuandien369.reponsitory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.xuandien369.entity.Song;

public interface SongReponsitory extends CrudRepository<Song, Integer> {
	@Query("SELECT s FROM Song s ")
	public  Page<Song> findSong(Pageable pageable);
}
