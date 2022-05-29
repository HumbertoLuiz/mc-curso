package io.github.humbertoluiz.mc.service.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.github.humbertoluiz.mc.domain.Pedido;
import io.github.humbertoluiz.mc.repositories.PedidoRepository;
import io.github.humbertoluiz.mc.services.PedidoService;
import io.github.humbertoluiz.mc.services.exception.ObjectNotFoundException;

@Service
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	private PedidoRepository repo;

	@Override
	public Optional<Pedido> buscar(Long id) throws ObjectNotFoundException {
		Optional<Pedido> obj = repo.findById(id);
		if (obj.isPresent()) {
			return obj;
		} else {
			return Optional.ofNullable(obj.orElseThrow(() -> 
			new ObjectNotFoundException ("Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName())));
		}
	}
	
}
