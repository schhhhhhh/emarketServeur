package io.artcreativity.emarket.metier;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import io.artcreativity.emarket.entities.Command;
import io.artcreativity.emarket.entities.CommandItem;
import io.artcreativity.emarket.entities.Product;
import io.artcreativity.emarket.repositories.CommandItemRepository;
import io.artcreativity.emarket.repositories.CommandRepository;
import io.artcreativity.emarket.repositories.ProductRepository;

@Service
public class AdminMetierImpl implements AdminMetier {
	
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CommandRepository commandRepository;
	@Autowired
	private CommandItemRepository commandItemRepository;

	@Override
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(long id, Product product) {
		Optional<Product> optional = productRepository.findById(id);
		if(optional.isEmpty())
			return null;
		Product p = optional.get();
		if(product.getName() != null)
			p.setName(product.getName());
		if(product.getDescription() != null)
			p.setDescription(product.getDescription());
		if(product.getPrice() != null)
			p.setPrice(product.getPrice());
		
		return productRepository.save(p);
	}

	@Override
	public List<Product> getProducts(String search) {
		search = "%" + search + "%";
		return productRepository.findByNameLikeOrDescriptionLike(search, search);
	}

	@Override
	public Product getProduct(long id) {
		Optional<Product> optional = productRepository.findById(id);
		if(optional.isEmpty())
			return null;
		return optional.get();
	}

	@Override
	public boolean deleteProduct(long id) {
		Optional<Product> optional = productRepository.findById(id);
		if(optional.isEmpty())
			return false;
		productRepository.delete(optional.get());
		return true;
	}

	@Override
	public List<Command> getCommands() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommandItem> getCommandItemsByCommand(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean treatCommandItem(long id, boolean ans) {
		// TODO Auto-generated method stub
		return false;
	}

}
