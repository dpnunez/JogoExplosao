package semana6MeiosDeTransporte;

public class Veiculo {
	private String marca;
	private int qtdRodas;
	private String modelo;
	private int velocidade;
	
	public Veiculo(String marca, int rodas, String modelo) {
		this.marca = marca;
		this.qtdRodas = rodas;
		this.modelo = modelo;
	}
	
	public void imprimirInformacoes() {
		System.out.println(
				"marca: " + marca + "\n" +
				"rodas: " + qtdRodas + "\n" +
				"modelo: " + modelo + "\n" +
				"velocidade: " + velocidade
				);
	}
	
	public void acelerar(int valor) {
		this.velocidade += valor;
	}
	
	public void frear(int valor) {
		this.velocidade -= valor;
	}
	
	public int getQtdRodas() {
		return qtdRodas;
	}
	
	public String getModelo() {
		return modelo;
	}
}
