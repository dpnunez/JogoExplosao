package semana2;

public class ExercicioPratica2 {
	public static void main(String[] args) {
		Elevador ev = new Elevador(4, 3);
		
		ev.loggarInfos();
		ev.sobe();
		ev.sobe();
		
		ev.loggarInfos();
		
		ev.entra();
		ev.entra();
		ev.entra();
		ev.entra();
		
		ev.loggarInfos();
		
		
		ev.desce();
		ev.desce();
		ev.desce();
		
		ev.loggarInfos();
		
		ev.sai();
		ev.sai();
		ev.sai();
		ev.sai();
		
		ev.loggarInfos();
	}
}
