package boleto;

import java.util.Scanner;

public class Boleto {
	public static void main(String[] args) {
		double boleto1, boleto2, boleto3, boleto4, salariobruto, salarioliquido, sobra, total;
		Scanner ler = new Scanner(System.in);

		System.out.println("Digite o 1º boleto:");
		boleto1 = ler.nextDouble();

		System.out.println("Digite o 2º boleto:");
		boleto2 = ler.nextDouble();

		System.out.println("Digite o 3º boleto:");
		boleto3 = ler.nextDouble();

		System.out.println("Digite o 4º boleto:");
		boleto4 = ler.nextDouble();

		total = boleto1 + boleto2 + boleto3 + boleto4;

		System.out.println("o TOTAL DA FACADA É: " + total);

		System.out.println("Digite qual o seu salario bruto:");
		salariobruto = ler.nextDouble();

		salarioliquido = salariobruto - 14 % salariobruto;

		System.out.println("O seu salario liquido é:" + salarioliquido);

		sobra = salarioliquido - total;

		System.out.println("o que sobrou da sua grana é:" + sobra);
		
		ler.close();
	}
}