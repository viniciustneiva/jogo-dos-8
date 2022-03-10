import java.util.*;

public class Tabela {
	private Map<Integer, String> tabela;
	private String[] elementos = {"0", "1", "2", "3", "4", "5", "6", "7", "8"};
	private Map<Integer, String> resultado; // {"1", "2", "3", "8", " ", "4", "7", "6", "5"};
	private ArrayList<Tabela> estados;
	private int contagem;
	Tabela(){
		this.contagem = 0;
		this.tabela = new HashMap<>();
		this.resultado = new HashMap<>();
		this.estados = new ArrayList<Tabela>();
		embaralhar(elementos);
		for(int i = 0; i < 9; i++){
			this.tabela.put(i, this.elementos[i]);
		}
	}

	public Map<Integer, String> getTabela(){
		return this.tabela;
	}

	public ArrayList<Tabela> getEstados(){
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
		
		return resultado;
	}

	public String[] getElementos(){
		return this.elementos;
	}

	public boolean posDisponivel(int pos){
		Map<Integer, String> tabela = getTabela();
		if(tabela.get(pos) == "0"){
			return true;
		}

		return false;
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

	private boolean igual(Tabela t,Map<Integer, String> r){
		Map<Integer, String> tabela = t.getTabela();
		if(tabela == r){
			return true;
		}else{
			return false;
		}
	}

	private void troca(int atual, int posFinal){
		Map<Integer, String> tabela = getTabela();

		String antigo = tabela.get(atual);
		String novo = tabela.get(posFinal);

		tabela.replace(posFinal, antigo);
		tabela.replace(atual, novo);

	}

	public void soluciona(Tabela atual){
		Tabela tabelaAtual = atual;
		Map<Integer, String> tabelaFinal = atual.getResultado();
		if(tabelaAtual.igual(tabelaAtual, tabelaFinal)){
			System.out.println("Solução encontrada, numero de movimentos: "+ this.contagem);
		}else{

		}

	}

}
