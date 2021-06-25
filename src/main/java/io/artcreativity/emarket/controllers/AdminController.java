package io.artcreativity.emarket.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.RestController;

import io.artcreativity.emarket.entities.Command;
import io.artcreativity.emarket.entities.CommandItem;
import io.artcreativity.emarket.entities.Product;
import io.artcreativity.emarket.metier.AdminMetier;

@RestController
@RequestMapping("admin")
public class AdminController {

	@Autowired
	private AdminMetier adminMetier;

	@PostMapping("/products")
	public Product createProduct(@RequestBody Product product) {
		return adminMetier.createProduct(product);
	}
	
	@PutMapping("/products/{id}")
	public Product updateProduct(@PathVariable(value = "id") long id, @RequestBody Product product) {
		return adminMetier.updateProduct(id, product);
	}
	
	@GetMapping("/products")
	public List<Product> getProducts(@RequestParam(name = "research", required = false, defaultValue = "") String search) {
		return adminMetier.getProducts(search);
	}

	@GetMapping("/products/{id}")
	public Product getProduct(@PathVariable(value = "id") long id) {
		return adminMetier.getProduct(id);
	}

	@DeleteMapping("/products/{id}")
	public boolean deleteProduct(@PathVariable(value = "id") long id) {
		return adminMetier.deleteProduct(id);
	}

	public List<Command> getCommands() {
		return adminMetier.getCommands();
	}

	public List<CommandItem> getCommandItemsByCommand(long id) {
		return adminMetier.getCommandItemsByCommand(id);
	}

	public boolean treatCommandItem(long id, boolean ans) {
		return adminMetier.treatCommandItem(id, ans);
	}
	
	
}
