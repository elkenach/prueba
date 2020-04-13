package com.generation20.proyectofinal.molde;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "sport")
public class Sport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 30, nullable = false)
	private String name;
	@Column(length = 512, nullable = false)
	private String description;
	@Column(length = 255, nullable = false)
	private String photo;
	private boolean visibility;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	@OneToMany(targetEntity = UserSport.class, cascade = CascadeType.ALL,
			fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "idSport", referencedColumnName = "id")
	private List<UserSport> userSport;
	
	public Sport() {}

	
	public Sport(Integer id, String name, String description, String photo, boolean visibility,
			Date createdAt, List<UserSport> userSport) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.photo = photo;
		this.visibility = visibility;
		this.createdAt = createdAt;
		this.userSport = userSport;
	}

	public boolean getVisibility() {
		return visibility;
	}


	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}


	public List<UserSport> getUser() {
		return userSport;
	}

	public void setUser(List<UserSport> userSport) {
		this.userSport = userSport;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
}
