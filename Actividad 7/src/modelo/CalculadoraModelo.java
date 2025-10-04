package modelo;

public class CalculadoraModelo {

    public double sumar(double a, double b) { return a + b; }

    public double restar(double a, double b) { return a - b; }

    public double multiplicar(double a, double b) { return a * b; }

    public double dividir(double a, double b) {
        if (b == 0) throw new ArithmeticException("División por cero no permitida");
        return a / b;
    }

    public double potencia(double a, double b) { return Math.pow(a, b); }

    public double raiz(double a, double b) {
        if (b == 0) throw new ArithmeticException("Índice de raíz no puede ser 0");
        return Math.pow(a, 1.0 / b);
    }
}
