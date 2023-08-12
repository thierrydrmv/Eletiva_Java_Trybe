package ListaPoo;

public class PessoaFuncionaria {
    private String nomeCompleto;
    private String cpf;
    private String endereco;
    private double salario;

    public PessoaFuncionaria(String nome, String CPF, String Endereco, double Salario) {
        this.nomeCompleto = nome;
        this.cpf = CPF;
        this.endereco = Endereco;
        this.salario = Salario;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

}
