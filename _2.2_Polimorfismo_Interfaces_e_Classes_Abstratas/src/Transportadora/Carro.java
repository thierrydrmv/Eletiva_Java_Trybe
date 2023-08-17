package Transportadora;

public class Carro extends Veiculo {

    public Carro(String placa, int anoFabricacao) {
        super(placa, anoFabricacao);
        this.setCombustivel("Flex");
    }

    @Override
    public void abastecer(String local, String motorista, double valor) {
        this.abastecimentos.add(String.format("Local: base, Motorista: %s, valor: R$ %.2f"
                , motorista, valor));
    }
}
