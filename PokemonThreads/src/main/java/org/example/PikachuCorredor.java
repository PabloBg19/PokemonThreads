package org.example;

/**
 * PikachuCorredor.java (Ejercicio de Herencia - "ES UN")
 *
 * MISIÓN: Hacer que Pikachu "SEA UN" Hilo (Thread).
 * Él mismo es el corredor.
 *
 * Desventaja: Pikachu ya no puede heredar de la clase "Pokemon",
 * ¡porque Java solo permite heredar de UNA clase!
 * Ha "gastado" su herencia en ser un Thread.
 */

// TODO 1: Haz que esta clase HEREDE de la clase Thread. //hecho
// (Pista: usa la palabra clave "extends")
public class PikachuCorredor extends Thread {

    private String nombre;

    public PikachuCorredor(String nombre) {
        this.nombre = nombre;
    }

    // TODO 2: ¡Define la tarea del Hilo!
    // Debes "anular" (Override) el método run() de la clase Thread.
    // Esta es la "carrera" que Pikachu correrá cuando le digan .start()
    
    // Escribe el método run() aquí...
    @Override
    public void run() {
        System.out.println( this.nombre + " empieza a correr! (Método: extends Thread)");
        
        try {
            // Simulamos que la carrera toma 1 segundo
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("¡Pikachu se tropezó!");
        }
        
        System.out.println(this.nombre + " terminó la carrera!");
    }
}