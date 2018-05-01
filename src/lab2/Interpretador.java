package lab2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Testando as funcionalidades do sistema. Todos os comandos estão sendo buscado no arquivo comando.txt que se encontra
 * na pasta comandos.
 
 * 
 * @author Samuel pereira de Vasconcelos
 *
 */
public class Interpretador {

	private static Set<Aluno> alunos = new HashSet<Aluno>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		File file = new File(new File("").getAbsolutePath() + "/comandos/comandos.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		while (bufferedReader.ready()) {
			String linha= bufferedReader.readLine();
			String[] comando = linha.split(" ");
			if (comando[0].equals("CADASTRAR_ALUNO")) {
				Aluno aluno = new Aluno(Long.parseLong(comando[1]));
				alunos.add(aluno);
				System.out.println("Aluno Cadastrado: " + comando[1]);

			} else if (comando[0].equals("CADASTRAR_LABORATORIO")) {
				long matricula = Long.parseLong(comando[1]);
				String nomeLab = comando[2];
				Aluno aluno = buscaAluno(matricula);
				if (comando.length > 3) {
					int cota = Integer.parseInt(comando[3]);
					aluno.cadastraLaboratorio(nomeLab, cota);
				} else {
					aluno.cadastraLaboratorio(nomeLab);
				}
				System.out.println("Laboratório cadastrado : " + matricula + " " + aluno.laboratorioToString(nomeLab));
			} else if (comando[0].equals("CONSOME_ESPACO")) {
				long matricula = Long.parseLong(comando[1]);
				String nomeLab = comando[2];
				int mbytes = Integer.parseInt(comando[3]);
				Aluno aluno = buscaAluno(matricula);
				aluno.consomeEspaco(nomeLab, mbytes);
				System.out.println("Laboratório consumido : " + matricula + " " + aluno.laboratorioToString(nomeLab));
			} else if (comando[0].equals("LIBERA_ESPACO")) {
				long matricula = Long.parseLong(comando[1]);
				String nomeLab = comando[2];
				int mbytes = Integer.parseInt(comando[3]);
				Aluno aluno = buscaAluno(matricula);
				aluno.liberaEspaco(nomeLab, mbytes);
				System.out.println("Laboratório Liberado : " + matricula + " " + aluno.laboratorioToString(nomeLab));
			} else if (comando[0].equals("ATINGIU_COTA")) {
				long matricula = Long.parseLong(comando[1]);
				String nomeLab = comando[2];
				Aluno aluno = buscaAluno(matricula);
				if (aluno.atingiuCota(nomeLab)) {
					System.out.println("Atigiu cota: " + aluno.laboratorioToString(nomeLab));
				} else {
					System.out.println("Não atigiu cota: " + aluno.laboratorioToString(nomeLab));
				}
			} else if (comando[0].equals("IMPRIME_LABORATORIO")) {
				long matricula = Long.parseLong(comando[1]);
				String nomeLab = comando[2];
				Aluno aluno = buscaAluno(matricula);
				System.out.println(aluno.laboratorioToString(nomeLab));
			} else if (comando[0].equals("CADASTRAR_DISCIPLINA")) {
				long matricula = Long.parseLong(comando[1]);
				String nomeDisciplina = comando[2];
				Aluno aluno = buscaAluno(matricula);
				aluno.cadastraDisciplina(nomeDisciplina);
				System.out.println("Disciplina cadastrada: " + aluno.disciplinaToString(nomeDisciplina));
			} else if (comando[0].equals("CADASTRA_HORAS")) {
				long matricula = Long.parseLong(comando[1]);
				String nomeDisciplina = comando[2];
				Aluno aluno = buscaAluno(matricula);
				int horas = Integer.parseInt(comando[3]);
				aluno.cadastraHoras(nomeDisciplina, horas);
				System.out.println("Horas cadastradas: " + aluno.disciplinaToString(nomeDisciplina));
			} else if (comando[0].equals("CADASTRA_NOTAS")) {
				long matricula = Long.parseLong(comando[1]);
				String nomeDisciplina = comando[2];
				int nota = Integer.parseInt(comando[3]);
				double valorNota = Double.parseDouble(comando[4]);
				Aluno aluno = buscaAluno(matricula);
				aluno.cadastraNota(nomeDisciplina, nota, valorNota);
				System.out.println("Nota cadastrada: " + aluno.disciplinaToString(nomeDisciplina));
			} else if (comando[0].equals("APROVADO")) {
				long matricula = Long.parseLong(comando[1]);
				String nomeDisciplina = comando[2];
				Aluno aluno = buscaAluno(matricula);
				if (aluno.aprovado(nomeDisciplina)) {
					System.out.println("Aluno " + matricula + " provado em " + nomeDisciplina);
				} else {
					System.out.println("Aluno " + matricula + " reprovado em " + nomeDisciplina);
				}
			} else if (comando[0].equals("CADASTRA_CANTINA")) {
				long matricula = Long.parseLong(comando[1]);
				String nomeCantina = comando[2];
				Aluno aluno = buscaAluno(matricula);
				aluno.cadastraCantina(nomeCantina);
				System.out.println("Cantina cadastrada: " + aluno.cantinaToString(nomeCantina));
			} else if (comando[0].equals("CADASTRA_LANCHE")) {
				long matricula = Long.parseLong(comando[1]);
				String nomeCantina = comando[2];
				int qtdItens = Integer.parseInt(comando[3]);
				int valorCentavos = Integer.parseInt(comando[4]);
				Aluno aluno = buscaAluno(matricula);
				aluno.cadastraLanche(nomeCantina, qtdItens, valorCentavos);
				System.out.println("Lanche cadastrado: " + aluno.cantinaToString(nomeCantina));
			} else if (comando[0].equals("PAGAR_CONTA")) {
				long matricula = Long.parseLong(comando[1]);
				String nomeCantina = comando[2];
				int valorCentavos = Integer.parseInt(comando[3]);
				Aluno aluno = buscaAluno(matricula);
				aluno.pagarConta(nomeCantina, valorCentavos);
				System.out.println("Conta paga: " + aluno.cantinaToString(nomeCantina));
			} else if (comando[0].equals("DEFINE_SAUDE_MENTAL")) {
				long matricula = Long.parseLong(comando[1]);
				String valor = comando[2];
				Aluno aluno = buscaAluno(matricula);
				aluno.defineSaudeMental(valor);
				System.out.println("Saúde mental definida: " + aluno.getStatusGeral());
			} else if (comando[0].equals("DEFINE_SAUDE_FISICA")) {
				long matricula = Long.parseLong(comando[1]);
				String valor = comando[2];
				Aluno aluno = buscaAluno(matricula);
				aluno.defineSaudeFisica(valor);
				System.out.println("Saúde física definida: " + aluno.getStatusGeral());
			} else {
				System.out.println("Comando não encontrado");
			}

		}
		bufferedReader.close();
		fileReader.close();
	}

	/**
	 * Faz uma Buscade um aluno no conjunto de alunos
	 * 
	 * @param matricula
	 *            : representa a matrícula do aluno a ser buscado
	 * @return Retorna um aluno
	 */
	private static Aluno buscaAluno(long matricula) {
		Iterator<Aluno> iterator = alunos.iterator();
		while (iterator.hasNext()) {
			Aluno aluno = iterator.next();
			if (aluno.getMatricula() == matricula)
				return aluno;
		}
		return null;
	}

}