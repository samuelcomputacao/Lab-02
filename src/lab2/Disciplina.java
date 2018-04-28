package lab2;

/**
 * 
 * Representação de uma Disciplina.
 *
 * 
 * @author Samuel pereira de Vasconcelos
 * 
 */

public class Disciplina {
	
	
	/**
	 * Uma String representanco o nomde da disciplina
	 */
	private String nomeDisciplina;
	
	/**
	 * Armazena todas as notas da disciplina
	 */
	private double[] notas;
	
	/**
	 * representa a carga horária da disciplina
	 */
	private int horas;
	
	/**
	 * Representa todos os pesos de cada nota da disciplina
	 */
	private int[] pesos;
	
	
	/**
	 * Constrói uma Disciplina a partir de seu nome.
	 *
	 * 
	 * @param nomeDisiciplina :  representa o nome que será dado ao laboratório
	 *
	 * Como padrão: todo laboratório inicia com uma carga horária 0
	 */
	public Disciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
		this.notas = new double[4];
		this.horas = 0;
	}
	
	/**
	 * Constrói uma Disciplina a partir de seu nome e a quantidade de notas que ela possui
	 *
	 * @param qtdNotas : representa a quantidade de notas que uma disciplina possui
	 * @param nomeDisiciplina :  representa o nome que será dado ao laboratório
	 *
	 * Como padrão: todo laboratório inicia com uma carga horária 0
	 */
	public Disciplina(String nomeDisciplina,int qtdNotas) {
		this.nomeDisciplina = nomeDisciplina;
		this.notas = new double[qtdNotas];
		this.horas = 0;
	}
	
	/**
	 * Constrói uma Disciplina a partir de seu nome.
	 *
	 * 
	 * @param nomeDisiciplina :  representa o nome que será dado ao laboratório
	 * @param qtdNotas : representa a quantidade de notas que uma disciplina possui
	 * @param pesos : representa os pesos de cada disciplina 
	 * Como padrão: todo laboratório inicia com uma carga horária 0
	 */
	public Disciplina(String nomeDisciplina,int qtdNotas,int[] pesos) {
		this.nomeDisciplina = nomeDisciplina;
		this.notas = new double[qtdNotas];
		this.horas = 0;
		this.pesos = pesos;
	}
	
	
	/**
	 * Cadastra a quantidade de horas a uma disciplina
	 * @param horas : representa a carga horária de uma disciplina
	 */
	public void cadastraHoras(int horas) {
		this.horas = horas;
	}
	
	/**
	 * Cadastra uma nota a disciplina
	 * 
	 * @param nota : representa qual nota será adicionada.
	 * @param valorNota : representa o valor da nota que será adicionada
	 */
	public void cadastraNota(int nota, double valorNota) {
		this.notas[nota-1] = valorNota;
	}
	
	
	/**
	 * Verifica se um aluno foi aprovado ou não. Logo, se o aluno possuir média maior ou igual a 7 ele será aprovado
	 * caso contrario, reprovado
	 *  
	 * @return retorna um boleano a partir da decisão.
	 */
	public boolean aprovado() {
		return (this.media()>=7);
	}
	
	/**
	 * Calcula a media de um aluno, que pode ser ponderada ou não.
	 * 
	 * @return a media do aluno.
	 */
	private double media() {
		double soma = 0;
		
		if(this.pesos!=null) {
			int pesoTotal = 0;
			for(int i = 0; i < this.notas.length; i++) {
				soma += this.notas[i]*this.pesos[i];
				pesoTotal += this.pesos[i];
			}
			return soma/pesoTotal;
			
		}else {
			for(int i = 0; i < this.notas.length; i++) {
				soma += this.notas[i];
			}
			return soma/4;
		}
		
	}
	
	/**
	 * Constrói uma representação de uma disciplina
	 * 
	 * @return retona uma string representando uma string.
	 */
	@Override
	public String toString() {
		String str = String.format("%s %d %s %s",this.nomeDisciplina,this.horas,String.valueOf(this.media()),this.notasToString());
		return str;
	}

	/**
	 * Constrói uma representação de todas as notas da disciplina. 
	 * 
	 * @return retorna uma String representado todas as notas de uma disicplina 
	 */
	private String notasToString() {
		String str = "[";
		for(int i = 0; i < this.notas.length; i++) {
			if (i != 0) str += ", ";
			str += String.valueOf(this.notas[i]);
		}
		return str+"]";
	}
	
	/**
	 * Retorna o nome da disicplina  
	 * @return Uma String representando o nome da disciplina
	 */
	public String getNomeDisciplina() {
		return this.nomeDisciplina;
	}
	
	



}
