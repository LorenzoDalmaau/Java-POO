# 01 – Clases y Objetos (Classes and Objects)

> Objetivo: que una persona junior entienda **de verdad** qué es una clase, qué es un objeto y cómo se relacionan con el código real que va a ver en proyectos Java y Spring Boot.

En esta carpeta tienes:

- `Person.java` → definición de una clase
- `Main.java` → creación y uso de objetos de esa clase
- Este `README.md` → explicación teórica y práctica

---

## 1. ¿Qué es una clase?

### Definición sencilla

Una **clase** es un modelo o plantilla que sirve para describir:

- **Qué datos** va a tener algo → sus atributos
- **Qué puede hacer** → sus métodos

No es “algo real” todavía, es solo la descripción.

### Definición un poco más técnica

En Java, una clase:

- Define **atributos** (también llamados campos o propiedades)
- Define **métodos** (funciones asociadas a la clase)
- Se usa como base para crear **objetos** con `new`

### Ejemplo con la clase `Person`

# 01 – Clases y Objetos (Classes and Objects)

> Objetivo: que una persona junior entienda **de verdad** qué es una clase, qué es un objeto y cómo se relacionan con el código real que va a ver en proyectos Java y Spring Boot.

En esta carpeta tienes:

- `Person.java` → definición de una clase
- `Main.java` → creación y uso de objetos de esa clase
- Este `README.md` → explicación teórica y práctica

---

## 1. ¿Qué es una clase?

Una **clase** es un modelo o plantilla que sirve para describir:

- **Qué datos** va a tener algo → sus atributos
- **Qué puede hacer** → sus métodos

No es “algo real” todavía, es solo la descripción.

### Definición un poco más técnica

En Java, una clase:

- Define **atributos** (también llamados campos o propiedades)
- Define **métodos** (funciones asociadas a la clase)
- Se usa como base para crear **objetos** con `new`

### Ejemplo con la clase `Person`

```java
public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void introduce() {
        System.out.println("Hola, me llamo " + name + " y tengo " + age + " años.");
    }

    public void celebrateBirthday() {
        age++;
    }
}
```

Aquí la clase `Person` dice:

- Cada persona tiene un name y un age

- Cada persona puede:

    - introduce() → presentarse

    - celebrateBirthday() → cumplir años (cambiar su edad)

### 2. ¿Qué es un objeto?

Un objeto es un ejemplo concreto de una clase.

La clase es la idea: “persona”

El objeto es uno específico: “Alice, 25 años”

#### **En código**

```java
Person alice = new Person("Alice", 25);
Person bob   = new Person("Bob", 30);
```

- `Person` → la clase

- `alice` y `bob` → dos objetos distintos

- Cada uno guarda sus propios datos:

    - alice.name = "Alice"

    - alice.age = 25

    - bob.name = "Bob"

    - bob.age = 30

Aunque se basan en la misma clase, **no comparten estado**.

### Partes importantes de una clase

Vamos a analizar `Person.java` por partes.

#### 3.1 Atributos (campos, propiedades)

```java
private String name;
private int age;
```
- Son **variables** que pertenecen a cada objeto.

- Guardan el **estado** del objeto.

- En este ejemplo, cada persona recuerda su propio `name` y `age`.

¿Por qué private?

- Porque no queremos que cualquiera cambie estos valores desde fuera.

- Más adelante, en “Encapsulación”, veremos esto en profundidad.

#### 3.2 Constructor

```java
public person(String name, int age) {
    this.name = name;
    this.age = age;
}
```
Un ``constructor`` es un método especial que:

Tiene el **mismo nombre** que la clase (`Person`)

No tiene tipo de retorno (`void` ni ningún otro)

Se usa junto con `new` para crear objetos:

```java
Person alice = new Person("Alice", 25);
```

¿Qué hace `this`?

- `this.name` → el atributo del objeto

- `name` (sin `this`) → el parámetro del constructor

Es decir: “pon en el atributo `name` del objeto el valor que llega en el parámetro `name`”.

### 3.3 Métodos de comportamiento
```java
public void introduce() {
    System.out.println("Hola, me llamo " + name + " y tengo " + age + " años.");
}

public void celebrateBirthday() {
    age++;
    System.out.println(name + " ahora tiene " + age + " años. ¡Feliz cumpleaños!");
}
```
Un **método**:

