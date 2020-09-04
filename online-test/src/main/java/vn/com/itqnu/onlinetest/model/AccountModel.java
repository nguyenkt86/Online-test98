package vn.com.itqnu.onlinetest.model;

import java.util.Date;

public class AccountModel {

	private Long id;
	private String username;
	private String password;
	private String fullName;
	private Date birthday;
	private boolean gender;
	private String email;
	private String phone;
	private String address;
	private int roleId;

	public AccountModel() {
	}

	// Constructor for create account
	public AccountModel(String fullName, Date birthday, boolean gender, String email, String phone, String address) {
		super();
		this.fullName = fullName;
		this.birthday = birthday;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	// Constructor for get account
	public AccountModel(Long id, String username, String password, String fullName, Date birthday, boolean gender,
			String email, String phone, String address, int roleId) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.birthday = birthday;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.roleId = roleId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

}
