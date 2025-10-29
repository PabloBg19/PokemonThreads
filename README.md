# PokemonThreads

#¿Cuál es la diferencia en cómo iniciamos PikachuCorredor vs CharizardVolador?
Este ejercicio demuestra **dos formas de ejecutar tareas en Java con hilos (threads)**:  
- una mediante **herencia** (`extends Thread`)  
- y otra mediante **implementación de interfaz** (`implements Runnable`).

---

## ⚡ PikachuCorredor — “ES UN” Hilo (`extends Thread`)

Pikachu **hereda** de la clase `Thread`, lo que significa que **él mismo es un hilo de ejecución**.

```java
PikachuCorredor pikachu = new PikachuCorredor("Pikachu");
pikachu.start(); // 🔥 inicia directamente el hilo
```

- ✅ Usa `.start()` porque es un hilo real.  
- 🧠 El método `run()` es sobrescrito para definir la tarea que ejecutará el hilo.  
- ⚠️ Desventaja: ya no puede heredar de otra clase (por ejemplo, `Pokemon`),  
  ya que en Java solo se puede heredar de **una clase**.

---

## 🔥 CharizardVolador — “TIENE UNA TAREA” (`implements Runnable`)

Charizard **no es un hilo**, sino **una tarea que un hilo puede ejecutar**.



```java
CharizardVolador charizard = new CharizardVolador("Charizard");
Thread hilo = new Thread(charizard);
hilo.start(); // 🚀 el hilo ejecuta la tarea de Charizard
```

- ✅ Implementa `Runnable`, lo que lo hace más flexible.  
- 🧠 Puede seguir heredando de otra clase (por ejemplo, `Pokemon`).  
- ⚙️ Se ejecuta dentro de un objeto `Thread`, que “adopta” su tarea.

---

## ⚔️ Comparación rápida

| Característica | PikachuCorredor (`extends Thread`) | CharizardVolador (`implements Runnable`) |
|-----------------|------------------------------------|-------------------------------------------|
| Tipo de relación | “ES UN” hilo | “TIENE UNA” tarea |
| Método de inicio | `pikachu.start()` | `new Thread(charizard).start()` |
| Herencia adicional | ❌ No puede heredar otra clase | ✅ Puede heredar otra clase |
| Flexibilidad | Menor | Mayor |
| Uso común | Casos simples o demostrativos | Casos reales de ejecución en paralelo |

---

## 💬 Ejemplo de salida esperada

```
Pikachu empieza a correr! (Método: extends Thread)
Charizard empieza su misión de vuelo! (Método: implements Runnable)
Pikachu terminó la carrera!
Charizard terminó la misión!
```
#Si PikachuCorredor quisiera heredar también de Pokemon, ¿sería posible? ¿Por qué?

En Java, **una clase solo puede heredar de una clase a la vez**.  
Esto se debe a que **Java no permite herencia múltiple de clases**, para evitar conflictos de ambigüedad en los métodos o atributos que podrían venir de múltiples padres.

```java
// ❌ Esto NO es posible en Java:
public class PikachuCorredor extends Thread, Pokemon {
    // Error de compilación
}
```

El compilador marcaría un error porque `Thread` **ya es una clase**,  
y Java no permite que una clase herede de más de una.

---

## ✅ Alternativa correcta

Si quisieras que **Pikachu tenga las habilidades de Pokemon** y **también se ejecute en un hilo**, podrías hacerlo **implementando la interfaz Runnable** en lugar de heredar de Thread.

```java
public class PikachuCorredor extends Pokemon implements Runnable {

    @Override
    public void run() {
        System.out.println("Pikachu corre usando Runnable!");
    }
}

// Luego puedes ejecutarlo así:
PikachuCorredor pikachu = new PikachuCorredor();
Thread hilo = new Thread(pikachu);
hilo.start();
```

✅ De esta forma:
- Pikachu **sigue siendo un Pokemon** (hereda de `Pokemon`).
- Y **también puede ejecutar tareas en un hilo** (gracias a `Runnable`).

---

## 💡 En resumen

| Concepto | Explicación |
|-----------|-------------|
| Herencia múltiple de clases | ❌ No permitida en Java |
| Herencia de una clase + interfaz | ✅ Sí permitida |
| Solución para Pikachu | Heredar de `Pokemon` e implementar `Runnable` |
| Ventaja | Flexibilidad y mantenimiento limpio del código |

#¿Y CharizardVolador podría heredar de Pokemon además de implementar Runnable?

En Java, **una clase puede heredar de UNA sola clase** (por ejemplo, `Pokemon`),  
**pero puede implementar múltiples interfaces** (como `Runnable`, `Serializable`, etc.).

Por eso, esta definición es perfectamente válida:

```java
public class CharizardVolador extends Pokemon implements Runnable {
    
    @Override
    public void run() {
        System.out.println("Charizard está volando en su misión!");
    }
}
```

---

## 🧠 ¿Por qué esto sí se puede?

- `extends Pokemon` → Charizard **hereda** los atributos y métodos de `Pokemon`.  
- `implements Runnable` → Charizard **firma un contrato** para definir una tarea ejecutable (`run()`),  
  sin necesidad de heredar de `Thread`.

💡 En otras palabras:
> Charizard **ES UN** Pokémon y **TIENE UNA TAREA** que puede ejecutar un hilo.

---

## ⚙️ Ejecución del hilo

```java
CharizardVolador charizard = new CharizardVolador("Charizard");
Thread hilo = new Thread(charizard);
hilo.start(); // 🚀 El hilo ejecuta la tarea del Charizard
```

---

## ✅ Ventajas de esta combinación

| Ventaja | Descripción |
|----------|-------------|
| ✔ Herencia útil | Charizard mantiene todo lo de `Pokemon` |
| ✔ Flexibilidad | Puede ejecutar tareas sin perder su herencia |
| ✔ Reutilización | Puede implementar más interfaces si se necesita |
| ✔ Buen diseño | Sigue el principio de “una responsabilidad por clase” |

---

## ❌ Lo que no puede hacer

No podría hacer esto:

```java
public class CharizardVolador extends Pokemon, Thread {
    // 🚫 Error: Java no permite herencia múltiple de clases
}
```

Porque `Thread` y `Pokemon` **ambas son clases**, y Java solo permite **una herencia de clase**.


