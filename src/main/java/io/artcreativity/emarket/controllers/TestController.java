package io.artcreativity.emarket.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.artcreativity.emarket.entities.Product;
import io.artcreativity.emarket.repositories.ProductRepository;

@RestController
public class TestController {
	
	@Autowired
	private ProductRepository productRepository;

	@GetMapping("ma-route")
	public String home() {
		return "Hello World";
	}
	
	@GetMapping("hello")
	public String salutation(@RequestParam(name="name", required = false) String nom) {
		return "Hello " + nom;
	}
	
}
