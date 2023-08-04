
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class EsPortaria {

    /**
     * Método emitirRelatorio.
     */
    public static void emitirRelatorio(int qtdFundamental1, int qtdFundamental2, int qtdMedio) {
        int numPessoas = qtdFundamental1 + qtdFundamental2 + qtdMedio;
        DecimalFormat df = new DecimalFormat("#.##");

        double porcMedio = 0.0f;
        double porcFundamental1 = 0.0f;
        double porcFundamental2 = 0.0f;

        if (numPessoas > 0) {
            porcMedio = (double) 100.0f * qtdMedio / numPessoas;
            porcFundamental1 = (double) 100.0f * qtdFundamental1 / numPessoas;
            porcFundamental2 = (double) 100.0f * qtdFundamental2 / numPessoas;

        }

        porcMedio = Double.valueOf(df.format(porcMedio).replace(',', '.'));
        porcFundamental1 = Double.valueOf(df.format(porcFundamental1).replace(',', '.'));
        porcFundamental2 = Double.valueOf(df.format(porcFundamental2).replace(',', '.'));

        System.out.println("----- Quantidade -----");
        System.out.println("Ensino Fundamental I: " + qtdFundamental1);
        System.out.println("Ensino Fundamental II: " + qtdFundamental2);
        System.out.println("Ensino Médio: " + qtdMedio);
        System.out.println("");
        System.out.println("----- Percentual -----");
        System.out.println("Ensino Fundamental I: " + porcFundamental1 + "%");
        System.out.println("Ensino Fundamental II: " + porcFundamental2 + "%");
        System.out.println("Ensino Médio: " + porcMedio + "%");
        System.out.println("");
        System.out.println("TOTAL: " + numPessoas);
    }

    /**
     * Método coletarInformacoes.
     */
    public static void coletarInformacoes() {
        short controle = 0;
        ArrayList<Integer> idades = new ArrayList<Integer>();
        Scanner scanControle = new Scanner(System.in);

        int qtdFundamental1 = 0;
        int qtdFundamental2 = 0;
        int qtdMedio = 0;

        do {
            System.out.println("Entre com o número correspondente à opção desejada:");
            System.out.println("1 - Registrar o acesso de pessoa estudante");
            System.out.println("2 - Finalizar o acesso e emitir o relatório");

            controle = scanControle.nextShort();

            if (controle == 1) {
                System.out.println("Informe a idade da pessoa estudante:");
                int idade = scanControle.nextInt();
                idades.add(idade);
                if (idade >= 15) {
                    System.out.println("Pessoa estudante do Ensino Médio, catraca liberada!");
                    qtdMedio++;
                } else if (idade >= 11) {
                    System.out.println("Pessoa estudante do Ensino Fundamental II, catraca liberada!");
                    qtdFundamental2++;
                } else {
                    System.out.println("Pessoa estudante do Ensino Fundamental I, catraca liberada!");
                    qtdFundamental1++;
                }
            } else if (controle != 2) {
                System.out.println("Entre com uma opção válida!");
            }
        } while (controle != 2);

        emitirRelatorio(qtdFundamental1, qtdFundamental2, qtdMedio);

        scanControle.close();
    }
}
