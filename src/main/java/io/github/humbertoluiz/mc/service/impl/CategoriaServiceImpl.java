package io.github.humbertoluiz.mc.service.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.github.humbertoluiz.mc.domain.Categoria;
import io.github.humbertoluiz.mc.repositories.CategoriaRepository;
import io.github.humbertoluiz.mc.services.CategoriaService;
import io.github.humbertoluiz.mc.services.exception.ObjectNotFoundException;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	@Override
	public Optional<Categoria> buscar(Long id) throws ObjectNotFoundException {
		Optional<Categoria> obj = repo.findById(id);
		if (obj.isPresent()) {
			return obj;
		} else {
			return Optional.ofNullable(obj.orElseThrow(() -> 
			new ObjectNotFoundException ("Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName())));
		}
	}
	
}
