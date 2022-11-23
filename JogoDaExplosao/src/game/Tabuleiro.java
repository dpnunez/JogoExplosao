package game;

public class Tabuleiro {
    private PosicaoTabuleiro[][] posicoes;
    private int dimensaoTabuleiro;
    
    public Tabuleiro(int dimensao) {
        this.dimensaoTabuleiro = dimensao;
        this.posicoes = new PosicaoTabuleiro[dimensao][dimensao];
        
        // Iniciar tabuleiro;
        for(int linha=0; linha<dimensao; linha++)
            for(int coluna=0; coluna<dimensao; coluna++) {
                boolean jogavel = 
                        linha == 0 || linha == (dimensao-1) ||
                        coluna == 0 || coluna == (dimensao-1);
                
                boolean pontoDeSalvamento = 
                        (linha == 0 || linha == (dimensao-1)) &&
                        (coluna == 0 || coluna == (dimensao-1));
                this.posicoes[linha][coluna] = new PosicaoTabuleiro(coluna, linha, jogavel, pontoDeSalvamento);
            }
        for(int linha=0; linha<dimensao; linha++)
            for(int coluna=0; coluna<dimensao; coluna++) {
                PosicaoTabuleiro proxima;
                PosicaoTabuleiro pontoDeSalvamentoMaisProximo = null;
                if(this.posicoes[linha][coluna].getJogavel()) {
                    if(linha == 0 && coluna == 0) {
                        proxima = this.posicoes[0][1];
                    } else if(linha == 0 && coluna == dimensao-1) {
                        proxima = this.posicoes[1][dimensao-1];
                    } else if(linha == dimensao-1 && coluna == dimensao-1) {
                        proxima = this.posicoes[dimensao-1][dimensao-2];
                    } else if(linha == dimensao-1 && coluna == 0) {
                        proxima = this.posicoes[dimensao-2][0];
                    } else if(linha == 0) {
                        // topo
                        pontoDeSalvamentoMaisProximo = this.posicoes[0][0];
                        proxima = this.posicoes[linha][coluna+1];
                    } else if(linha == dimensao-1) {
                        // baixo
                        pontoDeSalvamentoMaisProximo = this.posicoes[dimensao-1][dimensao-1];
                        proxima = this.posicoes[linha][coluna-1];
                    } else if(coluna == 0) {
                        // esquerda
                        pontoDeSalvamentoMaisProximo = this.posicoes[dimensao-1][0];
                        proxima = this.posicoes[linha-1][coluna];
                    } else {
                        // direita
                        pontoDeSalvamentoMaisProximo = this.posicoes[0][dimensao-1];
                        proxima = this.posicoes[linha+1][coluna];
                    }
                    
                    this.posicoes[linha][coluna].setProximaPosicao(proxima);
                    if(pontoDeSalvamentoMaisProximo != null) {
                        this.posicoes[linha][coluna].setPontoDeSalvamentoMaisProximo(pontoDeSalvamentoMaisProximo);
                    }
                    
                }
                
            }
    }
    
    public Tabuleiro() {
        this(5);
    }

    public int getDimensaoTabuleiro() {
        return dimensaoTabuleiro;
    }
    
    
    
    public PosicaoTabuleiro getPosicao (int x, int y) {
        return this.posicoes[y][x];
    }
    
     public void explodirLado(int ladoId) {
        switch(ladoId) {
            case 0 -> {
                // destroi o topo do tabuleiro
                for(int i=0; i<this.dimensaoTabuleiro;i++)
                    this.posicoes[0][i].setConstruida(false);
            }
            case 1 -> {
                // destroi a base do tabuleiro
                for(int i=0; i<this.dimensaoTabuleiro;i++)
                    this.posicoes[this.dimensaoTabuleiro-1][i].setConstruida(false);
            }
            case 2 -> {
                // destroi lado direito
                for(int i=0; i<this.dimensaoTabuleiro;i++)
                    this.posicoes[i][this.dimensaoTabuleiro-1].setConstruida(false);
            }
            case 3 -> {
                // destroi lado esquerdo
                for(int i=0; i<this.dimensaoTabuleiro;i++)
                    this.posicoes[i][0].setConstruida(false);
            }
            
        }
    }
    
    public void printBoardOnConsole() {
        
        for(int linha=0; linha<this.dimensaoTabuleiro; linha++) {
            for(int coluna=0; coluna<this.dimensaoTabuleiro; coluna++) {
                PosicaoTabuleiro posicao = posicoes[linha][coluna];
                if (posicao.getPontoDeSalvamento()) {
                    System.out.print("{H}");
                } else if (posicao.getJogavel()) {
                    if(posicao.getConstruida()) {
                        System.out.print("{m}");
                    } else {
                        System.out.print("{ }");
                    }
                    
                } else {
                    System.out.print(" O ");
                }
            }  
            System.out.println("\n");
        }
    }
    
}