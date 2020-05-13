package grafos;

import java.util.List;

public class Aresta {
	private String id;
	private Vertice vInicial;
	private Vertice vFinal;

	public Aresta(String id, Vertice vInicial, Vertice vFinal) {
		super();
		this.id = id;
		this.vInicial = vInicial;
		this.vFinal = vFinal;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Vertice getvInicial() {
		return vInicial;
	}

	public void setvInicial(Vertice vInicial) {
		this.vInicial = vInicial;
	}

	public Vertice getvFinal() {
		return vFinal;
	}

	public void setvFinal(Vertice vFinal) {
		this.vFinal = vFinal;
	}

	/*
	 * Método que cria uma aresta através de do ID de dois vértices e 
     * uma lista populada para utilizar das referencias de memória.
	 */
	public static Aresta novaAresta(String id, String v1, String v2, 
        List<Vertice> vertices) {
		Vertice vInicial = vertices.stream().filter(
            vertice -> v1.equals(vertice.getId())
            ).findFirst().orElse(null);
		Vertice vFinal = vertices.stream().filter(
            vertice -> v2.equals(vertice.getId())
            ).findFirst().orElse(null);
		return new Aresta(id, vInicial, vFinal);
	}

}
