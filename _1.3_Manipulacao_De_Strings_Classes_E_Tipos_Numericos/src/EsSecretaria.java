import java.util.Scanner;

public class EsSecretaria {
    public void coletarInformacoes() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite seu nome: ");
        String nome = scanner.next();
        System.out.println("Digite sua primeira nota: ");
        String nota1 = scanner.next();
        float n1 = Float.parseFloat(nota1);
        System.out.println("Digite sua segunda nota: ");
        String nota2 = scanner.next();
        float n2 = Float.parseFloat(nota2);
        System.out.println("Digite sua terceira nota: ");
        String nota3 = scanner.next();
        float n3 = Float.parseFloat(nota3);
        System.out.println("Digite sua quarta nota: ");
        String nota4 = scanner.next();
        float n4 = Float.parseFloat(nota4);
        float result = calcularMedia(n1, n2, n3, n4);
        System.out.println(result);
        scanner.close();
    }

    public float calcularMedia(float n1, float n2, float n3, float n4) {
        float media = (n1 + n2 + n3 + n4) / 4;
        System.out.println(media);
        return media;
    }
}
