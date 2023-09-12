public class Caixa extends pessoa implements Funcionario {
    private int totalVendas;
    private float caixaRestaurante;
    private String cargo;
    private float salario;
    private String nome;
    private int idade;

    public Caixa(int totalVendas, String cargo, float salario, String nome, int idade) {
        this.totalVendas = totalVendas;
        this.cargo = cargo;
        this.salario = salario;
        this.nome = nome;
        this.idade = idade;
    }

    public Caixa() {

    }

    public int getTotalVendas() {
        return this.totalVendas;
    }

    public void setTotalVendas(int totalVendas) {
        this.totalVendas = totalVendas;
    }

    public float getCaixaRestaurante() {
        return this.caixaRestaurante;
    }

    public void setCaixaRestaurante(float caixaRestaurante) {
        this.caixaRestaurante = caixaRestaurante;
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

    public void receberPagamento(Cliente cliente, float clienteGastos) {
        caixaRestaurante += clienteGastos;
        totalVendas += 1;
        System.out.println(cliente.getNome() + ", seu pagamento foi recebido com sucesso!");
        cliente.setFezPagamento(true);
    }
}

