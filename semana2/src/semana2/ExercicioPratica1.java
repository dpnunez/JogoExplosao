package semana2;
import java.time.LocalDate;

public class ExercicioPratica1 {
	public static void main(String[] args) {
		Pessoa p1 = new Pessoa();
		
		p1.setDataNascimento(LocalDate.of(2000, 4, 16));
		p1.setNome("Fulano");
		p1.setAltura(1.75);
		
		p1.imprimirDados();
	}
}
