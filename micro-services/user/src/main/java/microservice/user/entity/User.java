package microservice.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "User_Entity", uniqueConstraints={
        @UniqueConstraint( name = "uq_mail_user",  columnNames ={"mail_user"})
     })
public class User {
	
	@Id
	@GeneratedValue
	private Integer id_user;
	@Column(name="name_user")
	private String name;
	@Column(name="surname_user")
	private String surname;
	@Column(name="money_user")
	private Double money;
	@Column(name="password_user")
	private String password;
	@Column(name="is_admin")
	private Boolean isAdmin;
	@Column(name="mail_user")
	private String mail;	
	
	public User() {		
	}
	
	public Integer getId_user() {
		return id_user;
	}
	public User setId_user(Integer id_user) {
		this.id_user = id_user;
		return this;
	}
	public String getName() {
		return name;
	}
	public User setName(String name) {
		this.name = name;
		return this;
	}
	public String getSurname() {
		return surname;
	}
	public User setSurname(String surname) {
		this.surname = surname;
		return this;
	}
	public Double getMoney() {
		return money;
	}
	public User setMoney(Double money) {
		this.money = money;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public User setPassword(String password) {
		this.password = password;
		return this;
	}
	public Boolean getIsAdmin() {
		return isAdmin;
	}
	public User setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
		return this;
	}

	public String getMail() {
		return mail;
	}

	public User setMail(String mail) {
		this.mail = mail;
		return this;
	}

	@Override
	public String toString() {
		return "User [id_user=" + id_user + ", name=" + name + ", surname=" + surname + ", money=" + money
				+ ", password=" + password + ", isAdmin=" + isAdmin + ", mail=" + mail + "]";
	}
	
	

}
