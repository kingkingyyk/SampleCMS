package model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Student extends Human{
	//private Set<Subject> subjects;
	//private Set<Sales> sales;
	
	public Student() {}

	public Student(Integer id, String ic, String name, String contact, String emergencyContact, LocalDate dob, String address, String gender, String email, Boolean active, School school) {
		super(id, ic, name, contact, emergencyContact, dob, address, gender, email, active, school);
	}

/*
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
*/
}
