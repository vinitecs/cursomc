package br.com.vini.cursojava.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.vini.cursojava.domain.enums.TipoCliente;


@Entity
public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		private String nome;
		private String email;
		private String cpfOuCnpj;
		//esta variavel é tipo Enum onde  os getters e setters vão apresentar .getCod 
		//para representar o tipo Int a declaração Integer ele tráz referencia da classe TipoCliente no formato Enum 
		private Integer tipo;
		
		
		
		//Coleção da classe endereço onde a classe pessoa possui  um endereço
		@JsonManagedReference
		@OneToMany(mappedBy = "cliente")
		private List<Endereco> enderecos = new ArrayList<>();
		
		
		@OneToMany(mappedBy = "cliente")
		private List<Pedido> pedidos = new ArrayList<>();
		
		

		//Coleção de Strings que não vai ter repetição 
		@ElementCollection
		//no banco ele cria tabela telefone  com cliente _id
		@CollectionTable(name="TELEFONE")
		//a coleção Set ele não possui varios telefones
		private Set<String> telefones = new HashSet<>();
		
		public Cliente() {
			
		}

		public Cliente(Integer id, String nome, String email, String cpfOuCnpj, TipoCliente tipo) {
			super();
			this.id = id;
			this.nome = nome;
			this.email = email;
			this.cpfOuCnpj = cpfOuCnpj;
			this.tipo = tipo.getCod();
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getCpfOuCnpj() {
			return cpfOuCnpj;
		}

		public void setCpfOuCnpj(String cpfOuCnpj) {
			this.cpfOuCnpj = cpfOuCnpj;
		}

		public TipoCliente getTipo() {
			return TipoCliente.toEnum(tipo);
		}

		public void setTipo(TipoCliente tipo) {
			this.tipo = tipo.getCod();
		}

		

		public List<Endereco> getEnderecos() {
			return enderecos;
		}

		public void setEnderecos(List<Endereco> enderecos) {
			this.enderecos = enderecos;
		}

		public Set<String> getTelefones() {
			return telefones;
		}

		public void setTelefones(Set<String> telefones) {
			this.telefones = telefones;
		}
		
		public List<Pedido> getPedido() {
			return pedidos;
		}

		public void setPedido(List<Pedido> pedidos) {
			this.pedidos = pedidos;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Cliente other = (Cliente) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}

		
}
