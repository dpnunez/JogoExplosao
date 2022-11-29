package game;

import java.util.*;
import java.util.Scanner;


public class JogoDaExplosao {
    private final Tabuleiro tabuleiro;
    private final Dado dado;
    private final List<Jogador> jogadores;
    private int indexJogadorAtual;
    private final Random randSeed;
    private Jogador ganhador;
    private boolean andarDuplicadoAtivo;
    
    public JogoDaExplosao(Dado d, Tabuleiro t, List<Jogador> jogadores) {
        this.tabuleiro = t;
        this.dado = d;
        this.jogadores = jogadores;
        this.indexJogadorAtual = 0;
        this.randSeed = new Random();
        this.andarDuplicadoAtivo = false;
    }
    
    public int getIndexProximoJogador() {
        int i = this.indexJogadorAtual + 1;
        if(i >= this.jogadores.size()) {
            i=0;
        }
        return i;
        
    }
    
    public void mudarJogador() {
        this.indexJogadorAtual = this.getIndexProximoJogador();
    }
    
    public Jogador getJogadorAtual() {
        return this.jogadores.get(this.indexJogadorAtual);
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

    public Jogador getGanhador() {
        return ganhador;
    }
    
    public void explodirLado(int ladoId) {
        String ladoString = "gerando";
        switch (ladoId) {
            case 0 -> ladoString = "topo";
            case 1 -> ladoString = "base";
            case 2 -> ladoString = "direito";
            case 3 -> ladoString = "esquerdo";
        }

        System.out.println("BOMBAAA!! destruindo o lado " + ladoString);
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
                pontoDeSalvamento = posicaoJogador.getPontoDeSalvamentoAnterior();
                // explosao e jogador no topo
            } else if (ladoId == 1 && y == tabuleiro.getDimensaoTabuleiro() - 1) {
                pontoDeSalvamento = posicaoJogador.getPontoDeSalvamentoAnterior();
                // explosao e jogador na base
            } else if (ladoId == 2 && x == tabuleiro.getDimensaoTabuleiro() - 1) {
                pontoDeSalvamento = posicaoJogador.getPontoDeSalvamentoAnterior();
                // explosao e jogador na direita
            } else if (ladoId == 3 && x == 0) {
                pontoDeSalvamento = posicaoJogador.getPontoDeSalvamentoAnterior();
                // explosao e jogador na esquerda
            }

            if(pontoDeSalvamento != null) {
                if(jogador.getPoderPassivo() instanceof AsasDeIcaro) {
                    System.out.println("O jogador " + jogador.getNome() + " Cairia na ponte, mas tem asas de icaro! ");
                    jogador.setPosicaoX(posicaoJogador.getPontoDeSalvamentoPosterior().getX());
                    jogador.setPosicaoY(posicaoJogador.getPontoDeSalvamentoPosterior().getY());
                    jogador.setPassivo(null);
                } else {
                    System.out.println("O jogador " + jogador.getNome() + " caiu da ponte! ");
                    System.out.println("voltando para x: " + pontoDeSalvamento.getX() + " y: " + pontoDeSalvamento.getY());
                    jogador.setPosicaoX(pontoDeSalvamento.getX());
                    jogador.setPosicaoY(pontoDeSalvamento.getY());
                }
            }
        }
    }
    
    public void empurar(Jogador jogadorEmpurrando, List<Jogador> listaParaEmpurrar) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Você tem a carta empurrar e está passando por uma casa ocupada por 1 ou mais jogadores, os quais sao: ");
        for(int i=0; i<listaParaEmpurrar.size(); i++) {
            System.out.println(i + " - " + listaParaEmpurrar.get(i).getNome());
        }
        System.out.println("4 - Nao utilizar empurrar");
        System.out.print("> ");
        int escolha = entrada.nextByte();
        
        if (escolha >= 0 && escolha < listaParaEmpurrar.size()) {
            // Empurrar
            Jogador empurrado = listaParaEmpurrar.get(escolha);
            int x = empurrado.getPosicaoX();
            int y = empurrado.getPosicaoY();
            PosicaoTabuleiro pontoDeSalvamentoAnteriorDoEmpurrado = this.tabuleiro.getPosicao(x, y).getPontoDeSalvamentoAnterior();
            
            System.out.println("O jogador " + empurrado.getNome() + " foi empurrado para x: " + pontoDeSalvamentoAnteriorDoEmpurrado.getX() + " y: " + pontoDeSalvamentoAnteriorDoEmpurrado.getY());
            empurrado.setPosicaoX(pontoDeSalvamentoAnteriorDoEmpurrado.getX());
            empurrado.setPosicaoY(pontoDeSalvamentoAnteriorDoEmpurrado.getY());
            
            jogadorEmpurrando.setPassivo(null);
        } else {
            System.out.println("Empurrar nao utilizado");
        }
        
    }
    
    public void andar(int valorProp, Jogador j) {
        if (j.getImovel()) {
            System.out.println("Você está imobilizado!");
            j.setImovel(false);
        } else {
            int valor = valorProp;
            if(this.andarDuplicadoAtivo) valor = valorProp * 2;
            if(valor > 6) valor = 6;

            PosicaoTabuleiro posicaoAtualJogador = this.tabuleiro.getPosicao(j.getPosicaoX(), j.getPosicaoY());
            System.out.println("Jogador " + j.getNome() + " deve andar " + valor);
                // 1 2 3 andar
            int construidas=0;
            // andar(valor+1)
            while(construidas<valor ) {
                posicaoAtualJogador = posicaoAtualJogador.getProximaPosicao();
                List<Jogador> jogadoresNaPosicaoAtual = new ArrayList<>(); 

                if(posicaoAtualJogador.getX() == j.getPosicaoInicialX() && posicaoAtualJogador.getY() == j.getPosicaoInicialY()) {
                    System.out.println("GANHOU");
                    this.ganhador = j;
                    break;
                }

                for(int i=0; i<this.jogadores.size(); i++) {
                    Jogador jVerificar  = this.jogadores.get(i);
                    int posX = jVerificar.getPosicaoX();
                    int posY = jVerificar.getPosicaoY();
                    boolean ehMesmaPosicao =
                            posX == posicaoAtualJogador.getX() &&
                            posY == posicaoAtualJogador.getY();
                    if(jVerificar != j && ehMesmaPosicao) {
                        jogadoresNaPosicaoAtual.add(jVerificar);
                    }
                }

                // SE jogadorAtual.passivo == Empurrar e SE tiver outro jogador na posicaoAtual
                if(j.getPoderPassivo() instanceof Empurrar && !jogadoresNaPosicaoAtual.isEmpty()) {
                    this.empurar(j, jogadoresNaPosicaoAtual);
                }
                if(!posicaoAtualJogador.getConstruida()) {
                    construidas++;
                    posicaoAtualJogador.setConstruida(true);
                }
            }

            j.setPosicaoX(posicaoAtualJogador.getX());
            j.setPosicaoY(posicaoAtualJogador.getY());
            if(this.andarDuplicadoAtivo) {
                System.out.println("Desativando velocidade duplicada");
                this.andarDuplicadoAtivo = false;
            } 
        }
        
    }
    
    public void tratativaValorDado(int valor, Jogador j) {
        System.out.println("Dado resultado foi " + valor);
        if(valor<=3 || this.andarDuplicadoAtivo) {
            this.andar(valor, j);
        } else if (valor <=5) {
            // 4 5 = bomba
            int ladoId = this.randSeed.nextInt(4);
            this.explodirLado(ladoId);
        } else {
            
            int poder = this.randSeed.nextInt(6);
            switch(poder) {
                case 0 -> {
                    j.setPassivo(new AsasDeIcaro());
                    System.out.println("Jogador " + j.getNome() + " adquiriu um item passivo: AsasDeIcaro");
                }
                case 1 -> {
                    j.setPassivo(new Escudo());
                    System.out.println("Jogador " + j.getNome() + " adquiriu um item passivo: Escudo");
                }
                case 2 -> {
                    j.setPassivo(new Empurrar());
                    System.out.println("Jogador " + j.getNome() + " adquiriu um item passivo: Empurrar");
                }
                case 3 -> {
                    j.setInstantaneo(new Imobilizar());
                    System.out.println("Jogador " + j.getNome() + " adquiriu um item instantâneo: Imobilizar");
                }
                case 4 -> {
                    j.setInstantaneo(new Velocidade());
                    System.out.println("Jogador " + j.getNome() + " adquiriu um item instantâneo: Velocidade");
                }
                case 5 -> {
                    j.setInstantaneo(new Sabotar("Sabotar"));
                    System.out.println("Jogador " + j.getNome() + " adquiriu um item instantâneo: Sabotar");
                }
            }
            
        }
    }
    
    public void usarVelocidade() {
        System.out.println("Velocidade ativa nessa rodada!");
        this.andarDuplicadoAtivo = true;
    }
    
    public void usarImobilizar(Jogador imobilizado) {
        System.out.println("O jogador " + imobilizado.getNome() + " foi imobilizado!");
        imobilizado.setImovel(true);
    }
    
    public void mostrarListaFiltrada(List<Jogador> lista) {
        for(int i=0; i<lista.size(); i++) {
            System.out.println(i  + " - " + lista.get(i).getNome());
        }
    }
    
    public void usarInstantaneo(Jogador j) {
        Item instantaneo = j.getPoderInstantaneo();
        Scanner entrada = new Scanner(System.in);
        if(instantaneo instanceof Velocidade) {
            // usar velocidade
            this.usarVelocidade();
        } else if(instantaneo instanceof Imobilizar) {
            System.out.println("Imobilizar ativado! Escolha qual jogador você deseja imobilizar por uma rodada (fallback é o próximo jogador): ");
            List<Jogador> possiveisImobilizaveis = new ArrayList<>();
            for(int i=0; i<this.jogadores.size(); i++) {
                if(this.jogadores.get(i) != j)
                    possiveisImobilizaveis.add(this.jogadores.get(i));
            }
            
            mostrarListaFiltrada(possiveisImobilizaveis);
            System.out.print("> ");
            int escolha = entrada.nextByte();
            Jogador jogadorASerImobilizado;
            if(escolha < possiveisImobilizaveis.size()) {
                jogadorASerImobilizado = possiveisImobilizaveis.get(escolha);
            } else {
                jogadorASerImobilizado = this.jogadores.get(this.getIndexProximoJogador());
            }
            
            this.usarImobilizar(jogadorASerImobilizado);    
        }
        j.setInstantaneo(null);
    }
    
    public String getMenu() {
        return """
               1 - Girar dado
               2 - listar poderes
               3 - usar instantaneo""";
    }
    
    public void getPosicoesJogadores() {
        for(int i=0; i<jogadores.size(); i++) {
            Jogador j = jogadores.get(i);
            
            System.out.println(j);
        }
    }
    
  
    public void tratarEscolha(int escolha) {
        int valor;
        
        switch(escolha) {
        case 1 -> {
            //Lança o dado
            valor = this.dado.rodar();
            this.tratativaValorDado(valor, this.getJogadorAtual());
            }
        case 2 -> {
            //Lista os poderes
            getJogadorAtual().listaPoderes();
            Scanner entrada = new Scanner(System.in);
            System.out.println(this.getMenu());
            System.out.print(">");
            escolha = entrada.nextByte();
            this.tratarEscolha(escolha);
            }
        case 3 -> {
                if(this.getJogadorAtual().getPoderInstantaneo() == null) {
                    System.out.println("Você nao tem item instantaneo! ");
                    Scanner entrada = new Scanner(System.in);
                    System.out.println(this.getMenu());
                    System.out.print(">");
                    escolha = entrada.nextByte();
                    this.tratarEscolha(escolha);
                } else {
                    this.usarInstantaneo(this.getJogadorAtual());
                }
            }
        default -> {
            //Se tudo der errado lança o dado
            valor = this.dado.rodar();
            this.tratativaValorDado(valor, this.getJogadorAtual());
            }
        }
        
            }
    
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        System.out.println("""
                           Bem vindo ao Jogo Explosao Estrela!
                           Inicialmente voc\u00ea deve definir as especifica\u00e7oes da partida a ser jogada, como dimensoes do tabuleiro, quantidade de jogadores e seus nomes.Tenha um bom jogo
                           """);
        
        
        // validaçao int
        System.out.println("Informe as dimensoes do jogo: ");
        int dimensao = entrada.nextInt();
        
        // validaçao int
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
        int escolha;
        
        
        JogoDaExplosao jogo = new JogoDaExplosao(d, t, jogadores);
        
        while(true) {
            System.out.println("Estado do tabuleiro: ");
            jogo.getTabuleiro().printBoardOnConsole();
            System.out.println("Estado dos jogadores: ");
            jogo.getPosicoesJogadores();
            System.out.println("\nJogador atual: " + jogo.getJogadorAtual());

            System.out.println("\n");

            
            if(jogo.getJogadorAtual().getImovel()) {
                // skipar jogada e trocar flag caso jogador atual esteja imobilizado
                System.out.println("Jogador imovel, a rodada será passada!");
                jogo.getJogadorAtual().setImovel(false);
            } else {
                System.out.println(jogo.getMenu());
                System.out.print(">");
                escolha = entrada.nextByte();
                jogo.tratarEscolha(escolha);
            }
            if(jogo.getGanhador() != null) {
                System.out.println(jogo.getGanhador().getNome() + " GANHOU!!");
                break;
            }
            
            jogo.mudarJogador();
        }         
    }
    
}