- Es una acción que puede realizar un objeto.

- Puede leer o modificar los atributos del objeto.

En este caso:

- introduce() → solo lee name y age y los muestra.

- celebrateBirthday() → modifica el estado del objeto (age++).

Esto es clave:

Cuando llamas a un método de un objeto, estás diciendo:
“_tú, objeto concreto, haz esto con tus propios datos_”.

### 3.4 Getters
```java
public String getName() { return name; }
public int getAge() { return age; }
```

Los **getters** son métodos que permiten leer los atributos, sin dar acceso directo a la variable.

En muchos proyectos Java (sobre todo con Spring y JPA):

- Las herramientas usan estos getters para convertir objetos a JSON, guardarlos en base de datos, etc.

### 3.5 `toString()` y `@Override`
```java
@Override
public String toString() {
    return "Person {name='" + name + "', age=" + age + "}";
}
```


- `toString()` es un método definido en la clase base `Object`.

- Sirve para obtener una representación en texto del objeto.

La anotación @Override indica:

- “Estoy sobrescribiendo un método que ya existe en la clase padre”.

- Si te equivocas en la firma del método, el compilador se queja → muy útil.

En Main.java hacemos:

```java
System.out.println(alice);
```

y gracias a `toString()` se imprime algo legible en vez de algo tipo `Person@5a07e868`.

### 4. Main.java paso a paso

En `Main.java` vemos como se usa la clase `Person`.

```java
public class Main {

    public static void main(String[] args) {

        System.out.println("=== EJEMPLO: CLASES Y OBJETOS ===\n");

        Person alice = new Person("Alice", 25);
        Person bob   = new Person("Bob", 30);

        System.out.println("alice -> " + alice);
        System.out.println("bob   -> " + bob + "\n");

        alice.introduce();
        bob.introduce();

        alice.celebrateBirthday();

        System.out.println("alice -> " + alice);
        System.out.println("bob   -> " + bob + "\n");

        System.out.println("=== FIN DEL EJEMPLO ===");
    }
}
```
**Lo que está pasando**

1. **Entrada del programa**
    
   La JVM busca el método:
    ```java
    public static void main(String[] args)
```
2. **Creamos objetos**
   
   Usamos el constructor de Person:
    ```java
    new Person("Alice", 25);
    new Person("Bob", 30);
```

3. **Mostramos el estado inicial**

   Gracias a toString(), vemos su contenido de forma legible.

4. **Llamamos a métodos**

- `alice.introduce();`

- `bob.introduce();`

- `alice.celebrateBirthday();`

5. Comprobamos que el estado ha cambiado

Solo cambia la edad de `alice`. `bob` sigue igual.

Cada objeto mantiene su propio estado.

### 5. Relación con proyectos reales y Spring Boot

En un proyecto real, verás clases muy parecidas a `Person`, pero con nombres como:

- `User`

- `Product`

- `Order`

- `Invoice`

- `Payment`

#### Algunos ejemplos típicos:

- En Spring Boot:

    - `@Entity` → clases que representan tablas de base de datos.

    - `@Service` → clases que contienen lógica de negocio.

    - `@Controller` → clases que exponen endpoints REST.

#### En todos los casos:

- Definimos clases

- El programa trabaja con objetos de esas clases

Ejemplo mental:

- Clase `User` → describe qué es un usuario.

- Objeto `currentUser` → representa al usuario que ha iniciado sesión ahora mismo.

### 7. Ejercicios recomendados (para practicar)

Si estás aprendiendo, prueba a modificar este ejemplo:

1. **Añade un nuevo atributo a `Person`:**

- Por ejemplo: `String email`

- Actualiza:

    - el constructor

    - `toString()`

    - `introduce()`

2 **Crea un nuevo método de comportamiento:**

- Por ejemplo: `public void changeName(String newName)`

- Haz que modifique el nombre y lo muestre por pantalla.

3. **Crea otra clase:**

- Crea una clase `Car` con atributos como `brand`, `model`, `year`.

- Crea algunos objetos `Car` en `Main` y muestra su información.