package recursividad;

public class frm09 {

    // Función iterativa para verificar si una cadena es subcadena de otra
    public static boolean esSubcadenaIterativa(String cadena, String subcadena) {
        int longitudCadena = cadena.length();
        int longitudSubcadena = subcadena.length();

        // Si la subcadena es más larga que la cadena, no puede ser subcadena
        if (longitudSubcadena > longitudCadena) {
            return false;
        }

        // Recorremos la cadena para buscar la subcadena
        for (int i = 0; i <= longitudCadena - longitudSubcadena; i++) {
            boolean esSubcadena = true;

            // Verificamos si los caracteres coinciden
            for (int j = 0; j < longitudSubcadena; j++) {
                if (cadena.charAt(i + j) != subcadena.charAt(j)) {
                    esSubcadena = false;
                    break;
                }
            }

            // Si encontramos una coincidencia, retornamos true
            if (esSubcadena) {
                return true;
            }
        }
        return false; // Si no encontramos coincidencia
    }

    // Función recursiva para verificar si una cadena es subcadena de otra
    public static boolean esSubcadenaRecursiva(String cadena, String subcadena, int index) {
        int longitudCadena = cadena.length();
        int longitudSubcadena = subcadena.length();

        // Caso base: si hemos recorrido toda la cadena y no encontramos subcadena
        if (index > longitudCadena - longitudSubcadena) {
            return false;
        }

        // Verificamos si los caracteres coinciden en la posición actual
        for (int i = 0; i < longitudSubcadena; i++) {
            if (cadena.charAt(index + i) != subcadena.charAt(i)) {
                return esSubcadenaRecursiva(cadena, subcadena, index + 1); // Llamada recursiva con siguiente posición
            }
        }

        // Si encontramos coincidencia, retornamos true
        return true;
    }

    public static void main(String[] args) {
        String cadena = "Este es un ejemplo de subcadena";
        String subcadena = "ejemplo";

        // Verificación iterativa
        boolean resultadoIterativo = esSubcadenaIterativa(cadena, subcadena);
        System.out.println("¿Es subcadena (iterativo)? " + resultadoIterativo);

        // Verificación recursiva
        boolean resultadoRecursivo = esSubcadenaRecursiva(cadena, subcadena, 0);
        System.out.println("¿Es subcadena (recursivo)? " + resultadoRecursivo);
    }
}

