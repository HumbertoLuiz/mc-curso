package io.github.humbertoluiz.mc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.humbertoluiz.mc.domain.Categoria;
import io.github.humbertoluiz.mc.domain.Cidade;
import io.github.humbertoluiz.mc.domain.Cliente;
import io.github.humbertoluiz.mc.domain.Endereco;
import io.github.humbertoluiz.mc.domain.Estado;
import io.github.humbertoluiz.mc.domain.Produto;
import io.github.humbertoluiz.mc.domain.enums.TipoCliente;
import io.github.humbertoluiz.mc.repositories.CategoriaRepository;
import io.github.humbertoluiz.mc.repositories.CidadeRepository;
import io.github.humbertoluiz.mc.repositories.ClienteRepository;
import io.github.humbertoluiz.mc.repositories.EnderecoRepository;
import io.github.humbertoluiz.mc.repositories.EstadoRepository;
import io.github.humbertoluiz.mc.repositories.ProdutoRepository;

@SpringBootApplication
public class McCursoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(McCursoApplication.class, args);
	}

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = Categoria.builder().nome("Informatica").build();
		Categoria cat2 = Categoria.builder().nome("Escritorio").build();
		
		Produto p1 = Produto.builder()
				.nome("Computador").preco(2000.00).build();
		Produto p2 = Produto.builder()
				.nome("Impressora").preco(800.00).build();
		Produto p3 = Produto.builder()
				.nome("Mouse").preco(80.00).build();
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = Estado.builder().id(1L).nome("Minas Gerais").build();
		Estado est2 = Estado.builder().id(2L).nome("São Paulos").build();
		
		Cidade c1 = Cidade.builder().id(1L).nome("Uberlandia").estado(est1).build();
		Cidade c2 = Cidade.builder().id(2L).nome("São Paulo").estado(est2).build();
		Cidade c3 = Cidade.builder().id(3L).nome("Campinas").estado(est2).build();
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = Cliente.builder()
				.nome("Maria Silva")
				.email("maria@gmail.com")
				.cpfOuCnpj("36378912377")
				.tipo(TipoCliente.PESSOAFISICA)
				.build();
		
		cli1.getTelefones().addAll(Arrays.asList("0000000","1111111"));
		
		Endereco e1 = Endereco.builder()
				.logradouro("Rua Flores")
				.numero("300")
				.complemento("apto 303")
				.bairro("Jardim")
				.cep("85469-490")
				.cliente(cli1)
				.cidade(c1).build();
		
		Endereco e2 = Endereco.builder()
				.logradouro("Av. Matos")
				.numero("105")
				.complemento("sala 800")
				.bairro("Centro")
				.cep("87869-990")
				.cliente(cli1)
				.cidade(c2).build();
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll((Iterable<Cliente>) Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
	}
}
