package semana4Lembretes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class LembretesApp {
	private BlocoLembretes blocoLembretes;
	public final int sairValor = 6;
	public final int adicionarValor = 1;
	public final int removerValor = 2;
	public final int listarValor = 3;
	public final int buscarDataValor = 4;
	public final int buscarNomeValor = 5;
	
	public LembretesApp() {
		this.blocoLembretes = new BlocoLembretes();
	}
	
	public BlocoLembretes getBlocoLembretes() {
		return blocoLembretes;
	}
	
	public void menu() {
		System.out.println("Lembretes App - a lista contém " + this.blocoLembretes.numeroDeLembretes()
 				+ " lembretes.\n"
				+ "Escolha uma das seguintes opções:\n"
				+ adicionarValor + " - Adicionar\n"
				+ removerValor + " - Remover\n"
				+ listarValor + " - Listar\n"
				+ buscarDataValor + " - Busca por data\n"
				+ buscarNomeValor + " - Busca por nome\n"
				+ sairValor + " - sair");
	}
	
//	1- Adicionar novo lembrete
//	2- Remover lembrete
//	3- Listar
//	4- Busca por data
//	5- Busca por nome
//	6- Sair
	
	
	public static void main(String[] args) {
		LembretesApp app = new LembretesApp();
		BlocoLembretes bloco = app.getBlocoLembretes();
		Scanner scan = new Scanner(System.in);
		DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		int opcao;
		
		
		while(true) {
			app.menu();
			opcao = scan.nextInt();
			scan.nextLine(); // esvaziar buffer
			
			
			if (opcao == app.adicionarValor) {
				System.out.println("Titulo: ");
				String titulo = scan.nextLine();
				System.out.println("\nDescrição: ");
				String descricao = scan.nextLine();
				System.out.println("\nInforme a data (dd/mm/aaaa): ");
				String data = scan.next();
				
				Lembrete lembreteAdd = new Lembrete(LocalDate.parse(data, dataFormatter), titulo, descricao);
				bloco.incluirLembrete(lembreteAdd);
			} else if (opcao == app.removerValor) {
				System.out.println("\nInforme o indice para remoção: ");
				int indexParaRemover = scan.nextInt();
				scan.nextLine();
				bloco.removerLembrete(indexParaRemover);
				
			} else if (opcao == app.listarValor) {
				bloco.listarLembretes();
			} else if (opcao == app.buscarDataValor) {
				System.out.println("\nInforme a data (dd/mm/aaaa): ");
				String data = scan.next();
				bloco.buscarLembretesPorData(LocalDate.parse(data, dataFormatter));
			} else if (opcao == app.buscarNomeValor) {
				System.out.println("\nInforme o titulo do lembrete: ");
				String tituloSubstring = scan.nextLine();
				
				bloco.buscarLembretesPorNome(tituloSubstring);
			} else if (opcao == app.sairValor) {
				break;
			} else {
				System.out.println("Nao suportada");
			}
		}
	}
}
