package recursividad;

public class frm03 {

    // Función recursiva para calcular el n-ésimo número de Fibonacci
    public static int fibonacci(int n) {
        // Caso base: los dos primeros números de Fibonacci son 1
        if (n <= 1) {
            return 1;
        }
        // Caso recursivo: Fibonacci(n) = Fibonacci(n-1) + Fibonacci(n-2)
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int n = 6; // Número en la serie Fibonacci que queremos calcular
        
        int resultado = fibonacci(n);
        System.out.println("El número Fibonacci en la posición " + n + " es: " + resultado);
    }
}

