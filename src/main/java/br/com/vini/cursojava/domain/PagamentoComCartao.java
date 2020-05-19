package br.com.vini.cursojava.domain;

import javax.persistence.Entity;

import br.com.vini.cursojava.domain.enums.EstadoPagamento;
@Entity
public class PagamentoComCartao extends Pagamento {
	private static final long serialVersionUID = 1L;

	private Integer numeroDeparcelas;
	
	public PagamentoComCartao() {
		
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido,Integer numeroDeparcelas) {
		super(id, estado, pedido);
		this.numeroDeparcelas= numeroDeparcelas;
		// TODO Auto-generated constructor stub
	}

	public Integer getNumeroDeparcelas() {
		return numeroDeparcelas;
	}

	public void setNumeroDeparcelas(Integer numeroDeparcelas) {
		this.numeroDeparcelas = numeroDeparcelas;
	}
	
	
}
