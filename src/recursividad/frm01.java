package recursividad;

public class frm01 {

    // Función recursiva que calcula a^b
    public static int potencia(int base, int exponente) {
        // Caso base: cualquier número elevado a 0 es 1
        if (exponente == 0) {
            return 1;
        }
        // Caso recursivo: base^exponente = base * base^(exponente-1)
        return base * potencia(base, exponente - 1);
    }

    public static void main(String[] args) {
        int base = 5;
        int exponente = 3;
        
        int resultado = potencia(base, exponente);
        System.out.println(base + " elevado a " + exponente + " es: " + resultado);
    }
}

