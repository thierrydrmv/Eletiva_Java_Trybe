package PolimorfismoSobrescrita;

public class Moto extends Veiculo {
    public void acelerar() {
        System.out.println("Método acelerar da classe Moto");
    }

    public void mostrar() {
        super.acelerar();
        this.acelerar();
    }
}
