package io.artcreativity.emarket.security;



import io.artcreativity.emarket.entities.User;
import io.artcreativity.emarket.exceptions.ResourceNotFoundException;
import io.artcreativity.emarket.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() ->
						new UsernameNotFoundException("User not found with username or email : " + username)
				);
		return UserPrincipal.create(user);
	}

	public UserDetails loadUserById(/*String*/ Long id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub

		User user = userRepository.findById(/* UUID.fromString(id) */ id).orElseThrow(
				() -> new ResourceNotFoundException("User", "id", id)
		);
		return UserPrincipal.create(user);
	}

}
