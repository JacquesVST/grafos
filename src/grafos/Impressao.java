package grafos;

import java.util.List;

public class Impressao {

	/*
	 * M�todo para imprimir apenas a matriz de adjac�ncia
	 */
	public static void imprimirMatrizAdjacencia(int[][] matriz) {
		System.out.println("\nMatriz de Adjac�ncia\n");
		for (int[] vetor : matriz) {
			String linha = "|";
			for (int item : vetor) {
				linha += Integer.toString(item) + "|";
			}
			System.out.println(linha);
		}
	}

	/*
	 * M�todo para imprimir apenas a lista de adjac�ncia
	 */
	public static void imprimirListaAdjacencias(
        List<ListaAdjacencia> listaAdjacencia) {
		System.out.println("\nLista de Adjac�ncias");
		for (ListaAdjacencia lista : listaAdjacencia) {
			String adjacenciaVertice = lista.getVertice().getId();
			for (Vertice adjacencia : lista.getAdjacencias()) {
				if (adjacencia == null) {
					adjacenciaVertice += ".";
					continue;
				} else {
					adjacenciaVertice += "->" + adjacencia.getId();
				}
			}
			System.out.println(adjacenciaVertice);
		}
	}

	/*
	 * M�todo para imprimir apenas o grau dos v�rtices
	 */
	public static void imprimirGrauDosVertices(
        List<GrauVertice> grauVertices, boolean direcionado) {
		if (direcionado) {
			System.out.println("\nV�rtice | Grau Entrada | Grau Sa�da");
			System.out.println("--------+--------------+-----------");
			grauVertices.forEach(vertice -> {
				String grauVertice = "    " + vertice.getVertice().getId() 
                    + "\t|\t" + vertice.getEntrada()
					+ "      |     " + vertice.getSaida();
				System.out.println(grauVertice);
			});
		} else {
			System.out.println("\nV�rtice | Grau");
			System.out.println("--------+-----");
			grauVertices.forEach(vertice -> {
				String grauVertice = 
                    "    " + vertice.getVertice().getId() + "\t|  " + 
                    (vertice.getEntrada() + vertice.getSaida());
				System.out.println(grauVertice);
			});
		}
	}
	
	/*
	 * M�todo para imprimir o ID do grafo todos os itens acima
	 */
	public static void imprimirTudo(Grafo grafo) {
		System.out.println("\n\tGrafo: " + grafo.getId());
		Impressao.imprimirMatrizAdjacencia(grafo.gerarMatrizAdjacencia());
		Impressao.imprimirListaAdjacencias(grafo.gerarListaAdjacencia());
		Impressao.imprimirGrauDosVertices(
            grafo.gerarGrauDosVertices(), grafo.isDirecionado());
	}

}
