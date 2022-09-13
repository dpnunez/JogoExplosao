package semana4Lembretes;

import java.time.LocalDate;

//2. Crie uma classe chamada BlocoDeLembretes. O objetivo desta classe é
//guardar um conjunto de lembretes, modelados pela classe Lembrete, em um array,
//implementando uma estrutura de lista (lista sequencial). Ao instanciar um array, é
//necessário determinar o seu tamanho, que neste exercício deve ser de 10 posições. Nos
//próximos exercícios você adicionará mais recursos à estrutura da classe. Você pode
//implementar o método main para testar as funcionalidades implementadas.

//3. Adicione um método chamado incluirLembrete, que recebe um objeto
//Lembrete como parâmetro e o adiciona no array, sempre na última posição da lista
//(lembre a última posição da lista não é necessariamente a última posição do array).

//4. Adicione um método chamado numeroDeLembretes, que retorna o número
//de lembretes armazenados no array

//5. Adicione um método chamado removerLembrete, que recebe o número
//(índice/posição no array) do lembrete a ser removido e o exclui da lista

//6. Adicione um método chamado listarLembretes para imprimir todos os
//lembretes armazenados na lista.

//7. Adicione um método chamado buscarLembretesPorData para listar todos
//os lembretes da lista que ocorrem na mesma data passada como parâmetro no método

//8. Adicione um método chamado buscarLembretesPorNome para listar todos
//os lembretes da lista que contenham a substring que será passada como parâmetro do
//método em seu nome.

//9. Altere o método incluirLembrete para que a inclusão de novos lembretes na
//lista não fique limitada ao valor inicial atribuído com tamanho do array. Ao invocar o
//método de inclusão, se não houver mais espaço no array, deve-se (1) instanciar um novo
//array com o dobro do tamanho do array atual, (2) copiar os dados do array atual para o
//novo e (3) incluir o novo lembrete no novo array. Lembre de (4) atualizar o atributo da
//classe BlocoDeLembretes que referencia o array atual para o novo array instanciado.

public class BlocoLembretes {
	private Lembrete[] listaLembrete;
	
	public BlocoLembretes() {
		this.listaLembrete = new Lembrete[1];
	}
	
	public void incluirLembrete(Lembrete lm) {
		boolean deveExpandirLista = this.numeroDeLembretes() == this.listaLembrete.length;
		
		if(deveExpandirLista) {
			Lembrete[] novaListaLembretes = new Lembrete[this.listaLembrete.length * 2];
			System.arraycopy(this.listaLembrete, 0, novaListaLembretes, 0, this.listaLembrete.length);
			this.listaLembrete = novaListaLembretes;
		}
			
		int proximoIndex = this.numeroDeLembretes();
		
		this.listaLembrete[proximoIndex] = lm;
	}
	
	public boolean removerLembrete(int index) {
		if(this.listaLembrete[index] == null) return false;
		
		Lembrete[] copy = new Lembrete[this.numeroDeLembretes()];

		for (int i = 0, j = 0; i < this.numeroDeLembretes(); i++) {
		    if (i != index) {
		        copy[j++] = this.listaLembrete[i];
		    }
		}
		
		this.listaLembrete = copy;
		
		return true;
	}
	
	public void listarLembretes() {
		System.out.println("inicio lista");
		for(int i=0; i<this.numeroDeLembretes(); i++)
			System.out.println(this.listaLembrete[i] + "\n\n");
		System.out.println("final lista");
	}
	
	public void buscarLembretesPorData(LocalDate dataDeBusca) {
		System.out.println("Inicio da busca\n");
		for(int i=0; i<this.numeroDeLembretes(); i++) {
			if(this.listaLembrete[i].getDataNotificacao().isEqual(dataDeBusca))
				this.listaLembrete[i].imprimir();
		}
		System.out.println("Fim da busca\n");
	}
	
	public void buscarLembretesPorNome(String substr) {
		for(int i=0; i<this.numeroDeLembretes(); i++) {
			if(this.listaLembrete[i].getNome().contains(substr))
				this.listaLembrete[i].imprimir();
		}
	}
	
	public int numeroDeLembretes() {
		int contador = 0;
		for(int i=0; i<=this.listaLembrete.length - 1; i++) {
			if(this.listaLembrete[i] != null) contador++;
		}
		
		return contador;
	}
}
