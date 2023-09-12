public class Cozinheiro extends Pessoa implements Funcionario {
    private int pratosPreparados;
    private String cargo;
    private float salario;
    private String nome;
    private int idade;

    public Cozinheiro(int pratosPreparados, String cargo, float salario, String nome, int idade) {
        this.pratosPreparados = pratosPreparados;
        this.cargo = cargo;
        this.salario = salario;
        this.nome = nome;
        this.idade = idade;
    }

    public Cozinheiro() {

    }

    public int getPratosPreparados() {
        return this.pratosPreparados;
    }

    public void setPratosPreparados(int pratosPreparados) {
        this.pratosPreparados = pratosPreparados;
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

    public void cozinhar(Comida comida) {
        System.out.println("O cozinheiro " + getNome() + " está preparando seu pedido: " + comida.getNome());
        pratosPreparados += 1;
    }
}

