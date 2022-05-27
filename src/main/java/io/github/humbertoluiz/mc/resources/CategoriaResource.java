package io.github.humbertoluiz.mc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.humbertoluiz.mc.domain.Categoria;
import io.github.humbertoluiz.mc.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	@GetMapping("/listar/{id}")
	public ResponseEntity<?> buscar(@PathVariable Long id) {
		Categoria obj = service.buscar(id);		
		return ResponseEntity.ok().body(obj);
	}
	
	

}
