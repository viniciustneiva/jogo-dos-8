buscaProfundidade(arvGeradora, raiz); // chama o metodo

// dps de chamar o método, faz a ultima posiçao = a primeira
percArv.add(k, percArv.get(0));

// metodo
public void buscaProfundidade(Grafo grafo, int raiz) {

ciclo.add(raiz);
percArv.add(k, raiz);

visitados[raiz] = true;

int i;
for (i = 0; i < grafo.numV; i++) {
    if (grafo.matrizAdj[raiz][i] != 0 && visitados[i] == false) {
        k++;
        buscaProfundidade(grafo, i);
    }
}
k++;
percArv.add(k, percArv.get(k - 2));  // qnd n tem + filhos guarda a raiz anterior
}
