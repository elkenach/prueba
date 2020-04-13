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
@Table(name = "publication")
public class Publication {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
	@Column(nullable = false)
	public Integer idUser;
	@Column(nullable = false)
	public Integer idSport;
	@Column(length = 700, nullable = false)
	public String text;
	@Column(length = 255, nullable = false)
	public String photo;
	@Column(length = 255)
	public String link;
	public boolean visibility;
	@Column(length = 30, nullable = false)
	public String nameAuthor;
	@Column(length = 30, nullable = false)
	public String nameSport;
	@Temporal(TemporalType.TIMESTAMP)
	public Date createdAt;
	@OneToMany(targetEntity = Route.class, cascade = CascadeType.ALL,
			fetch = FetchType.LAZY, orphanRemoval = false)
	@JoinColumn(name = "idPublication", referencedColumnName = "id")
	public List<Route> route;
	
	public Publication() {}


	public Publication(Integer id, Integer idUser, Integer idSport, String text, String photo, String link,
			boolean visibility, String nameAuthor, String nameSport, Date createdAt, List<Route> route) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.idSport = idSport;
		this.text = text;
		this.photo = photo;
		this.link = link;
		this.visibility = visibility;
		this.nameAuthor = nameAuthor;
		this.nameSport = nameSport;
		this.createdAt = createdAt;
		this.route = route;
	}

	

	public List<Route> getRoute() {
		return route;
	}


	public void setRoute(List<Route> route) {
		this.route = route;
	}


	public String getNameAuthor() {
		return nameAuthor;
	}

	public void setNameAuthor(String nameAuthor) {
		this.nameAuthor = nameAuthor;
	}

	public String getNameSport() {
		return nameSport;
	}

	public void setNameSport(String nameSport) {
		this.nameSport = nameSport;
	}

	public boolean getVisibility() {
		return visibility;
	}

	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}	
}
