package io.github.humbertoluiz.mc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.humbertoluiz.mc.domain.Categoria;
import io.github.humbertoluiz.mc.repositories.CategoriaRepository;

@SpringBootApplication
public class McCursoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(McCursoApplication.class, args);
	}

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria("Informatica");
		Categoria cat2 = new Categoria("Escritorio");
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
	}
}
