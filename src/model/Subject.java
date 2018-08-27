package model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="SUBJECT")
public class Subject {
	private Integer id;
	private String name;
	private Teacher teacher;
	private Set<Student> students;
	
	public Subject() {}
	
	public Subject(Integer id, String name, Teacher teacher, Set<Student> students) {
		super();
		this.id = id;
		this.name = name;
		this.teacher = teacher;
		this.students = students;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="NAME", nullable=false, length=200)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="Subject_Student", joinColumns= {@JoinColumn(name = "SUBJECT_ID")}, inverseJoinColumns = {@JoinColumn(name = "STUDENT_IC")})
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
	
}
