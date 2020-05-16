package br.com.vini.cursojava;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.vini.cursojava.domain.Categoria;
import br.com.vini.cursojava.domain.Produto;
import br.com.vini.cursojava.repositories.CategoriaRepository;
import br.com.vini.cursojava.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	@Autowired
	private CategoriaRepository categoriaRepository; 
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	
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
	}

	
}
