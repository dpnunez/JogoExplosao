package semana3Banco;

public class Telefone {
	private String ddd;
	private String numero;
	
	public Telefone() {
		this.ddd = null;
		this.numero = null;
	}
	
	public Telefone(String ddd, String numero) {
		this.ddd = ddd;
		this.numero = numero;
	}
	
	public Telefone(Telefone cp ) {
		this.ddd = cp.getDdd();
		this.numero = cp.getNumero();
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public void imprimir() {
		System.out.println(this.ddd + " " + this.numero);
	}
	
	
}
