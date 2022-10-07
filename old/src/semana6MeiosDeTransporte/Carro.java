package semana6MeiosDeTransporte;

public class Carro extends Automovel {
	private int qtdPortas;
	
	public Carro(String marca, int rodas, String modelo, double potencia, int qtdPortas) {
		super(marca, rodas, modelo, potencia);
		this.qtdPortas = qtdPortas;
	}
	
	public void imprimirInformacoes() {
		super.imprimirInformacoes();
		System.out.println(
				"portas: " + this.qtdPortas + "\n"
				);
	}
}
