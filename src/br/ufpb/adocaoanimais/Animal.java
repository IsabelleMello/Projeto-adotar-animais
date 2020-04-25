package br.ufpb.adocaoanimais;
public abstract class Animal {

	private String nome;

	private String codigo;

	private String dataNascimento;

	private String tamanho;

	private boolean ehBarulhento;

	private boolean ehManso;

	private String cor;

	private String sexo;

	private boolean temPedigree;

	private boolean estahComVacinasEmDia;

	private boolean estahCastrado;

	private String detalhes;

	private String tipoAlimentacao;
	
	public static final String SEXO_FEMININO = "Feminino";
	public static final String SEXO_MASCULINO = "Masculino";


	public Animal(String nome, String codigo, String dataNascimento, String tamanho, boolean ehBarulhento,
			boolean ehManso, String cor, String sexo, boolean temPedigree, boolean estahComVacinasEmDia,
			boolean estahCastrado, String tipoAlimentacao, String detalhes) {
		super();
		this.nome = nome;
		this.codigo = codigo;
		this.dataNascimento = dataNascimento;
		this.tamanho = tamanho;
		this.ehBarulhento = ehBarulhento;
		this.ehManso = ehManso;
		this.cor = cor;
		this.sexo = sexo;
		this.temPedigree = temPedigree;
		this.estahComVacinasEmDia = estahComVacinasEmDia;
		this.estahCastrado = estahCastrado;
		this.setTipoAlimentacao(tipoAlimentacao);
		this.detalhes = detalhes;
	}

	public Animal() {
		this("", "", "", "", false, false, "", "", false, false, false, "", "");
	}

	@Override
	public String toString() {
		return "Nome: " 
				+ nome 
				+ ", codigo: " 
				+ codigo
				+ ", tipo: " 
				+ getTipo() 
				+ ", dataNascimento: " 
				+ dataNascimento 
				+ ", tamanho="
				+ tamanho 
				+ ", ehBarulhento=" 
				+ ehBarulhento 
				+ ", ehManso: " 
				+ ehManso
				+ ", cor: " 
				+ cor 
				+ ", sexo: "
				+ sexo
				+ ", temPedigree: " 
				+ temPedigree
				+ ", estahComVacinasEmDia: " 
				+ estahComVacinasEmDia
				+ ", estahCastrado: "
				+ estahCastrado 
				+ ", detalhes: " 
				+ detalhes 
				+ ", tipoAlimentacao: "
				+ tipoAlimentacao;
	}

	public abstract String getTipo();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public boolean isEhBarulhento() {
		return ehBarulhento;
	}

	public void setEhBarulhento(boolean ehBarulhento) {
		this.ehBarulhento = ehBarulhento;
	}

	public boolean isEhManso() {
		return ehManso;
	}

	public void setEhManso(boolean ehManso) {
		this.ehManso = ehManso;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public boolean isTemPedigree() {
		return temPedigree;
	}

	public void setTemPedigree(boolean temPedigree) {
		this.temPedigree = temPedigree;
	}

	public boolean isEstahComVacinasEmDia() {
		return estahComVacinasEmDia;
	}

	public void setEstahComVacinasEmDia(boolean estahComVacinasEmDia) {
		this.estahComVacinasEmDia = estahComVacinasEmDia;
	}

	public boolean isEstahCastrado() {
		return estahCastrado;
	}

	public void setEstahCastrado(boolean estahCastrado) {
		this.estahCastrado = estahCastrado;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}

	public String getTipoAlimentacao() {
		return tipoAlimentacao;
	}

	public void setTipoAlimentacao(String tipoAlimentacao) {
		this.tipoAlimentacao = tipoAlimentacao;
	}

}