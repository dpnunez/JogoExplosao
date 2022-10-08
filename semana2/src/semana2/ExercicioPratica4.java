package semana2;

public class ExercicioPratica4 {
	public static void main(String[] args) {
		Relogio teste = new Relogio();
		
		for(int i = 0; i <= 1441; i++) {
			teste.atualizaVisor();
			teste.eventoDoRelogio();
		}
	}
}
