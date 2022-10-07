package semana1;
//Faça um programa que calcule o fatorial.
public class Exercicio4 {
	public static void main(String[] args) {
		int n, fatorial;
		fatorial = 1;
		n = 6;
		
		for(int i = 1; i <= n; i++) fatorial *= i;
		
		System.out.println("Fatorial de " + n + " é " + fatorial);
	}
}
