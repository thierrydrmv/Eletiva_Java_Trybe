package PolimorfismoSobrescrita;

public class Main {
    public static void main(String[] args) {
        Carro carro = new Carro();
        carro.abastecer();
        carro.acelerar();

        Moto moto = new Moto();
        moto.abastecer();
        moto.acelerar();
        System.out.println("---- Método que chama o método acelerar da classe pai e filha ----");
        moto.mostrar();
    }
}
