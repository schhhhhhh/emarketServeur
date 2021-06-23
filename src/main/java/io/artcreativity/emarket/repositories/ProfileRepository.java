package io.artcreativity.emarket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.artcreativity.emarket.entities.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
