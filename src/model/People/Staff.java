package model.People;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;

import model.School;
import utils.Utils;

@Entity
public class Staff extends Human{
	private String username;
	private byte [] password;
	private String staffType;

	public Staff() {}

	public Staff(Integer id, String ic, String name, String contact, String emergencyContact, LocalDate dob, String address, String gender, String email, Boolean active, School school, String username, String password, String staffType) {
		super(id, ic, name, contact, emergencyContact, dob, address, gender, email, active, school);
		this.username = username;
		this.setPassword(password);
		this.staffType = staffType;
	}

	@Column(name="USERNAME", length=200)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	@Lob
	@Column(name="PASSWORD")
	public byte[] getPassword() {
		return this.password;
	}
	public void setPassword(byte [] password) {
		this.password = password;
	}
	public void setPassword(String password) {
		this.password = Utils.hash(password);
	}

	@Column(name="STAFF_TYPE", length=200)
	public String getStaffType() {
		return staffType;
	}
	public void setStaffType(String staffType) {
		this.staffType = staffType;
	}

	public boolean isPasswordMatch(String password) {
		byte [] hashedPassword=Utils.hash(password);
		for (int i=0;i<this.password.length;i++) if (this.password[i]!=hashedPassword[i]) return false;
		return true;
	}
}
