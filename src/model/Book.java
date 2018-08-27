package model;

import javax.persistence.Entity;

@Entity
public class Book extends Stock {
	
	public Book() {}

	public Book(Integer id, String name, double buyingPrice, double currentSellingPrice, School school) {
		super(id, name, buyingPrice, currentSellingPrice, school);
	}
	
}
