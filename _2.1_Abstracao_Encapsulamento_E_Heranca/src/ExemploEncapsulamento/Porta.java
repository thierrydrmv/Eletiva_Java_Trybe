package ExemploEncapsulamento;

public class Porta {
    private int tamanho;
    private String material;
    // o atributo estaAberta foi alterado para protected para que a classe PortaSegura ter acesso a este atributo
    protected boolean estaAberta;

    public Porta() {
        this.estaAberta = false;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public String getMaterial() {
        return this.material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void abrir() {
        if (estaAberta) {
            System.out.println("Porta já está aberta");
        } else {
            estaAberta = true;
            System.out.println("Porta foi aberta");
        }
    }

    public void fechar() {
        if (!estaAberta) {
            System.out.println("Porta já estava fechada");
        } else {
            estaAberta = false;
            System.out.println("Porta foi fechada");
        }
    }
}
