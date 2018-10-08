package model.SubjectEnrollment;

import model.People.Teacher;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="TEACHER_SUBJECT")
public class TeacherSubject {
    private int id;
    private Teacher teacher;
    private Subject subject;

    private Set<StudentEnrollment> studentEnrollments = new HashSet<StudentEnrollment>();
    private Set<MonthlyTSFee> monthlyTSFees = new HashSet<MonthlyTSFee>();

    public String toString() {
        return subject.getName();
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="TEACHER_SUBJECT_ID")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "HUMAN_ID")
    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SUBJECT_ID")
    public Subject getSubject() {
        return subject;
    }
    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @OneToMany(mappedBy = "teacherSubject", cascade=CascadeType.ALL)
    public Set<StudentEnrollment> getStudentEnrollments() {
        return studentEnrollments;
    }
    public void setStudentEnrollments(Set<StudentEnrollment> studentEnrollments) {
        this.studentEnrollments = studentEnrollments;
    }
    public void addStudentEnrollment(StudentEnrollment studentEnrollment) {
        this.studentEnrollments.add(studentEnrollment);
    }

    @OneToMany(mappedBy = "teacherSubject", cascade=CascadeType.ALL)
    public Set<MonthlyTSFee> getMonthlyTSFees() {
        return monthlyTSFees;
    }
    public void setMonthlyTSFees(Set<MonthlyTSFee> monthlyTSFees) {
        this.monthlyTSFees = monthlyTSFees;
    }
    public void addMonthlyTSFee(MonthlyTSFee monthlyTSFee)
    {
        this.monthlyTSFees.add(monthlyTSFee);
    }

}
