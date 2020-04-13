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
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 30, nullable = false)
	private String name;
	@Column(length = 30, nullable = false)
	private String lastName;
	@Column(length = 30, nullable = false, unique = false)
	private String userName;
	@Column(length = 50, nullable = false, unique = false)
	private String email;
	@Column(length = 100, nullable = false)
	private String password;
	@Column(length = 255)
	private volatile String description;
	@Column(length = 255)
	private String profilePic;
	private boolean visibility;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	@OneToMany(targetEntity = UserSport.class, cascade = CascadeType.ALL,
			fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "idUser", referencedColumnName = "id")
	private List<UserSport> userSport;
	
	public User() {}

	public User(Integer id, String name, String lastName, String userName, String email, String password,
			String description, String profilePic, Date createdAt, List<UserSport> userSport, boolean visibility ) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.description = description;
		this.profilePic = profilePic;
		this.createdAt = createdAt;
		this.userSport = userSport;
		this.visibility = visibility;
	}
	
	public boolean getVisibility() {
		return visibility;
	}

	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}

	public List<UserSport> getSport() {
		return userSport;
	}

	public void setSport(List<UserSport> userSport) {
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	};
}
