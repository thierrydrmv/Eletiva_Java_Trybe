import java.util.Scanner;

public class EsPessoaEstudante {
    public void coletarInformacoes() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.println("Olá " + nome);
        System.out.println("Digite sua idade em anos: ");
        int anos = scanner.nextInt();
        System.out.println("O restante em meses ");
        int meses = scanner.nextInt();
        System.out.println("O restante em dias ");
        int dias = scanner.nextInt();
        calcularIdadeEmDias(anos, meses, dias);
        scanner.close();

    }

    public void calcularIdadeEmDias(int anos, int meses, int dias) {
        int idadeEmDias = anos * 365 + meses * 30 + dias;
        System.out.println("Você tem " + idadeEmDias + " dias de vida");
    }
}
