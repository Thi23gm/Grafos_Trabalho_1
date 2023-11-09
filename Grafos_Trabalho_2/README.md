# _Busca de Profundidade em Grafos_

Este projeto implementa a busca de profundidade em grafos usando Java usando o modelo de Lista de Adjacência.

## Busca em Profundidade

A Busca em Profundidade (DFS - Depth-First Search) é um algoritmo fundamental para a exploração de grafos. Este algoritmo é utilizado para percorrer estruturas de dados em profundidade, a partir de um nó inicial, antes de retroceder para explorar outros caminhos.

### Principais Características

- Algoritmo de busca não informada.
- Pode ser implementado de forma recursiva ou utilizando uma pilha.
- Eficiente na identificação de componentes conectados e detecção de ciclos em grafos.

### Tipos de Arestas na DFS

Durante a DFS, as arestas podem ser classificadas em quatro categorias:

1. **Aresta de Árvore:** Arestas que fazem parte da árvore gerada durante a busca.
2. **Aresta de Retorno:** Arestas que levam de um nó a um de seus ancestrais na árvore gerada.
3. **Aresta de Avanço:** Arestas que levam a um nó que ainda não foi completamente explorado.
4. **Aresta de Cruzamento:** Arestas que conectam nós diferentes em diferentes ramos da árvore gerada, indicando a existência de caminhos paralelos no grafo.

A DFS é amplamente utilizada em problemas de análise de conectividade, ordenação topológica, detecção de ciclos e muitas outras aplicações em ciência da computação e algoritmos de grafos.

## Instalação

1 - Faça o clone do repositorio
```sh
git clone https://github.com/Thi23gm/Grafos_Trabalho_2.git
```

2- Navegue até a pasta do projeto e compile o arquivo principal:

```sh
cd Grafos_Trabalho_2
javac Main.java
```
3- Execute a aplicação:
```
java Main
```
4- O programa irá solicitar o caminho do arquivo de criação do grafo. Você pode inserir qualquer caminho de arquivo. Se quiser usar os exemplos fornecidos pelo projeto, eles estão disponíveis nos seguintes caminhos:

- Para o grafo de teste com 100 vértices: " Tests/graph-test-100txt "
- Para o grafo de teste com 5000 vértices: " Tests/graph-test-5000.txt "

5- Para ver as saidas sera criado arquivos TXT na pasta Saidas/Arestas que terá 4 arquivos, Arestas_Arvore.txt, Saidas/Arestas/Arestas_Retorno.txt, Arestas_Cruzamento.txt e Arestas_Avanco.txt que conterá as arestas em seus respectivas classificações.
