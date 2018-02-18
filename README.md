# Reserva de carros

### Teste para vaga de programador Java - Lemaf

##### Ambiente de desenvolvimento 
- Sistema operacional Fedora 26;
- IDE Eclipse Oxygen;
- Java versão 1.8;
- JUnit versão 5.

#### Execução da aplicação

Para executar a aplicação salve o arquivo [Reserva_carro.jar](https://github.com/amandalima/Reserva_carro/blob/master/Reserva_carro.jar "Executável jar") em um diretório do seu computador e execute os seguintes comandos:

```sh
$ cd diretorio
$ java -jar Reserva_carro.jar
```
A aplicação irá executar em modo texto, aguardando a entrada do usuário

O formato de entrada aceito pela aplicação é:

```sh
<numeroPassageiros>:<data1>,<data2>,<data3>....
```

Por exemplo:
```sh
3:22/02/2018,23/02/2018,24/02/2018
```

### Observações

1- O enunciado do problema dizia: 
>A entrada para o programa será um intervalo de datas para um cliente regular e a
quantidade de passageiros desejada.

Porém a entrada de exemplo divergia desta informação. Adaptei a entrada para aceitar somente a quantidade de passageiros e o intervalo de datas.

2- Incluí dois modelos de carros em cada loja, a saída mostrará os dois modelos disponíveis. Caso o valor do aluguel no intervalo de datas seja igual para mais de uma loja, todas as lojas serão mostradas
