package br.ufpb.adocaoanimais;
public class Requisito {
	private String nomeRequisito;
	private String valorEsperadoRequisito;
	
	public static final String REQUISITO_TIPO_ANIMAL = "Tipo";
	public static final String REQUISITO_COR = "Cor";
	public static final String REQUISITO_SEXO = "Sexo";
	
	
	
	public Requisito(String nomeRequisito, String valorEsperadoRequisito) {
		super();
		this.nomeRequisito = nomeRequisito;
		this.valorEsperadoRequisito = valorEsperadoRequisito;
	}

	
	public String getNomeRequisito() {
		return nomeRequisito;
	}
	public void setNomeRequisito(String nomeRequisito) {
		this.nomeRequisito = nomeRequisito;
	}
	public String getValorEsperadoRequisito() {
		return valorEsperadoRequisito;
	}
	public void setValorEsperadoRequisito(String valorEsperadoRequisito) {
		this.valorEsperadoRequisito = valorEsperadoRequisito;
	}


	@Override
	public String toString() {
		return "NomeRequisito: " 
				+ nomeRequisito
				+ ", valorEsperadoRequisito: "
				+ valorEsperadoRequisito;
	}
	
	
}