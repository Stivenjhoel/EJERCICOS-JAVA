package recursividad;

public class frm08 {

    // Función recursiva que implementa el algoritmo de Euclides para calcular el MCD
    public static int mcdEuclides(int m, int n) {
        // Caso base: si el resto es 0, el MCD es el segundo número
        if (n == 0) {
            return m;
        }
        // Llamada recursiva con n y el resto de la división m/n
        return mcdEuclides(n, m % n);
    }

    public static void main(String[] args) {
        int m = 56; // Primer número
        int n = 98; // Segundo número

        int resultado = mcdEuclides(m, n);
        System.out.println("El máximo común divisor de " + m + " y " + n + " es: " + resultado);
    }
}

