package io.github.humbertoluiz.mc.services;

import java.util.Optional;

import io.github.humbertoluiz.mc.domain.Pedido;

public interface PedidoService {	

	Optional<Pedido> buscar(Long id);
}
