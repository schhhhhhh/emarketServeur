package io.artcreativity.emarket.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.artcreativity.emarket.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByNameLikeOrDescriptionLike(String search1, String search2);
}
