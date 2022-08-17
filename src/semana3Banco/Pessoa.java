package semana3Banco;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pessoa {
    private String nome;
    private Endereco endereco;
    private Telefone telefone;
    private LocalDate dataNascimento;
    
    public Pessoa(String nome, Endereco ed, Telefone telefone, LocalDate data) {
        this.nome = nome;
        this.endereco = ed;
        this.telefone = telefone;
        this.dataNascimento = data;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void imprimir() {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
    	this.endereco.imprimir();
        System.out.println("+----------------------------------+");
        System.out.println("Nome: " + nome);
        if(this.endereco != null) {
        	System.out.println("Endereço: ");
        	this.endereco.imprimir();
        }
        
        if(this.telefone != null) {
        	System.out.print("Telefone: ");
        	this.telefone.imprimir();
        }
        
        System.out.println("Data de nascimento: " + dataNascimento.format(formatter));
        
        System.out.println("+----------------------------------+");
    }
}
