# _Busca de Caminhos Disjuntos em Grafos_

Este projeto implementa a busca de caminhos disjuntos em grafos a partir de um vertice inicial a final, feito usando Java.

## Busca de Caminhos Disjuntos

A busca de caminhos disjuntos é procura de rotas ou caminhos que não compartilham nenhum nó (ponto de conexão) em comum. Esse conceito é comumente aplicado em várias áreas, como teoria dos grafos, redes de computadores, circuitos elétricos, logística, entre outros contextos.

Na teoria dos grafos, a busca por caminhos disjuntos pode envolver a identificação de dois caminhos diferentes entre dois pontos, garantindo que esses caminhos não tenham nós repetidos. Pode ser útil em aplicações como roteamento em redes, onde é desejável ter caminhos alternativos para garantir a redundância e a tolerância a falhas.

### Principais Características

- A busca de caminhos disjuntos oferece redundância, garantindo rotas alternativas, promovendo a resiliência em caso de falhas.
- Encontrar caminhos sem nós compartilhados assegura diversidade de rotas, útil para otimizar o desempenho e distribuir o tráfego de forma equilibrada.
- Esta abordagem é essencial em redes de comunicação, sistemas de transporte e em muitas outras aplicações para garantir conectividade confiável e robustez.

## Instalação

1 - Faça o clone do repositorio
```sh
git clone https://github.com/Thi23gm/Grafos_Trabalho_3.git
```

2- Navegue até a pasta do projeto e compile o arquivo principal:

```sh
cd Grafos_Trabalho_3
javac Main.java
```
3- Execute a aplicação:
```
java Main
```
4- O programa irá solicitar o caminho do arquivo de criação do grafo. Você pode inserir qualquer caminho de arquivo. Se quiser usar os exemplos fornecidos pelo projeto, eles estão disponíveis nos seguintes caminhos:

- Para o grafo de teste com 10 vértices: " Tests/graph-test-100.txt "
- Para o grafo de teste com 100 vértices: " Tests/graph-test-100.txt "

5- O programa também irá solicitar os vertices de inicio e final dos caminhos que você solicitar, lembre que o Grafo que você importar tem os valores dos vertices, de 10 vertices (1 a 10) e o de 100 vertices (1 a 100).

6- A saida será dada pelo melhor caminho (o de menor tamanho) e o numero de caminhos possiveis, também irá gerar um arquivo saida.txt que terá todos os caminhos possiveis do vertice inicial para o vertice destino.
