package grafos;

import java.util.ArrayList;
import java.util.List;

/*
 * Classe auxiliar para impressão da lista de adjacência
 */
public class ListaAdjacencia {
	private Vertice vertice;
	private List<Vertice> adjacencias;

	public ListaAdjacencia(Vertice vertice) {
		this.vertice = vertice;
		adjacencias = new ArrayList<Vertice>();
	}

	public Vertice getVertice() {
		return vertice;
	}

	public void setVertice(Vertice vertice) {
		this.vertice = vertice;
	}

	public List<Vertice> getAdjacencias() {
		return adjacencias;
	}

	public void setAdjacencias(List<Vertice> adjacencias) {
		this.adjacencias = adjacencias;
	}

}
