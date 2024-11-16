package recursividad;

public class frm02 {

    // Función iterativa que calcula a^b
    public static int potenciaIterativa(int base, int exponente) {
        int resultado = 1; // Inicializamos el resultado en 1
        
        // Ciclo for para multiplicar la base por sí misma 'exponente' veces
        for (int i = 1; i <= exponente; i++) {
            resultado *= base;
        }
        
        return resultado;
    }

    public static void main(String[] args) {
        int base = 5;
        int exponente = 3;
        
        int resultado = potenciaIterativa(base, exponente);
        System.out.println(base + " elevado a " + exponente + " es: " + resultado);
    }
}

