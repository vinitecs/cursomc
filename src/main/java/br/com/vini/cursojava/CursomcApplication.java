package br.com.vini.cursojava;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.vini.cursojava.domain.Categoria;
import br.com.vini.cursojava.domain.Cidade;
import br.com.vini.cursojava.domain.Cliente;
import br.com.vini.cursojava.domain.Endereco;
import br.com.vini.cursojava.domain.Estado;
import br.com.vini.cursojava.domain.ItemPedido;
import br.com.vini.cursojava.domain.Pagamento;
import br.com.vini.cursojava.domain.PagamentoComBoleto;
import br.com.vini.cursojava.domain.PagamentoComCartao;
import br.com.vini.cursojava.domain.Pedido;
import br.com.vini.cursojava.domain.Produto;
import br.com.vini.cursojava.domain.enums.EstadoPagamento;
import br.com.vini.cursojava.domain.enums.TipoCliente;
import br.com.vini.cursojava.repositories.CategoriaRepository;
import br.com.vini.cursojava.repositories.CidadeRepository;
import br.com.vini.cursojava.repositories.ClienteRepository;
import br.com.vini.cursojava.repositories.EnderecoRepository;
import br.com.vini.cursojava.repositories.EstadoRepository;
import br.com.vini.cursojava.repositories.ItemPedidoRepository;
import br.com.vini.cursojava.repositories.PagamentoRepository;
import br.com.vini.cursojava.repositories.PedidoRepository;
import br.com.vini.cursojava.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	@Autowired
	private CategoriaRepository categoriaRepository; 
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "informatica");
		Categoria cat2 = new Categoria(null, "escritorio");
		Categoria cat3 = new Categoria(null, "casa");
		
		Produto p1 = new Produto(null, "mouse",80.00);
		Produto p2 = new Produto(null, "computador",1600.00);
		Produto p3 = new Produto(null, "cadeira",116.00);
		
		//faz com que classifique  os produtos com em cada categoria 
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		//faz com que reconheça  em que a categoria o produto pertence
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1,cat2,cat3));
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
	
		Estado est1 = new Estado(null, "minas gerais");
		Estado est2 = new Estado(null,"sao paulo");
		
		Cidade c1 = new Cidade(null,"Uberlandia", est1);
		Cidade c2 = new Cidade(null,"Sao paulo",est2);
		Cidade c3 = new Cidade(null,"Campinas",est2);
		
		
		est1.getCidade().addAll(Arrays.asList(c1));
		est2.getCidade().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null,"maria silva", "maria@gmail.com","324",TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("23442344","12343456"));
		
		
		Endereco e1 = new Endereco(null,"rua flores","300","qd 05 lt 04", "barravento","7459003",cli1,c1);
		Endereco e2 = new Endereco(null,"avenida matos","405","qd07 lt14","vitoria","75098332",cli1,c2);
	
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null,sdf.parse("18/05/2020 22:27"),cli1,e1);
		Pedido ped2 = new Pedido(null,sdf.parse("19/07/2020 22:27"),cli1,e2);
		
		
		Pagamento pgto1 = new PagamentoComCartao(null,EstadoPagamento.QUITADO,ped1,6);
		ped1.setPagamento(pgto1);
		
		
		
		Pagamento pgto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE,ped2,sdf.parse("19/07/2020 22:27"),null);
		ped2.setPagamento(pgto2);
		
		cli1.getPedido().addAll(Arrays.asList(ped1,ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
		pagamentoRepository.saveAll(Arrays.asList(pgto1,pgto2));
		
	
		ItemPedido ip1 = new ItemPedido(ped1,p1, 0.00, 1, 2000.0);
		ItemPedido ip2 = new ItemPedido(ped1,p3,0.00,2,80.00);
		ItemPedido ip3 = new ItemPedido(ped2,p2,100.00,1,800.00);
		
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip3));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3));
		
	}

	
}
