public class EscolaInteligenteApp {
    public static void main(String[] args) {
        System.out.println("Hi");
        EsPessoaEstudante thierry = new EsPessoaEstudante();
        thierry.coletarInformacoes();
        EsSecretaria media = new EsSecretaria();
        media.coletarInformacoes();
    }
}
