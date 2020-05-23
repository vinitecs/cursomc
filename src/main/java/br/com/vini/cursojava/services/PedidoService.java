package br.com.vini.cursojava.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vini.cursojava.domain.Pedido;
import br.com.vini.cursojava.repositories.PedidoRepository;
import br.com.vini.cursojava.services.excepion.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

	// esta classe é aque comunica com o banco de dados para
	// regra de negocio

	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName())
				); 
	}
}
