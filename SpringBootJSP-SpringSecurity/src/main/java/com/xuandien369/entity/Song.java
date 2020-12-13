package com.xuandien369.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "song")
public class Song {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "singer")
	private String singer;
	
	@Column(name = "path")
	private String path;
	
	@ManyToOne
	@JoinColumn(name = "categorysongID", nullable = false)
	private CategorySong categorySong;
	
	public Song() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public CategorySong getCategorySong() {
		return categorySong;
	}

	public void setCategorySong(CategorySong categorySong) {
		this.categorySong = categorySong;
	}
	
	
}
