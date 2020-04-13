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
@Table(name = "event")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
	@Column(nullable = false)
	public Integer idUser;
	@Column(nullable = false)
	public Integer idSport;
	@Column(length = 255, nullable = false)
	public String photo;
	@Column(length = 700, nullable = false)
	public String description;
	@Column(length = 255)
	public String link;
	@Column(length = 20, nullable = false)
	public String eventTime;
	@Temporal (TemporalType.DATE)
	@Column(nullable = false)
	public Date eventDate;
	@Temporal(TemporalType.TIMESTAMP)
	public Date createdAt;
	@Column(length = 30, nullable = false)
	public String nameAuthor;
	@Column(length = 30, nullable = false)
	public String nameSport;
	public boolean visibility;
	@OneToMany(targetEntity = Route.class, cascade = CascadeType.ALL,
			fetch = FetchType.LAZY, orphanRemoval = false)
	@JoinColumn(name = "idEvent", referencedColumnName = "id")
	public List<Route> route;
	
	public Event() {}

	
	public Event(Integer id, Integer idUser, Integer idSport, String photo, String description, String link,
			String eventTime, Date eventDate, Date createdAt, String nameAuthor, String nameSport, boolean visibility,
			List<Route> route) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.idSport = idSport;
		this.photo = photo;
		this.description = description;
		this.link = link;
		this.eventTime = eventTime;
		this.eventDate = eventDate;
		this.createdAt = createdAt;
		this.nameAuthor = nameAuthor;
		this.nameSport = nameSport;
		this.visibility = visibility;
		this.route = route;
	}

	public List<Route> getRoute() {
		return route;
	}
	public void setRoute(List<Route> route) {
		this.route = route;
	}
	public boolean isVisibility() {
		return visibility;
	}

	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
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

	public String getEventTime() {
		return eventTime;
	}

	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	};
}
