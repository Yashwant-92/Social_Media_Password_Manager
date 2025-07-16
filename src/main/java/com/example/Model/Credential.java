package com.example.Model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class Credential {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Cascade(CascadeType.ALL)
	private int id;

	@Column(name = "platform")
	private String platform;

	@Column(name = "username")
	private String username;

	@Column(name = "passowrd")
	private String password;

	@Column(name = "date")
	private String date;

	public Credential() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Credential(int id, String platform, String username, String password, String date) {
		super();
		this.id = id;
		this.platform = platform;
		this.username = username;
		this.password = password;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Credential [id=" + id + ", platform=" + platform + ", username=" + username + ", password=" + password
				+ ", date=" + date + "]";
	}

}
