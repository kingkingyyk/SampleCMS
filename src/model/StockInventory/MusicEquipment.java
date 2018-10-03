package model.StockInventory;

import model.School;
import model.StockInventory.Stock;

import javax.persistence.Entity;

@Entity
public class MusicEquipment extends Stock {

	public MusicEquipment() {}

	public MusicEquipment(Integer id, String name, double buyingPrice, double currentSellingPrice, School school) {
		super(id, name, buyingPrice, currentSellingPrice, school);
	}
	
}
