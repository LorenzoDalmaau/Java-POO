package classes_and_objects;


/**
 * Clase Person
 *
 *  Esta clase representa a una persona con:
 *  - nombre (name)
 *  - edad (age)
 *
 * Es un ejemplo sencillo para explicar:
 *  - qué es una clase
 *  - qué es un objeto
 *  - qué es un constructor
 *  - qué son los atributos y los métodos
 *
 * La explicación teórica completa está en el README de esta carpeta.
 */
public class Person {

    // Atributos (también llamados campos o propiedades)
    // Cada objeto Person tendrá su propio "name" y "age".
    private String name;
    private int age;

    /**
     * Constructor de la clase Person.
     *
     * Se utiliza con la palabra clave "new" para crear objetos:
     *   new Person("Alice", 25);
     *
     * @param name nombre de la persona
     * @param age  edad de la persona
     */
    public Person(String name, int age) {
        // "this.name" se refiere al atributo de la clase.
        // "name" (sin this) es el parámetro del constructor.
        this.name = name;
        this.age = age;
    }

    // Métodos "getter": permiten leer los valores de los atributos.
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    /**
     * Método de comportamiento.
     * El objeto "se presenta" usando sus propios datos.
     */
    public void introduce() {
        System.out.println("Hola, me llamo " + name + " y tengo " + age + " años.");
    }

    /**
     * Otro método de comportamiento.
     * Cambia el estado del objeto (incrementa la edad).
     */
    public void celebrateBirthday() {
        age++;
        System.out.println(name + " ahora tiene " + age + " años. ¡Feliz cumpleaños!");
    }

    /**
     * Representación en texto del objeto Person.
     *
     * La anotación @Override indica que estamos sobrescribiendo
     * el método toString() heredado de la clase Object. (Lo veremos en herencia)
     */
    @Override
    public String toString() {
        return "Person {name='" + name + "', age=" + age + "}";
    }
}


