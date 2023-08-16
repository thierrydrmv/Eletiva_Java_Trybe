package PolimorfismoSobrecarga;

public class Main {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        System.out.println("soma(int a, int b): " + calc.soma(3,6));
        System.out.println("soma(int a, int b, int c): " + calc.soma(3,6, 3));
        System.out.println("soma(double a, double b): " + calc.soma(1.2, 3.2));
    }
}
