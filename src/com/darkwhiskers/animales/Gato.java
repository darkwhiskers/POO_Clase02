package com.darkwhiskers.animales;

/**
 * Representa un gato como objeto del mundo real.
 *
 * <p>
 * Esta clase demuestra los conceptos fundamentales de la POO:</p>
 * <ul>
 * <li><b>Atributos (estado):</b> nombre, color, edad, maullido.</li>
 * <li><b>Constructor:</b> inicializa el objeto al instanciarlo con
 * {@code new}.</li>
 * <li><b>Encapsulamiento:</b> todos los atributos son {@code private}.</li>
 * <li><b>Getters y Setters:</b> acceso controlado a los atributos
 * privados.</li>
 * <li><b>Métodos de comportamiento:</b> acciones que puede realizar el
 * objeto.</li>
 * <li><b>toString():</b> representación textual del objeto.</li>
 * <li><b>equals():</b> comparación por contenido, no por referencia.</li>
 * </ul>
 *
 * @author Miguel Silva C.
 * @version 1.0
 * @since 2025
*/
public class Gato {

    private String nombre;
    private String color;
    private int edad;
    private String maullido;

    /**
     * Constructor vacio.
     * Crea un objeto Gato con atributos sin definir.
     */
    public Gato() {
        this.nombre = "Sin nombre";
        this.color = "Sin definir";
        this.edad = 0;
        this.maullido = "Miau";
    }

    /**
     * Constructor con todos los parámetros. Crea un gato con los valores
     * provistos.
     *
     * @param nombre Nombre del gato.
     * @param color Color del pelaje.
     * @param edad Edad en años.
     * @param maullido Sonido que emite.
     */
    public Gato(String nombre, String color, int edad, String maullido) {
        this.nombre = nombre;
        this.color = color;
        this.edad = edad;
        this.maullido = maullido;
    }

    /**
     * Constructor parcial: nombre y maullido solamente. Ejemplo de
     * <b>sobrecarga de constructores</b>.
     *
     * @param nombre Nombre del gato.
     * @param maullido Sonido que emite.
     */
    public Gato(String nombre, String maullido) {
        this.nombre = nombre;
        this.maullido = maullido;
        this.color = "Sin definir";
        this.edad = 0;
    }

    // =========================================================
    // GETTERS Y SETTERS (métodos especiales de acceso)
    // =========================================================

    public String getNombre() { return nombre; }
    public String getColor() { return color; }
    public int getEdad() { return edad; }
    public String getMaullido() { return maullido; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setColor(String color) { this.color = color; }
    public void setEdad(int edad) {
        // Setter con validación: el setter puede rechazar valores inválidos
        if (edad >= 0) {
            this.edad = edad;
        } else {
            System.out.println("Error: la edad no puede ser negativa.");
        }
    }
    public void setMaullido(String maullido) { this.maullido = maullido; }

    // =========================================================
    // MÉTODOS DE COMPORTAMIENTO
    // =========================================================

    public void maullar() {
        System.out.println(nombre + " dice: " + maullido);
    }

    public void comer(String comida) {
        System.out.println(nombre + " está comiendo " + comida + ".");
    }

    public void sentarseEnElTeclado() {
        System.out.println(nombre + " se sentó en el teclado. ¡Trabajo interrumpido!");
    }

    public void dormir(int horas) {
        System.out.println(nombre + " está durmiendo " + horas + " hora(s)... Zzz");
    }

    public void saludar() {
        System.out.print("¡Hola! Soy " + nombre);
        System.out.println(" y tengo " + edad + " año(s) de edad.");
    }

    // =========================================================
    // MÉTODOS HEREDADOS DE Object (sobrescritos)
    // =========================================================

    @Override
    public String toString() {
        return "Gato [nombre=" + nombre
                + ", color=" + color
                + ", edad=" + edad
                + ", maullido=" + maullido + "]";
    }

    /**
     * Compara dos objetos {@code Gato} por su nombre.
     * @param obj Objeto a comparar.
     * @return {@code true} si ambos gatos tienen el mismo nombre.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Gato otro = (Gato) obj;
        return this.nombre.equals(otro.nombre);
    }

    /**
     * Devuelve el código hash del gato basado en su nombre.
     * @return código hash basado en el nombre.
     */
    @Override
    public int hashCode() {
        return nombre.hashCode();
    }

}

