package lab2;

import java.util.HashSet;
import java.util.Iterator;
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
	
	/**
	 * Cadastra uma nova conta de labaratório com cota padrão a um aluno
	 * 
	 * @param nomeLaboratorio : nome do novo laboratório que será adicionado
	 */
	public void cadastraLaboratorio(String nomeLaboratorio) {
		this.laboratorios.add(new ContaLaboratorio(nomeLaboratorio));
	}
	
	/**
	 * Cadastra uma nova conta de labaratório com cota específica a um aluno
	 * 
	 * @param nomeLaboratorio : nome do novo laboratório que será adicionado
	 * @param cota : tamanho do espaço máximo que será utilizado pelo laboratório
	 */
	public void cadastraLaboratorio(String nomeLaboratorio, int cota) {
		this.laboratorios.add(new ContaLaboratorio(nomeLaboratorio, cota));
	}
	
	/**
	 * Altera o valor total utilizado pelo laboratório
	 * @param nomeLaboratorio : Nome do laboratório que será modificado
	 * @param mbytes : Quantidade a ser crementada
	 */
	public void consomeEspaco(String nomeLaboratorio, int mbytes) {
		ContaLaboratorio conta = buscaConta(nomeLaboratorio,this.laboratorios);
		conta.consomeEspaco(mbytes);
		
	}
	
	/**
	 * Altera o valor total utilizado pelo laboratório
	 * @param nomeLaboratorio : Nome do laboratório que será modificado
	 * @param mbytes : Quantidade a ser crementada
	 */
	public void liberaEspaco(String nomeLaboratorio, int mbytes) {
		ContaLaboratorio conta = buscaConta(nomeLaboratorio,this.getLaboratorios());
		conta.liberaEspaco(mbytes);
	}
	
	public boolean atingiuCota(String nomeLaboratorio) {
		ContaLaboratorio conta = buscaConta(nomeLaboratorio,this.laboratorios);
		return conta.atingiuCota();
	}
	
	
	/**
	 * Busca no conjunto de contas  que tem um nome específico
	 * @param nome: o nome da conta  a ser buscada
	 * @param tipo : o tipo de conta a ser buscado
	 * @return uma conta de laboratório
	 */
	private Conta buscaConta(String nome, Set<Conta> conjunto) {
		Iterator<Conta> iterator = conjunto.iterator();
		while(iterator.hasNext()) {
			Conta conta = iterator.next();
			if(conta.getNome().equals(nome)) {
				return conta;
			}
		}
		return null;
	}

	/**
	 * 
	 * @return Retorna as disciplinas de um aluno
	 */
	public Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	
	/**
	 * Modifica as disciplinas de um aluno
	 * @param disciplinas : Refere-se a conjunto de discipinas de um aluno
	 */
	public void setDisciplinas(Set<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	/**
	 * @return Retorna todas as contas de cantinas de um aluno
	 */
	public Set<ContaCantina> getCantinas() {
		return cantinas;
	}
	
	/**
	 * Modifica as contas nas cantinas de um aluno
	 * @param cantinas: faz referencia a um conjunto de cantinas
	 */
	public void setCantinas(Set<ContaCantina> cantinas) {
		this.cantinas = cantinas;
	}
	
	/**
	 * Retorna todas as contas em laboratórios de um aluno 
	 * @return Um conjunto de laboratórios
	 */
	public Set<ContaLaboratorio> getLaboratorios() {
		return laboratorios;
	}

	/**
	 * Modifica todas as contas de laborátorio de um aluno
	 * @param laboratorios : Faz referência a um conjunto de conta de laboratório
	 */
	public void setLaboratorios(Set<ContaLaboratorio> laboratorios) {
		this.laboratorios = laboratorios;
	}
	
	/**
	 * Retorna a saude em que o aluno se encontra
	 * @return O estado de saude de um aluno 
	 */
	public Saude getSaude() {
		return saude;
	}

	/**
	 * Modifica o estado de saúde de um aluno
	 * @param saude : refere-se a saude do aluno
	 */
	public void setSaude(Saude saude) {
		this.saude = saude;
	}

}
