package xyz.jvst.grafos.segundaImplementacao;

import java.util.Scanner;

public class SegundaImplementacao {

	public static void menu(Scanner sc) {

		// Impress�o das op��es de grafo dispon�veis
		System.out.println("\n\tEscolha uma das op��es abaixo:");
		System.out.println(" Digite 'c' para um grafo personalizado");
		System.out.println(" Digite 'r' para um grafo aleat�rio");
		System.out.println(" Digite 'v' para um grafo aleat�rio, informando numero de vertices");

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
			System.out.println("\n\tOp��o '" + opcao + "' inv�lida redirecionada para op��o aleat�rio");
			grafoSelecionado = GeradorGrafos.novoGrafoAleatorio();
		}

		Impressao.imprimirMatriz(grafoSelecionado.gerarMatrizAdjacencia(), grafoSelecionado.getVertices(),
				"\nMatriz de Adjac�ncia\n");
		Impressao.imprimirMatriz(grafoSelecionado.gerarMatrizAlcancabilidade(), grafoSelecionado.getVertices(),
				"\nMatriz de Alcan�abilidade\n");

		sc.close();
	}

}
