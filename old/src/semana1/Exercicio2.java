package semana1;
//Escreva um programa que dado três números inteiros, 
//apresente o menor deles e todos que são positivos.
public class Exercicio2 {
	public static void main(String[] args) {
		int n1, n2, n3, maior;
		
		n1 = 5;
		n2 = 5;
		n3 = 5;
		
		
		if(n1 >= n2 && n1 >= n3) {
			maior = n1;
		} else if (n2 >= n1 && n2 >= n3) {
			maior = n2;
		} else {
			maior = n3;
		}
		
		System.out.println("O maior valor é: " + maior);
		
		if(n1 > 0) System.out.print(n1 + " ");
		if(n2 > 0) System.out.print(n2 + " ");
		if(n3 > 0) System.out.print(n3 + " ");
	}
}
