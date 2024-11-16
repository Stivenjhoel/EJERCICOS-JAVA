package repetitivos;

public class frm10 {

    // Método para verificar la condición de la suma de las cifras pares e impares
    public static boolean verificarCondicion(int numero) {
        int sumaPares = 0;
        int sumaImpares = 0;

        // Extraer cada cifra del número
        for (int i = 0; i < 4; i++) {
            int cifra = numero % 10;  // Obtener la última cifra
            numero /= 10;  // Eliminar la última cifra del número

            // Verificar si la posición es par o impar
            if (i % 2 == 0) {
                sumaPares += cifra;  // Suma de cifras en posiciones pares (0, 2)
            } else {
                sumaImpares += cifra;  // Suma de cifras en posiciones impares (1, 3)
            }
        }

        // Verificar si la suma de cifras pares es igual a la suma de cifras impares
        return sumaPares == sumaImpares;
    }

    public static void main(String[] args) {
        int contador = 0;

        // Recorrer todos los números de 1000 a 9999 (4 cifras)
        for (int numero = 1000; numero <= 9999; numero++) {
            // Verificar si cumple la condición
            if (verificarCondicion(numero)) {
                System.out.println(numero);  // Mostrar el número que cumple la condición
                contador++;  // Contar cuántos números cumplen la condición
            }
        }

        // Mostrar la cantidad de números encontrados
        System.out.println("Cantidad de números encontrados: " + contador);
    }
}

