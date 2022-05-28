package io.github.humbertoluiz.mc.resources;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.humbertoluiz.mc.domain.Cliente;
import io.github.humbertoluiz.mc.services.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> buscar(@PathVariable Long id) {
		Optional<Cliente> obj = service.buscar(id);		
		return ResponseEntity.ok().body(obj);
	}
	
	

}
