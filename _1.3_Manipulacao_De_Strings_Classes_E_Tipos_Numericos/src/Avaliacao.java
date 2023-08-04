public class Avaliacao {
    public void calcularIMC(double peso, double altura) {
      // Math.pow (numero, elevado a)
        double result = peso / Math.pow(altura, 2);
        System.out.println("Seu IMC é: " + result);
    }
}
