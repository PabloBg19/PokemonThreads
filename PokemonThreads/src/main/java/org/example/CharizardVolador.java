package org.example;

/**
 * CharizardVolador.java (Ejercicio de Interfaz - "TIENE UNA TAREA")
 *
 * MISIÓN: Hacer que Charizard "TENGA UNA TAREA" (Runnable).
 * Él no es un Hilo... él es una "misión" que un Hilo puede ejecutar.
 *
 * Ventaja: ¡Charizard es flexible! Aún podría heredar de "Pokemon"
 * (ej: class CharizardVolador extends Pokemon implements Runnable)
 */

// TODO 1: Haz que esta clase IMPLEMENTE la interfaz Runnable. //hecho
// (Pista: usa la palabra clave "implements")
public class CharizardVolador implements Runnable {

    private String nombre;

    public CharizardVolador(String nombre) {
        this.nombre = nombre;
    }

    // TODO 2: ¡Define la tarea de la Interfaz!
    // Como "firmaste el contrato" Runnable, Java te OBLIGA
    // a escribir el método run().
    
    // Escribe el método run() aquí...
    @Override //hecho
    public void run() {
        System.out.println( this.nombre + " empieza su misión de vuelo! (Método: implements Runnable)");
        
        try {
            // Simulamos que el vuelo toma 1 segundo
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("¡A Charizard le dio el viento!");
        }
        
        System.out.println( this.nombre + " terminó la misión!");
    }
}