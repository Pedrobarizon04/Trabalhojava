import java.util.Scanner;

public class Restaurante {
    public static Cardapio cardapio = new Cardapio();
    public static Garcom garcom = new Garcom(0, 0, "Garçom", 1238.0f, "Dave", 18);
    public static Cozinheiro cozinheiro = new Cozinheiro(0, "Cozinheiro", 1956.46f, "Lucas", 17);
    public static Caixa caixa = new Caixa(0, "Caixa", 1616.24f, "Pedro", 18);
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Cliente cliente = new Cliente();

        int opcao;
        String nomeRestaurante = "Delícias do Ricardo";
        String nomeCliente;

        System.out.print("Olá, somos do Restaurante " + nomeRestaurante + ", qual é o seu nome? ");
        nomeCliente = scanner.nextLine();
        cliente.setNome(nomeCliente);

        System.out.println(cliente.getNome() + ", aqui está um menu de ações.");
        do {
            System.out.println("Menu");
            System.out.println("1 - Visualizar o cardápio.");
            System.out.println("2 - Fazer pedido.");
            System.out.println("3 - Visualizar a comanda.");
            System.out.println("4 - Comer.");
            System.out.println("5 - Pagar.");
            System.out.println("6 - Saldo");
            System.out.println("7 - Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch(opcao) {
                case 1:
                    cardapio.getCardapio();
                    break;
                case 2:
                    System.out.print(garcom.getNome() + ": O que você deseja, "+ cliente.getNome()+ "? ");
                    cliente.fazerPedido(cliente);
                    break;
                case 3:
                    cliente.getComanda();
                    break;
                case 4:
                    cliente.comer();
                    break;
                case 5:
                    cliente.pagar();
                    break;
                case 6:
                    cliente.getSaldo();
                    break;
                case 7:
                    if (!cliente.isFezPedido() || (cliente.isFezPagamento() && cliente.isFezPagamento())) {
                        System.out.println("Até logo!");
                        scanner.close();
                        return;
                    } 
                    else {
                        System.out.println("Você precisa pagar antes de sair!");
                        break;
                    }
                default:
                    System.out.println("Opção inválida.");
            }
        } while(true);
    }
}
