package br.ufpb.adocaoanimais;
import java.util.List;

public class Usuario {

	private String nome;

	private String cpf;

	private String dataNascimento;

	private List<Requisito> requisitos;

	public Usuario(String nome, String cpf, String dataNascimento, List<Requisito> requisitos) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.requisitos = requisitos;
	}

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Requisito> getRequisitos() {
		return requisitos;
	}

	public void adicionaRequisito(Requisito req) {
		this.requisitos.add(req);
	}
	
	public void setRequisitos(List<Requisito> requisitos) {
		this.requisitos = requisitos;
	}

	@Override
	public String toString() {
		return "Usuario de nome "
				+ nome 
				+ ", cpf " 
				+ cpf 
				+ ", dataNascimento "
				+ dataNascimento
				+ ", requisitos "
				+ requisitos;
	}
	
}