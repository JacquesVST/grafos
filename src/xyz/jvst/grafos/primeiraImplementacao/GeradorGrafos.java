package xyz.jvst.grafos.primeiraImplementacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GeradorGrafos {

	/*
	 * Grafo pré-montado com base na atividade 3 da última lista
	 */
	public static Grafo exemploGrafoDirecionado() {
		List<Vertice> verticeList = new ArrayList<Vertice>();
		for (int i = 0; i < 5; i++) {
			verticeList.add(new Vertice(Integer.toString(i + 1)));
		}

		List<Aresta> arestaList = new ArrayList<Aresta>();
		arestaList.add(Aresta.novaAresta("a1", "1", "2", verticeList));
		arestaList.add(Aresta.novaAresta("a2", "2", "3", verticeList));
		arestaList.add(Aresta.novaAresta("a3", "2", "4", verticeList));
		arestaList.add(Aresta.novaAresta("a4", "1", "4", verticeList));
		arestaList.add(Aresta.novaAresta("a5", "4", "2", verticeList));
		arestaList.add(Aresta.novaAresta("a6", "4", "3", verticeList));
		arestaList.add(Aresta.novaAresta("a7", "3", "5", verticeList));
		arestaList.add(Aresta.novaAresta("a8", "4", "5", verticeList));

		return new Grafo(
            "Grafo Direcionado", verticeList, arestaList, true);
	}

	/*
	 * Grafo pré-montado com base na atividade 4 da última lista.
	 */
	public static Grafo exemploGrafoNaoDirecionado() {
		List<Vertice> verticeList = new ArrayList<Vertice>();
		for (int i = 0; i < 5; i++) {
			verticeList.add(new Vertice(Integer.toString(i + 1)));
		}

		List<Aresta> arestaList = new ArrayList<Aresta>();
		arestaList.add(Aresta.novaAresta("a1", "1", "3", verticeList));
		arestaList.add(Aresta.novaAresta("a2", "2", "3", verticeList));
		arestaList.add(Aresta.novaAresta("a3", "3", "2", verticeList));
		arestaList.add(Aresta.novaAresta("a4", "1", "2", verticeList));
		arestaList.add(Aresta.novaAresta("a5", "3", "4", verticeList));
		arestaList.add(Aresta.novaAresta("a6", "2", "5", verticeList));
		arestaList.add(Aresta.novaAresta("a7", "5", "2", verticeList));
		arestaList.add(Aresta.novaAresta("a8", "4", "5", verticeList));

		return new Grafo(
            "Grafo não Direcionado", verticeList, arestaList, false);
	}

	/*
	 * Método para montar um grafo com dados informados pelo usuÃ¡rio.
	 */
	public static Grafo novoGrafoPersonalizado(Scanner sc) {
		List<Vertice> vertices = new ArrayList<Vertice>();
		List<Aresta> arestas = new ArrayList<Aresta>();

		System.out.println("Identifique este Grafo: ");
		String nome = sc.nextLine();

		System.out.println("\nInforme numero de vértices do Grafo: ");
		int numeroVertices = sc.nextInt();
		for (int i = 0; i < numeroVertices; i++) {
			vertices.add(new Vertice(Integer.toString(i + 1)));
		}

		System.out.println(
            "\nInforme um aresta por vez no formato " + 
            "\'VérticeA-VérticeB\', digite ';' para finalizar: ");
		String arestasString = sc.next();
		int a = 0;
		while (!arestasString.equals(";")) {
			try {
				String[] verticesAresta = 
                arestasString.trim().replaceAll("\\s+", " ").split("-");
				arestas.add(Aresta.novaAresta(
                    "a" + Integer.toString(a + 1), 
                    verticesAresta[0], 
                    verticesAresta[1],
					vertices));
				a++;
			} catch (Exception e) {
				System.out.println("\'" + arestasString + 
                    "\' Não é válido para o formato " + 
                    "\'VérticeA-VérticeB\' ");
			}
			arestasString = sc.next();
		}

		System.out.println("\nO grafo é direcionado? (s/n) ");
		String resposta;
		boolean direcao = false;
		do {
			resposta = sc.next().toLowerCase().trim();
			if (resposta.equals("s")) {
				direcao = true;
			} else if (!resposta.equals("n")) {
				System.out.println(resposta + 
                " não é uma opção válida! (s/n) ");
			}
		} while (!direcao && !resposta.equals("n"));

		return new Grafo(nome, vertices, arestas, direcao);
	}

	/*
	 * Método para montar um grafo com quantidade aleatória 
	 * de vértices, geração aleatória de arestas com base nos 
	 * vértices e com chances de ser direcionado ou não.
	 */
	public static Grafo novoGrafoAleatorio() {
		Random gerador = new Random();
		int vertices = gerador.nextInt(9) + 1;
		List<Vertice> verticeList = new ArrayList<Vertice>();
		for (int i = 0; i < vertices; i++) {
			verticeList.add(new Vertice(Integer.toString(i + 1)));
		}

		int arestas = gerador.nextInt(vertices * 2);
		List<Aresta> arestaList = new ArrayList<Aresta>();
		for (int i = 0; i < arestas; i++) {
			arestaList.add(Aresta.novaAresta(
                "a" + Integer.toString(i + 1), 
                Integer.toString(gerador.nextInt(vertices) + 1),
				Integer.toString(gerador.nextInt(vertices) + 1), 
                verticeList));
		}

		boolean direcao = gerador.nextBoolean();

		String nome = "Grafo " + 
        (direcao ? "Direcionado" : "Não Direcionado") + " Aleatório";

		return new Grafo(nome, verticeList, arestaList, direcao);
	}

}
