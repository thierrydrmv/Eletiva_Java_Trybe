import java.util.Scanner;

public class Avaliation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual seu peso? ");
        String peso = scanner.next();
        System.out.println("Qual sua altura? ");
        String altura = scanner.next();
        double weight = Double.parseDouble(peso);
        double height = Double.parseDouble(altura);
        Avaliacao nova = new Avaliacao();
        nova.calcularIMC(weight, height);
        scanner.close();
        
    }
}
