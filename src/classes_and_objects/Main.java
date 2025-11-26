package classes_and_objects;

/**
 * Clase Main
 *
 * Punto de entrada del programa.
 * Aquí:
 *   - creamos objetos de la clase Person
 *   - llamamos a sus métodos
 *   - mostramos por consola cómo cambia su estado
 *
 * Cómo ejecutar desde terminal:
 *   javac Person.java Main.java
 *   java Main
 *
 * (En el README tienes las instrucciones explicadas paso a paso).
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("=== EJEMPLO: CLASES Y OBJETOS ===\n");

        // 1. Creamos dos objetos (dos "Person" distintas)
        Person alice = new Person("Alice", 25);
        Person bob   = new Person("Bob", 30);

        // 2. Vemos su estado inicial
        System.out.println("Se han creado dos objetos Person:");
        System.out.println("alice -> " + alice);  // llama internamente a toString()
        System.out.println("bob   -> " + bob + "\n");

        // 3. Llamamos a un método de comportamiento
        System.out.println("Cada persona se presenta:");
        alice.introduce();
        bob.introduce();
        System.out.println();

        // 4. Modificamos el estado de uno de los objetos
        System.out.println("Alice cumple años:");
        alice.celebrateBirthday();
        System.out.println();

        // 5. Comprobamos el nuevo estado
        System.out.println("Estado después del cumpleaños:");
        System.out.println("alice -> " + alice);
        System.out.println("bob   -> " + bob + "\n");

        System.out.println("=== FIN DEL EJEMPLO ===");
    }
}


