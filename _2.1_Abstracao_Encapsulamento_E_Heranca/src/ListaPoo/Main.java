package ListaPoo;

public class Main {
    public static void main(String[] args) {
        PessoaFuncionaria Thierry = new PessoaFuncionaria("Thierry", "999999999-99", "Rua das flores", 8000);
        //Req 1
        System.out.println(Thierry.getCpf());
        System.out.println(Thierry.getSalario());
        Thierry.setSalario(20000);
        System.out.println(Thierry.getSalario());
        ContaPoupanca Bob = new ContaPoupanca(200, "Bob");
        Bob.sacar(20);
        Bob.depositar(30);
        System.out.println(Bob.mostrarSaldo());
        System.out.println(Bob.mostrarTitularConta());
        PessoaUsuaria Blob = new PessoaUsuaria("Bob", "Construtor");
        System.out.println(Blob.getPessoaUsuaria());
    }
}
