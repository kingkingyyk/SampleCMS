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
	private Set<Human> human;
	private Set<Stock> stocks;
	//private Set<Student> students;
	
	public School() {}
	public School(String name, Set<Human> human, Set<Stock> stocks) {
		this.name=name;
		this.human=human;
		this.stocks=stocks;
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
	public Set<Human> getHuman() {
		return human;
	}
	public void setHuman(Set<Human> human) {
		this.human = human;
	}

	@OneToMany(mappedBy="school", cascade=CascadeType.ALL)
	public Set<Stock> getStocks() {
		return stocks;
	}
	public void setStocks(Set<Stock> stocks) {
		this.stocks = stocks;
	}
}
