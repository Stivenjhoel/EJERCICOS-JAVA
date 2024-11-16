package recursividad;

public class frm05 {

    // Función recursiva para calcular el mayor de los elementos de un vector entre las posiciones "desde" y "hasta"
    public static int mayorElemento(int[] v, int desde, int hasta) {
        // Caso base: cuando "desde" es igual a "hasta", solo hay un elemento, que es v[desde]
        if (desde == hasta) {
            return v[desde];
        }
        // Caso recursivo: mayorElemento(v, desde, hasta) = máximo entre v[desde] y el mayor del resto del vector
        int maxResto = mayorElemento(v, desde + 1, hasta); // Calculamos el máximo del resto del vector
        return Math.max(v[desde], maxResto); // Comparamos el valor en v[desde] con el máximo del resto
    }

    public static void main(String[] args) {
        int[] vector = {3, 5, 1, 9, 2, 8, 7}; // Vector de números enteros
        int desde = 0; // Índice inicial
        int hasta = 6; // Índice final
        
        int resultado = mayorElemento(vector, desde, hasta);
        System.out.println("El mayor elemento del vector desde la posición " + desde + " hasta la " + hasta + " es: " + resultado);
    }
}

