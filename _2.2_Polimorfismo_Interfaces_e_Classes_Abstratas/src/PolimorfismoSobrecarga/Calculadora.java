package PolimorfismoSobrecarga;

public class Calculadora {

    public int soma(int a, int b) {
        return a + b;
    }

    public int soma(int a, int b, int c) {
        return a + b + c;
    }
    public double soma(double a, double b) {
        return  a + b;
    }
}
