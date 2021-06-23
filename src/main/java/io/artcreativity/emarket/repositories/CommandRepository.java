package io.artcreativity.emarket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.artcreativity.emarket.entities.Command;

public interface CommandRepository extends JpaRepository<Command, Long> {

}
