import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {

    private float saldoInicial = 500.0f;
    private float dinheiro;
    private float totalGastos;
    private List<Comida> comanda;
    private boolean fezPedido = false;
    private boolean fezPagamento = false;

    public Cliente(float dinheiro, float totalGastos, String nome, int idade) {
        super(nome, idade);
        this.dinheiro = dinheiro;
        this.totalGastos = totalGastos;
        comanda = new ArrayList<>();
    }

    public Cliente() {
        super();
        comanda = new ArrayList<>();
        this.dinheiro = saldoInicial;
    }

    public float getDinheiro() {
        return this.dinheiro;
    }

    public void setDinheiro(float dinheiro) {
        this.dinheiro = dinheiro;
    }

    public float getTotalGastos() {
        return this.totalGastos;
    }

    public void setTotalGastos(float totalGastos) {
        this.totalGastos = totalGastos;
    }

    public boolean isFezPedido() {
        return this.fezPedido;
    }

    public void setFezPedido(boolean fezPedido) {
        this.fezPedido = fezPedido;
    }

    public boolean isFezPagamento() {
        return this.fezPagamento;
    }

    public void setFezPagamento(boolean fezPagamento) {
        this.fezPagamento = fezPagamento;
    }


    public void fazerPedido(Cliente cliente) {
        Scanner scanner = new Scanner(System.in);
        int id;

        id = scanner.nextInt();

        Comida comidaPedido = Restaurante.cardapio.getComidaPeloId(id);
        if (comidaPedido != null) {
            float precoComida = comidaPedido.getPreco();
            if (dinheiro >= precoComida) {
                Restaurante.garcom.anotarPedido(id, cliente);
                dinheiro -= precoComida;
            } else {
                System.out.println("Desculpe, você não tem dinheiro suficiente para fazer este pedido.");
            }
        } else {
            System.out.println("Item não encontrado.");
        }
    }


    public void setComanda(Comida comida) {
        comanda.add(comida);
    }

    public void getComanda() {
        System.out.println("Comanda:");
        for (Comida comida : comanda) {
            System.out.println(comida.getNome() + " - " + comida.getPreco() + "$");
        }
        System.out.println("Total - " + getTotalGastos());
    }

    public void getSaldo() {
        System.out.println("Seu saldo atual: " + dinheiro);
    }

    @Override
    public void comer() {
        if (fezPedido) {
            System.out.println(getNome() + " está comendo...");
        } else {
            System.out.println(getNome() + ", você precisa fazer um pedido antes de comer!");
            Restaurante.cardapio.getCardapio();
        }
    }

    public void pagar() {
        if (fezPedido) {
            if (dinheiro >= totalGastos) {
                Restaurante.caixa.receberPagamento(this, this.totalGastos);
                dinheiro -= totalGastos;
                System.out.println("Seu saldo atual: " + dinheiro);

                comanda.clear();
                fezPedido = false;
                fezPagamento = false;
                totalGastos = 0.0f;
            } else {
                System.out.println("Desculpe, você não tem dinheiro suficiente para pagar a comanda.");
                System.out.println("Você não pode pagar e será convidado a sair. Um processo será aberto contra você.");
                encerrarSessao();
            }
        } else {
            System.out.println(getNome() + ", você ainda não fez nenhum pedido!");
            Restaurante.cardapio.getCardapio();
        }
    }

    public void encerrarSessao() {
        System.out.println("Obrigado por visitar delícias do Ricardo.");
        System.exit(0);
    }
}
