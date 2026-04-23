package com.darkwhiskers.vehiculos;

public class Motor {

    // =========================================================
    // ATRIBUTOS
    // =========================================================
 
    private String marca;
    private int potenciaHP;
    private boolean encendido;
 
    // =========================================================
    // CONSTRUCTORES
    // =========================================================

    // Constructor vacio:
    public Motor() { }
 
    /**
     * Crea un motor con la marca y potencia indicadas.
     * El motor se crea apagado por defecto.
     *
     * @param marca      Fabricante del motor.
     * @param potenciaHP Potencia en caballos de fuerza.
     */
    public Motor(String marca, int potenciaHP) {
        this.marca      = marca;
        this.potenciaHP = potenciaHP;
        this.encendido  = false; // comienza apagado.
    }
 
    // =========================================================
    // GETTERS Y SETTERS
    // =========================================================
 
    public String getMarca() { return marca; }
    public int getPotenciaHP() { return potenciaHP; }
    public boolean isEncendido() { return encendido; }
    
    public void setMarca(String marca) { this.marca = marca; }
    public void setPotenciaHP(int potenciaHP) {
        if (potenciaHP > 0) this.potenciaHP = potenciaHP;
    }
 
    // =========================================================
    // MÉTODOS DE COMPORTAMIENTO
    // =========================================================
 
    public void encender() {
        if (!encendido) {
            encendido = true;
            System.out.println("Motor " + marca + " encendido. ¡Vroom!");
        } else {
            System.out.println("El motor ya estaba encendido.");
        }
    }

    public void apagar() {
        if (encendido) {
            encendido = false;
            System.out.println("Motor " + marca + " apagado.");
        } else {
            System.out.println("El motor ya estaba apagado.");
        }
    }
 
    // =========================================================
    // MÉTODO HEREDADO DE Object
    // =========================================================

    @Override
    public String toString() {
        return "Motor [marca=" + marca
                + ", potencia=" + potenciaHP + " HP"
                + ", encendido=" + encendido + "]";
    }
 
}
