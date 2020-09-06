package xyz.jvst.grafos;

import java.util.Scanner;

import xyz.jvst.grafos.primeiraImplementacao.PrimeiraImplementacao;
import xyz.jvst.grafos.segundaImplementacao.SegundaImplementacao;

public class Principal {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("\tEscolha uma das opções abaixo:");

		System.out.println(
				" Digite '1' para a implementação com lista de adjacência, matriz de adjacência e grau do vértice");
		System.out.println(" Digite '2' para a implementação da matriz de alcançabilidade");
		System.out.println(" Digite 'x' para parar o programa");
		System.out.print("\nInput: ");

		String opcao = sc.next();

		if (opcao.equals("1")) {
			PrimeiraImplementacao.menu(new Scanner(System.in));
		} else if (opcao.equals("2")) {
			SegundaImplementacao.menu(new Scanner(System.in));
		} else if (!opcao.equals("x")) {
			System.out.println("\n\tOpção '" + opcao + "' inválida");
		}

	}
}
