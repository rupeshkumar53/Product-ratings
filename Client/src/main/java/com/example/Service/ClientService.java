package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.Model.Client;
import com.example.Repostory.ClientRepositry;
import com.example.Security.JwtUtil;

@Service
public class ClientService {

	@Autowired
	private ClientRepositry clientRepositry;
	@Autowired
	private RestTemplate restTemplate;
	@Value("${product.service.url}")
	private String productServiceUrl;
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public Client add(Client client) {

		client.setPassword(passwordEncoder.encode(client.getPassword()));
		clientRepositry.save(client);
		return clientRepositry.save(client);
	}

	public List<Client> getAllClient() {
		return clientRepositry.findAll();
	}

	public List<Client> getByClientName(String CName) {
		return clientRepositry.findByUserNameContaining(CName);
	}

	public String getAllProduct() {
		String url = "http://PRODUCT-SERVICE/product";
		return restTemplate.getForObject(url, String.class);
	}

	public String getProductByName(String PName) {
		String url = "http://PRODUCT-SERVICE/product/" + PName;
		return restTemplate.getForObject(url, String.class);
	}

	public ResponseEntity<String> loging(Client client) {

		try {
			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(client.getUserName(), client.getPassword()));
		} catch (BadCredentialsException e) {
			return ResponseEntity.status(401).body("Invalid credentials");
		}
		String token = jwtUtil.generateToken(client.getUserName());
		return ResponseEntity.ok(token);
	}

}
