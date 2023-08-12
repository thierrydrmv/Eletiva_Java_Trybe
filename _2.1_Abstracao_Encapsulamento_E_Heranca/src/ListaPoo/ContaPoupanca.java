package ListaPoo;

public class ContaPoupanca {
    private double saldo;
    private String titularConta;
    public ContaPoupanca(double saldo, String titularConta) {
        this.saldo = saldo;
        this.titularConta = titularConta;
    }
    public void depositar(double valor) {
        this.saldo += valor;
    }

    public void sacar(double valor) {
        this.saldo -= valor;
    }

    public double mostrarSaldo() {
        return saldo;
    }

    public String mostrarTitularConta() {
        return titularConta;
    }
}
