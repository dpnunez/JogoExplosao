package semana3;

public class TesteRefatoracao {
	 public static void main(String[] args) {
		Tv televisao = new Tv(100, 100);
		ControleRemoto controle = new ControleRemoto(televisao);
		
		controle.aumentarVolume();
		controle.proximoCanal();
		
		for(int i = 0; i <= 200; i++) {
			controle.proximoCanal();
		}
		
		televisao.imprime();
	}
}
