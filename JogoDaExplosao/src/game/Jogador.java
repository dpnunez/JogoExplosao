/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

/**
 *
 * @author Daniel
 */
public class Jogador {
    private String nome;
    private int posicaoX;
    private int posicaoY;
    private final int posicaoInicialX;
    private final int posicaoInicialY;
    private Item passivo;
    private Item instantaneo;
    
    public Jogador(String n, int x, int y) {
        this.nome = n;
        this.posicaoInicialX = x;
        this.posicaoInicialY = y;
        this.posicaoX = x;
        this.posicaoY = y;
    }
    
    public void listaPoderes(){
        System.out.println("Poder Passivo: " + getPoderPassivo());
        System.out.println("Pode Instantâneo: " + getPoderInstantaneo());
    }

    public int getPosicaoX() {
        return posicaoX;
    }

    public int getPosicaoY() {
        return posicaoY;
    }

    public int getPosicaoInicialX() {
        return posicaoInicialX;
    }

    public int getPosicaoInicialY() {
        return posicaoInicialY;
    }
    
    public Item getPoderInstantaneo(){
        return this.instantaneo;
    }
    
    public Item getPoderPassivo(){
        return this.passivo;
    }

    public void setPosicaoX(int posicaoX) {
        this.posicaoX = posicaoX;
    }

    public void setPosicaoY(int posicaoY) {
        this.posicaoY = posicaoY;
    }
    
    public void setPassivo(Item x){
        this.passivo = x;
    }
    
    public void setInstantaneo(Item y){
        this.instantaneo = y;
    }

    public String getNome() {
        return nome;
    }
    
    
    
    
    
    
    @Override
    public String toString() {
        return this.nome + " | x: " + posicaoX + " y: " + posicaoY; 
    }
    
}