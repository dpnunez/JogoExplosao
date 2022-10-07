package semana2;

public class ExercicioPratica3 {
	public static void main(String[] args) {
		ControleRemoto controle = new ControleRemoto();
		
		System.out.println("canal " + controle.getCanal());
		System.out.println("volume " + controle.getVolume());
		
		controle.diminuirCanal();
		controle.aumentarCanal();
		controle.aumentarVolume();
		
		System.out.println("canal " + controle.getCanal());
		System.out.println("volume " + controle.getVolume());
		
		controle.setCanal(40);
		System.out.println("canal " + controle.getCanal());
		controle.setCanal(1002);
		System.out.println("canal " + controle.getCanal());
	}
}
