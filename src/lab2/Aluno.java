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
	 * Representa a matrícula de um aluno
	 */
	private long matricula;
	
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
	 * Constrói um aluno com os valores de disciplinas, cantinas e laboratórios zerados
	 */
	public Aluno(long matricula) {
		this.disciplinas = new HashSet<Disciplina>();
		this.cantinas = new HashSet<ContaCantina>();
		this.laboratorios = new HashSet<ContaLaboratorio>();
		this.matricula = matricula;
		this.saude = new Saude();
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
		ContaLaboratorio conta = buscaContaLab(nomeLaboratorio);
		conta.consomeEspaco(mbytes);		
	}
	
	/**
	 * Altera o valor total utilizado pelo laboratório
	 * @param nomeLaboratorio : Nome do laboratório que será modificado
	 * @param mbytes : Quantidade a ser crementada
	 */
	public void liberaEspaco(String nomeLaboratorio, int mbytes) {
		ContaLaboratorio conta = buscaContaLab(nomeLaboratorio);
		conta.liberaEspaco(mbytes);
	}
	
	/**
	 * Verifica se um aluno já atingiu o estapaço total liberado pelolaboratório
	 * @param nomeLaboratorio : Nome do laboratório que será verificado
	 */
	public boolean atingiuCota(String nomeLaboratorio) {
		ContaLaboratorio conta = buscaContaLab(nomeLaboratorio);
		return conta.atingiuCota();
	}
	
	/**
	 * Constrói uma represenção de um laboratório 
	 * @return retorna uma string que representa o laboratório
	 */
	public String laboratorioToString(String nomeLaboratorio) {
		ContaLaboratorio conta= buscaContaLab(nomeLaboratorio);
		return conta.toString();
		
	}
	
	/**
	 * Cadastra uma nova disciplina ao conjunto de disciplina de um determinado aluno  
	 * @param nomeDisciplina :  Uma String que representa o nome da nova disciplina
	 */
	public void cadastraDisciplina(String nomeDisciplina) {
		Disciplina disciplina = new Disciplina(nomeDisciplina);
		this.disciplinas.add(disciplina);
	}
	
	/**
	 * Cadastra uma carga horária a uma determinada disciplina do conjunto de disciplinas  
	 * @param nomeDisciplina :  Uma String que representa o nome da disciplina
	 * @param horas : UM inteiro representando a carga horária da disciplina
	 */	
	public void cadastraHoras(String nomeDisciplina, int horas) {
		Disciplina disciplina = buscaDisciplina(nomeDisciplina);
		disciplina.cadastraHoras(horas);		
	}
	
	/**
	 * Cadastra uma nota a uma disciplina de um determinado aluno  
	 * @param nomeDisciplina :  Uma String que representa o nome da disciplina
	 * @param nota  : Um inteiro representando qual nota será cadastrada
	 * @param valorNota : Um valor de ponto flutuante representando o valor da nota
	 */
	public void cadastraNota(String nomeDisciplina, int nota, double valorNota) {
		Disciplina disciplina = buscaDisciplina(nomeDisciplina);
		disciplina.cadastraNota(nota, valorNota);
	}
	
	/**
	 * Verifica se o aluno está aprovado  
	 * @param nomeDisciplina :  Uma String que representa o nome da disciplina
	 * @return Um valor boleano que representa se o aluno está aprovado ou não
	 */
	public boolean aprovado(String nomeDisciplina) {
		Disciplina disciplina = buscaDisciplina(nomeDisciplina);
		return disciplina.aprovado();
	}
	
	/**
	 * Constrói uma representação para uma determinad disciplina de um aluno  
	 * @param nomeDisciplina :  Uma String que representa o nome da disciplina
	 * @return Uma String representando uma disciplina de um aluno 
	 */
	public String disciplinaToString(String nomeDisciplina) {
		Disciplina disciplina = buscaDisciplina(nomeDisciplina);
		return disciplina.toString();
	}
	
	/**
	 * Cria uma nova conta na cantina para um determinado aluno  
	 * @param nomeCantina :  Uma String que representa o nome da cantina
	 */
	public void cadastraCantina(String nomeCantina) {
		ContaCantina cantina = new ContaCantina(nomeCantina);
		this.cantinas.add(cantina);
	}
	

	/**
	 * Cria um novo lanche de um aluno em uma determinada cantina  
	 * @param nomeCantina :  Uma String que representa o nome da cantina
	 * @param qtdItens : Um inteirorepresentando a quantidade de itens que será adicionado 
	 * @param valorCentavos : Um inteiro representando o preço do lanche
	 */
	public void cadastraLanche(String nomeCantina, int qtdItens, int valorCentavos) {
		ContaCantina cantina = buscaCantina(nomeCantina);
		cantina.cadastraLanche(qtdItens, valorCentavos);
	}
	
	/**
	 * Realiza um pagamento em centavos em uma determinada cantina  
	 * @param nomeCantina :  Uma String que representa o nome da cantina onde será feito o pagamento
	 */
	public void pagarConta(String nomeCantina, int valorCentavos) {
		ContaCantina cantina = buscaCantina(nomeCantina);
		cantina.pagaConta(valorCentavos);
	}
	
	/**
	 * Constrói uma representação para uma determinada cantina de um aluno  
	 * @param nomeCantina :  Uma String que representa o nome da cantina
	 */
	public String cantinaToString(String nomeCantina) {
		ContaCantina cantina = buscaCantina(nomeCantina);
		return cantina.toString();
	}
	
	/**
	 * Define a situação da saúde Mental de um determinado aluno  
	 * @param valor :  Situação da saúde mental
	 */
	public void defineSaudeMental(String valor) {
		this.saude.defineSaudeMental(valor);
	}
	
	/**
	 * Define a situação da saúde Fisíca de um determinado aluno  
	 * @param valor :  Situação da saúde fisica
	 */
	public void defineSaudeFisica(String valor) {
		this.saude.defineSaudeFisica(valor);
	}
	
	/**
	 * Constrói uma representação da situação da saúde de um aluno  
	 * @return Uma String representando a saúde do aluno
	 */
	public String getStatusGeral() {
		return this.saude.getStatusGeral();
	}

	/**
	 * Realiza uma busca no conjunto de cantinas de um determinado aluno  
	 * @param nomeCantina :  Uma String que representa o nome da cantina que será buscada
	 * @return Uma conta de cantina
	 */
	private ContaCantina buscaCantina(String nomeCantina) {
		Iterator<ContaCantina> iterator = this.cantinas.iterator();
		while(iterator.hasNext()) {
			ContaCantina cantina = iterator.next(); 
			if(cantina.getNomeDaCantina().equals(nomeCantina)) return cantina;
		}
		return null;
	}

	/**
	 * Realiza uma busca de disiplina no conjunto de disciplina de um aluno   
	 * @param nomeDisciplina :  Uma String que representa o nome da  disciplina
	 */
	private Disciplina buscaDisciplina(String nomeDisciplina) {
		Iterator<Disciplina> iterator = this.disciplinas.iterator();
		while(iterator.hasNext()) {
			Disciplina disciplina = iterator.next();
			if(disciplina.getNomeDisciplina().equals(nomeDisciplina)) return disciplina;
		}
		return null;
	}

	/**
	 * Busca no conjunto de contas de laboratório  que tem um nome específico
	 * @param nome: o nome da conta  a ser buscada
	 * @param tipo : o tipo de conta a ser buscado
	 * @return uma conta de laboraório
	 */
	private ContaLaboratorio buscaContaLab(String nome) {
		Iterator<ContaLaboratorio> iterator = this.laboratorios.iterator();
		while(iterator.hasNext()) {
			ContaLaboratorio conta = iterator.next();
			if(conta.getNome().equals(nome)) {
				return conta;
			}
		}
		return null;
	}

	/**
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
	 * Modifica todas as contas de laborótorio de um aluno
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
	
	/**
	 * Modifica a matrícula de um aluno
	 * @param matrícula : refere-se a matrícula do aluno
	 */
	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}
	
	
	/**
	 * Retorna a matrícula de uma aluno
	 * 
	 * @return Um valor representando a matrícula
	 */public long getMatricula() {
		return matricula;
	}
	
	/**
	 * Retorna o estado atual de saúde de um aluno
	 * @return Uma String representando a sude do aluno
	 */
	@Override
	public String toString() {
		
		return this.saude.getStatusGeral();
	}
	
}
