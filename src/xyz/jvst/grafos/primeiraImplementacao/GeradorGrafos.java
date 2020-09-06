package xyz.jvst.grafos.primeiraImplementacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GeradorGrafos {

	/*
	 * Grafo pr�-montado com base na atividade 3 da �ltima lista
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
	 * Grafo pr�-montado com base na atividade 4 da �ltima lista.
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
            "Grafo n�o Direcionado", verticeList, arestaList, false);
	}

	/*
	 * M�todo para montar um grafo com dados informados pelo usuário.
	 */
	public static Grafo novoGrafoPersonalizado(Scanner sc) {
		List<Vertice> vertices = new ArrayList<Vertice>();
		List<Aresta> arestas = new ArrayList<Aresta>();

		System.out.println("Identifique este Grafo: ");
		String nome = sc.nextLine();

		System.out.println("\nInforme numero de v�rtices do Grafo: ");
		int numeroVertices = sc.nextInt();
		for (int i = 0; i < numeroVertices; i++) {
			vertices.add(new Vertice(Integer.toString(i + 1)));
		}

		System.out.println(
            "\nInforme um aresta por vez no formato " + 
            "\'V�rticeA-V�rticeB\', digite ';' para finalizar: ");
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
                    "\' N�o � v�lido para o formato " + 
                    "\'V�rticeA-V�rticeB\' ");
			}
			arestasString = sc.next();
		}

		System.out.println("\nO grafo � direcionado? (s/n) ");
		String resposta;
		boolean direcao = false;
		do {
			resposta = sc.next().toLowerCase().trim();
			if (resposta.equals("s")) {
				direcao = true;
			} else if (!resposta.equals("n")) {
				System.out.println(resposta + 
                " n�o � uma op��o v�lida! (s/n) ");
			}
		} while (!direcao && !resposta.equals("n"));

		return new Grafo(nome, vertices, arestas, direcao);
	}

	/*
	 * M�todo para montar um grafo com quantidade aleat�ria 
	 * de v�rtices, gera��o aleat�ria de arestas com base nos 
	 * v�rtices e com chances de ser direcionado ou n�o.
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
        (direcao ? "Direcionado" : "N�o Direcionado") + " Aleat�rio";

		return new Grafo(nome, verticeList, arestaList, direcao);
	}

}
