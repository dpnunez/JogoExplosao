package game;

public class PosicaoTabuleiro {
    private final int x;
    private final int y;
    private final boolean jogavel;
    private final boolean pontoDeSalvamento;       // regra default sao os cantos
    private boolean construida;
    private PosicaoTabuleiro proximaPosicao;
    private PosicaoTabuleiro pontoDeSalvamentoMaisProximo;
    
    public PosicaoTabuleiro(int x, int y, boolean jogavel, boolean pontoDeSalvamento) {
        this.x = x;
        this.y = y;
        this.jogavel = jogavel;
        this.pontoDeSalvamento = pontoDeSalvamento;
        this.construida = false;   
    }

    public void setProximaPosicao(PosicaoTabuleiro proximaPosicao) {
        this.proximaPosicao = proximaPosicao;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public boolean getJogavel() {
        return jogavel;
    }
    
    public boolean getConstruida() {
        return construida;
    }

    public boolean getPontoDeSalvamento() {
        return this.pontoDeSalvamento;
    }

    public PosicaoTabuleiro getProximaPosicao() {
        return proximaPosicao;
    }

    public void setConstruida(boolean construida) {
        this.construida = construida;
    }

    public void setPontoDeSalvamentoMaisProximo(PosicaoTabuleiro pontoDeSalvamentoMaisProximo) {
        this.pontoDeSalvamentoMaisProximo = pontoDeSalvamentoMaisProximo;
    }

    public PosicaoTabuleiro getPontoDeSalvamentoMaisProximo() {
        return pontoDeSalvamentoMaisProximo;
    }
    
    
    
}
