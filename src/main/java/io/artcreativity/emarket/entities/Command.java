package io.artcreativity.emarket.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Command extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private double totalAmount;
	
	@OneToMany(mappedBy = "command")
	private List<CommandItem> commandItems;
	
	@ManyToOne
//	@JoinColumn
	private User user;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public List<CommandItem> getCommandItems() {
		return commandItems;
	}
	public void setCommandItems(List<CommandItem> commandItems) {
		this.commandItems = commandItems;
	}
	
	
}
