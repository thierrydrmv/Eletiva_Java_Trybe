package Transportadora;

public class Main {
    public static void main(String[] args) {
        Carro c1 = new Carro(" ABC 1234", 2012);
        Caminhao c2 = new Caminhao(" ABC 1234", 2021);

        c1.abastecer(null, "Fabio", 250);
        c1.abastecer(null, "Maria", 250);

        c2.abastecer("Posto BR", "Fabiola", 320);
        c2.abastecer("Posto Shell", "Marcos", 350);

        c1.listaDeAbastecimentos();

        c2.listaDeAbastecimentos();
    }
}
