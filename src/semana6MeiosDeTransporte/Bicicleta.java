package semana6MeiosDeTransporte;

public class Bicicleta extends Veiculo {
	private int numMarchas;
	private boolean bagageiro;
	
	public Bicicleta(String marca, int rodas, String modelo, int marchas, boolean bagageiro) {
		super(marca, rodas, modelo);
		this.numMarchas = marchas;
		this.bagageiro = bagageiro;
	}
	
	public void imprimirInformacoes() {
		super.imprimirInformacoes();
		System.out.println(
				"marchas: " + numMarchas + "\n" +
				"bagageiro: " + bagageiro + "\n"
				);
	}
}
