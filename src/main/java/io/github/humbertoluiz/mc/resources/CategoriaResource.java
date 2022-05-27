package io.github.humbertoluiz.mc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.github.humbertoluiz.mc.domain.Categoria;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@GetMapping("/listar")
	public List<Categoria> listar() {
		Categoria cat1 = new Categoria((long) 1, "Informatica");
		Categoria cat2 = new Categoria((long) 2, "Escritório");
		
		List<Categoria> lista= new ArrayList<>();
		lista.add(cat1);
		lista.add(cat2);
		
		return lista;
	}

}
