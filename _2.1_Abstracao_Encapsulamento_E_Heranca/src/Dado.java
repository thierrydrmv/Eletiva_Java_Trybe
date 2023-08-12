public class Dado {
    private int quantidadeDeLados;

    public Dado(int quantidadeDeLados) {
        this.quantidadeDeLados = quantidadeDeLados;
    }

    public int rolagem() {
        return 1 + (int) (Math.random() * quantidadeDeLados);
    }
}
