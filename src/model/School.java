package model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="SCHOOL")
public class School {
	private String name;
	private Set<Staff> staffs;
	private Set<Stock> stocks;
	private Set<Student> students;
	
	public School() {}
	public School(String name, Set<Staff> staffs, Set<Stock> stocks, Set<Student> students) {
		this.name=name;
		this.staffs=staffs;
		this.stocks=stocks;
		this.students=students;
	}
	
	@Id
	@Column(name="NAME", unique=true, nullable=false, length=100)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@OneToMany(mappedBy="school", cascade=CascadeType.ALL)
	public Set<Staff> getStaffs() {
		return staffs;
	}
	public void setStaffs(Set<Staff> staffs) {
		this.staffs = staffs;
	}
	
	@OneToMany(mappedBy="school", cascade=CascadeType.ALL)
	public Set<Stock> getStocks() {
		return stocks;
	}
	public void setStocks(Set<Stock> stocks) {
		this.stocks = stocks;
	}
	
	@OneToMany(mappedBy="school", cascade=CascadeType.ALL)
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
}
