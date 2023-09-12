# Classes em Java - B3
Resolução do trabalho elaborado pelo professor Ricardo Petri <br/>
#

### -- Versão 2.0 -- <br/>
- A classe "Pessoa" agora é um classe abstrata;
- A classe "Funcionário" agora é uma interface, que faz parte das classes "Cozinheiro", "Garçom" e "Caixa";
- O sistema possui uma nova funcionalidade: Saldo. O cliente inicia com  500 reais e vai se subtraindo conforme o cliente paga a comanda. Caso o cliente não tenha saldo o suficiente para pagar a comanda, ele é convidado a se retirar do restaurante. O usuário também pode conferir o seu saldo utilizando a tecla 6;

#

### -- Versão 1.0 --
## Execução do Código
- Quando o código é executado, o programa apresenta o nome do restaurante e pede o nome do usuário (cliente); <br/>
- O programa então envia um menu de opções ao cliente, sendo elas: <br/>
1 - Visualizar o cardápio; <br/>
2 - Fazer pedido; <br/>
3 - Visualizar a comanda; <br/>
4 - Comer; <br/>
5 - Pagar; <br/>
6 - Sair. <br/>

- Ao selecionar a opção 1, o programa envia o cardápio; <br/>
1 - Pizza - 70.0$ <br/>
2 - Cheeseburgur - 28.0$ <br/>
3 - Batata Frita - 10.0$ <br/>
4 - Pastel - 8.0$ <br/>
5 - Guaraná - 4.5$ <br/>
6 - Água - 3.5$ <br/>

- Ao selecionar a opção 2, o programa pede o *id* do produto desejado, e quando o cliente envia, o programa retorna que o pedido está sendo preparado pelo cozinheiro; <br/>
- Ao selecionar a opção 3, o programa envia um recibo dos produtos que o cliente pediu juntamente com o extrato total do que o cliente consumiu; <br/>
- Ao selecionar a opção 4, o programa envia uma mensagem dizendo que o cliente está comendo. Caso o cliente ainda não tenha efetuado o pedido, o programa retorna uma mensagem alertando que você deve fazer o pedido primeiro, e envia o cardápio para escolher o produto desejado; <br/>
- Ao selecionar a opção 5, o programa envia uma mensagem que o pagamento foi efetuado com sucesso, juntamente com o saldo do cliente. Caso o cliente não tenha feito o pedido, o programa retorna uma mensagem alertando que você deve antes fazer o pedido, e envia o cardápio para escolher o produto desejado; <br/>
- Ao selecionar a opção 6, o programa envia uma mensagem dizendo "até logo!", e encerra o programa. <br/>

## Funcionamento do código
- ### Classe "Restaurante" <br/>
  Classe mãe do código, possui os atributos estáticos: 'Cardapio', 'Garcom', 'Cozinheiro' e 'Caixa'. Solicita o nome do cliente, e armazena na instância 'cliente'. Executa o menu para o usuário usando do-while.  <br/>
- ### Classe "Garcom" <br/>
  Possui atributos de 'mesas atendidas' e 'gorjeta'. Possui um construtor para criar um objeto 'Garcom' na classe 'Funcionario', com atributos incluidos nele. Possui métodos get e set para modificar atributos privados da classe, como gorjetas e mesas atendidas. Possui o método 'anotar pedido', responsável por anotar um pedido feito pelo cliente. Ele verifica se o item solicitado está no cardápio (Restaurante.cardapio) e, se estiver, realiza várias ações, como atualizar o número de mesas atendidas pelo garçom, adicionar o valor da comida aos gastos totais do cliente e notificar o cozinheiro sobre o pedido. Possui também o método 'notificar cozinheiro, que chama o método 'cozinhar' do objeto 'cozinheiro' da classe 'Restaurante'.
- ### Classe "Pessoa" <br/>
  Classe base para as classes 'Funcionario' e 'Cliente'. Possui atributos de nome e idade. Possui construtor usado para criar um objeto Pessoa com valores específicos para nome e idade. Possui métodos get e set para acessar e modificar os atributos privados referentes à classe. Possui um método 'comer' que imprime uma mensagem indicando que o cliente está comendo, usando o nome obtido no método 'getNome'.
- ### Classe "Funcionario" <br/>
  Subclasse da classe 'Pessoa'. Possui atributos de salário e cargo. Possui um construtor usado para criar um objeto Funcionario com valores específicos para cada atributo, incluindo os atributos herdados da classe Pessoa. Possui métodos get e set acessar e modificar os valores dos atributos 'cargo' e 'salario'.
- ### Classe "Cliente" <br/>
  Subclasse da classe 'Pessoa'. Possui atributos referentes ao dinheiro disponível do cliente, o total de gastos do cliente, uma lista de comidas na comanda, e as informações se o cliente fez um pedido e se fez o pagamento. Possui um construtor usado para criar um objeto Cliente com valores específicos de nome e idade, dinheiro, total de gastos e comanda. Possui métodos get e set para 'dinheiro', 'totalGastos', 'fezPedido' e 'fezPagamento'. Possui método 'fazerPedido', que lê a entrada do usuário para obter o ID do item desejado e chamar 'anotarPedido' do objeto 'garcom' para registrar o pedido. Possui métodos para a comanda, que permitem adicionar itens à comanda do cliente (setComanda) e exibir os itens na comanda juntamente com o total de gastos (getComanda). Possui também os métodos 'comer', para imprimir que o cliente está comendo e 'pagar' para prosseguir com o pagamento da conta.
- ### Classe "Caixa" <br/>
  Subclasse da classe 'Funcionario'. Possui atributos que representam o total de vendas e o valor atual no caixa do restaurante. Possui um construtor para setar os valores 'totalVendas', 'cargo', 'salario', 'nome' e 'idade'. Possui métodos get e set para 'TotalVendas' e 'CaixaRestaurante'. Possui um método 'receberPagamento', que recebe o pagamento do cliente, adicionando o valor dos gastos do cliente ao valor do caixa do restaurante, incrementando o total de vendas e informando ao cliente que o pagamento foi recebido com sucesso.
- ### Classe "Cozinheiro" <br/>
  Subclasse da classe 'Funcionario' Possui um atributo que representa o número de pratos preparados pelo cozinheiro. Possui um construtor usado para criar um objeto 'Cozinheiro' com valores cargo, salario, nome e idade. Possui métodos get e set para 'PratosPreparados'. Possui um método 'cozinhar' com uma instância de 'Comida' como parâmetro e tem o objetivo de exibir uma mensagem dizendo que o cozinheiro está cozinhando seu pedido.
- ### Classe "Cardapio" <br/>
  Classe que representa o cardápio do restaurante. Possui um atributo que armazena os objetos 'Comida' na 'ListaDeComidas'. Possui um construtor 'Cardapio' para armazenar a lista de comidas em um array. Possui um método 'setCardapio' que adiciona as opções de comida ao cardápio, com nome preço e ID. Possui um método 'getCardapio', que exibe o cardápio com os nomes, preços e ID. Possui também um método 'getComidaPeloId' que serve para obter uma instância de 'Comida' por um ID fornecido, caso não encontre o ID pela lista, ele retorna nulo.
- ### Classe "Comida" <br/>
  Classe que representa um elemento em 'Cardapio'. Possui atributos que representam o nome da comida e o ID. Possui um construtor para criar o objeto 'Comida' com valores de nome, preço e ID. Possui métodos get e set representando cada item do cardápio, que possui nome, preco e ID exclusivos.
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
*Código operado por Lucas Abdo, Davi Giovani e Pedro Barizon*
