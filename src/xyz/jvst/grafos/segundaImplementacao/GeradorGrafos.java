package xyz.jvst.grafos.segundaImplementacao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class GeradorGrafos {

	/*
	 * M�todo para montar um grafo com dados informados pelo usu�rio.
	 */
	public static Grafo novoGrafoPersonalizado(Scanner sc) {
		List<Aresta> arestas = new ArrayList<Aresta>();

		System.out.println("\nInforme o numero de v�rtices do Grafo: ");
		Integer vertices = sc.nextInt();

		System.out.println("\nInforme um aresta por vez no formato \'V�rticeA-V�rticeB\', ");
		System.out.println("Pressione enter para inserir a pr�xima aresta e ';' para finalizar");

		String arestasString = sc.next();
		while (!arestasString.equals(";")) {
			try {
				String[] verticesAresta = arestasString.trim().replaceAll("\\s+", " ").split("-");
				arestas.add(
						new Aresta(Integer.parseInt(verticesAresta[0]) - 1, Integer.parseInt(verticesAresta[1].trim().replaceAll("\\s+", ";")) - 1));
			} catch (Exception e) {
				System.out.println("\'" + arestasString + "\' N�o � v�lido para o formato " + "\'V�rticeA-V�rticeB\' ");
			}
			if (arestasString.endsWith(";")) {
				arestasString = ";";
			} else {
				arestasString = sc.next();
			}
		}

		return new Grafo(vertices, arestas);

	}

	/*
	 * M�todo para montar um grafo com quantidade aleat�ria de v�rtices, gera��o
	 * aleat�ria de arestas com base nos v�rtices e com chances de ser direcionado
	 * ou n�o.
	 */
	public static Grafo novoGrafoAleatorio() {
		Random gerador = new Random();
		Integer vertices = gerador.nextInt(7) + 3;

		int arestas = gerador.nextInt(vertices * vertices);
		List<Aresta> arestaList = new ArrayList<Aresta>();
		for (int i = 0; i < arestas; i++) {
			Aresta aresta = new Aresta(gerador.nextInt(vertices), gerador.nextInt(vertices));
			arestaList.add(aresta);
		}

		return new Grafo(vertices, removerParalelas(arestaList));
	}

	/*
	 * M�todo para montar um grafo com quantidade aleat�ria de v�rtices, gera��o
	 * aleat�ria de arestas com base nos v�rtices e com chances de ser direcionado
	 * ou n�o.
	 */
	public static Grafo novoGrafoAleatorioComVertices(Scanner sc) {

		System.out.println("\nInforme o numero de v�rtices do Grafo: ");
		int vertices = sc.nextInt();

		Random gerador = new Random();
		int arestas = gerador.nextInt(vertices * vertices);
		List<Aresta> arestaList = new ArrayList<Aresta>();
		for (int i = 0; i < arestas; i++) {
			Aresta aresta = new Aresta(gerador.nextInt(vertices), gerador.nextInt(vertices));
			arestaList.add(aresta);
		}

		return new Grafo(vertices, removerParalelas(arestaList));
	}

	public static List<Aresta> removerParalelas(List<Aresta> arestasRepetidas) {
		List<Aresta> arestasUnicas = new ArrayList<Aresta>();
		Set<String> hashArestas = new HashSet<String>();
		for (Aresta aresta : arestasRepetidas) {
			if (!hashArestas.contains(aresta.getOrigem().toString() + aresta.getDestino().toString())) {
				hashArestas.add(aresta.getOrigem().toString() + aresta.getDestino().toString());
				arestasUnicas.add(aresta);
			}
		}
		return arestasUnicas;
	}

}
