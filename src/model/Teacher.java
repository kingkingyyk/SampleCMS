package model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Teacher extends Staff {
	private Set<Subject> subjects;

	public Teacher() {
		super();
	}

	public Teacher(String ic, String name, LocalDate dob, String email, String address, String contact, School school, Set<Subject> subjects) {
		super(ic, name, dob, email, address, contact, school);
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
