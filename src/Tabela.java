import java.util.*;

public class Tabela {
	private String[][] tabela;
	private String[] elementos = {" ", "1", "2", "3", "4", "5", "6", "7", "8"};
	private String[] resultado = {"1", "2", "3", "8", " ", "4", "7", "6", "5"};
	
	public static void embaralhar(String [] v) {

		Random random = new Random();

		for (int i=0; i < (v.length - 1); i++) {
			//sorteia um índice
			int j = random.nextInt(v.length);
			//troca o conteúdo dos índices i e j do vetor
			String temp = v[i];
			v[i] = v[j];
			v[j] = temp;
		}

	}
	
	Tabela(){
		tabela = new String[3][3];
		embaralhar(elementos);
		int k = 0;
		for(int linha = 0; linha < 3 && k<9; linha++) {
			for(int coluna = 0; coluna < 3 && k<9; coluna++) {
				this.tabela[linha][coluna] = elementos[k];
				k++;
			}
		}
	}
	
	public void imprime() {
		System.out.println("Tabela gerada aleatoriamente!");
		for(int linha = 0; linha < 3; linha++) {
			for(int coluna = 0; coluna < 3; coluna++) {
				System.out.print(this.tabela[linha][coluna]+" ");
			}
			System.out.println("");
		}
	}
	
public void imprimeResultado() {
	System.out.println("Resultado final:");
		String[][] resposta = resultado();
		for(int linha = 0; linha < 3; linha++) {
			for(int coluna = 0; coluna < 3; coluna++) {
				System.out.print(resposta[linha][coluna]+" ");
			
			}
			System.out.println("");
		}
	}
	
	public String[][] resultado() {
		String[][] gabarito = new String[3][3];
		int k = 0;
		for(int linha = 0; linha < 3  && k<9 ; linha++) {
			for(int coluna = 0; coluna < 3  && k<9; coluna++) {
				gabarito[linha][coluna] = this.resultado[k];
				k++;
			}
		}
		
		return gabarito;
	}
}
