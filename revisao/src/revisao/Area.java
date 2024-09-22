package revisao;

import java.util.Scanner;

public class Area {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double pi = Math.PI;

		System.out.print("Digite o raio do círculo: ");
		double raio = scanner.nextDouble();

		double area = pi * Math.pow(raio, 2);

		System.out.println("A área do círculo é: " + area);
		scanner.close();
	}
}
