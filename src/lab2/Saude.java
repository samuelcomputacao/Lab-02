package lab2;

/**
 * Representa a saúde de alguém
 * @author Samuel Pereira de Vasconcelos
 *
 */
public class Saude {
	
	/**
	 * representa a saúde Fisica de alguém
	 */
	private String saudeFisica;
	
	/**
	 * representa a saúde mental de alguém
	 */
	private String saudeMental;
	
	/**
	 * Representa como alguém está se sentindo
	 */
	private String emoji;
	
	/**
	 * Constrói uma saúde. Logo, toda saúde é inicializada como boa.
	 */
	public Saude() {
		this.saudeFisica = "boa";
		this.saudeMental = "boa";
		this.definirEmoji("");
	}
	
	
	/**
	 * Altera o estado da saúde mental de alguém
	 * 
	 * @param valor : representado o estado de saúde
	 */
	public void defineSaudeMental(String valor) {
		this.saudeMental = valor;
		this.definirEmoji("");
	}
	
	/**
	 * Altera o estado da saúde fisica de alguém
	 * 
	 * @param valor : representado o estado de saúde
	 */
	public void defineSaudeFisica(String valor){
		this.saudeFisica = valor;
		this.definirEmoji("");
	}
	
	/**
	 * representa a saúde de alguem
	 * 
	 * @return Retorna uma String com os status da saúde física e mental
	 */
	public String getStatusGeral() {
		if(this.saudeFisica.equals("boa") && this.saudeMental.equals("boa")) {
			if(this.emoji.length()>0) {
				return "boa " + this.emoji;
			}else{
				return "boa";
			}

		}else if(this.saudeFisica.equals("boa") || this.saudeMental.equals("boa")) {
			if(this.emoji.length()>0) {
				return "ok "+ this.emoji;
			}else{
				return "ok";
			}
		}else{
			if(this.emoji.length()>0) {
				return "fraca "+ this.emoji;
			}
			return "fraca";
		}
	}
	
	public  void definirEmoji(String valor) {
		this.emoji = valor;
	}

}
