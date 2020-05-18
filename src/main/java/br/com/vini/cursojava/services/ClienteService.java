package br.com.vini.cursojava.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vini.cursojava.domain.Cliente;
import br.com.vini.cursojava.repositories.ClienteRepository;
import br.com.vini.cursojava.services.excepion.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	// esta classe é aque comunica com o banco de dados para
	// regra de negocio

	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName())
				); 
	}
}
