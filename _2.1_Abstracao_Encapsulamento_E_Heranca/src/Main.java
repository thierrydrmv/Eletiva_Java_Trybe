public class Main {
    public static void main(String[] args) {
        Livro livro = new Livro("Assim falava Zaratustra", 348, "12312312321");
        int numeroDePaginas = livro.retornarNumeroDePaginas();
        System.out.println(numeroDePaginas);
        Dado d20 = new Dado(20);
        System.out.println(d20.rolagem());
        Carro carro = new Carro("MC20", "Maserati", 2023);
        System.out.println(carro.getNome());
        Calculadora calc = new Calculadora();
        calc.setPrimeiroNumero(7);
        calc.setSegundoNumero(2);
        System.out.println(calc.multiplicar());
    }
}