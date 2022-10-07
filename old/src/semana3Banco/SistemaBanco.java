package semana3Banco;

import java.time.LocalDate;

public class SistemaBanco {
    public static void main(String[] args) {
        boolean consegui;
        Conta minhaConta, contaDestino;
        
        Pessoa maria, joao, felipe;
        Endereco ed1 = new Endereco("log1", "96330-000", "arroio grande", "RS");
        Telefone t1, t2, t3;
        LocalDate d1, d2, d3;
        
        t1 = new Telefone("53", "984361508");
        t2 = new Telefone("54", "984361508");
        t3 = new Telefone("55", "984361508");
        
        d1 = LocalDate.of(2000, 4, 16);
        d2 = LocalDate.of(2001, 5, 17);
        d3 = LocalDate.of(2002, 6, 18);
        
        maria = new Pessoa("Maria", ed1, t1, d1);
        joao = new Pessoa("Joao", ed1, t2, d2);
        felipe = new Pessoa("Felipe", ed1, t3, d3);
        
        minhaConta = new Conta(maria, 1000, 700);
        minhaConta.imprimir();
        
        contaDestino = new Conta(joao, 500);
        contaDestino.deposita(200);
        contaDestino.imprimir();
        
        Conta contaFelipe = new Conta(felipe, 400, 300);
        
        consegui = minhaConta.saca(700);
        if (consegui == true)
            System.out.println("Saque realizado com sucesso!");
        else
            System.out.println("Saldo Insuficiente!");
        
        minhaConta.transferirPara(contaDestino, 500);
        
        minhaConta.imprimir();
        contaDestino.imprimir();
        contaFelipe.imprimir();
    }
}