public class Carro {
    private String nome;
    private String montadora;
    private int ano;

    public Carro(String nomeCarro, String montadoraCarro, int anoCarro) {
        this.nome = nomeCarro;
        this.montadora = montadoraCarro;
        this.ano = anoCarro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMontadora() {
        return montadora;
    }

    public void setMontadora(String montadora) {
        this.montadora = montadora;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
