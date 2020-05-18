package br.com.vini.cursojava.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import br.com.vini.cursojava.domain.Cliente;
import br.com.vini.cursojava.services.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResources {
		// ele cria instância  da classe serviço 
		@Autowired
		private ClienteService service;
		
		//essa classe é a classe rest que comunica com http
		@RequestMapping(value="/{id}", method=RequestMethod.GET)
		public ResponseEntity<?> find(@PathVariable Integer id) {
		
			Cliente obj = service.find(id);			
			return ResponseEntity.ok().body(obj);
			
		}
		
}
