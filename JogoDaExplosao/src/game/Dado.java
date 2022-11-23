package game;
import java.util.Random;

public class Dado {
    private final Random randSeed;
    private final int lados;
    private int valorAtual;
    
    public Dado() {
        this.randSeed = new Random();
        this.lados = 6;
    }
    
    public int rodar() {
        this.valorAtual = this.randSeed.nextInt(this.lados) + 1;
        return this.valorAtual;
    }

    public int getValorAtual() {
        return valorAtual;
    }
    
    @Override
    public String toString() {
        return """
               Dado: {
                 valor atual: """ + this.valorAtual + "\n" + "}";
    }
}