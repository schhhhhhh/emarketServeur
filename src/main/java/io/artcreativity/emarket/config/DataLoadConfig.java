package io.artcreativity.emarket.config;

import java.util.Collections;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import io.artcreativity.emarket.entities.Profile;
import io.artcreativity.emarket.entities.Role;
import io.artcreativity.emarket.entities.User;
import io.artcreativity.emarket.repositories.ProfileRepository;
import io.artcreativity.emarket.repositories.RoleRepository;
import io.artcreativity.emarket.repositories.UserRepository;

@Component
public class DataLoadConfig {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProfileRepository profileRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private RoleRepository roleRepository;
	
	@PostConstruct
	public void loadAdminUser() {
		if(userRepository.existsByUsername("admin"))
			return;
		Role roleAdmin = roleRepository.save(new Role("ADMIN"));
		User user = new User();
		user.setUsername("admin");
		user.setFirstname("Admin");
		user.setLastname("Super ");
		user.setPassword(passwordEncoder.encode("P@ss2021"));
		user.setRoles(Collections.singleton(roleAdmin));
		user = userRepository.save(user);
		Profile profile = new  Profile();
		profile.setUsername("admin");
		profile.setFirstname("Admin");
		profile.setUser(user);
		profileRepository.save(profile);
	}
}
