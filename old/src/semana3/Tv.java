package semana3;

public class Tv {
	private int volume;
	private int canal;
	private int maxCanais;
	private int maxVolume;
	
	public Tv() {
		this.volume = 0;
		this.canal = 0;
		this.maxCanais = 100;
		this.maxVolume = 100;
	}
	
	public Tv(int maxCanais, int maxVolume) {
		this.volume = 0;
		this.canal = 0;
		this.maxCanais = maxCanais;
		this.maxVolume = maxVolume;
	}
	
	public Tv(Tv cp) {
		this.volume = cp.getVolume();
		this.canal = cp.getCanal();
		this.maxCanais = cp.getMaxCanais();
		this.maxVolume = cp.getMaxVolume();
	}
	
	public boolean aumentarVolume() {
		if(this.volume < this.maxVolume) {
			this.volume++;
			return true;
		}
		return false;
	}
	
	public boolean aumentarCanal() {
		if(this.canal < this.maxCanais) {
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
	public boolean setVolume(int volume) {
		if(volume >= 0 && volume <= this.maxVolume) {
			this.volume = volume;
			return true;
		}
		
		return false;
	}
	public int getCanal() {
		return canal;
	}
	public boolean setCanal(int canal) {
		if(canal > 0 && canal < this.maxCanais) {
			this.canal = canal;		
			return true;
		}
		
		return false;
	}
	
	public int getMaxCanais() {
		return maxCanais;
	}
	
	public int getMaxVolume() {
		return maxVolume;
	}
	
	public void setMaxCanais(int maxCanais) {
		this.maxCanais = maxCanais;
	}
	
	public void setMaxVolume(int maxVolume) {
		this.maxVolume = maxVolume;
	}
	
	public void imprime() {
		System.out.println(this);
	}
	
	@Override
    public String toString() {
        return "canal: " + this.canal + "\n" +
        		"volume: " + this.volume;
    }
}
