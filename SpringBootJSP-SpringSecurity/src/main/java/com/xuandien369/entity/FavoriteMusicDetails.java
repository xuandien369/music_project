package com.xuandien369.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "favoritemusicdetails")
public class FavoriteMusicDetails {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FMid", nullable = false)
	private FavoriteMusic FMId;
	
	@OneToOne
	 @JoinColumn(name = "Songid", nullable = false)
	 private Song songId;

	public Integer getId() {
		return id;
	}

	public FavoriteMusic getFMId() {
		return FMId;
	}

	public Song getSongId() {
		return songId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setFMId(FavoriteMusic fMId) {
		FMId = fMId;
	}

	public void setSongId(Song songId) {
		this.songId = songId;
	}
	
}
