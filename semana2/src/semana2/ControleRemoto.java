package semana2;

public class ControleRemoto {
	private int volume;
	private int canal;
	
	public boolean aumentarVolume() {
		if(this.volume < 100) {
			this.volume++;
			return true;
		}
		return false;
	}
	
	public boolean aumentarCanal() {
		if(this.canal < 100) {
			this.canal++;
			return true;
		}
		return false;
	}
	
	public boolean diminuirVolume() {
		if(this.volume > 0) {
			this.volume--;
			return true;
		}
		return false;
	}
	
	public boolean diminuirCanal() {
		if(this.canal > 0) {
			this.canal--;
			return true;
		}
		return false;
	}
	
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public int getCanal() {
		return canal;
	}
	public void setCanal(int canal) {
		if(canal > 0 && canal < 100) {
			this.canal = canal;			
		}
	}
	
}
