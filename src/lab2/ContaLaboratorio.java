package lab2;
/**
 * 
 * Representação de uma conta na cantina.
 *
 * 
 * @author Samuel pereira de Vasconcelos
 * 
 */

public class ContaLaboratorio {
	
	private String nomeLaboratorio;
	
	/**
	 * Espaco maximo que um laborátoio pode ocupar 
	 */
	private int cota;
	
	/**
	 * Espaco que o laboratótio esta ocupando
	 */
	private int espaco;
	
	/**
	 * Constrói uma conta no labotatório a partir de seu nome.
	 *
	 * 
	 * @param nomeLaboratório :  representa o nome que será dado ao laboratório
	 *
	 * Como padrão: todo laboratório inicioa com uma cota 2000 e espaco 0
	 */
	
	public ContaLaboratorio(String nomeLaboratorio) {
		this.nomeLaboratorio = nomeLaboratorio;
		this.cota = 2000;
		this.espaco = 0;
	}
	
	/**
	 * Constrói uma conta no labotatório a partir de seu nome e um valor maximo para sua cota.
	 *
	 * 
	 * @param nomeLaboratório :  representa o nome que será dado ao laboratório
	 * @param cota: representa o valor maximo de armazenamento que um laboratório pode ocupar  
	 * Como padrão: todo laboratório inicioa com espaco 0
	 */	
	public ContaLaboratorio(String nomeLaboratorio, int cota) {
		this.nomeLaboratorio = nomeLaboratorio;
		this.cota = cota;
		this.espaco = 0;
	}
	
	public void consomeEspaco(int mbytes) {
		this.espaco += mbytes;
	}
	
	public void liberaEspaco(int mbytes) {
		this.espaco -= mbytes;
	}
	
	public boolean atingiuCota() {
		return espaco >= cota;
	}
	
	@Override
	public String toString() {
		String str = String.format("%s %d/%d",this.nomeLaboratorio,this.espaco,this.cota);;
		return str;
	}
}
