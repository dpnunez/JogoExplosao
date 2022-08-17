package semana3;

import java.time.LocalTime;

public class Relogio {
	private int horas;
	private int minutos;
	
	public Relogio(int horas, int minutos) {
		this.horas = horas;
		this.minutos = minutos;
	}
	
	public Relogio() {
		this(LocalTime.now().getHour(), LocalTime.now().getMinute());
	}
	
	public Relogio(Relogio cp) {
		this.horas = cp.getHoras();
		this.minutos = cp.getMinutos();
	}
	
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
	
	public int getHoras() {
		return horas;
	}
	
	public int getMinutos() {
		return minutos;
	}
	
}
