package recursividad;

public class frm06 {

    // Función recursiva para invertir una cadena de caracteres
    public static String invertir(String cadena) {
        // Caso base: si la cadena tiene 0 o 1 caracteres, ya está invertida
        if (cadena.length() <= 1) {
            return cadena;
        }
        // Caso recursivo: invertimos la subcadena desde el segundo carácter hasta el final
        // y concatenamos el primer carácter al final
        return invertir(cadena.substring(1)) + cadena.charAt(0);
    }

    public static void main(String[] args) {
        String cadena = "Hola"; // Cadena de ejemplo
        
        String resultado = invertir(cadena);
        System.out.println("La cadena invertida de \"" + cadena + "\" es: \"" + resultado + "\"");
    }
}

