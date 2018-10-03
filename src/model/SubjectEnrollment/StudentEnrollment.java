package model.SubjectEnrollment;

import model.People.Student;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="STUDENT_ENROLLMENT")
public class StudentEnrollment {
    private int id;
    private double registrationFee;

    private Student student;
    private TeacherSubject teacherSubject;

    private Set<MonthlyStudentFee> monthlyStudentFees = new HashSet<MonthlyStudentFee>();

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="STUDENT_ENROLLMENT_ID")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name="REGISTRATION_FEE")
    public double getRegistrationFee() {
        return registrationFee;
    }
    public void setRegistrationFee(double registrationFee) {
        this.registrationFee = registrationFee;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "HUMAN_ID")
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TEACHER_SUBJECT_ID")
    public TeacherSubject getTeacherSubject() {
        return teacherSubject;
    }
    public void setTeacherSubject(TeacherSubject teacherSubject) {
        this.teacherSubject = teacherSubject;
    }

    @OneToMany(mappedBy = "studentEnrollment", cascade=CascadeType.ALL)
    public Set<MonthlyStudentFee> getMonthlyStudentFees() {
        return monthlyStudentFees;
    }
    public void setMonthlyStudentFees(Set<MonthlyStudentFee> monthlyStudentFees) {
        this.monthlyStudentFees = monthlyStudentFees;
    }
    public void addMonthlyStudentFees(MonthlyStudentFee monthlyStudentFee) {
        this.monthlyStudentFees.add(monthlyStudentFee);
    }
}
