package com.darkwhiskers.calculos;

/**
 * Clase utilitaria de operaciones aritméticas.
 *
 * <p>Demuestra el uso de <b>atributos y métodos {@code static}</b>.</p>
 *
 * <p>Cuando un miembro es {@code static}:</p>
 * <ul>
 *   <li>Pertenece a la <b>clase</b>, no a los objetos.</li>
 *   <li>No depende de instancias: se accede directamente con
 *       {@code NombreClase.miembro}.</li>
 *   <li>Existe aunque no se haya creado ningún objeto.</li>
 *   <li>Hay una <b>única copia</b> compartida por todos los objetos.</li>
 * </ul>
 *
 * <p>Casos de uso típicos de {@code static}:</p>
 * <ul>
 *   <li>Contadores globales compartidos.</li>
 *   <li>Métodos utilitarios que no necesitan estado de objeto
 *       (ej: {@link Math#sqrt(double)}).</li>
 *   <li>Constantes de clase ({@code static final}).</li>
 * </ul>
 *
 * @author  Miguel Silva C.
 * @version 1.0
 * @since   2025
*/

public class Aritmetica {

     
    // =========================================================
    // ATRIBUTOS ESTÁTICOS
    // =========================================================
    
    public static int cantidad;
    public static final double PI = 3.1416;
 
    // =========================================================
    // MÉTODOS ESTÁTICOS
    // =========================================================

    public static int sumar(int a, int b) {
        cantidad++; // incrementa el contador estático
        return a + b;
    }

    public static int restar(int a, int b) {
        cantidad++;
        return a - b;
    }

    public static int multiplicar(int a, int b) {
        cantidad++;
        return a * b;
    }

    public static double dividir(double a, double b) {
        cantidad++;
        if (b == 0) {
            System.out.println("Error: división por cero.");
            return 0;
        }
        return a / b;
    }

    public static int obtenerYResetearContador() {
        int total = cantidad;
        cantidad = 0;
        return total;
    }
}
