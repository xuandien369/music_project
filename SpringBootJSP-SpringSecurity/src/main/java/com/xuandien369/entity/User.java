package com.xuandien369.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "userxd")
public class User {
	@Id
	@Column(name = "userid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String username;
	
	private String password;
	
	private boolean enabled;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "reset_password_token")
	private String resetPassordToken ;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "auth_provider")
	private AuthenticationProvider authProvider ;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(
				name = "user_role",
				joinColumns = @JoinColumn(name="userid"),
				inverseJoinColumns = @JoinColumn(name="roleid")
			)
	private Set<Role> roles = new HashSet<>();
	
	 @OneToMany(fetch = FetchType.EAGER, mappedBy = "userId")
	 private Set<FavoriteMusic> favoriteMusic = new HashSet<>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public Set<FavoriteMusic> getFavoriteMusic() {
		return favoriteMusic;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getResetPassordToken() {
		return resetPassordToken;
	}
	public void setResetPassordToken(String resetPassordToken) {
		this.resetPassordToken = resetPassordToken;
	}
	public void setFavoriteMusic(Set<FavoriteMusic> favoriteMusic) {
		this.favoriteMusic = favoriteMusic;
	}
	public AuthenticationProvider getAuthProvider() {
		return authProvider;
	}
	public void setAuthProvider(AuthenticationProvider authProvider) {
		this.authProvider = authProvider;
	}
	
	
}
