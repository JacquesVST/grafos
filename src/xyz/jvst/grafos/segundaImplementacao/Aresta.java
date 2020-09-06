package xyz.jvst.grafos.segundaImplementacao;

public class Aresta {
	private Integer origem;
	private Integer destino;

	public Aresta(Integer origem, Integer destino) {
		this.origem = origem;
		this.destino = destino;
	}

	public Integer getOrigem() {
		return origem;
	}

	public void setOrigem(Integer origem) {
		this.origem = origem;
	}

	public Integer getDestino() {
		return destino;
	}

	public void setDestino(Integer destino) {
		this.destino = destino;
	}

	@Override
	public String toString() {
		return "Aresta [origem=" + origem + ", destino=" + destino + "]";
	}

}
