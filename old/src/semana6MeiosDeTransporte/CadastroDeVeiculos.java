package semana6MeiosDeTransporte;

import java.util.Arrays;

public class CadastroDeVeiculos {
	private Veiculo[] lista;
	
	public CadastroDeVeiculos() {
		lista = new Veiculo[0];
	}
	
	public void imprimirLength() {
		System.out.println(this.lista.length);
	}
	
	public void inserir(Veiculo v) {
		int novoTamanho = this.lista.length + 1;
		Veiculo[] novaLista = new Veiculo[novoTamanho];
		
		for(int i=0; i < this.lista.length; i++) {
			novaLista[i] = this.lista[i];
		}
		
		novaLista[novoTamanho - 1] = v;
		this.lista = novaLista;
	}
	
	public Veiculo retornaItem(int index) {
		if(index >= this.lista.length) return null;
		
		return this.lista[index];
	}
	
	public int tamanho() {
		return this.lista.length;
	}
	
	public void imprimir() {
		System.out.println("Lista: ");
		for(int i=0; i < this.lista.length; i++)
			this.lista[i].imprimirInformacoes();
	}
	
	public void ordenar() {
		Arrays.sort(this.lista, (o1, o2) -> o1.getModelo().compareTo(o2.getModelo()));
		
	}
	
	
	public static void main(String[] args) {
		CadastroDeVeiculos cd = new CadastroDeVeiculos();
		Automovel v1 = new Carro("Tesla", 4, "a", 2000, 4);
		Automovel v2 = new Carro("Tesla2", 4, "b", 2000, 4);
		Automovel v3 = new Carro("Tesla2", 4, "c", 2000, 4);
		cd.inserir(v2);
		cd.inserir(v3);
		cd.inserir(v1);

		v1.acelerar(10);
		
		cd.ordenar();
		
		cd.imprimir();
	}
}
