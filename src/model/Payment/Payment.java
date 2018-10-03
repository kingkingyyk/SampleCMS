package model.Payment;

import model.People.Staff;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="PAYMENT")
public class Payment {
	private int id;
	private double amount;
	private LocalDateTime salesTime;
	private String staffName;

	private Set<StudentFeePaymentDetail> studentFeePaymentDetails = new HashSet<StudentFeePaymentDetail>();

	public Payment() {}

	public Payment(int id, double amount, LocalDateTime salesTime, String staffName, Set<StudentFeePaymentDetail> studentFeePaymentDetails) {
		this.id = id;
		this.amount = amount;
		this.salesTime = salesTime;
		this.staffName = staffName;
		this.studentFeePaymentDetails = studentFeePaymentDetails;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PAYMENT_ID")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="AMOUNT")
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Column(name="SALES_TIME")
	public LocalDateTime getSalesTime() {
		return salesTime;
	}
	public void setSalesTime(LocalDateTime salesTime) {
		this.salesTime = salesTime;
	}

	@Column(name="STAFF_NAME")
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	@OneToMany(mappedBy = "payment", cascade=CascadeType.ALL)
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
