package xyz.jvst.grafos.segundaImplementacao;

import java.util.List;

public class Grafo {
	private Integer vertices;
	private List<Aresta> arestas;

	public Grafo(Integer vertices, List<Aresta> arestas) {
		this.vertices = vertices;
		this.arestas = arestas;
	}

	public Integer getVertices() {
		return vertices;
	}

	public void setVertices(Integer vertices) {
		this.vertices = vertices;
	}

	public List<Aresta> getArestas() {
		return arestas;
	}

	public void setArestas(List<Aresta> arestas) {
		this.arestas = arestas;
	}

	/*
	 * Método para gerar uma matriz bidimensional representando a matriz de
	 * adjacências do grafo
	 */
	public Integer[][] gerarMatrizAdjacencia() {
		Integer[][] matrizAdjacencia = new Integer[vertices][vertices];
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				matrizAdjacencia[i][j] = 0;
			}
		}
		for (Aresta aresta : arestas) {
			matrizAdjacencia[aresta.getOrigem()][aresta.getDestino()]++;
		}
		return matrizAdjacencia;
	}

	/*
	 * Método para gerar uma matriz bidimensional representando a matriz de
	 * adjacências do grafo
	 */
	public Integer[][] gerarMatrizAlcancabilidade() {
		Integer[][] matriz = this.gerarMatrizAdjacencia();
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				for (int k = 0; k < vertices; k++) {
					matriz[j][k] = (matriz[j][k] == 1 || (matriz[j][i] == 1 && matriz[i][k] == 1)) ? 1 : 0;
				}
			}
		}
		return matriz;
	}

}
