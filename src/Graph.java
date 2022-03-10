import java.io.*;
import java.util.*;

public class Graph{
    private int V; 
    private LinkedList<Integer> adj[];
    private Vizinho vizinho;
    private int contagem;
    Graph(int v){
        V = v;
        vizinho = new Vizinho();
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i){
            adj[i] = new LinkedList();
        }
        contagem = 0;
    }

    public void addEdge(Tabela t){
        Map<Integer, String[]> vizinhanca = vizinho.getVizinhos();
        Map<Integer, String> tabela = t.getTabela();
        String[] vizinhoAtual;
        int vInteiro;
        String str;
        for(int j = 0; j < tabela.size() ; j++){
            str = tabela.get(j);
            vInteiro = Integer.parseInt(str);
            vizinhoAtual = vizinhanca.get(j);
            for(int i = 0; i < vizinhoAtual.length;i++){
                if(vizinhoAtual[i] == "1"){
                    adj[vInteiro].add(i);
                }
            }
        }        
    }

    public void DFSUtil(int v,boolean visited[]){

        visited[v] = true;
        System.out.print(v+" ");
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()){
            int n = i.next();
            if (!visited[n])
                DFSUtil(n,visited);
                
            ++this.contagem;    
        }

    }
  
    public void DFS(){
        boolean visited[] = new boolean[V];
        for (int i=0; i<V; ++i){
            if (visited[i] == false){
                DFSUtil(i, visited);
            }
        }
    }

    public int getContagem(){
        return this.contagem;
    }
}