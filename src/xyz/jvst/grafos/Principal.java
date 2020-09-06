package xyz.jvst.grafos;

import java.util.Scanner;

import xyz.jvst.grafos.primeiraImplementacao.PrimeiraImplementacao;
import xyz.jvst.grafos.segundaImplementacao.SegundaImplementacao;

public class Principal {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("\tEscolha uma das op��es abaixo:");

		System.out.println(
				" Digite '1' para a implementa��o com lista de adjac�ncia, matriz de adjac�ncia e grau do v�rtice");
		System.out.println(" Digite '2' para a implementa��o da matriz de alcan�abilidade");
		System.out.println(" Digite 'x' para parar o programa");
		System.out.print("\nInput: ");

		String opcao = sc.next();

		if (opcao.equals("1")) {
			PrimeiraImplementacao.menu(new Scanner(System.in));
		} else if (opcao.equals("2")) {
			SegundaImplementacao.menu(new Scanner(System.in));
		} else if (!opcao.equals("x")) {
			System.out.println("\n\tOp��o '" + opcao + "' inv�lida");
		}

	}
}
