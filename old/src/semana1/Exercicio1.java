package semana1;
//Faça um programa para calcular a média aritmética de duas notas. Também calcule e apresente a nota
//ponderada, considerando peso 2 e 3, respectivamente.

public class Exercicio1 {
	public static void main(String[] args) {
		double n1, n2;
		n1 = 5;
		n2 = 3;
		
		int notaMaxima = 5;
		
		double mediaAritmetica = (n1 + n2)/2;
		System.out.println("Média aritmética é: " + mediaAritmetica);
		double mediaPonderada = (n1 * 2 + n2 * 3)/notaMaxima;
		System.out.println("Média ponderada: " + mediaPonderada);
		
	}
}
