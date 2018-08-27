package model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="SALES")
public class Sales {
	private Integer id;
	private double buyingPrice;
	private double sellingPrice;
	private double actualSellingPrice;
	private LocalDateTime salesTime;
	private Student student;
	
	public Sales() {}
	
	public Sales(Integer id, double buyingPrice, double sellingPrice, double actualSellingPrice,
			LocalDateTime salesTime, Student student) {
		this.id = id;
		this.buyingPrice = buyingPrice;
		this.sellingPrice = sellingPrice;
		this.actualSellingPrice = actualSellingPrice;
		this.salesTime = salesTime;
		this.student = student;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="BUYING_PRICE")
	public double getBuyingPrice() {
		return buyingPrice;
	}
	public void setBuyingPrice(double buyingPrice) {
		this.buyingPrice = buyingPrice;
	}

	@Column(name="SELLING_PRICE")
	public double getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	@Column(name="ACTUAL_SELLING_PRICE")
	public double getActualSellingPrice() {
		return actualSellingPrice;
	}
	public void setActualSellingPrice(double actualSellingPrice) {
		this.actualSellingPrice = actualSellingPrice;
	}

	@Column(name="SALES_TIME")
	public LocalDateTime getSalesTime() {
		return salesTime;
	}
	public void setSalesTime(LocalDateTime salesTime) {
		this.salesTime = salesTime;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	
}
