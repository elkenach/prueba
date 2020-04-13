package com.generation20.proyectofinal.molde;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "user_sport")
public class UserSport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUserSport;
	private Integer idUser;
	private Integer idSport;
	private Boolean visibility;
	private String nameSport;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	public UserSport() {}

	public UserSport(Integer idUserSport, Integer idUser, Integer idSport, Boolean visibility, String nameSport,
			Date createdAt) {
		super();
		this.idUserSport = idUserSport;
		this.idUser = idUser;
		this.idSport = idSport;
		this.visibility = visibility;
		this.nameSport = nameSport;
		this.createdAt = createdAt;
	}

	public String getNameSport() {
		return nameSport;
	}

	public void setNameSport(String nameSport) {
		this.nameSport = nameSport;
	}

	public Boolean getVisibility() {
		return visibility;
	}

	public void setVisibility(Boolean visibility) {
		this.visibility = visibility;
	}

	public Integer getIdUserSport() {
		return idUserSport;
	}

	public void setIdUserSport(Integer idUserSport) {
		this.idUserSport = idUserSport;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public Integer getIdSport() {
		return idSport;
	}

	public void setIdSport(Integer idSport) {
		this.idSport = idSport;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}	
}
