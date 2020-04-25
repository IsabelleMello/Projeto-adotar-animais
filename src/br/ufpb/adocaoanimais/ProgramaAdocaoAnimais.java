package br.ufpb.adocaoanimais;
import static java.lang.Boolean.parseBoolean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


public class ProgramaAdocaoAnimais {
	
	/* Array de opções por conta do modo que irei expor minhas opções para o usuário
	 */
	private static final String[] opcoes = {"Cadastrar animal", "Cadastrar Usuário", "Pesquisar Usuário pelo cpf", "Pesquisar usuário pelo nome", 
			"Pesquisar animais do tipo", "Gravar dados", "Recuperar dados", "Pesquisar animais pelo sexo" ,
			"Pesquisar animais pela cor","Pesquisar Usuário com preferência de tipo", "Outra forma para adotar animais", "Pesquisa animais pelo tamanho", "Sair"};	

	public static void main(String [] args) {
		SistemaAdocaoAnimais sistema = new SistemaAdocaoAnimaisList();
		boolean sair = true;
		while (sair) { 
			String escolhaUsuario = null;
			try {
			 escolhaUsuario = opcoesDados("Sistema Adoção de Animais", opcoes).toString();
			}catch(OperacaoCanceladaException e){
				sair = false;
				break;		
			}
			switch(escolhaUsuario) {
				case "Cadastrar animal": 
					String tipoAnimal = "", nomeAnimal= "", codigoAnimal = "", dataNascimentoAnimal = "", tamanhoAnimal = "", 
					corAnimal = "", sexoAnimal = "", tipoAlimentacaoAnimal = "", detalhesAnimal = "" ;
					boolean ehBarulhentoAnimal  = false, ehMansoAnimal = false, temPedigreeAnimal = false, estahComVacinasEmDiaAnimal = false, estahCastradoAnimal = false;

					
					try {
						nomeAnimal = JOptionPane.showInputDialog("Informe o nome do animal");
						codigoAnimal = JOptionPane.showInputDialog("Informe o código do animal");
						tipoAnimal = JOptionPane.showInputDialog("Informe o tipo do animal. Use 1 para Cachorro e 2 para Gato");
						dataNascimentoAnimal = pedidoDeDados("Informe a data de nascimento do animal");
						tamanhoAnimal = pedidoDeDados("Informe o tamanho do animal");
						ehBarulhentoAnimal = pedirSimOuNao("O animal é barulhento?");
						ehMansoAnimal = pedirSimOuNao("O animal é manso?");
						corAnimal = pedidoDeDados("Informe a cor do animal");
						sexoAnimal = pedidoDeDados("Informe o sexo do animal");
						temPedigreeAnimal = pedirSimOuNao("O animal tem pedigree?");
						estahComVacinasEmDiaAnimal = pedirSimOuNao("O animal está com vacinas em dia?");
						estahCastradoAnimal = pedirSimOuNao("O animal está castrado?");
						tipoAlimentacaoAnimal = pedidoDeDados("Informe o tipo de alimentação do animal?");
						detalhesAnimal = pedidoDeDados("Quais os detalhes do animal?");

					} catch (OperacaoCanceladaException e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					
					Animal a = null;
					if (tipoAnimal.equals("1")) {
						a = new Cachorro(nomeAnimal, codigoAnimal, dataNascimentoAnimal, tamanhoAnimal, ehBarulhentoAnimal, ehMansoAnimal,
								corAnimal, sexoAnimal, temPedigreeAnimal, estahComVacinasEmDiaAnimal,
								estahCastradoAnimal, tipoAlimentacaoAnimal, detalhesAnimal);
					} else if (tipoAnimal.equals("2")) {
						a = new Gato(nomeAnimal, codigoAnimal, dataNascimentoAnimal, tamanhoAnimal, ehBarulhentoAnimal, ehMansoAnimal,
							 	corAnimal, sexoAnimal, temPedigreeAnimal, estahComVacinasEmDiaAnimal,
								estahCastradoAnimal, tipoAlimentacaoAnimal, detalhesAnimal);
					}
					if (a!=null) {
						boolean cadastrou = sistema.cadastraAnimal(a);
						if (cadastrou) {
							JOptionPane.showMessageDialog(null, "Animal cadastrado com sucesso");
						} else {
							JOptionPane.showMessageDialog(null, "Animal já estava cadastrado");
						}
					}
				break;
			  case "Cadastrar Usuário":
				String nomeUser = "", cpfUser= "", tipo = "", codigo = "", dataNascimento = "", tamanho = "", cor = "", sexo = "", tipoAlimentacao = "", detalhes = "" ;
				boolean ehBarulhento  = false, ehManso = false, temPedigree = false, estahComVacinasEmDia = false, estahCastrado = false;

				
				try {
					nomeUser = pedidoDeDados("Informe o nome do usuário");
					cpfUser = pedidoDeDados("Informe o cpf do usuário");
					dataNascimento = pedidoDeDados("Informe a data de nascimento do usuário");
					tipo = JOptionPane.showInputDialog("Qual a preferência do tipo do animal? Use 1 para Cachorro e 2 para Gato");
					tamanho = pedidoDeDados("Qual a preferência de tamanho do animal?");
					ehBarulhento = pedirSimOuNao("O animal desejado pelo usuário é barulhento?");
					ehManso = pedirSimOuNao("O animal desejado pelo usuário é manso?");
					cor = pedidoDeDados("Qual a preferência de cor do animal?");
					sexo = pedidoDeDados("Qual a preferência de sexo do animal?");
					temPedigree = pedirSimOuNao("O animal desejado pelo usuário tem que ter pedigree?");
					estahComVacinasEmDia = pedirSimOuNao("O animal desejado pelo usuário tem que estar com as vacinas em dia?");
					estahCastrado = pedirSimOuNao("O animal esejado pelo usuário tem que estar castrado?");
					tipoAlimentacao = pedidoDeDados("Qual a preferência do tipo de alimentação do animal?");
					detalhes = pedidoDeDados("Qual a preferência de detalhes do animal?");

				} catch (OperacaoCanceladaException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
				}

				List<Requisito> listaRequisitos = new ArrayList<>();
				
				// Criação de Requisitos
				Requisito tipoRequisito = new Requisito("Tipo", tipo);
				Requisito tamanhoRequisto = new Requisito("Tamanho", tamanho);
				Requisito ehBarulhentoRequisito = new Requisito("ehBarulhento", Boolean.toString(ehBarulhento));
				Requisito ehMansoRequisito = new Requisito("ehManso", Boolean.toString(ehManso));
				Requisito corRequisto = new Requisito("Cor", cor);
				Requisito sexoRequisto = new Requisito("Sexo", sexo);
				Requisito temPedigreeRequisito = new Requisito("temPedigree", Boolean.toString(temPedigree));
				Requisito estaComVacinasEmDiaRequisito = new Requisito("ehManso", Boolean.toString(estahComVacinasEmDia));
				Requisito estahCastradoRequisito = new Requisito("estahCastrado", Boolean.toString(estahCastrado));
				Requisito tipoAlimentacaoRequisito = new Requisito("tipoAlimentacao", tipoAlimentacao);
				Requisito detalhesRequisito = new Requisito("detalhes", detalhes);

				listaRequisitos.add(tamanhoRequisto);
				listaRequisitos.add(ehBarulhentoRequisito);
				listaRequisitos.add(ehMansoRequisito);
				listaRequisitos.add(corRequisto);
				listaRequisitos.add(sexoRequisto);
				listaRequisitos.add(temPedigreeRequisito);
				listaRequisitos.add(estaComVacinasEmDiaRequisito);
				listaRequisitos.add(estahCastradoRequisito);
				listaRequisitos.add(tipoAlimentacaoRequisito);
				listaRequisitos.add(detalhesRequisito);
				listaRequisitos.add(tipoRequisito);

				
				Usuario u = new Usuario(nomeUser, cpfUser, dataNascimento, listaRequisitos);
				if (sistema.cadastraUsuario(u)) {
					JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso");
				} else {
					JOptionPane.showMessageDialog(null, "Usuário não cadastrado, pois já estava cadastrado");
				}
				
			    break;
			  case "Pesquisar Usuário pelo cpf":
				String cpf = JOptionPane.showInputDialog("Informe o cpf do usuário: ");
				try {
					Usuario usuarioPesquisado = sistema.pesquisaUsuario(cpf);
					JOptionPane.showMessageDialog(null,
							"Usuario encontrado com sucesso: " + usuarioPesquisado.toString());

				} catch (UsuarioNaoExisteException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
					
				break;
				case "Pesquisar Usuário com preferência de tipo":
					String preferenciaAnimal = JOptionPane.showInputDialog("Informe a sua preferência. Use 1 para Cachorro e 2 para Gato");
					List<Usuario> listaUsuariosComPreferenciaDeTipoAnimal = sistema.pesquisaUsuariosComPreferenciaDeTipoAnimal(preferenciaAnimal);
					if(!listaUsuariosComPreferenciaDeTipoAnimal.isEmpty()) {
						for(Usuario user: listaUsuariosComPreferenciaDeTipoAnimal) {
							JOptionPane.showMessageDialog(null, "Usuário encontrado " + user.toString());
							
						}
	
					}
					else {
						JOptionPane.showMessageDialog(null, "Não foi encontrado usuário com essa preferência");
					}
				
				break;
				
			  case "Pesquisar usuário pelo nome":
				String nomeBuscado = JOptionPane.showInputDialog("Informe o nome do usuário");
				List<Usuario> listaNomeUsuarios = sistema.pesquisaUsuariosComNomeComecandoCom(nomeBuscado);
				if(!listaNomeUsuarios.isEmpty()) {
					for (Usuario user : listaNomeUsuarios) {
						JOptionPane.showMessageDialog(null, "Usuário encontrado " + user.toString());
					}
				}
				else {
				JOptionPane.showMessageDialog(null, "Não foi encontrado usuário com esse nome");
				}
				break;

			  case "Pesquisar animais do tipo":
				List<Animal> animais = null;
				String tipoPesq = JOptionPane.showInputDialog("Informe o tipo do animal. Use 1 para Cachorro ou 2 para Gato");
				if (tipoPesq.equals("1")) {
					animais = sistema.pesquisaAnimaisDoTipo(Cachorro.TIPO_ANIMAL_CACHORRO);
				} else if (tipoPesq.equals("2")) {
					animais = sistema.pesquisaAnimaisDoTipo(Gato.TIPO_ANIMAL_GATO);
				}
				if (animais!=null) {
					for (Animal animal: animais) {
						JOptionPane.showMessageDialog(null, animal.toString());
					}
				} else {
					JOptionPane.showMessageDialog(null, "Não foi encontrado animal do tipo pesquisado");
				}
				break;
			  case "Pesquisar animais pelo sexo":
					List<Animal> listaAnimais = null;
					String pesquisaSexo = JOptionPane.showInputDialog("Qual o sexo do animal?");
					if (pesquisaSexo.equalsIgnoreCase("Feminino")) {
						listaAnimais = sistema.pesquisaAnimaisPeloSexo(Animal.SEXO_FEMININO);
					} else if (pesquisaSexo.equalsIgnoreCase("Masculino")) {
						listaAnimais = sistema.pesquisaAnimaisPeloSexo(Animal.SEXO_MASCULINO);
					}
					if (!listaAnimais.isEmpty()) {
						for (Animal animal: listaAnimais) {
							JOptionPane.showMessageDialog(null, animal.toString());
						}
					} else {
						JOptionPane.showMessageDialog(null, "Não foi encontrado animal do sexo pesquisado");
					}
					break;
			  case "Pesquisar animais pela cor":
					List<Animal> animaisCor = null;
					String pesquisaCor = JOptionPane.showInputDialog("Informe a cor do animal");
					animaisCor = sistema.pesquisaAnimaisPelaCor(pesquisaCor);
					if (!animaisCor.isEmpty()) {
						for (Animal animal: animaisCor) {
							JOptionPane.showMessageDialog(null, animal.toString());
						}
					} else {
						JOptionPane.showMessageDialog(null, "Não foi encontrado animal da cor pesquisada");
					}
					break;
			case "Gravar dados":
				try {
					gravarDados(sistema);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Erro ao gravar dados");
					e.printStackTrace();
				}
				break;
			case "Recuperar dados":
				try {
					recuperarDados(sistema);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Erro ao recuperar dados");
					e.printStackTrace();
				}
				break;
			case "Outra forma para adotar animais":
				JOptionPane.showMessageDialog(null, new MensagemComLink("Esse é o link para o site de adoção 'Amigo não se compra' <a href=\"https://www.amigonaosecompra.com.br\">Adote</a>"
						+ "\n Lembre-se adoção é um ato lindo, mas não pode ser feito no impulso ou apenas por indicação de terceiros."));
				break;
			case "Pesquisa animais pelo tamanho":
				List<Animal> tamAnimais = null;
				String pesquisaAnimaisPeloTamanho = JOptionPane.showInputDialog("Informe o tamanho do animal:");
				tamAnimais = sistema.pesquisaAnimaisPeloTamanho(pesquisaAnimaisPeloTamanho);
				if (!tamAnimais.isEmpty()) {
					for (Animal animal: tamAnimais) {
						JOptionPane.showMessageDialog(null, animal.toString());
					}
				} else {
					JOptionPane.showMessageDialog(null, "Não foi encontrado animal da cor pesquisada");
				}
				break;
			 case "Sair":
					sair = false;
					break;

			}

		}
		JOptionPane.showMessageDialog(null, "FIM DO PROGRAMA");
	}
	/**
	 Gravar os dados usando como separador dos requisitos as duas barras (//)
	 */
	public static void gravarDados(SistemaAdocaoAnimais sistema) throws IOException {
		GravadorDeDados gravador = new GravadorDeDados();
		List<Usuario> usuarios = sistema.getUsuarios();
		List<String> linhas = new ArrayList<String>();
		for (Usuario u : usuarios) {
			String linha = u.getNome() + "#" + u.getCpf() + "#" + u.getDataNascimento() + "#";
			List<Requisito> requisitos = u.getRequisitos();
			String requisitoUsuario = "";
			for (Requisito r : requisitos) {
				requisitoUsuario += r.getNomeRequisito() + "//" + r.getValorEsperadoRequisito() + ";";
			}
			linha += requisitoUsuario;
			linhas.add(linha);
		}
		gravador.gravaTextoEmArquivo(linhas, "usuarios.txt");

		List<Animal> animais = sistema.getAnimais();
		List<String> linhasCachorro = new ArrayList<String>();
		List<String> linhasGato = new ArrayList<String>();

		for (Animal a : animais) {
			if (a instanceof Gato) {
				String linha = a.getNome() + "#" + a.getCodigo() + "#" + a.getDataNascimento() + "#" + a.getTamanho()
						+ "#" + a.isEhBarulhento() + "#" + a.isEhManso() + "#" + a.getCor() + "#" + a.getSexo() + "#"
						+ a.isTemPedigree() + "#" + a.isEstahComVacinasEmDia() + "#" + a.isEstahCastrado() + "#"
						+ a.getTipoAlimentacao() + "#" + a.getDetalhes();

				linhasGato.add(linha);

			} else {
				String linha = a.getNome() + "#" + a.getCodigo() + "#" + a.getDataNascimento() + "#" + a.getTamanho()
						+ "#" + a.isEhBarulhento() + "#" + a.isEhManso() + "#" + a.getCor() + "#" + a.getSexo() + "#"
						+ a.isTemPedigree() + "#" + a.isEstahComVacinasEmDia() + "#" + a.isEstahCastrado() + "#"
						+ a.getTipoAlimentacao() + "#" + a.getDetalhes();

				linhasCachorro.add(linha);

			}
		}

		
		gravador.gravaTextoEmArquivo(linhasGato, "gatos.txt");
		gravador.gravaTextoEmArquivo(linhasCachorro, "cachorros.txt");
	}

	public static void recuperarDados(SistemaAdocaoAnimais sistema) throws IOException {
		GravadorDeDados gravador = new GravadorDeDados();
		List<Usuario> usuarios = new ArrayList<Usuario>();
		List<String> linhas = gravador.recuperaTextoEmArquivo("usuarios.txt");
		for (String linha : linhas) {
			String[] dados = linha.split("#");
			String[] listaReq = dados[3].split(";");
			
			List<Requisito> listaRequisitos = new ArrayList<>();
			for(String lista: listaReq) {
				String[] dadosRequisitos = lista.split("//");
				listaRequisitos.add(new Requisito(dadosRequisitos[0],dadosRequisitos[1]));
			}
			
			Usuario u = new Usuario(dados[0], dados[1], dados[2], listaRequisitos);
			usuarios.add(u);
		}
				
		sistema.setUsuarios(usuarios);
		
		List<Animal> animais = new ArrayList<Animal>();
		List<String> linhasGato = gravador.recuperaTextoEmArquivo("gatos.txt");
		for (String linha : linhasGato) {
			String[] dados = linha.split("#");
			Animal a = new Gato(dados[0], dados[1], dados[2], dados[3], parseBoolean(dados[4]), parseBoolean(dados[5]), dados[6], 
					dados[7], parseBoolean(dados[8]), parseBoolean(dados[9]), parseBoolean(dados[10]), dados[11], dados[12]);
			animais.add(a);
			
		}

		List<String> linhasCachorro = gravador.recuperaTextoEmArquivo("cachorros.txt");
		for (String linha : linhasCachorro) {
			String[] dados = linha.split("#");
			Animal a = new Cachorro(dados[0], dados[1], dados[2], dados[3], parseBoolean(dados[4]),
					parseBoolean(dados[5]), dados[6], dados[7], parseBoolean(dados[8]), parseBoolean(dados[9]),
					parseBoolean(dados[10]), dados[11], dados[12]);
			animais.add(a);
		}
		sistema.setAnimais(animais);
	}
	
	/*
	 * Método para pedir os dados do usuário, caso o usuário não forneça nenhum dado, o programa irá insistir até que ele digite algo. 
	 * Além disso, o programa exibe uma mensagem de "Operação cancelada, caso o usuário deseje cancelar a operação.
	 */
	
	private static String pedidoDeDados(String mensagem) throws OperacaoCanceladaException {
		String pedido = JOptionPane.showInputDialog(mensagem);
		if(pedido == null) {
			throw new OperacaoCanceladaException("Operação cancelada pelo usuário");
		}
		while(pedido.replace(" ", "").equals("")) {
			pedido = JOptionPane.showInputDialog("É necessário que você forneça algum dado \n "+ mensagem);
			if(pedido == null) {
				throw new OperacaoCanceladaException("Operação cancelada pelo usuário");
				
			}
		}
		return pedido;
		
	}
	/*
	 * Método para que as opções sejam expostas em forma de lista em que se posso selecionar e escolher a opção
	 */
	private static String opcoesDados(String mensagem, String[] opcoes) throws OperacaoCanceladaException {
		String opcaoPedido = null;
		opcaoPedido= JOptionPane.showInputDialog(null, mensagem, "Sistema Adoção de Animais",
				JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]).toString();

		if (opcaoPedido == null) {
			throw new OperacaoCanceladaException("Operação foi cancelada pelo usuário");
		}
		return opcaoPedido;
	}
	/*
	 * Método para criação do botão e pedir sim ou não ao usuário
	 */
	private static boolean pedirSimOuNao(String mensagem) {
		String [] simOuNao = {"Sim", "Não"};
		String resposta = simOuNao[JOptionPane.showOptionDialog(null, mensagem, "Sistema Adoção de Animais", 
				JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, simOuNao, simOuNao[0])];
		boolean dadoRecebido = false;
		if(resposta.equals("Sim")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
}