package recursividad;

public class frm10 {

    // Función recursiva que cuenta cuántas veces aparece la subcadena en la cadena como subsecuencia
    public static int contarSubsecuencias(String cadena, String subcadena, int i, int j) {
        // Caso base: si hemos recorrido toda la subcadena, hemos encontrado una coincidencia
        if (j == subcadena.length()) {
            return 1;
        }
        
        // Caso base: si hemos recorrido toda la cadena y no hemos encontrado la subcadena
        if (i == cadena.length()) {
            return 0;
        }

        // Si los caracteres coinciden, podemos elegir:
        // 1. Tomamos el carácter actual de la cadena y de la subcadena
        // 2. O no tomamos el carácter actual de la cadena
        int contar = 0;
        if (cadena.charAt(i) == subcadena.charAt(j)) {
            contar += contarSubsecuencias(cadena, subcadena, i + 1, j + 1);  // Tomar este carácter
        }
        // Continuamos buscando sin tomar el carácter actual de la cadena
        contar += contarSubsecuencias(cadena, subcadena, i + 1, j);

        return contar;
    }

    public static void main(String[] args) {
        String cadena1 = "Hhoola";
        String subcadena1 = "hola";
        int resultado1 = contarSubsecuencias(cadena1, subcadena1, 0, 0);
        System.out.println("La subcadena '" + subcadena1 + "' aparece " + resultado1 + " veces en '" + cadena1 + "'.");

        String cadena2 = "hobla";
        String subcadena2 = "hola";
        int resultado2 = contarSubsecuencias(cadena2, subcadena2, 0, 0);
        System.out.println("La subcadena '" + subcadena2 + "' aparece " + resultado2 + " veces en '" + cadena2 + "'.");

        String cadena3 = "ohla";
        String subcadena3 = "hola";
        int resultado3 = contarSubsecuencias(cadena3, subcadena3, 0, 0);
        System.out.println("La subcadena '" + subcadena3 + "' aparece " + resultado3 + " veces en '" + cadena3 + "'.");
    }
}

