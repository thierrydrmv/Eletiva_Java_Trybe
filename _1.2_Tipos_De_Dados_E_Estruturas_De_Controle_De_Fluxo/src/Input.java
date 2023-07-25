import java.lang.reflect.Array;
import java.util.Scanner;

public class Input {

  public static int menu(Scanner scanner) {
    System.out.println("Selecione uma opção:");
    System.out.println("1 - Avaliar sua visita");
    System.out.println("2 - Verificar avaliações");
    System.out.println("3 - Sair");
    int scan = Integer.parseInt(scanner.nextLine());
    if (scan == 1)  {
      avalie(scanner);
    } else if (scan == 2) {
      data();
    }
    return scan;
  }

  public static void avalie(Scanner scanner) {
    System.out.println("Digite o seu nome: ");
    String nome = scanner.nextLine();
    System.out.println("Digite o nome do corretor que te atendeu: ");
    String corretor = scanner.nextLine();
    System.out.println("De uma nota de 0 a 10 ao imóvel: ");
    int nota = Integer.parseInt(scanner.nextLine());
    String data = nome + " " + corretor + " " + nota;
    System.out.println(data);
  }

  public static void data() {
    System.out.println("avaliacoes");
  }
}
