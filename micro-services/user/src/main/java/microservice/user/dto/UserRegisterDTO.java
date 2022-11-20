package microservice.user.dto;

import java.io.Serializable;

public class UserRegisterDTO implements Serializable{
	private static final long serialVersionUID = 8099261266061662076L;
	private Integer id_user;
	private Boolean isAdmin;
	private Double money;
	private String surname;
	private String name;
	private String password;
	private String mail;
	
	public UserRegisterDTO() {
		super();
	}

	public UserRegisterDTO(Boolean isAdmin, Double money, String surname, String name, String password, String mail) {
		super();
		this.isAdmin = isAdmin;
		this.money = money;
		this.surname = surname;
		this.name = name;
		this.password = password;
		this.mail = mail;
	}
	
	public Integer getId_user() {
		return id_user;
	}

	public UserRegisterDTO setId_user(Integer id_user) {
		this.id_user = id_user;
		return this;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}
	public UserRegisterDTO setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
		return this;
	}
	public Double getMoney() {
		return money;
	}
	public UserRegisterDTO setMoney(Double money) {
		this.money = money;
		return this;
	}
	public String getSurname() {
		return surname;
	}
	public UserRegisterDTO setSurname(String surname) {
		this.surname = surname;
		return this;
	}
	public String getName() {
		return name;
	}
	public UserRegisterDTO setName(String name) {
		this.name = name;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public UserRegisterDTO setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getMail() {
		return mail;
	}
	public UserRegisterDTO setMail(String mail) {
		this.mail = mail;
		return this;
	}
}
