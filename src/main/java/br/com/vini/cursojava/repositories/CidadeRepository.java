package br.com.vini.cursojava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vini.cursojava.domain.Cidade;

@Repository
public interface CidadeRepository  extends JpaRepository<Cidade, Integer>{
	// esta classe ele cria para obter acesso a Dados 
	

}
