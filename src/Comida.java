public class Comida {
    private String nome;
    private float preco;
    private int id;

    public Comida(String nome, float preco, int id) {
        this.nome = nome;
        this.preco = preco;
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return this.preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

}
