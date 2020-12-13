package com.xuandien369.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "favoritemusic")
public class FavoriteMusic {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "userid", nullable = false)
	private User userId;
	
	 @OneToMany(fetch = FetchType.EAGER, mappedBy = "FMId",cascade = CascadeType.ALL)
	 private Set<FavoriteMusicDetails> favoriteMusicDetails = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<FavoriteMusicDetails> getFavoriteMusicDetails() {
		return favoriteMusicDetails;
	}

	public void setFavoriteMusicDetails(Set<FavoriteMusicDetails> favoriteMusicDetails) {
		this.favoriteMusicDetails = favoriteMusicDetails;
	}
	
}
