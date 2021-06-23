package io.artcreativity.emarket.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.artcreativity.emarket.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByUsername(String username);

	boolean existsByUsername(String string);

}
