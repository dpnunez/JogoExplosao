package semana3;

//Exercício 2: Crie uma classe denominada Elevador para armazenar as informações de
//um elevador dentro de um prédio. A classe deve armazenar o andar atual (térreo = 0),
//total de andares no prédio (desconsiderando o térreo), capacidade do elevador e
//quantas pessoas estão presentes nele. A classe deve também disponibilizar os seguintes
//métodos:
//● Inicializa : que deve receber como parâmetros a capacidade do elevador e o total
//de andares no prédio (os elevadores sempre começam no térreo e vazio);
//● Entra : para acrescentar uma pessoa no elevador (só deve acrescentar se ainda
//houver espaço);
//● Sai : para remover uma pessoa do elevador (só deve remover se houver alguém
//dentro dele);
//● Sobe : para subir um andar (não deve subir se já estiver no último andar)

public class Elevador {
	private int andarAtual;
	private int totalDeAndares;
	private int capacidade;
	private int lotacaoAtual;
	
	public Elevador(int totalDeAndares, int capacidade) {
		this.totalDeAndares = totalDeAndares;
		this.capacidade = capacidade;
	}
	
	public Elevador() {
		this(1, 1);
	}
	
	public Elevador(Elevador cp) {
		this.totalDeAndares = cp.getTotalDeAndares();
		this.capacidade = cp.getCapacidade();
	}
	
	

	
	// Metodos
	public void loggarInfos() {
		System.out.println("Andar: " + this.andarAtual);
		System.out.println("Pessoas " + this.lotacaoAtual);
	}
	
	public boolean entra() {
		if(this.lotacaoAtual < this.capacidade) {
			this.lotacaoAtual++;
			return true;
		}
		
		return false;
	}
	
	public boolean sai() {
		if(this.lotacaoAtual > 0) {
			this.lotacaoAtual--;
			return true;
		}
		
		return false;
	}
	
	public boolean sobe() {
		if(this.andarAtual < this.totalDeAndares) {
			this.andarAtual++;
			return true; 
		}
		
		return false;
	}
	
	public boolean desce() {
		if(this.andarAtual > 0) {
			this.andarAtual--;
			return true; 
		}
		return false;
	}
	
	// Getters and setters
	public int getAndarAtual() {
		return andarAtual;
	}

	public void setAndarAtual(int andarAtual) {
		this.andarAtual = andarAtual;
	}

	public int getLotacaoAtual() {
		return lotacaoAtual;
	}

	public void setLotacaoAtual(int lotacaoAtual) {
		this.lotacaoAtual = lotacaoAtual;
	}
	
	public int getTotalDeAndares() {
		return totalDeAndares;
	}
	
	public int getCapacidade() {
		return capacidade;
	}
}
