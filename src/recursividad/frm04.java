package recursividad;

public class frm04 {

    // Función recursiva para calcular la suma de un vector entre las posiciones "desde" y "hasta"
    public static int sumaVector(int[] v, int desde, int hasta) {
        // Caso base: cuando "desde" es igual a "hasta", solo hay un elemento, que es v[desde]
        if (desde == hasta) {
            return v[desde];
        }
        // Caso recursivo: sumaVector(v, desde, hasta) = v[desde] + sumaVector(v, desde + 1, hasta)
        return v[desde] + sumaVector(v, desde + 1, hasta);
    }

    public static void main(String[] args) {
        int[] vector = {1, 2, 3, 4, 5, 6, 7, 8, 9}; // Vector de números enteros
        int desde = 0; // Índice inicial
        int hasta = 8; // Índice final
        
        int resultado = sumaVector(vector, desde, hasta);
        System.out.println("La suma de los elementos del vector desde la posición " + desde + " hasta la " + hasta + " es: " + resultado);
    }
}

