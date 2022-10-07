package semana3Banco;

public class Endereco {
	private String logradouro;
	private String complemento;
	private String cep;
	private String cidade;
	private String estado;
	
	// Contrutor completo
	public Endereco(
			String log,
			String comp,
			String cep,
			String cidade,
			String estado 
			) {
		this.logradouro = log;
		this.complemento = comp;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
	}
	
	public Endereco(String log, String cep, String cidade, String estado) {
		this(log, null, cep, cidade, estado);
	}
	
	public Endereco() {
		this(null, null, null, null);
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public void imprimir() {
		System.out.println(this);
	}
	
	@Override
	public String toString() {
        return
        	"  logradouro: " + this.logradouro +
        	"\n  complemento: " +  this.complemento +
        	"\n  cep: " +  this.cep +
        	"\n  cidade: " + this.cidade +
        	"\n  estado: " + this.estado + "\n";
    }
	
}
