package xyz.jvst.grafos.primeiraImplementacao;

import java.util.Scanner;

public class PrimeiraImplementacao {

	public static void menu(Scanner sc) {

		// Impressão das opções de grafo disponíveis
		System.out.println("\n\tEscolha uma das opções abaixo:");
		System.out.println("\n Digite 'exe1' para Exemplo 1 (direcionado)");
		System.out.println(" Digite 'exe2' para Exemplo 2 (não direcionado)");
		System.out.println(" Digite 'custom' para um grafo personalizado");
		System.out.println(" Digite 'rand' para um grafo completamente aleatório");

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
			System.out.println("\n\tOpção '" + opcao + "' invÃ¡lida redirecionada para opção aleatório");
			grafoSelecionado = GeradorGrafos.novoGrafoAleatorio();
		}

		// Impressão das opções de impressão disponíveis
		System.out.println("\n\tEscolha uma das ações abaixo:");
		System.out.println("\n Digite 'madj' para Impressão da matriz de adjacência");
		System.out.println(" Digite 'ladj' para Impressão da lista de adjacência");
		System.out.println(" Digite 'grau' para Impressão do grau dos vértices");
		System.out.println(" Digite 'tudo' para Impressão de todos os itens acima");

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
			System.out.println("\n\tOpção '" + opcao + "' inválida redirecionada para opção tudo");
			Impressao.imprimirTudo(grafoSelecionado);
		}
		sc.close();
	}

}
