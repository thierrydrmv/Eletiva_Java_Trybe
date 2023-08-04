import java.util.Scanner;

class UsandoScanner {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    System.out.print("Qual o seu nome: ");
    String nome = scanner.next();
    System.out.println("Qual sua idade? ");
    String numero = scanner.next();
    // convertendo o input em short (short vai até 32767)
    short idade = Short.parseShort(numero);
    idade++;
    System.out.println("Boas-vindas, " + nome + "!" + " Você fará " + idade + " ano que vem!");
    System.out.print("Entre com o primeiro número: ");
    String input1 = scanner.next();
    System.out.print("Entre com o segundo número: ");
    String input2 = scanner.next();

    // convertendo o input para number
    int n1 = Integer.parseInt(input1);
    int n2 = Integer.parseInt(input2);

    int resultado = n1 + n2;
    System.out.println("O resultado da soma é: " + resultado);
    System.out.println("Qual é a população do Brasil: ");
    String inputPopulacao = scanner.next();
    long populacaoBrasil = Long.parseLong(inputPopulacao);
    // Como o java atribui diretamente o tipo int aos números é preciso deixar claro que é Long com o L
    long result = populacaoBrasil + 1L;
    System.out.println("A população do Brasil + 1 é : " + result);
    // float 7 casas decimais
    System.out.print("Entre com o preço do litro da gasolina: ");
    String in = scanner.next();
    // double 15 casas decimais
    float gasolina = Float.parseFloat(in);
//    float gasosaDouble = Double.parseDouble(in);
    float re = gasolina + gasolina;
    System.out.println("Ano que vem o litro da gasolina vai custar: " + re);

    scanner.close();

  }

}