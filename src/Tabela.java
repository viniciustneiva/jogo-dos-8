import java.util.*;

public class Tabela {
	private Map<Integer, String> tabela = new HashMap<>();
	private String[] elementos = {" ", "1", "2", "3", "4", "5", "6", "7", "8"};
	private Map<Integer, String> resultado = new HashMap<>(); // {"1", "2", "3", "8", " ", "4", "7", "6", "5"};
	
	Tabela(){
		embaralhar(elementos);
		for(int i = 0; i < 9; i++){
			this.tabela.put(i,this.elementos[i]);
		}
	}

	public Map<Integer, String> getTabela(){
		return this.tabela;
	}

	public  Map<Integer, String> getResultado() {
		Map<Integer, String> resultado = new HashMap<>();
		resultado.put(0,"1");
		resultado.put(1,"2");
		resultado.put(2,"3");
		resultado.put(3,"8");
		resultado.put(4," ");
		resultado.put(5,"4");
		resultado.put(6,"7");
		resultado.put(7,"6");
		resultado.put(8,"5");
		return resultado;
	}

	public String[] getElementos(){
		return this.elementos;
	}
	
	public void imprime(Map<Integer, String> t) {
		int count = 0;
		for (Integer key: t.keySet()){  
			System.out.print(t.get(key)+" ");
			count++;
			if(count == 3){
				System.out.println("");
				count = 0;
			}
		}
	}
	
	
	public static void embaralhar(String [] v) {
		Random random = new Random();
		for (int i=0; i < (v.length - 1); i++) {
			//sorteia um �ndice
			int j = random.nextInt(v.length);
			//troca o conte�do dos �ndices i e j do vetor
			String temp = v[i];
			v[i] = v[j];
			v[j] = temp;
		}

	}

}
