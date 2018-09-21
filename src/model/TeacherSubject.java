package model;

import javax.persistence.*;

@Entity
@Table(name="TEACHER_SUBJECT")
public class TeacherSubject {
    private int id;
    private Teacher teacher;
    private Subject subject;

    private double fee;
    private double commision;

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

    @Column(name="FEE")
    public double getFee() {
        return fee;
    }
    public void setFee(double fee) {
        this.fee = fee;
    }

    @Column(name="COMMISION")
    public double getCommision() {
        return commision;
    }
    public void setCommision(double commision) {
        this.commision = commision;
    }
}
