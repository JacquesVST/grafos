package xyz.jvst.grafos.segundaImplementacao;

public class Impressao {

	/*
	 * Método para imprimir apenas a matriz de adjacência
	 */
	public static void imprimirMatriz(Integer[][] matriz, Integer tamanho, String impressao) {
		System.out.println(impressao);
		for (int i = 0; i < tamanho; i++) {
			String linha = "|";
			for (int j = 0; j < tamanho; j++) {
				linha += matriz[i][j] + "|";
			}
			System.out.println(linha);
		}
	}
}
