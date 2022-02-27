import java.util.*;

public class App {
	public static void main(String[] args) {
		Tabela t = new Tabela();
		Map<Integer, String[]> dH = new HashMap<Integer, String[]>();
		dH.put(0, new String[] {"0", "1", "2", "1", "2", "3", "2", "3", "4"});
		dH.put(1, new String[] {"1", "0", "1", "2", "1", "2", "3", "2", "3"});
		dH.put(2, new String[] {"2", "1", "0", "3", "2", "1", "4", "3", "2"});
		dH.put(3, new String[] {"1", "2", "3", "0", "1", "2", "1", "2", "3"});
		dH.put(4, new String[] {"2", "1", "2", "1", "0", "1", "2", "1", "2"});
		dH.put(5, new String[] {"3", "2", "1", "2", "1", "0", "3", "2", "1"});
		dH.put(6, new String[] {"2", "3", "4", "1", "2", "3", "0", "1", "2"});
		dH.put(7, new String[] {"3", "2", "3", "2", "1", "2", "1", "0", "1"});
		dH.put(8, new String[] {"4", "3", "2", "3", "2", "1", "2", "1", "0"});
		
		t.imprime();
		System.out.println("--------------");
		t.imprimeResultado();
		System.out.println("--------------");
		System.out.println("Distância Heurística entre as posições: ");

		int i;
		for(int j = 0; j<9; j++){
			i = 0;
			System.out.print("|");
			for(String s:dH.get(j)){
				if(i == 8){
					System.out.print(s);
				}else{
					System.out.print(s+", ");
				}
				i++;
			}
			System.out.print("|");
		}
		

	}
	
}
