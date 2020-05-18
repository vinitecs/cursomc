package br.com.vini.cursojava;

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
import br.com.vini.cursojava.domain.Produto;
import br.com.vini.cursojava.domain.enums.TipoCliente;
import br.com.vini.cursojava.repositories.CategoriaRepository;
import br.com.vini.cursojava.repositories.CidadeRepository;
import br.com.vini.cursojava.repositories.ClienteRepository;
import br.com.vini.cursojava.repositories.EnderecoRepository;
import br.com.vini.cursojava.repositories.EstadoRepository;
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
		
		Cliente cli1 = new Cliente(null,"maria silva", "maria@gmail.com","324324567836",TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("23442344","12343456"));
		
		
		Endereco e1 = new Endereco(null,"rua flores","300","qd 05 lt 04", "barravento","7459003",cli1,c1);
		Endereco e2 = new Endereco(null,"avenida matos","405","qd07 lt14","vitoria","75098332",cli1,c2);
	
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		
	}

	
}
