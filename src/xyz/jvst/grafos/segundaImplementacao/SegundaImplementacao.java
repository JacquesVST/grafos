package xyz.jvst.grafos.segundaImplementacao;

import java.util.Scanner;

public class SegundaImplementacao {

	public static void menu(Scanner sc) {

		// Impressão das opções de grafo disponíveis
		System.out.println("\n\tEscolha uma das opções abaixo:");
		System.out.println(" Digite 'c' para um grafo personalizado");
		System.out.println(" Digite 'r' para um grafo aleatório");
		System.out.println(" Digite 'v' para um grafo aleatório, informando numero de vertices");

		Grafo grafoSelecionado;
		System.out.print("\nInput: ");
		String opcao = sc.next().toLowerCase();

		if (opcao.equals("c")) {
			grafoSelecionado = GeradorGrafos.novoGrafoPersonalizado(new Scanner(System.in));
		} else if (opcao.equals("r")) {
			grafoSelecionado = GeradorGrafos.novoGrafoAleatorio();
		} else if (opcao.equals("v")) {
			grafoSelecionado = GeradorGrafos.novoGrafoAleatorioComVertices(new Scanner(System.in));
		} else {
			System.out.println("\n\tOpção '" + opcao + "' inválida redirecionada para opção aleatório");
			grafoSelecionado = GeradorGrafos.novoGrafoAleatorio();
		}

		Impressao.imprimirMatriz(grafoSelecionado.gerarMatrizAdjacencia(), grafoSelecionado.getVertices(),
				"\nMatriz de Adjacência\n");
		Impressao.imprimirMatriz(grafoSelecionado.gerarMatrizAlcancabilidade(), grafoSelecionado.getVertices(),
				"\nMatriz de Alcançabilidade\n");

		sc.close();
	}

}
