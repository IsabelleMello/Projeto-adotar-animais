package br.ufpb.adocaoanimais;
public class Gato extends Animal {

	public static final String TIPO_ANIMAL_GATO = "Gato";
	public Gato(String nome, String codigo, String dataNascimento, String tamanho, boolean ehBarulhento,
			boolean ehManso, String cor, String sexo, boolean temPedigree, boolean estahComVacinasEmDia,
			boolean estahCastrado, String tipoAlimentacao, String detalhes) {
		super(nome, codigo, dataNascimento, tamanho, ehBarulhento, ehManso, cor, sexo, temPedigree, estahComVacinasEmDia,
				estahCastrado, tipoAlimentacao, detalhes);
	}
	
	public Gato() {
		super();
	}

	@Override
	public String getTipo() {
		return TIPO_ANIMAL_GATO;
	}
	
}