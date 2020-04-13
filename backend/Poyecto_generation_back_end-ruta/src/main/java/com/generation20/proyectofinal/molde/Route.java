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
@Table(name = "route")
public class Route {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
	public Integer idPublication;
	public Integer idEvent;
	@Column(length = 255)
	public String information;
	@Temporal(TemporalType.TIMESTAMP)
	public Date createdAt;
	@OneToMany(targetEntity = Coordinate.class, cascade = CascadeType.ALL,
			 	fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "idRoute", referencedColumnName = "id")
	List<Coordinate> coordinate;
	
	public Route() {}
	
	
	public Route(Integer id, Integer idPublication, Integer idEvent, String information, Date createdAt,
			List<Coordinate> coordinate) {
		super();
		this.id = id;
		this.idPublication = idPublication;
		this.idEvent = idEvent;
		this.information = information;
		this.createdAt = createdAt;
		this.coordinate = coordinate;
	}

	public Integer getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(Integer idEvent) {
		this.idEvent = idEvent;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdPublication() {
		return idPublication;
	}
	public void setIdPublication(Integer idPublication) {
		this.idPublication = idPublication;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public List<Coordinate> getCoordinate() {
		return coordinate;
	}
	public void setCoordinate(List<Coordinate> coordinate) {
		this.coordinate = coordinate;
	}
}
