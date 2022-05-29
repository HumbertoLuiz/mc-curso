package io.github.humbertoluiz.mc;

import java.text.SimpleDateFormat;
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
import io.github.humbertoluiz.mc.domain.ItemPedido;
import io.github.humbertoluiz.mc.domain.Pagamento;
import io.github.humbertoluiz.mc.domain.PagamentoComBoleto;
import io.github.humbertoluiz.mc.domain.PagamentoComCartao;
import io.github.humbertoluiz.mc.domain.Pedido;
import io.github.humbertoluiz.mc.domain.Produto;
import io.github.humbertoluiz.mc.domain.enums.EstadoPagamento;
import io.github.humbertoluiz.mc.domain.enums.TipoCliente;
import io.github.humbertoluiz.mc.repositories.CategoriaRepository;
import io.github.humbertoluiz.mc.repositories.CidadeRepository;
import io.github.humbertoluiz.mc.repositories.ClienteRepository;
import io.github.humbertoluiz.mc.repositories.EnderecoRepository;
import io.github.humbertoluiz.mc.repositories.EstadoRepository;
import io.github.humbertoluiz.mc.repositories.ItemPedidoRepository;
import io.github.humbertoluiz.mc.repositories.PagamentoRepository;
import io.github.humbertoluiz.mc.repositories.PedidoRepository;
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
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;	
	
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
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:m");
		
		Pedido ped1 = Pedido.builder()
				.instante(sdf.parse("30/09/2017 10:32"))
				.cliente(cli1)
				.enderecoDeEntrega(e1)
				.build();
		
		Pedido ped2 = Pedido.builder()
				.instante(sdf.parse("10/10/2017 19:35"))
				.cliente(cli1)
				.enderecoDeEntrega(e2)
				.build();
		
		Pagamento pagto1 = PagamentoComCartao.builder()
				.estado(EstadoPagamento.QUITADO)
				.pedido(ped1)
				.numeroDeParcelas(6)
				.build();		
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = PagamentoComBoleto.builder()
				.estado(EstadoPagamento.PENDENTE)
				.pedido(ped2)
				.dataVencimento(sdf.parse("20/10/2017 00:00"))
				.dataPagamento(null)
				.build();		
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
	
		ItemPedido ip1 = ItemPedido.builder()
				.pedido(ped1)
				.produto(p1)
				.desconto(0.00)
				.quantidade(1)
				.preco(2000.00)
				.build();
			
		ItemPedido ip2 = ItemPedido.builder()
				.pedido(ped1)
				.produto(p3)
				.desconto(0.00)
				.quantidade(2)
				.preco(80.00)
				.build();
		
		ItemPedido ip3 = ItemPedido.builder()
				.pedido(ped2)
				.produto(p2)
				.desconto(100.00)
				.quantidade(1)
				.preco(800.00)
				.build();
	
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip1));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
		
	}
}
