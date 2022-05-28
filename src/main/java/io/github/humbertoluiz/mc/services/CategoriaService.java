package io.github.humbertoluiz.mc.services;

import java.util.Optional;

import io.github.humbertoluiz.mc.domain.Categoria;

public interface CategoriaService {	

	Optional<Categoria> buscar(Long id);
}
