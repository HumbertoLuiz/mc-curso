package io.github.humbertoluiz.mc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.humbertoluiz.mc.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

	
}
