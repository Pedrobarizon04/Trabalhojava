public class Garcom extends Pessoa implements Funcionario {
    private int mesasAtendidas;
    private float gorjeta;
    private String cargo;
    private float salario;
    private String nome;
    private int idade;

    public Garcom(int mesasAtendidas, float gorjeta, String cargo, float salario, String nome, int idade) {
        this.mesasAtendidas = mesasAtendidas;
        this.gorjeta = gorjeta;
        this.cargo = cargo;
        this.salario = salario;
        this.nome = nome;
        this.idade = idade;
    }

    public Garcom() {

    }

    public int getMesasAtendidas() {
        return this.mesasAtendidas;
    }

    public void setMesasAtendidas(int mesasAtendidas) {
        this.mesasAtendidas = mesasAtendidas;
    }

    public float getGorjeta() {
        return this.gorjeta;
    }

    public void setGorjeta(float gorjeta) {
        this.gorjeta = gorjeta;
    }

    public String getCargo() {
        return this.cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public float getSalario() {
        return this.salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void anotarPedido(int id, Cliente cliente) {
        Comida comidaPedido = Restaurante.cardapio.getComidaPeloId(id);
        if (comidaPedido != null) {
            System.out.println("Pedido anotado!");

            mesasAtendidas += 1;
            float precoComida = comidaPedido.getPreco();
            float totalGastosAtual = cliente.getTotalGastos();
            cliente.setTotalGastos(totalGastosAtual + precoComida);

            cliente.setComanda(comidaPedido);
            notificarCozinheiro(comidaPedido);
            cliente.setFezPedido(true);
        } else {
            System.out.println("Item não encontrado.");
        }
    }

    public void notificarCozinheiro(Comida comida) {
        Restaurante.cozinheiro.cozinhar(comida);
    }
}
