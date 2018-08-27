package model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="STUDENT")
public class Student {
	private String ic;
	private String name;
	private String contact;
	private String address;
	private String email;
	private Set<Subject> subjects;
	private Set<Sales> sales;
	private School school;
	
	public Student() {}
	
	public Student(String ic, String name, String contact, String address, String email, Set<Subject> subjects,
			Set<Sales> sales, School school) {
		this.ic = ic;
		this.name = name;
		this.contact = contact;
		this.address = address;
		this.email = email;
		this.subjects = subjects;
		this.sales = sales;
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

	@Column(name="CONTACT", nullable=false, length=200)
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}

	@Column(name="ADDRESS", nullable=false, length=200)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name="EMAIL", nullable=false, length=200)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.MERGE}, mappedBy="students")
	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}
	
	@OneToMany(mappedBy="student", cascade=CascadeType.ALL)
	public Set<Sales> getSales() {
		return sales;
	}

	public void setSales(Set<Sales> sales) {
		this.sales = sales;
	}
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	public School getSchool() {
		return this.school;
	}
	public void setSchool(School school) {
		this.school=school;
	}
}
