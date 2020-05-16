package br.com.vini.cursojava.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vini.cursojava.domain.Categoria;
import br.com.vini.cursojava.repositories.CategoriaRepository;
import br.com.vini.cursojava.services.excepion.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	// esta classe é aque comunica com o banco de dados para
	// regra de negocio

	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName())
				); 
	}
}
