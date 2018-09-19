package model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Teacher extends Human {
	private Set<Subject> subjects;

	public Teacher() {}

	public Teacher(Integer id, String ic, String name, String contact, String emergencyContact, LocalDate dob, String address, String gender, String email, School school, Set<Subject> subjects) {
		super(id, ic, name, contact, emergencyContact, dob, address, gender, email, school);
		this.subjects = subjects;
	}

	@OneToMany(mappedBy="teacher")
	public Set<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}
	
	
}
