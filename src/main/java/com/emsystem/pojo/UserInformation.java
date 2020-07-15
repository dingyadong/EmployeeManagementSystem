package com.emsystem.pojo;

public class UserInformation {
	private int user_id;
	private String user_name;
	private String password;
	private String user_sex;
	private String user_age;
	private String system_role;
	private String department_name;
	private String post;
	private String self;
	private String hobbies;
	private String telephone;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	public String getUser_age() {
		return user_age;
	}
	public void setUser_age(String user_age) {
		this.user_age = user_age;
	}
	public String getSystem_role() {
		return system_role;
	}
	public void setSystem_role(String system_role) {
		this.system_role = system_role;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getSelf() {
		return self;
	}
	public void setSelf(String self) {
		this.self = self;
	}
	public String getHobbies() {
		return hobbies;
	}
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	@Override
	public String toString() {
		return "UserInformation [user_id=" + user_id + ", user_name=" + user_name + ", password=" + password
				+ ", user_sex=" + user_sex + ", user_age=" + user_age + ", system_role=" + system_role
				+ ", department_name=" + department_name + ", post=" + post + ", self=" + self + ", hobbies=" + hobbies
				+ ", telephone=" + telephone + "]";
	}
	
}
