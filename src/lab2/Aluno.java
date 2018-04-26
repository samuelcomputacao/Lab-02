package lab2;

import java.util.HashSet;
import java.util.Set;

/**
 * Representa um aluno
 * 
 * @author Samuel Pereira de vasconcelos
 *
 */

public class Aluno {
	
	/**
	 * Representa todas as disciplinas que um aluno possui
	 */
	private Set<Disciplina> disciplinas;
	
	/**
	 * Representa todas as contas de cantina que o aluno possui
	 */
	private Set<ContaCantina> cantinas;
	
	/**
	 * Representa todas as contas de laboratório que o alun possui.
	 */
	private Set<ContaLaboratorio> laboratorios;
	
	/**
	 * Representa a saúde de um aluno
	 */
	private Saude saude;
	
	/**
	 * Constrói um aluno com os valores de disciplinas, cantinas e laboratótios zerados
	 */
	public Aluno() {
		this.disciplinas = new HashSet<Disciplina>();
		this.cantinas = new HashSet<ContaCantina>();
		this.laboratorios = new HashSet<ContaLaboratorio>();
	}

}
