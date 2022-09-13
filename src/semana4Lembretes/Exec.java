package semana4Lembretes;

import java.time.LocalDate;

public class Exec {
	public static void main(String[] args) {
		Lembrete lm1, lm2, lm3; 
		BlocoLembretes bloco;
		
		bloco = new BlocoLembretes();
		lm1 = new Lembrete(LocalDate.of(2022, 9, 11), "Aula POO");
		lm2 = new Lembrete(LocalDate.now(), "Aula AOC");
		lm3 = new Lembrete(LocalDate.now(), "Aula MCC");
		
		
//		System.out.println(bloco.numeroDeLembretes());
		bloco.incluirLembrete(lm1);	
		bloco.incluirLembrete(lm2);
		bloco.incluirLembrete(lm3);
//		System.out.println(bloco.numeroDeLembretes());
		
//		bloco.removerLembrete(0);
		
		bloco.listarLembretes();
//		bloco.buscarLembretesPorData(LocalDate.now());
		
//		bloco.buscarLembretesPorNome("POO");
		
	}
}
