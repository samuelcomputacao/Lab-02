package lab2;

import java.util.List;
import java.util.ArrayList;

/**
 * 
 * Representação de uma conta na cantina.
 *
 * 
 * @author Samuel pereira de Vasconcelos
 * 
 */

public class ContaCantina {

	private String nomeDaCantina;
	private List<Lanche> lanches;
	private int conta;
	
	/**
	 * Constrói uma contana cantina a partir de seu nome.
	 *
	 * 
	 * @param nomeDaCantina
	 * 
	 */

	public ContaCantina(String nomeDaCantina) {
		this.nomeDaCantina = nomeDaCantina;
		this.lanches = new ArrayList<Lanche>();
		this.conta = 0;
	}

	/**
	 * Adiciona um lanche alista de lanches
	 * 
	 * @param qtdItens
	 *            : quantidades de iten a ser adicionados
	 * 
	 * @param valorCentavos:
	 *            valor total em centavos do lanche que vai ser adicionado
	 * 
	 */

	public void cadastraLanche(int qtdItens, int valorCentavos) {
		Lanche lanche = new Lanche(qtdItens, valorCentavos);
		this.conta += valorCentavos;
		this.lanches.add(lanche);
	}

	/**
	 * Adiciona um lanche com detalhe
	 * 
	 * @param qtdItens
	 *            : quantidades de iten a ser adicionados
	 * 
	 * @param valorCentavos:
	 *            valor total em centavos do lanche que vai ser adicionado
	 * 
	 * @param detalher
	 *            : Detalhe do lanche que será adicionado
	 * 
	 */

	public void cadastrarLanche(int qtdItens, int valorCentavos, String detalhes) {
		Lanche lanche = new Lanche(qtdItens, valorCentavos,detalhes);
		this.conta += valorCentavos;
		this.lanches.add(lanche);
		
	}

	/**
	 * Todo aluno precisa para a conta
	 * 
	 * @param valorCentavos:
	 *            valor em centavos do que vai ser pago
	 * 
	 */

	public void pagaConta(int valorCentavos) {
		this.conta -= valorCentavos;
	}

	/**
	 * 
	 * Retorna a String que representa o uma conta na cantina.
	 *
	 * @returns a representação em String de uma Conta na Cantina.
	 */

	@Override
	public String toString() {
		String str = String.format("%s %d %d", this.nomeDaCantina, this.qtdItens(), this.conta);
		return str;
	}

	/**
	 * Retorna a quantidade de itens que já foi consumido la cantina
	 * 
	 * @return retorna um inteiro
	 */
	private int qtdItens() {
		int retorno = 0;
		for(Lanche lanche : lanches) {
			retorno += lanche.getQuantidade();
		}
		return retorno;
	}
	
	/**
	 * Retorna uma representação do nome da cantina
	 * 
	 * @return Uma String representando a cantina
	 */
	public String getNomeDaCantina() {
		return this.nomeDaCantina;
	}

}
