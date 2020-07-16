package com.emsystem.pojo;

public class User {
	private int user_id;
	private String user_name;//用户姓名
	private String password;//用户密码
	private int boardroom_id;//会议室id
	private int department_id;//部门id
	private String user_sex;//用户性别
	private String user_age;//用户年龄
	private String post;//邮编
	private String self;
	private String hobbies;//爱好
	private int telephone;//电话
	private String email;//email
	private int MSN;
	private int system_role;//系统角色
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
	public int getBoardroom_id() {
		return boardroom_id;
	}
	public void setBoardroom_id(int boardroom_id) {
		this.boardroom_id = boardroom_id;
	}
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
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
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getMSN() {
		return MSN;
	}
	public void setMSN(int mSN) {
		MSN = mSN;
	}
	public int getSystem_role() {
		return system_role;
	}
	public void setSystem_role(int system_role) {
		this.system_role = system_role;
	}
}
