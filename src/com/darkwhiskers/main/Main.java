package com.darkwhiskers.main;

import com.darkwhiskers.animales.Gato;
import com.darkwhiskers.calculos.Aritmetica;
import com.darkwhiskers.vehiculos.Auto;
import com.darkwhiskers.vehiculos.Motor;
import java.io.PrintStream;

/**
 * @author  Mamba & Mike
 * @version 1.0
 * @since   2026
*/
public class Main {

    public static void main(String[] args) throws Exception {
        
        // Con este objeto podemos mosttrar los caracteres propios de ASCCI,
        // es decir, letras con tildes y caracteres especiales.
        System.setOut(new PrintStream(System.out, true, "UTF-8"));
        
        System.out.println("========== 1. OBJETOS DE LA CLASE GATO ==========");
 
        // Instanciación con constructor completo
        Gato mamba    = new Gato("Mamba",    "Negra",  11, "Miau");
        Gato siames   = new Gato("Siamés",   "Blanco",  3, "Meow");
 
        // Instanciación con constructor por defecto.
        Gato sinNombre = new Gato();
 
        // Instanciación con constructor parcial (sobrecarga).
        Gato gatito   = new Gato("Gatito", "Purr");
 
        // Cada objeto tiene su propia IDENTIDAD (son distintos aunque sean de la misma clase).
        System.out.println(mamba);      // llama a toString() automáticamente.
        System.out.println(siames);
        System.out.println(sinNombre);
        System.out.println(gatito);
 
        // ==========================================================
        // 2. COMPORTAMIENTOS (MÉTODOS)
        // ==========================================================
 
        System.out.println("\n========== 2. COMPORTAMIENTOS ==========");
 
        mamba.saludar();
        mamba.maullar();
        mamba.comer("atún");
        mamba.dormir(3);
        mamba.sentarseEnElTeclado();
 
        siames.saludar();
        siames.maullar();
 
        // ==========================================================
        // 3. GETTERS Y SETTERS (ENCAPSULAMIENTO)
        // ==========================================================
        /*
         * No se puede hacer: mamba.nombre = "Otro"  ← ERROR (private).
         * Sí se puede hacer: mamba.setNombre("Otro") ← acceso controlado.
         */
 
        System.out.println("\n========== 3. GETTERS Y SETTERS ==========");
 
        // Getter: obtener el valor de un atributo privado.
        System.out.println("Nombre  (getter): " + mamba.getNombre());
        System.out.println("Color   (getter): " + mamba.getColor());
        System.out.println("Edad    (getter): " + mamba.getEdad());
 
        // Setter: modificar el valor de un atributo privado.
        mamba.setNombre("Mambuchita");
        mamba.setColor("Negra brillante");
        mamba.setEdad(12);
        System.out.println("Después de setters: " + mamba);
 
        // Setter con validación: rechaza edad negativa.
        mamba.setEdad(-5); // imprimirá mensaje de error, no cambiará el valor.
        System.out.println("Edad después de intento inválido: " + mamba.getEdad());
 
        // ==========================================================
        // 4. MÉTODOS toString() Y equals()
        // ==========================================================
        /*
         * toString(): representación en texto del objeto.
         *   - Se llama automáticamente en System.out.println(objeto).
         *   - Sin sobrescribir: "animales.Gato@4a574795" (inútil).
         *   - Sobrescrito: "Gato [nombre=Mamba, color=Negra, ...]"
         *
         * equals(): comparación por CONTENIDO.
         *   - Sin sobrescribir funciona como == (compara referencias).
         *   - Sobrescrito: compara los atributos que definamos.
         */
 
        System.out.println("\n========== 4. toString() y equals() ==========");
 
        Gato gato1 = new Gato("Mamba", "Negra", 11, "Miau");
        Gato gato2 = new Gato("Mamba", "Gris",   5, "Mrrrr");
        Gato gato3 = new Gato("Siamés","Blanco",  3, "Meow");
 
        System.out.println("gato1.toString(): " + gato1);
        System.out.println("gato2.toString(): " + gato2);
 
        // equals() compara por nombre (definido en Gato.equals).
        System.out.println("gato1.equals(gato2): " + gato1.equals(gato2)); // true (mismo nombre)
        System.out.println("gato1.equals(gato3): " + gato1.equals(gato3)); // false
 
        // == compara referencias (si apuntan al mismo objeto en memoria)
        System.out.println("gato1 == gato2 (referencias): " + (gato1 == gato2)); // siempre false.
 
        // getClass() devuelve la clase real del objeto en tiempo de ejecución.
        System.out.println("Clase de gato1: " + gato1.getClass().getName());
 
        // ==========================================================
        // 5. COMPOSICIÓN: Auto contiene un Motor
        // ==========================================================
        /*
         * Un objeto puede contener otros objetos como atributos.
         * Esto se llama COMPOSICIÓN: "Auto TIENE UN Motor".
         *
         * Pasos:
         *   1. Crear el objeto que será contenido (Motor).
         *   2. Pasarlo al constructor del objeto contenedor (Auto).
         */
 
        System.out.println("\n========== 5. COMPOSICIÓN (Auto tiene un Motor) ==========");
 
        // Paso 1: crear el motor
        Motor motorFord = new Motor("Ford", 180);
 
        // Paso 2: crear el auto pasándole el motor
        Auto corolla = new Auto("Corolla", 4, "ABC-12345", motorFord);
 
        System.out.println(corolla); // toString() del Auto incluye toString() del Motor
 
        corolla.arrancar();   // el Auto delega en Motor.encender()
        corolla.acelerar();
        corolla.frenar();
        corolla.estacionar("Cochera principal");
        corolla.detener();    // el Auto delega en Motor.apagar()
 
        // También podemos acceder al motor directamente a través del getter
        System.out.println("Motor del corolla: " + corolla.getMotor());
 
        // ==========================================================
        // 6. USO DE STATIC
        // ==========================================================
        /*
         * Los miembros static pertenecen a la CLASE, no a los objetos.
         * Se accede directamente con: NombreClase.miembro
         *   Aritmetica.sumar(4, 5)   ← correcto
         *   Aritmetica.cantidad      ← atributo static
         *   Aritmetica.PI            ← constante static final
         *
         * No hace falta crear un objeto de Aritmetica.
         */
 
        System.out.println("\n========== 6. USO DE STATIC ==========");
 
        System.out.println("PI (constante static): " + Aritmetica.PI);
 
        // Cada llamada incrementa el contador static "cantidad"
        int suma    = Aritmetica.sumar(4, 5);
        int resta   = Aritmetica.restar(7, 3);
        int producto= Aritmetica.multiplicar(3, 6);
        double cociente = Aritmetica.dividir(10.0, 4.0);
 
        System.out.println("4 + 5  = " + suma);
        System.out.println("7 - 3  = " + resta);
        System.out.println("3 x 6  = " + producto);
        System.out.println("10 / 4 = " + cociente);
 
        // El contador es compartido por TODAS las llamadas (es de clase)
        System.out.println("Operaciones realizadas: " + Aritmetica.cantidad);
 
        // División por cero: la validación del setter la maneja
        Aritmetica.dividir(5.0, 0);
 
        System.out.println("\n========== FIN DEL PROGRAMA ==========");
        
    }

}
