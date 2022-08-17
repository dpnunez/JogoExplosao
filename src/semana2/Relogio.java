package semana2;

public class Relogio {
	private int horas;
	private int minutos;
	
	public void atualizaVisor() {
		System.out.println(String.format("%02d", this.horas) + ":" + String.format("%02d", this.minutos));
	}
	
	public void eventoDoRelogio() {
		if(this.minutos < 59) {
			// Incrementar somente minutos;
			this.minutos++;
		} else if(this.horas < 23) {
			// Incrementar horas;
			this.minutos = 0;
			this.horas++;
		} else {
			// Virada do dia
			this.horas = 0;
			this.minutos = 0;
		}
	}
	
}
