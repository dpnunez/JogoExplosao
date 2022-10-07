package semana3;
import java.time.LocalDate;
import java.time.Period;

public class Pessoa {
	private String nome;
	private LocalDate dataNascimento;
	private double altura;
	
	public Pessoa(String n, LocalDate data, double alt) {
		this.nome = n;
		this.dataNascimento = data;
		this.altura = alt;
	}
	
	public Pessoa() {
		this("Nome não informado", LocalDate.now(), 0);
	}
	
	public Pessoa(Pessoa cp) {
		this.nome = cp.getNome();
		this.dataNascimento = cp.getDataNascimento();
		this.altura = cp.getAltura();
	}
	
	public double getAltura() {
		return altura;
	}
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void imprimirDados() {
		System.out.println("Nome: " + this.nome);
		System.out.println("Data de nascimento: " + this.dataNascimento);
		System.out.println("Altura: " + this.altura);
		System.out.println("Idade: " + this.calcularIdade());
	}
	
	public int calcularIdade() {
		return Period.between(this.dataNascimento, LocalDate.now()).getYears();
	}
}
