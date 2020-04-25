package br.ufpb.adocaoanimais;

import java.util.List;

public interface SistemaAdocaoAnimais  {
	
	public List <Usuario> getUsuarios();
	
	public void  setUsuarios(List <Usuario> lista);
	
	public List <Animal> getAnimais();
	
	public void setAnimais (List <Animal> lista);
	
	/**
	 * Pesquisa no sistema o usuário com um dado CPF
	 * @param cpf O CPF a pesquisar
	 * @return O usuário do sistema que tem o mesmo CPF
	 */
	public Usuario pesquisaUsuario(String cpf) throws UsuarioNaoExisteException ;

	/**
	 * Pesquisa os usuários cujo nome começa com um certo prefixo
	 * @param prefixo O prefixo a pesquisar
	 * @return a lista dos usuários cujo nome começa com certo prefixo
	 */
	public List<Usuario> pesquisaUsuariosComNomeComecandoCom(String prefixo);

	/**
	 * Pesquisa os animais do tipo passado como parâmetro
	 * @param tipo O tipo de animal a pesquisar
	 * @return a lista dos animais do tipo pesquisado.
	 */
	public List<Animal> pesquisaAnimaisDoTipo(String tipo);
	
	/**
	 * Pesquisa no sistema animais por um determinado sexo 
	 * @param sexo O sexo do animal a pesquisar
	 * @return a lista dos animais do sexo pesquisado
	 */
	public List<Animal> pesquisaAnimaisPeloSexo(String sexo);
	
	/**
	 * Pesquisa no sistema animais por uma determinado cor 
	 * @param cor A cor do animal a pesquisar
	 * @return a lista dos animais da cor pesquisada
	 */
	public List<Animal> pesquisaAnimaisPelaCor(String cor);


	public boolean cadastraUsuario(Usuario user);

	/*
	 * Método que verifica se o usuário existe por meio do cpf
	 */
	public boolean existeUsuario(Usuario user);

	public boolean cadastraAnimal(Animal a);

	/*
	 * Método que verifica se o animal existe por meio do código
	 */
	public boolean existeAnimal(Animal animal);

	/**
	 * Pesquisa no sistema usuários de acordo com sua preferência de tipo do animal
	 * @param tipo O tipo do animal a pesquisar
	 * @return a lista dos usuário que preferem aquele tipo de animal especificado
	 */
	List<Usuario> pesquisaUsuariosComPreferenciaDeTipoAnimal(String tipo);
	
	List<Animal> pesquisaAnimaisPeloTamanho(String tamanho);

	
}