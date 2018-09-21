package model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
public class Teacher extends Human {
	private Set<TeacherSubject> teacherSubjects = new HashSet<TeacherSubject>();

	public Teacher() {}

	public Teacher(Integer id, String ic, String name, String contact, String emergencyContact, LocalDate dob, String address, String gender, String email, Boolean active, School school, Set<Subject> subjects) {
		super(id, ic, name, contact, emergencyContact, dob, address, gender, email, active, school);
	}

	public void addSubject(TeacherSubject subject) {
		this.teacherSubjects.add(subject);
	}

	@OneToMany(mappedBy = "teacher", cascade=CascadeType.ALL)
	public Set<TeacherSubject> getTeacherSubjects() {
		return teacherSubjects;
	}
	public void setTeacherSubjects(Set<TeacherSubject> teacherSubjects) {
		this.teacherSubjects = teacherSubjects;
	}

	public void addTeacherSubject(TeacherSubject teacherSubject) {
		this.teacherSubjects.add(teacherSubject);
	}
}
