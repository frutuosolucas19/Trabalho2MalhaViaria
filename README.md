# Trabalho 2 - Malha viária

Desenvolvimento de Sistemas Paralelos e Distribuídos
Dupla: Lucas de Liz Frutuoso   
       Matheus Henrique Maas


# Cenário

Especificação dos Veículos

a) Cada veículo deve ser um thread. ATENÇÃO: não utilizar ExecutorService para rodar asthreads.

b) O veículo se movimenta pela malha, uma posição por vez, respeitando o sentido defluxodapista. O veículo só pode se mover caso a posição à frente esteja livre.

c) Ao se deparar com um cruzamento: 

Deve escolher, aleatoriamente, uma das vias de saída do cruzamento paraseguirviagem. A escolha deve ser feita antes do veículo ingressar no cruzamento. 

d) Só deve se mover pelo cruzamento se todas as posições por onde vai passar estiveremtotalmente livres (exclusão mútua). 

e) Não deve bloquear o cruzamento de outros veículos (ficar parado no cruzamento).

f) Novos veículos são inseridos nos pontos de entrada da malha (ver especificação damalha)

g) Ao atingir um ponto de saída (ver especificação da malha), o veículo deve ser encerrado. h) Veículos possuem velocidades diferentes (tempo de sleep da thread a cada passo).

Especificação da Malha Viária

a) Deve ser carregada de um arquivo texto. 

b) Nas duas primeiras linhas estão a quantidade de linhas e colunas da malha, respectivamente.

c) As próximas linhas especificam o tipo de cada segmento (célula) da malha:

Valor (int) Tipo de segmento (movimentos permitidos)
0 Nada (célula não usada pela malha)
1 Estrada Cima
2 Estrada Direita
3 Estrada Baixo
4 Estrada Esquerda
5 Cruzamento Cima
6 Cruzamento Direita
7 Cruzamento Baixo
8 Cruzamento Esquerda
9 Cruzamento Cima e Direita
10 Cruzamento Cima e Esquerda
11 Cruzamento Direita e Baixo
12 Cruzamento Baixo e Esquerda

d) Características gerais das vias:

i) São sempre horizontais ou verticais (não haverá vias em diagonal).
ii) São de mão dupla, ou seja, possuem duas pistas.
iii) Nas bordas, só haverá vias perpendiculares.
iv) Entre vias paralelas, haverá sempre ao menos uma linha ou coluna embranco(ouseja,não haverá vias “grudadas” umas nas outras). 

e) Identificação de pontos de entrada e de saída de veículos:

i) Entrada: posição inicial da pista que está em uma das bordas da malha
ii) Saída: posição final da pista que está em uma das bordas da malha

# Diagrama de Classes

![diagramaDeClasse](https://user-images.githubusercontent.com/44911079/198379800-9456d9b5-809a-4c37-9fb6-6230395c5fe6.jpeg)



