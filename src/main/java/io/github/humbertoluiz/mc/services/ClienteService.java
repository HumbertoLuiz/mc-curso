package io.github.humbertoluiz.mc.services;

import java.util.Optional;

import io.github.humbertoluiz.mc.domain.Cliente;

public interface ClienteService {	

	Optional<Cliente> buscar(Long id);
}
