package io.github.humbertoluiz.mc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.humbertoluiz.mc.domain.Categoria;
import io.github.humbertoluiz.mc.repositories.CategoriaRepository;
import io.github.humbertoluiz.mc.services.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	@Override
	public Categoria buscar(Long id) {
		
		Categoria obj = repo.findById(id).get();
		
		return obj;
	}


}
