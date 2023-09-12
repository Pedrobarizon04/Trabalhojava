import java.util.ArrayList;
import java.util.List;

public class Cardapio {
    private List<Comida> listaDeComidas;

    public Cardapio() {
        listaDeComidas = new ArrayList<>();
        setCardapio();
    }

    private void setCardapio() {
        listaDeComidas.add(new Comida("Pizza", 70.0f, 1));
        listaDeComidas.add(new Comida("Cheeseburgur", 28.0f, 2));
        listaDeComidas.add(new Comida("Batata Frita", 10.0f, 3));
        listaDeComidas.add(new Comida ("Pastel", 8.0f, 4));
        listaDeComidas.add(new Comida ("Guaraná", 4.5f, 5));
        listaDeComidas.add(new Comida ("Água", 3.5f, 6));
    }

    public void getCardapio() {
        System.out.println("Cardápio:");
        for (Comida comida : listaDeComidas) {
            System.out.println(comida.getId() + " - " + comida.getNome() + " - " + comida.getPreco() + "$");
        }
    }

    public Comida getComidaPeloId (int id) {
        for (Comida comida : listaDeComidas) {
            if (comida.getId() == id) {
                return comida;
            }
        }
        return null;
    }
}
