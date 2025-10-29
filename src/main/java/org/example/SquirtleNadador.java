package org.example;

/**
 * SquirtleNadador.java (Ejercicio de Interfaz - "TIENE UNA TAREA")
 *
 * MISIÓN: Hacer que Squirtle "TENGA UNA TAREA" (Runnable).
 * Él no es un Hilo... él es una "misión" que un Hilo puede ejecutar.
 *
 * Ventaja: ¡Squirtle es flexible! Aún podría heredar de "Pokemon"
 * (ej: class SquirtleNadador extends Pokemon implements Runnable)
 */

public class SquirtleNadador implements Runnable {
    private String nombre;

    public SquirtleNadador(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public void run() { //clase run
            System.out.println( this.nombre + " empieza a nadar! (Método: implements Runnable)");

            try {  //simulacion de nado
                Thread.sleep(1000);
                System.out.println("Squirtle usa surf!");
            } catch (InterruptedException e) {
                throw new RuntimeException("Squirtle se cansó nadando!");
            }
            System.out.println( this.nombre + " terminó de nadar!");
        }


    }

