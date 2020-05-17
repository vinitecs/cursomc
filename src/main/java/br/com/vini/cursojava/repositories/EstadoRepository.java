package br.com.vini.cursojava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vini.cursojava.domain.Estado;

@Repository
public interface EstadoRepository  extends JpaRepository<Estado, Integer>{
	// esta classe ele cria para obter acesso a Dados 
	

}
