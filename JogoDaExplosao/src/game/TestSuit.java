/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class TestSuit {
    public void testeAndar() {
        System.out.println("Teste andar: ");
        
        List<Jogador> jogadores = new ArrayList<>();
        jogadores.add(new Jogador("Daniel", 0, 0));
        jogadores.add(new Jogador("Bruno", 5, 0));
        Dado d = new Dado();
        Tabuleiro t = new Tabuleiro(6);
        
        JogoDaExplosao jogo = new JogoDaExplosao(d, t, jogadores);
        jogo.andar(2, jogo.getJogadorAtual());
        jogo.mudarJogador();
        jogo.andar(2, jogo.getJogadorAtual());
        System.out.println("Estado do tabuleiro: ");
        jogo.getTabuleiro().printBoardOnConsole();
        System.out.println("Estado dos jogadores: ");
        jogo.getPosicoesJogadores();
        System.out.println("\nJogador atual: " + jogo.getJogadorAtual().getNome());

        System.out.println("=======================\n\n\n\n\n\n");
    }
    
    public void testeBomba() {
        System.out.println("Teste bomba: ");
        
        List<Jogador> jogadores = new ArrayList<>();
        jogadores.add(new Jogador("Daniel", 0, 0));
        jogadores.add(new Jogador("Bruno", 5, 0));
        Dado d = new Dado();
        Tabuleiro t = new Tabuleiro(6);
        
        JogoDaExplosao jogo = new JogoDaExplosao(d, t, jogadores);
        jogo.andar(2, jogo.getJogadorAtual());
        jogo.explodirLado(0);
        System.out.println("Estado do tabuleiro: ");
        jogo.getTabuleiro().printBoardOnConsole();
        System.out.println("Estado dos jogadores: ");
        jogo.getPosicoesJogadores();
        System.out.println("\nJogador atual: " + jogo.getJogadorAtual().getNome());

        System.out.println("=======================\n\n\n\n\n\n");
    }
    
    public void testeAsasDeIcaro() {
        System.out.println("Asas de icaro: ");
        
        List<Jogador> jogadores = new ArrayList<>();
        jogadores.add(new Jogador("Daniel", 0, 0));
        jogadores.add(new Jogador("Bruno", 5, 0));
        Dado d = new Dado();
        Tabuleiro t = new Tabuleiro(6);
        
        JogoDaExplosao jogo = new JogoDaExplosao(d, t, jogadores);
        jogo.getJogadorAtual().setPassivo(new AsasDeIcaro());
        jogo.andar(2, jogo.getJogadorAtual());
        
        jogo.explodirLado(0);
        System.out.println("Estado do tabuleiro: ");
        jogo.getTabuleiro().printBoardOnConsole();
        System.out.println("Estado dos jogadores: ");
        jogo.getPosicoesJogadores();
        System.out.println("\nJogador atual: " + jogo.getJogadorAtual().getNome());

        System.out.println("=======================\n\n\n\n\n\n");
    }
    
    public void testeEmpurrar() {
        System.out.println("Empurrar: ");
        
        List<Jogador> jogadores = new ArrayList<>();
        jogadores.add(new Jogador("Daniel", 0, 0));
        jogadores.add(new Jogador("Bruno", 5, 0));
        Dado d = new Dado();
        Tabuleiro t = new Tabuleiro(6);
        
        JogoDaExplosao jogo = new JogoDaExplosao(d, t, jogadores);
        jogo.getJogadorAtual().setPassivo(new Empurrar());
        jogo.mudarJogador();
        jogo.andar(2, jogo.getJogadorAtual());
        jogo.mudarJogador();
        jogo.andar(6, jogo.getJogadorAtual());
        
        System.out.println("Estado do tabuleiro: ");
        jogo.getTabuleiro().printBoardOnConsole();
        System.out.println("Estado dos jogadores: ");
        jogo.getPosicoesJogadores();
        System.out.println("\nJogador atual: " + jogo.getJogadorAtual().getNome());

        System.out.println("=======================\n\n\n\n\n\n");
    }
    
    public void testeVelocidade() {
        System.out.println("Velocidade: ");
        
        List<Jogador> jogadores = new ArrayList<>();
        jogadores.add(new Jogador("Daniel", 0, 0));
        jogadores.add(new Jogador("Bruno", 5, 0));
        Dado d = new Dado();
        Tabuleiro t = new Tabuleiro(6);
        
        JogoDaExplosao jogo = new JogoDaExplosao(d, t, jogadores);
        jogo.getJogadorAtual().setInstantaneo(new Velocidade());
        jogo.usarInstantaneo(jogo.getJogadorAtual());
        jogo.andar(2, jogo.getJogadorAtual());
        jogo.mudarJogador();
        
        jogo.andar(1, jogo.getJogadorAtual());
        
        System.out.println("Estado do tabuleiro: ");
        jogo.getTabuleiro().printBoardOnConsole();
        System.out.println("Estado dos jogadores: ");
        jogo.getPosicoesJogadores();
        System.out.println("\nJogador atual: " + jogo.getJogadorAtual().getNome());

        System.out.println("=======================\n\n\n\n\n\n");
    }
    
    
    
    public void testeImobilizar() {
        System.out.println("Imobilizar: ");
        
        List<Jogador> jogadores = new ArrayList<>();
        jogadores.add(new Jogador("Daniel", 0, 0));
        jogadores.add(new Jogador("Bruno", 5, 0));
        Dado d = new Dado();
        Tabuleiro t = new Tabuleiro(6);
        
        JogoDaExplosao jogo = new JogoDaExplosao(d, t, jogadores);
        jogo.getJogadorAtual().setInstantaneo(new Imobilizar());
        jogo.usarInstantaneo(jogo.getJogadorAtual());
        
        jogo.mudarJogador();
        jogo.andar(2, jogo.getJogadorAtual());

        System.out.println("=======================\n\n\n\n\n\n");
    }
    
    public void testeSabotar() {
        System.out.println("Teste Sabotar: ");
        
        List<Jogador> jogadores = new ArrayList<>();
        jogadores.add(new Jogador("Daniel", 0, 0));
        jogadores.add(new Jogador("Bruno", 5, 0));
        Dado d = new Dado();
        Tabuleiro t = new Tabuleiro(6);
        
        JogoDaExplosao jogo = new JogoDaExplosao(d, t, jogadores);
        jogo.getJogadorAtual().setInstantaneo(new Sabotar());
        jogo.andar(2, jogo.getJogadorAtual());
        jogo.explodirLado(0);                                               // explodir topo
        System.out.println("Estado do tabuleiro: ");
        jogo.getTabuleiro().printBoardOnConsole();
        System.out.println("Estado dos jogadores: ");
        jogo.getPosicoesJogadores();
        System.out.println("\nJogador atual: " + jogo.getJogadorAtual().getNome());

        System.out.println("=======================\n\n\n\n\n\n");
    }
    
    public static void main(String[] args) {
        TestSuit t = new TestSuit();
        
        t.testeAndar();
        t.testeBomba();
        t.testeAsasDeIcaro();
        t.testeEmpurrar();
        t.testeVelocidade();
        t.testeImobilizar();
        t.testeSabotar();
    }
}
