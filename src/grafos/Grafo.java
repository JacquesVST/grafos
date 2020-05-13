package grafos;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
	private String id;
	private List<Vertice> vertices;
	private List<Aresta> arestas;
	private boolean direcionado;

	public Grafo(String id, List<Vertice> vertices, List<Aresta> arestas, 
    boolean direcionado) {
		super();
		this.id = id;
		this.vertices = vertices;
		this.arestas = arestas;
		this.direcionado = direcionado;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Vertice> getVertices() {
		return vertices;
	}

	public void setVertices(List<Vertice> vertices) {
		this.vertices = vertices;
	}

	public boolean isDirecionado() {
		return direcionado;
	}

	public void setDirecionado(boolean direcionado) {
		this.direcionado = direcionado;
	}

	public List<Aresta> getArestas() {
		return arestas;
	}

	public void setArestas(List<Aresta> arestas) {
		this.arestas = arestas;
	}

	/*
	 * Método para gerar uma matriz bidimensional representando a matriz
	 * de adjacências do grafo
	 */
	public int[][] gerarMatrizAdjacencia() {
		int[][] matrizAdjacencia = 
        new int[vertices.size()][vertices.size()];
		for (int i = 0, j = 0; i < vertices.size(); j++) {
			matrizAdjacencia[i][j] = 0;
			if (j + 1 == vertices.size()) {
				i++;
				j = 0;
			}
		}
		arestas.forEach(aresta -> {
			if (direcionado) {
				matrizAdjacencia
                [vertices.indexOf(aresta.getvInicial())]
                [vertices.indexOf(aresta.getvFinal())]++;
			} else {
				matrizAdjacencia
                [vertices.indexOf(aresta.getvInicial())]
                [vertices.indexOf(aresta.getvFinal())]++;
				matrizAdjacencia
                [vertices.indexOf(aresta.getvFinal())]
                [vertices.indexOf(aresta.getvInicial())]++;
			}
		});
		return matrizAdjacencia;
	}

	/*
	 * Método para gerar uma lista contendo cada vértice e seu grau 
	 * de entrada e saída (somados quando o grafo não é direcionado)
	 */
	public List<GrauVertice> gerarGrauDosVertices() {
		int[] entrada = new int[vertices.size()];
		int[] saida = new int[vertices.size()];
		List<GrauVertice> grausVertice = new ArrayList<GrauVertice>();
		arestas.forEach(aresta -> {
			entrada[vertices.indexOf(aresta.getvFinal())]++;
			saida[vertices.indexOf(aresta.getvInicial())]++;
		});
		for (int i = 0; i < vertices.size(); i++) {
			grausVertice.add(
                new GrauVertice(vertices.get(i), entrada[i], saida[i]));
		}
		return grausVertice;
	}

	/*
	 * Método para gerar uma lista contendo, pra cada vértice,
	 * uma lista de vértices adjacentes
	 */
	public List<ListaAdjacencia> gerarListaAdjacencia() {
		List<ListaAdjacencia> listaAdjacencia = 
        new ArrayList<ListaAdjacencia>();
		vertices.forEach(vertice -> {
			ListaAdjacencia adjacencia = new ListaAdjacencia(vertice);
			arestas.forEach(aresta -> {
				if (direcionado) {
					if (aresta.getvInicial().equals(vertice)) {
						adjacencia.getAdjacencias().add(
                            aresta.getvFinal());
					}
				} else {
					if (aresta.getvInicial().equals(vertice)) {
						adjacencia.getAdjacencias().add(
                            aresta.getvFinal());
					} else if (aresta.getvFinal().equals(vertice)) {
						adjacencia.getAdjacencias().add(
                            aresta.getvInicial());
					}
				}
			});
			adjacencia.getAdjacencias().sort((Vertice v1, Vertice v2) -> {
				return v1.getId().compareTo(v2.getId());
			});
			adjacencia.getAdjacencias().add(null);
			listaAdjacencia.add(adjacencia);
		});
		return listaAdjacencia;
	}

}
