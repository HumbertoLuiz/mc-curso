package io.github.humbertoluiz.mc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.humbertoluiz.mc.domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	
}
