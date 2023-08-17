# _Represenação de Grafos_

Este projeto implementa a representação de grafos em Java usando o modelo de Lista de Adjacência e o Forward Star.

## Introdução

Grafos são estruturas de dados fundamentais que permitem representar relações entre pares de objetos. Este projeto implementa a representação de grafos e oferece uma interface simples para manipulação e consulta.

## Modelos de Representação
### Lista de Adjacência
A representação por Lista de Adjacência utiliza uma lista para cada vértice do grafo. Cada lista contém todos os vértices adjacentes ao vértice correspondente.

### Forward Star
A representação Forward Star utiliza uma única lista para todos os vértices e arestas. Os vértices são listados em ordem, seguidos por suas arestas adjacente.

### Lista de Adjacência X Forward Star
Na comparação entre Lista de Adjacência e Forward Star para representação de grafos, o Forward Star se destaca pela eficiência, ocupando menos espaço e apresentando tempos mais rápidos de criação e consulta, como os testes de tempo realizado no código. No entanto, apesar dessas vantagens, ele possui desvantagens como fazer alterações no grafo é complexo, muitas vezes sendo mais prático refazer o grafo do que modificá-lo.

## Instalação

1 - Faça o clone do repositorio
```sh
git clone https://github.com/Thi23gm/Grafos_Trabalho_1.git
```

2- Navegue até a pasta do projeto e compile o arquivo principal:

```sh
cd Grafos_Trabalho_1
javac Main.java
```
3- Execute a aplicação:
```
java Main
```
4- O programa irá solicitar o caminho do arquivo de criação do grafo. Você pode inserir qualquer caminho de arquivo. Se quiser usar os exemplos fornecidos pelo projeto, eles estão disponíveis nos seguintes caminhos:

- Para o grafo de teste com 100 vértices: " Tests/graph-test-100txt "
- Para o grafo de teste com 5000 vértices: " Tests/graph-test-5000.txt "
