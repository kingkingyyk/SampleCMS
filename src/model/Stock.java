package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table; 

@Entity
@Table(name="STOCK")
public class Stock {
	private Integer id;
	private String name;
	private double buyingPrice;
	private double currentSellingPrice;
	private School school;
	
	public Stock() {}
	
	public Stock(Integer id, String name, double buyingPrice, double currentSellingPrice, School school) {
		this.id = id;
		this.name = name;
		this.buyingPrice = buyingPrice;
		this.currentSellingPrice = currentSellingPrice;
		this.school = school;
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

	@Column(name="BUYING_PRICE", nullable=false)
	public double getBuyingPrice() {
		return buyingPrice;
	}

	public void setBuyingPrice(double buyingPrice) {
		this.buyingPrice = buyingPrice;
	}

	@Column(name="SELLING_PRICE", nullable=false)
	public double getCurrentSellingPrice() {
		return currentSellingPrice;
	}

	public void setCurrentSellingPrice(double currentSellingPrice) {
		this.currentSellingPrice = currentSellingPrice;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}
	
	
	
}
