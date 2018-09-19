package model;

import org.hibernate.annotations.ColumnTransformer;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Staff extends Human{
	private String username;

	@Column(name="PASSWORD", nullable=false, length=200)
	private String password;
	private String staffType;
	private Encryption encrypt = new Encryption();

	public Staff() {}

	public Staff(Integer id, String ic, String name, String contact, String emergencyContact, LocalDate dob, String address, String gender, String email, School school, String username, String password, String staffType) {
		super(id, ic, name, contact, emergencyContact, dob, address, gender, email, school);
		this.username = username;
		this.password = password;
		this.staffType = staffType;
	}

	@Column(name="USERNAME", nullable=false, length=200)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		//System.out.println("hohohohohho: "+ password);
		return encrypt.getDecryptedString(password);
		//return password;
	}
	public void setPassword(String password) {
		this.password = encrypt.getEncryptedString(password);
		//System.out.println("asdasd: "+ this.password);
	}

	@Column(name="STAFF_TYPE", nullable=false, length=200)
	public String getStaffType() {
		return staffType;
	}
	public void setStaffType(String staffType) {
		this.staffType = staffType;
	}
}
