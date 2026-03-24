package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.Client;
import com.example.Service.ClientService;

@RestController
@RequestMapping(value = "/auth")
public class ClientController {

	@Autowired
	private ClientService clientService;

	@PostMapping("/singup")
	public ResponseEntity<Client> singupClient(@RequestBody Client client) {

		Client data = clientService.add(client);
		return ResponseEntity.ok(data);
	}

	@PostMapping("/loging")
	public ResponseEntity<ResponseEntity<String>> logingClient(@RequestBody Client client) {

		ResponseEntity<String> data = clientService.loging(client);
		return ResponseEntity.ok(data);
	}

	@GetMapping
	public ResponseEntity<List<Client>> getAllClientDetails() {

		List<Client> data = clientService.getAllClient();
		return ResponseEntity.ok(data);
	}

	@GetMapping("/{CName}")
	public ResponseEntity<List<Client>> getClientDetailsByName(@PathVariable String CName) {

		List<Client> data = clientService.getByClientName(CName);
		return ResponseEntity.ok(data);
	}

	@GetMapping("/product")
	public ResponseEntity<String> getAllProductDetails() {

		String data = clientService.getAllProduct();
		return ResponseEntity.ok(data);
	}

	@GetMapping("/product/{PName}")
	public ResponseEntity<String> getDetailsProductByName(@PathVariable String PName) {

		String data = clientService.getProductByName(PName);
		return ResponseEntity.ok(data);
	}
}
