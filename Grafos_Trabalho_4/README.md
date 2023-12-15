## Instalação

1 - Faça o clone do repositorio
```sh
git clone https://github.com/Thi23gm/Grafos_Trabalho_4.git
```

2- Navegue até a pasta do projeto e compile o arquivo principal:

```sh
cd Grafos_Trabalho_4
javac DualMatrixTransportation.java
```
3- Execute a aplicação:
```
java DualMatrixTransportation
```
4- O programa irá solicitar o caminho do arquivo . Você pode inserir qualquer caminho de arquivo. Se quiser usar os exemplos fornecidos pelo projeto, eles estão disponíveis nos seguintes caminhos:

- Para o grafo de teste com 4 linhas e 5 colunas " Tests/input.txt ":
```sh
4 5
30
40
50
60
25
35
15
20
10
8 12 15 18 10
14 10 9 13 11
9 16 14 10 15
7 11 10 8 9
```
- Para o grafo de teste com 10 linhas e 10 colunas " Tests/input-2.txt ":
```sh
10 10
20
25
30
15
18
22
28
35
40
45
10
12
8
16
14
11
20
18
25
30
7 9 12 10 14 11 8 15 13 17
6 8 10 9 13 7 12 14 18 16
15 14 18 16 20 19 11 22 25 17
9 11 7 8 10 14 12 16 13 20
10 12 14 13 16 18 17 19 21 25
7 9 12 10 14 11 8 13 15 17
6 8 10 9 13 7 12 10 14 16
15 14 18 16 20 19 11 17 22 25
9 11 7 8 10 14 12 16 18 20
10 12 14 13 16 18 17 21 25 28
```

- Para o grafo de teste com 7 linhas e 5 colunas " Tests/input-1.txt ":
```sh
3 3
10
15
20
30
25
35
5 8 12
7 11 9
14 6 10
```

6- A saida será dada pela solução ótima com os Custos de Transporte (C), Variáveis Duais e o Custo Ótimo.