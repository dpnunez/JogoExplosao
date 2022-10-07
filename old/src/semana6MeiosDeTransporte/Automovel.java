package semana6MeiosDeTransporte;

public class Automovel extends Veiculo {
	private double potenciaMotor;
	
	public Automovel(String marca, int rodas, String modelo, double potencia) {
		super(marca, rodas, modelo);
		this.potenciaMotor = potencia;
	}
	
	public void imprimirInformacoes() {
		super.imprimirInformacoes();
		System.out.println(
				"potencia: " + potenciaMotor
				);
	}
	
}
