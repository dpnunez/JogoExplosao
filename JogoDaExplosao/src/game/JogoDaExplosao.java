package game;

import java.util.*;
import java.util.Scanner;


public class JogoDaExplosao {
    private final Tabuleiro tabuleiro;
    private final Dado dado;
    private final List<Jogador> jogadores;
    private int indexJogadorAtual;
    private final Random randSeed;
    
    public JogoDaExplosao(Dado d, Tabuleiro t, List<Jogador> jogadores) {
        this.tabuleiro = t;
        this.dado = d;
        this.jogadores = jogadores;
        this.indexJogadorAtual = 0;
        this.randSeed = new Random();
    }
    
    public void mudarJogador() {
        this.indexJogadorAtual++;
        if(this.indexJogadorAtual >= this.jogadores.size()) {
            this.indexJogadorAtual = 0;
        }
    }
    
    public Jogador getJogadorAtual() {
        return this.jogadores.get(indexJogadorAtual);
    }

    public Dado getDado() {
        return dado;
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }
    
    public void tratativaValorDado(int valor, Jogador j) {
        PosicaoTabuleiro posicaoAtualJogador = this.tabuleiro.getPosicao(j.getPosicaoX(), j.getPosicaoY());
        if(valor<=2) {
            // 0 1 2 andar
            System.out.println("Andar " + (valor + 1) + " casa");
            System.out.println(j.getNome() + " começou na casa x: " + posicaoAtualJogador.getX() + " y: " + posicaoAtualJogador.getY());
            int construidas=0;
            // andar(valor+1)
            while(construidas<=valor ) {
                posicaoAtualJogador = posicaoAtualJogador.getProximaPosicao();
                if(posicaoAtualJogador.getX() == j.getPosicaoInicialX() && posicaoAtualJogador.getY() == j.getPosicaoInicialY()) {
                    System.out.println("GANHOU");
                    break;
                    
                }
                if(!posicaoAtualJogador.getConstruida()) {
                    construidas++;
                    posicaoAtualJogador.setConstruida(true);
                }
            }
            
            j.setPosicaoX(posicaoAtualJogador.getX());
            j.setPosicaoY(posicaoAtualJogador.getY());
            
            System.out.println("Jogador " + j.getNome() + " foi para casa: x:" + j.getPosicaoX() + " y: " + j.getPosicaoY() );
            
        } else if (valor <=4) {
            // 3 4 = bomba
//            int ladoId = this.randSeed.nextInt(4); 
            int ladoId = 0;// MOCKADO = EXPLODIR TOPO
            System.out.println("BOMBAAA!!");
            this.tabuleiro.explodirLado(ladoId); 
            
            // verificar se algum jogador está no lado explodido
            for(int i=0; i<this.jogadores.size(); i++) {
                Jogador jogador = jogadores.get(i);
                int x = jogador.getPosicaoX();
                int y = jogador.getPosicaoY();
                
                //
                PosicaoTabuleiro posicaoJogador = tabuleiro.getPosicao(x, y);
                PosicaoTabuleiro pontoDeSalvamento = null;
                // resetar para o proximo salvamento
                if(ladoId == 0 && y == 0) {
                    pontoDeSalvamento = posicaoJogador.getPontoDeSalvamentoMaisProximo();
                    // explosao e jogador no topo
                } else if (ladoId == 1 && y == tabuleiro.getDimensaoTabuleiro() - 1) {
                    pontoDeSalvamento = posicaoJogador.getPontoDeSalvamentoMaisProximo();
                    // explosao e jogador na base
                } else if (ladoId == 2 && x == tabuleiro.getDimensaoTabuleiro() - 1) {
                    pontoDeSalvamento = posicaoJogador.getPontoDeSalvamentoMaisProximo();
                    // explosao e jogador na direita
                } else if (ladoId == 3 && x == 0) {
                    pontoDeSalvamento = posicaoJogador.getPontoDeSalvamentoMaisProximo();
                    // explosao e jogador na esquerda
                }
                
                if(pontoDeSalvamento != null) {
                     System.out.println("VOLTANDO " + jogador.getNome());
                     System.out.println("para x: " + pontoDeSalvamento.getX() + " y: " + pontoDeSalvamento.getY());
                    jogador.setPosicaoX(pontoDeSalvamento.getX());
                    jogador.setPosicaoY(pontoDeSalvamento.getY());
                }
            }
        }
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Informe as dimensoes do jogo: ");
        int dimensao = entrada.nextInt();
        
        System.out.println("Informe a quantidade de jogadores (max. 4, valores maiores serao arredondados para 4): ");
        int numeroJogadores = entrada.nextByte();     numeroJogadores = numeroJogadores > 4 ? 4 : numeroJogadores;
        if(numeroJogadores > 4) {
            numeroJogadores = 4;
        }
        
        
        
        entrada.nextLine();
        List<Jogador> jogadores = new ArrayList<>();
        for(int i=0; i<numeroJogadores; i++) {
            int x, y;
            
            switch (i) {
                default:
                case 0:
                    x=0;
                    y=0;
                    break;
                case 1:
                    x=dimensao-1;
                    y=0;
                    break;
                case 2:
                    x=dimensao-1;
                    y=dimensao-1;
                    break;
                case 3:
                    x=0;
                    y=dimensao-1;
                    break;
            }
            
            System.out.println("Insira o nome do jogador " + i + " :");
            
            String n = entrada.nextLine();
            Jogador j = new Jogador(n, x, y);
            jogadores.add(j);
        }
        
        
        Dado d = new Dado();
        Tabuleiro t = new Tabuleiro(dimensao);
        
        
        JogoDaExplosao jogo = new JogoDaExplosao(d, t, jogadores);
        jogo.getTabuleiro().printBoardOnConsole();
        
        
        
        System.out.println(jogo.getJogadorAtual());
        jogo.tratativaValorDado(2, jogo.getJogadorAtual());
        jogo.getTabuleiro().printBoardOnConsole();
        
        
        
        jogo.mudarJogador();
        System.out.println(jogo.getJogadorAtual());
        jogo.tratativaValorDado(2, jogo.getJogadorAtual());
   
        System.out.println(jogo.getJogadorAtual());
        jogo.getTabuleiro().printBoardOnConsole();
        
        jogo.tratativaValorDado(4, jogo.getJogadorAtual());
        jogo.getTabuleiro().printBoardOnConsole();
        System.out.println(jogo.getJogadorAtual());
        
        jogo.mudarJogador();
        jogo.tratativaValorDado(2, jogo.getJogadorAtual());
        jogo.getTabuleiro().printBoardOnConsole();
        
        jogo.tratativaValorDado(2, jogo.getJogadorAtual());
        jogo.getTabuleiro().printBoardOnConsole();

        
    }
    
}