package io.artcreativity.emarket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.artcreativity.emarket.entities.CommandItem;

public interface CommandItemRepository extends JpaRepository<CommandItem, Long> {

}
