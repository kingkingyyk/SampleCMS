package model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;

import utils.Utils;

@Entity
public class Staff extends Human{
	private String username;
	private byte [] password;
	private String staffType;

	public Staff() {}

	public Staff(Integer id, String ic, String name, String contact, String emergencyContact, LocalDate dob, String address, String gender, String email, School school, String username, String password, String staffType) {
		super(id, ic, name, contact, emergencyContact, dob, address, gender, email, school);
		this.username = username;
		this.setPassword(password);
		this.staffType = staffType;
	}

	@Column(name="USERNAME", nullable=false, length=200)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	@Lob
	@Column(name="PASSWORD", nullable=false)
	public byte[] getPassword() {
		return this.password;
	}
	public void setPassword(byte [] password) {
		this.password = password;
	}
	public void setPassword(String password) {
		this.password = Utils.hash(password);
	}
	public boolean isPasswordMatch(String password) {
		byte [] hashedPassword=Utils.hash(password);
		for (int i=0;i<this.password.length;i++) if (this.password[i]!=hashedPassword[i]) return false;
		return true;
	}

	@Column(name="STAFF_TYPE", nullable=false, length=200)
	public String getStaffType() {
		return staffType;
	}
	public void setStaffType(String staffType) {
		this.staffType = staffType;
	}
}
