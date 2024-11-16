package recursividad;

public class frm07 {

    // Función recursiva para verificar si una cadena es un palíndromo
    public static boolean esPalindromoRecursivo(String cadena, int inicio, int fin) {
        // Caso base: si la cadena tiene 0 o 1 caracteres, es un palíndromo
        if (inicio >= fin) {
            return true;
        }
        // Comprobamos si los caracteres en las posiciones "inicio" y "fin" son iguales
        if (cadena.charAt(inicio) != cadena.charAt(fin)) {
            return false;
        }
        // Llamada recursiva para comprobar el resto de la cadena
        return esPalindromoRecursivo(cadena, inicio + 1, fin - 1);
    }

    // Función iterativa para verificar si una cadena es un palíndromo
    public static boolean esPalindromoIterativo(String cadena) {
        int inicio = 0;
        int fin = cadena.length() - 1;
        
        while (inicio < fin) {
            // Comprobamos si los caracteres en las posiciones "inicio" y "fin" son iguales
            if (cadena.charAt(inicio) != cadena.charAt(fin)) {
                return false;
            }
            // Avanzamos hacia el centro de la cadena
            inicio++;
            fin--;
        }
        return true; // Si llegamos aquí, la cadena es un palíndromo
    }

    public static void main(String[] args) {
        String cadena = "DABALEARROZALAZORRAELABAD"; // Cadena de ejemplo

        // Verificación recursiva
        boolean resultadoRecursivo = esPalindromoRecursivo(cadena, 0, cadena.length() - 1);
        System.out.println("¿Es palíndromo (recursivo)? " + resultadoRecursivo);

        // Verificación iterativa
        boolean resultadoIterativo = esPalindromoIterativo(cadena);
        System.out.println("¿Es palíndromo (iterativo)? " + resultadoIterativo);
    }
}

