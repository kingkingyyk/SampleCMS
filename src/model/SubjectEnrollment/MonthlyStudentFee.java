package model.SubjectEnrollment;
import model.Payment.StudentFeePaymentDetail;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="MONTHLY_STUDENT_FEE")
public class MonthlyStudentFee {

    private int id;
    private boolean completeFeePayment;
    private double balance;

    private StudentEnrollment studentEnrollment;
    private MonthlyTSFee monthlyTSFee;

    private Set<StudentFeePaymentDetail> studentFeePaymentDetails = new HashSet<StudentFeePaymentDetail>();

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="MONTHLY_STUDENT_FEE_ID")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name="COMPLETE_FEE_PAYMENT")
    public boolean isCompleteFeePayment() {
        return completeFeePayment;
    }
    public void setCompleteFeePayment(boolean completeFeePayment) {
        this.completeFeePayment = completeFeePayment;
    }

    @Column(name="BALANCE")
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "STUDENT_ENROLLMENT_ID")
    public StudentEnrollment getStudentEnrollment() {
        return studentEnrollment;
    }
    public void setStudentEnrollment(StudentEnrollment studentEnrollment) {
        this.studentEnrollment = studentEnrollment;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MONTHLY_TS_Fee_ID")
    public MonthlyTSFee getMonthlyTSFee() {
        return monthlyTSFee;
    }
    public void setMonthlyTSFee(MonthlyTSFee monthlyTSFee) {
        this.monthlyTSFee = monthlyTSFee;
    }

    @OneToMany(mappedBy = "monthlyStudentFee", cascade=CascadeType.ALL)
    public Set<StudentFeePaymentDetail> getStudentFeePaymentDetails() {
        return studentFeePaymentDetails;
    }
    public void setStudentFeePaymentDetails(Set<StudentFeePaymentDetail> studentFeePaymentDetails) {
        this.studentFeePaymentDetails = studentFeePaymentDetails;
    }
    public void StudentFeePaymentDetail(StudentFeePaymentDetail studentFeePaymentDetail){
        this.studentFeePaymentDetails.add(studentFeePaymentDetail);
    }
}
