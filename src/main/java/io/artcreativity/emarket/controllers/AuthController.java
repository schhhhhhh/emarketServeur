package io.artcreativity.emarket.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.artcreativity.emarket.entities.User;
import io.artcreativity.emarket.exceptions.ResourceNotFoundException;
import io.artcreativity.emarket.payload.JwtAuthenticationResponse;
import io.artcreativity.emarket.payload.LoginFrom;
import io.artcreativity.emarket.repositories.UserRepository;
import io.artcreativity.emarket.security.TokenAuthentificationProvider;
import io.artcreativity.emarket.security.UserPrincipal;

@RestController
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private TokenAuthentificationProvider tokenProvider;
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("login")
	public JwtAuthenticationResponse authentification(@RequestBody LoginFrom loginForm) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						loginForm.getUsername(),
						loginForm.getPassword()
				)
		);

//		UserPrincipal userP = (UserPrincipal) authentication.getPrincipal();
//		User user = userRepository.findById(userP.getId()).orElseThrow(() -> new ResourceNotFoundException("User", "id", userP.getId()));
		SecurityContextHolder.getContext().setAuthentication(authentication);

		JwtAuthenticationResponse token = tokenProvider.generateToken(authentication);
		return token;
	}
}
