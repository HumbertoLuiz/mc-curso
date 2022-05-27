package io.github.humbertoluiz.mc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.humbertoluiz.mc.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	
}
