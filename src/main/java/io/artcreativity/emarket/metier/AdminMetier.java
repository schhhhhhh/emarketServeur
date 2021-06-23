package io.artcreativity.emarket.metier;

import java.util.List;

import io.artcreativity.emarket.entities.Command;
import io.artcreativity.emarket.entities.CommandItem;
import io.artcreativity.emarket.entities.Product;

public interface AdminMetier {

	Product createProduct(Product product);
	Product updateProduct(long id, Product product);
	List<Product> getProducts(String search);
	Product getProduct(long id);
	boolean deleteProduct(long id);
	
	List<Command> getCommands();
	List<CommandItem> getCommandItemsByCommand(long id);
	boolean treatCommandItem(long id, boolean ans);
	
}
