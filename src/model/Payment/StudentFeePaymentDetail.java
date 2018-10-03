package model.Payment;

import model.SubjectEnrollment.MonthlyStudentFee;

import javax.persistence.*;

@Entity
@Table(name="STUDENT_FEE_PAYMENT_DETAIL")
public class StudentFeePaymentDetail {
    private int id;

    private Payment payment;
    private MonthlyStudentFee monthlyStudentFee;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="STUDENT_FEE_PAYMENT_DETAIL_ID")
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PAYMENT_ID")
    public Payment getPayment() {
        return payment;
    }
    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MONTHLY_STUDENT_FEE_ID")
    public MonthlyStudentFee getMonthlyStudentFee() {
        return monthlyStudentFee;
    }
    public void setMonthlyStudentFee(MonthlyStudentFee monthlyStudentFee) {
        this.monthlyStudentFee = monthlyStudentFee;
    }
}
