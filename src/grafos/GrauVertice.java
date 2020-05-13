package grafos;

/*
 * Classe auxiliar para impressão do grau do vértice
 */
public class GrauVertice {

	private Vertice vertice;
	private int entrada;
	private int saida;

	public GrauVertice(Vertice vertice, int entrada, int saida) {
		super();
		this.vertice = vertice;
		this.entrada = entrada;
		this.saida = saida;
	}

	public Vertice getVertice() {
		return vertice;
	}

	public void setVertice(Vertice vertice) {
		this.vertice = vertice;
	}

	public int getEntrada() {
		return entrada;
	}

	public void setEntrada(int entrada) {
		this.entrada = entrada;
	}

	public int getSaida() {
		return saida;
	}

	public void setSaida(int saida) {
		this.saida = saida;
	}
}
