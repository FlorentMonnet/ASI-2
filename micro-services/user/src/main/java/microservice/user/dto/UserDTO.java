package microservice.user.dto;

public class UserDTO {
	private Integer id_user;
	private Boolean isAdmin;
	private Double money;
	private String surname;
	private String name;
	private String mail;
	
	public UserDTO() {
		super();
	}
	
	public UserDTO(Boolean isAdmin, Double money, String surname, String name, String mail) {
		super();
		this.isAdmin = isAdmin;
		this.money = money;
		this.surname = surname;
		this.name = name;
		this.mail = mail;
	}
	
	

	public Integer getId_user() {
		return id_user;
	}

	public UserDTO setId_user(Integer id_user) {
		this.id_user = id_user;
		return this;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
	

}
