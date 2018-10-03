package model.SubjectEnrollment;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="MONTHLY_TS_Fee")
public class MonthlyTSFee {

    private int id;
    private double fee;
    private double commision;

    private TeacherSubject teacherSubject;
    private Month month;

    private Set<MonthlyStudentFee> monthlyStudentFees = new HashSet<MonthlyStudentFee>();

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="MONTHLY_TS_Fee_ID")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TEACHER_SUBJECT_ID")
    public TeacherSubject getTeacherSubject() {
        return teacherSubject;
    }
    public void setTeacherSubject(TeacherSubject teacherSubject) {
        this.teacherSubject = teacherSubject;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MONTH_ID")
    public Month getMonth() {
        return month;
    }
    public void setMonth(Month month) {
        this.month = month;
    }

    @OneToMany(mappedBy = "monthlyTSFee", cascade=CascadeType.ALL)
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
