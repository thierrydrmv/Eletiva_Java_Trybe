package ExemploEncapsulamento;

public class MainPorta {
    public static void main(String[] args) {
        PortaSegura porta = new PortaSegura("Iu");
        porta.trancar("Iu");
        porta.abrir();
        porta.trancar("oo");
    }
}
