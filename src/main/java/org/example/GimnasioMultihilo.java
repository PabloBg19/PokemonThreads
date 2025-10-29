package org.example;

/**
 * GimnasioMultihilo.java
 * Este es el "gimnasio" donde probamos ambos métodos.
 */
public class GimnasioMultihilo {

    public static void main(String[] args) {
        
        System.out.println("--- MÉTODO 1: Herencia (extends Thread) ---");
        
        // TODO 3: Crea un PikachuCorredor "Pika-Runner".
        PikachuCorredor pikaCorredor = new PikachuCorredor("Pika-Runner");
        
        
        // TODO 4: ¡Inicia a Pikachu!
        // Como Pikachu "ES UN" Thread, él mismo tiene el método .start()
        System.out.println("Entrenador: ¡Pika-Runner, empieza!");

         pikaCorredor.start(); // <-- Completa esta línea
//cambio

        System.out.println("\n--- MÉTODO 2: Interfaz (implements Runnable) ---");

        // TODO 5: Crea la "tarea" de Charizard: "Charly-Volador"
        // charlyMision "NO ES UN" Thread. Es solo una TAREA (Runnable).
        CharizardVolador charlyMision = new CharizardVolador("Charly-Volador");

        

        // TODO 6: ¡Necesitamos un "Thread" (un trabajador) para que ejecute la tarea!
        // Crea un nuevo Thread y pásale la misión de Charizard (charlyMision)
        // en su constructor.
         Thread entrenadorQueDirigeACharizard = new Thread(charlyMision); // <-- Completa esta línea

        // TODO 7: ¡Inicia el Thread "trabajador"!
        // Llama al método .start() del "entrenador" (el Thread que acabas de crear).
        System.out.println("Entrenador: ¡Charizard, te elijo para esta misión!");
         entrenadorQueDirigeACharizard.start(); // <-- Completa esta línea

        System.out.println("\n--- MÉTODO 3: Interfaz (Squirtle) ---");
        SquirtleNadador squirtleNadador = new SquirtleNadador("Squirtle-Nadador");
        Thread entrenadorQueDirigeASquirtle = new Thread(squirtleNadador);
        System.out.println("Entrenador: ¡Squirtle, a nadar!");
        entrenadorQueDirigeASquirtle.start();

        System.out.println("\n--- El entrenador espera a que terminen (El main sigue) ---");
    }
}