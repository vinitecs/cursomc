package br.com.vini.cursojava.domain.enums;

public enum TipoCliente {
	
	PESSOAFISICA(1,"pessoa fisica"),
	PESOAJURIDICA(2,"Pessoa Jurídica");
	
	private int cod;
	private String descricao;
	
	//metodo construtor para orientação a objetos
	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}


	public int getCod() {
		return cod;
	}


	public String getDescricao() {
		return descricao;
	}
	// ele vai obter controle de cada codigo atribuido na numeração 
	public static TipoCliente toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		//ele vai percorrer todo o codio pta conferir se o codigo pra retornar o valor 
		for(TipoCliente x : TipoCliente.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
	//ele cria uma mensagem informando que o codigo é invalido 
	throw new IllegalArgumentException("Id inválido"+cod);
	}
}
