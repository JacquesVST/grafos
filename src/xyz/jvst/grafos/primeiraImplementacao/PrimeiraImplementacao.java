package xyz.jvst.grafos.primeiraImplementacao;

import java.util.Scanner;

public class PrimeiraImplementacao {

	public static void menu(Scanner sc) {

		// Impress�o das op��es de grafo dispon�veis
		System.out.println("\n\tEscolha uma das op��es abaixo:");
		System.out.println("\n Digite 'exe1' para Exemplo 1 (direcionado)");
		System.out.println(" Digite 'exe2' para Exemplo 2 (n�o direcionado)");
		System.out.println(" Digite 'custom' para um grafo personalizado");
		System.out.println(" Digite 'rand' para um grafo completamente aleat�rio");

		Grafo grafoSelecionado;
		System.out.print("\nInput: ");
		String opcao = sc.next().toLowerCase();

		if (opcao.equals("exe1")) {
			grafoSelecionado = GeradorGrafos.exemploGrafoDirecionado();
		} else if (opcao.equals("exe2")) {
			grafoSelecionado = GeradorGrafos.exemploGrafoNaoDirecionado();
		} else if (opcao.equals("custom")) {
			grafoSelecionado = GeradorGrafos.novoGrafoPersonalizado(new Scanner(System.in));
		} else if (opcao.equals("rand")) {
			grafoSelecionado = GeradorGrafos.novoGrafoAleatorio();
		} else {
			System.out.println("\n\tOp��o '" + opcao + "' inválida redirecionada para op��o aleat�rio");
			grafoSelecionado = GeradorGrafos.novoGrafoAleatorio();
		}

		// Impress�o das op��es de impress�o dispon�veis
		System.out.println("\n\tEscolha uma das a��es abaixo:");
		System.out.println("\n Digite 'madj' para Impress�o da matriz de adjac�ncia");
		System.out.println(" Digite 'ladj' para Impress�o da lista de adjac�ncia");
		System.out.println(" Digite 'grau' para Impress�o do grau dos v�rtices");
		System.out.println(" Digite 'tudo' para Impress�o de todos os itens acima");

		System.out.print("\nInput: ");
		opcao = sc.next().toLowerCase();
		if (opcao.equals("madj")) {
			Impressao.imprimirMatrizAdjacencia(grafoSelecionado.gerarMatrizAdjacencia());
		} else if (opcao.equals("ladj")) {
			Impressao.imprimirListaAdjacencias(grafoSelecionado.gerarListaAdjacencia());
		} else if (opcao.equals("grau")) {
			Impressao.imprimirGrauDosVertices(grafoSelecionado.gerarGrauDosVertices(),
					grafoSelecionado.isDirecionado());
		} else if (opcao.equals("tudo")) {
			Impressao.imprimirTudo(grafoSelecionado);
		} else {
			System.out.println("\n\tOp��o '" + opcao + "' inv�lida redirecionada para op��o tudo");
			Impressao.imprimirTudo(grafoSelecionado);
		}
		sc.close();
	}

}
