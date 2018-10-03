package model.SubjectEnrollment;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="SUBJECT")
public class Subject {
	private int id;
	private String name;
	private String description;

	private Set<TeacherSubject> teacherSubjects = new HashSet<TeacherSubject>();

	public Subject() {}

	public Subject(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SUBJECT_ID")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="NAME", nullable=false, length=200)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Column(name="DESCRIPTION", nullable=false, length=200)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(mappedBy = "subject", cascade=CascadeType.ALL)
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
