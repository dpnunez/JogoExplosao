package semana3Banco;

public class Conta {
    private static int contadorDeContas;
    private int numero;
    private Pessoa pessoa;
    private double saldo;
    private double limite;

    public Conta(Pessoa dono) {
        this.pessoa = dono;
        this.limite = 200;
        this.numero = numeroDaConta();
    }
    
    public Conta(Pessoa dono, double limite) {
        this.pessoa = dono;
        this.limite = limite;
        this.numero = numeroDaConta();
    }
    
    public Conta(Pessoa dono, double saldo, double limite) {
        this.pessoa = dono;
        this.saldo = saldo;
        this.limite = limite;
        this.numero = numeroDaConta();
    }
    
    private int numeroDaConta() {
        return ++contadorDeContas;
    }
    
    public boolean saca( double valor){
        if (this.saldo + limite < valor) {
            return false;
        } else {
            this.saldo = this.saldo - valor;
            return true;
        }
    }
    
    public void deposita( double quantidade){
        this.saldo = this.saldo + quantidade;
    }
    
    public void imprimir() {
        System.out.println("#### Conta do Cliente ##########");
        System.out.println("Número da Conta: " + this.numero + " (de " + contadorDeContas + " contas)");
        //System.out.println("Nome: " + this.pessoa);
        this.pessoa.imprimir();
        System.out.println("Saldo: " + this.saldo + "(Limite: " + this.limite + ")");
        System.out.println("################################");
    }
    
    public double getSaldo() {
        return this.saldo;
    }
    
    public boolean transferirPara(Conta destino, double valor) {
        boolean consegui;
        consegui = this.saca(valor);
        if (consegui)
            destino.deposita(valor);
        else
            System.out.println("Saldo Insuficiente para Transferência!");
       
        return consegui;
    }
}
