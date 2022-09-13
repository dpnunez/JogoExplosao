package semana4Lembretes;
import java.time.LocalDate;
//Exercício 1: Crie uma classe chamada Lembrete. O objetivo desta classe é guardar os
//seguintes dados de um lembrete: data para a notificação do lembrete (Lembre da
//abstração e reusabilidade de código!), nome do lembrete e descrição. Defina pelo menos
//um construtor de inicialização e um método para imprimir os dados do lembrete


public class Lembrete {
	private LocalDate dataNotificacao;
	private String nome;
	private String descricao;
	
	public Lembrete(LocalDate dt, String nome, String desc) {
		this.dataNotificacao = dt;
		this.nome = nome;
		this.descricao = desc;
	}
	
	public Lembrete(LocalDate dt, String nome) {
		this(dt, nome, null);
	}
	
	public void imprimir() {
		System.out.println(this);
	}
	
	@Override
	public String toString() {
        return
        	"Nome: " + this.nome + "\n" +
        	"Descrição: " + this.descricao + "\n" +
        	"Data: " + this.dataNotificacao + "\n";
    }
	
	public LocalDate getDataNotificacao() {
		return dataNotificacao;
	}
	
	public String getNome() {
		return nome;
	}

}
