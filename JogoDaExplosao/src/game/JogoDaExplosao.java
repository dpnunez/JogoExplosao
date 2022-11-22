package game;

public class JogoDaExplosao {
    public static void main(String[] args) {
        Dado d = new Dado();
        
        for(int i=0; i<= 4;i++) {
            d.rodar();
            System.out.println(d);
            System.out.println("\n");
        }
    }
    
}