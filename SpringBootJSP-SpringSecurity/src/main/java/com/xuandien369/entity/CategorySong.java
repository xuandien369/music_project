package com.xuandien369.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categorysong")
public class CategorySong {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "name")
	private String name;
	
//	 @OneToMany(fetch = FetchType.LAZY, mappedBy = "categorySong")
//	 private Set<Song> listEmployee = new HashSet<>();
	
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
//	public Set<Song> getListEmployee() {
//		return listEmployee;
//	}
//	public void setListEmployee(Set<Song> listEmployee) {
//		this.listEmployee = listEmployee;
//	}
}
