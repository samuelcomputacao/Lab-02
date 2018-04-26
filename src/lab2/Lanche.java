package lab2;

/**
 * 
 * Representação de um lanche.
 *
 * 
 * @author Samuel pereira de Vasconcelos
 * 
 */
public class Lanche {
	
	/**
	 * Representa a quantidade em unidades de um lanche
	 */
	private int quantidade;
	
	/**
	 * Repreesenta 0 valor total do lanche 
	 */
	private int valor;
	
	/**
	 * Representa o detalhe do lanche, que pode ser seu nome, ou o nome que vc gostar.
	 */
	private String detalhe;
	
	
	/**
	 * Constrói um lanche apartir de sua quanrtidade, valor e detalhe
	 * @param quantidade : Representa a quantidade em unidades de um lanche
	 * @param valor : Repreesenta 0 valor total do lanche
	 * @param detalhe : Representa o detalhe do lanche, que pode ser seu nome, ou o nome que vc gostar.
	 */
	public Lanche(int quantidade,int valor,String detalhe) {
		this.quantidade = quantidade;
		this.valor = valor;
		this.detalhe = detalhe;
	}
	
	/**
	 * Retorna a quantidade de itens daquele lanche
	 * @return retorna um inteiro
	 */
	public int getQuantidade() {
		return quantidade;
	}
	
	/**
	 * Retorna um valor representando o preço de um lanche
	 * @return retorna um inteiro representando o vaor em centavos
	 */
	public int getValor() {
		return valor;
	}
	
	/**
	 * Retorna o detalhe de um lanche
	 * @return retorna uma String 
	 */
	public String getDetalhe() {
		return detalhe;
	}

}
