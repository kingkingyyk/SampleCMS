package model.People;

import model.School;
import model.SubjectEnrollment.StudentEnrollment;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Student extends Human {
	//private Set<Subject> subjects;
	//private Set<Payment> sales;
	private Set<StudentEnrollment> studentEnrollments = new HashSet<StudentEnrollment>();

	public Student() {}

	public Student(Integer id, String ic, String name, String contact, String emergencyContact, LocalDate dob, String address, String gender, String email, Boolean active, School school) {
		super(id, ic, name, contact, emergencyContact, dob, address, gender, email, active, school);
	}

	@OneToMany(mappedBy = "student", cascade=CascadeType.ALL)
	public Set<StudentEnrollment> getStudentEnrollments() {
		return studentEnrollments;
	}
	public void setStudentEnrollments(Set<StudentEnrollment> studentEnrollments) {
		this.studentEnrollments = studentEnrollments;
	}
	public void addStudentEnrollment(StudentEnrollment studentEnrollment) {
		this.studentEnrollments.add(studentEnrollment);
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
	public Set<Payment> getSales() {
		return sales;
	}

	public void setSales(Set<Payment> sales) {
		this.sales = sales;
	}
*/
}
