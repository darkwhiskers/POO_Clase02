package com.darkwhiskers.vehiculos;

public class Auto {

    // =========================================================
    // ATRIBUTOS
    // =========================================================
 
    private String modelo;
    private int puertas;
    private String chasis;
    private Motor motor;
 
    // =========================================================
    // CONSTRUCTORES
    // =========================================================
 
    // Constructor vacio:
    public Auto() { }

    /**
     * Crea un auto con todos sus datos, incluyendo su motor.
     *
     * @param modelo  Modelo del vehículo.
     * @param puertas Cantidad de puertas.
     * @param chasis  Número de chasis.
     * @param motor   Objeto {@link Motor} que equipa este auto.
     */
    public Auto(String modelo, int puertas, String chasis, Motor motor) {
        this.modelo  = modelo;
        this.puertas = puertas;
        this.chasis  = chasis;
        this.motor   = motor;   // el auto recibe un objeto Motor ya creado
    }
 
    // =========================================================
    // GETTERS Y SETTERS
    // =========================================================
 
    public String getModelo()  { return modelo; }
    public int getPuertas()    { return puertas; }
    public String getChasis()  { return chasis; }
    public Motor getMotor()    { return motor; }
    
    public void setModelo(String modelo)  { this.modelo = modelo; }
    public void setPuertas(int puertas)   { this.puertas = puertas; }
    public void setChasis(String chasis)  { this.chasis = chasis; }
    public void setMotor(Motor motor)     { this.motor = motor; }
 
    // =========================================================
    // MÉTODOS DE COMPORTAMIENTO
    // =========================================================
    
    public void arrancar() {
        System.out.println("Arrancando el " + modelo + "...");
        motor.encender(); // el auto le pide al motor que se encienda
    }
    
    public void detener() {
        System.out.println("Deteniendo el " + modelo + "...");
        motor.apagar();
    }
    
    public void acelerar() {
        if (motor.isEncendido()) {
            System.out.println(modelo + " está acelerando. ¡Vroooom!");
        } else {
            System.out.println("No se puede acelerar: el motor está apagado.");
        }
    }
    
    public void frenar() {
        System.out.println(modelo + " está frenando...");
    }
    
    public void estacionar(String lugar) {
        System.out.println(modelo + " estacionado en: " + lugar);
    }
 
    // =========================================================
    // MÉTODOS HEREDADOS DE Object
    // =========================================================
    
    @Override
    public String toString() {
        return "Auto [modelo=" + modelo
                + ", puertas=" + puertas
                + ", chasis=" + chasis
                + ", motor=" + motor + "]"; // llama a toString() de Motor
    }
}
