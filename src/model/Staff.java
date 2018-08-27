package model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="STAFF")
public class Staff {
	private String ic;
	private String name;
	private LocalDate dob;
	private String email;
	private String address;
	private String contact;
	private School school;
	
	public Staff() {}
	public Staff(String ic, String name, LocalDate dob, String email, String address, String contact, School school) {
		this.ic = ic;
		this.name = name;
		this.dob = dob;
		this.email = email;
		this.address = address;
		this.contact = contact;
		this.school = school;
	}
	
	@Id
	@Column(name="IC")
	public String getIc() {
		return ic;
	}
	public void setIc(String ic) {
		this.ic = ic;
	}

	@Column(name="NAME", nullable=false, length=200)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="DATE_OF_BIRTH")
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	@Column(name="EMAIL", nullable=false, length=200)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="ADDRESS", nullable=false, length=200)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name="CONTACT", nullable=false, length=200)
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	
	
}
