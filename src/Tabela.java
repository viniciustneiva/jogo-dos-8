import java.util.*;

public class Tabela {
	private Map<Integer, String> tabela;
	private String[] elementos = {"0", "1", "2", "3", "4", "5", "6", "7", "8"};
	private Map<Integer, String> resultado; // {"1", "2", "3", "8", " ", "4", "7", "6", "5"};
	private ArrayList<ArrayList<String>> estados;
	private int contagem;
	Tabela(){
		this.contagem = 0;
		this.tabela = new HashMap<>();
		this.resultado = new HashMap<>();
		this.estados = new ArrayList<ArrayList<String>>();
		embaralhar(elementos);
		for(int i = 0; i < 9; i++){
			this.tabela.put(i, this.elementos[i]);
		}
	}

	public Map<Integer, String> getTabela(){
		return this.tabela;
	}

	public ArrayList<ArrayList<String>> getEstados(){
		return this.estados;
	}

	public  Map<Integer, String> getResultado() {

		this.resultado.put(0,"1");
		this.resultado.put(1,"2");
		this.resultado.put(2,"3");
		this.resultado.put(3,"8");
		this.resultado.put(4,"0");
		this.resultado.put(5,"4");
		this.resultado.put(6,"7");
		this.resultado.put(7,"6");
		this.resultado.put(8,"5");
		
		return this.resultado;
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
			int j = random.nextInt(v.length);
			String temp = v[i];
			v[i] = v[j];
			v[j] = temp;
		}

	}

	public void move(int atual, int posFinal){
		if(posDisponivel(posFinal) && podeMover(atual, posFinal)){
			troca(atual, posFinal);
			this.contagem++;
		}else{
			System.out.println("Posicao ocupada ou nao é vizinho!");
		}
		
	}

	public boolean podeMover(int atual, int posFinal){
		Vizinho v = new Vizinho();
		Map<Integer, String[]> vizinhanca = v.getVizinhos();
		String[] vizinhoAtual = vizinhanca.get(atual);

		if(vizinhoAtual[posFinal] == "1"){
			return true;
		}else{
			return false;
		}
	}

	public boolean posDisponivel(int pos){
		if(this.getTabela().get(pos) == "0"){
			return true;
		}
		return false;
	}

	private boolean igual(Map<Integer, String> t,Map<Integer, String> r){
		if(t == r){
			return true;
		}else{
			return false;
		}
	}

	private void troca(int atual, int posFinal){
		Map<Integer, String> tabela = this.getTabela();

		String antigo = tabela.get(atual);
		String novo = tabela.get(posFinal);

		tabela.replace(posFinal, antigo);
		tabela.replace(atual, novo);

	}

	public void soluciona(){
		ArrayList<String> result = new ArrayList<>();
		for (Integer chave: this.resultado.keySet()){  
			result.add(this.resultado.get(chave));
		}
		if(this.estados.isEmpty()){
			ArrayList<String> aux = new ArrayList<>();
			for (Integer key: this.tabela.keySet()){  
				aux.add(this.tabela.get(key));
			}
			this.estados.add(aux);
		}
		for(int k= 0;k < 10000;k++){
			
			if(this.igual(this.tabela, this.getResultado())){
				System.out.println("Solução encontrada!");
			}else{
				int i;
				for (Integer chave : this.tabela.keySet()) {
					i = 0;
					while(i< 9){
						if(posDisponivel(chave) && podeMover(i, chave)){
							this.move(i, chave);
							ArrayList<String> aux = new ArrayList<>();
							for (Integer key: this.tabela.keySet()){  
								aux.add(this.tabela.get(key));
							}
							this.estados.add(aux);
							
						}
						i++;
					}
					
		
				}

			}
		}
		System.out.println("Número de movimentos: "+this.contagem);

	}

}
