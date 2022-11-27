/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

/**
 *
 * @author Bruno Chim Silveira
 */
public class Imobilizar extends Instantaneo {
    public Imobilizar(){
        this.nome = "Imobilizar";
    }
    
    
    @Override
    public String toString() {
        return this.nome;
    }
}