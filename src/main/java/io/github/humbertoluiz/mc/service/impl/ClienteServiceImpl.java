package io.github.humbertoluiz.mc.service.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.github.humbertoluiz.mc.domain.Cliente;
import io.github.humbertoluiz.mc.repositories.ClienteRepository;
import io.github.humbertoluiz.mc.services.ClienteService;
import io.github.humbertoluiz.mc.services.exception.ObjectNotFoundException;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository repo;

	@Override
	public Optional<Cliente> buscar(Long id) throws ObjectNotFoundException {
		Optional<Cliente> obj = repo.findById(id);
		if (obj.isPresent()) {
			return obj;
		} else {
			return Optional.ofNullable(obj.orElseThrow(() -> 
			new ObjectNotFoundException ("Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName())));
		}
	}
	
}
