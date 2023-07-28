public class Aula {

  public static void main(String[] args) {
    String nomes = "Maria Magali, Magali da Silva, Magali Medeiros";
    String pessoa = "Laura";
    // replace
    nomes = nomes.replace("Magali", pessoa);

    System.out.println(nomes); // imprime: Maria Laura, Laura da Silva, Laura Medeiros
    // indexof
    System.out.println(pessoa.indexOf("u"));

    String casasTexto = "Grifinória;Sonseria;Corvinal;Lufa-Lufa";
    // split
    String casas[] = casasTexto.split(";");

    for (String casa : casas)
      System.out.println(casa);

    // Utilizando expressão regular - regex
    String casasTexto2 = "Grifinória123Sonseria456Corvinal789Lufa-Lufa";
    String casas2[] = casasTexto2.split("\\d+");

    for (String casa : casas2)
      System.out.println(casa);

    String frase = "caneta,lápis,lapiseira,caderno,borracha";
    String formatado[] = frase.split(",", 3);

    for (String novo_formato : formatado)
      System.out.println(novo_formato); // imprime ["caneta", "lápis", "lapiseira,caderno,borracha"]

    // toUpperCase
    System.out.println(casasTexto.toUpperCase());
  }

}
