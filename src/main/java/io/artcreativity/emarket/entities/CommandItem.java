package io.artcreativity.emarket.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CommandItem extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private Product product;
	@ManyToOne
	private Command command;
	
	private double quantity;
	private double price;
	private double totalAmount;

}
