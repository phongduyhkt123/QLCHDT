package DTO;

import java.sql.Date;

public class NhanVienModel extends PersonModel{
	private String email;
	private String password;
	private String avatar;
	private int role;
	
	public NhanVienModel() {}
	
	public NhanVienModel(int id, String name, String gender, Date dob, String phone, String address, String email,
			String password, String avatar, int role) {
		super(id, name, gender, dob, phone, address);
		this.email = email;
		this.password = password;
		this.avatar = avatar;
		this.role = role;
	}
	
	public NhanVienModel(String name, String gender, Date dob, String phone, String address, String email,
			String password, String avatar, int role) {
		super(name, gender, dob, phone, address);
		this.email = email;
		this.password = password;
		this.avatar = avatar;
		this.role = role;
	}
	
	@Override
	public String toString() {
		return super.toString();
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
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	
}
