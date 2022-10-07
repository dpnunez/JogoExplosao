package semana1;
//Faça um programa que verifique se um número é primo
public class Exercicio3 {
	public static void main(String[] args) {
		int n;
		boolean ehPrimo = true;
		n = 6;
		
		for(int i = 2; i < n; i++) {
			if((float)(n % i) == 0) {
				ehPrimo = false;
				break;
			}
		}
		
		if(ehPrimo) {
			System.out.println("É primo");
		} else {
			System.out.println("Nao é primo");
		}
	}
}
