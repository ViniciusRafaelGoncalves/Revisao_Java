package revisao;

import java.util.Scanner;

public class Raio {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double pi = Math.PI;

		System.out.print("Digite a área do círculo: ");
		double area = scanner.nextDouble();

		double raio = Math.sqrt(area / pi);

		System.out.println("O raio do círculo é: " + raio);
		
		scanner.close();
	}
}
