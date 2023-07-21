import java.util.Arrays;
import java.util.List;
public class App {
  public static void main(String[] args) {
    List<String> frutas = Arrays.asList("abacaxi", "manga", "uva", "caqui");
    String palavrasComMaisVogais = MaiorQuantidadeVogais.palavraComMaiorQuantidadeVogais(frutas);
    System.out.println("A palavra com mais vogais é: " + palavrasComMaisVogais);
  }
}
