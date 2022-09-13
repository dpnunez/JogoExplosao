package semana6MeiosDeTransporte;

public class Moto extends Automovel {
	private boolean partidaEletrica; 
	
	public Moto(String marca, int rodas, String modelo, double potencia, boolean partidaEletrica) {
		super(marca, rodas, modelo, potencia);
		this.partidaEletrica = partidaEletrica;
	}
	
	public void imprimirInformacoes() {
		super.imprimirInformacoes();
		System.out.println(
				"partida eletrica: " + this.partidaEletrica + "\n"
				);
	}
}
