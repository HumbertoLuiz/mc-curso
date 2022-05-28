package io.github.humbertoluiz.mc.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private Double preco;
	
	@Builder.Default
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "produto_categoria",
		joinColumns = @JoinColumn(name = "produto_id"),
		inverseJoinColumns = @JoinColumn(name = "categoria_id"))	
	private Set<Categoria> categorias = new HashSet<>();

}
