package br.com.erudio.models;

public class User {
	
	private Integer idUser;
	private String name;
	private String email;

	public User() {}

	public User(Integer idUser, String name, String email) {
		this.idUser = idUser;
		this.name = name;
		this.email = email;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
