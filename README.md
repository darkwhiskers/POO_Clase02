# Clase 02: POO — Clases, Objetos y Encapsulamiento

Este repositorio contiene los ejemplos y ejercicios prácticos de la segunda sesión de Java,
enfocada en los fundamentos de la **Programación Orientada a Objetos**: cómo modelar el mundo
real a través de clases y objetos, y cómo estructurar un programa Java correctamente.

---

## Estructura del Proyecto

```
Clase02/
 ├── animales/
 │    └── Gato.java          ← clase modelo con todos los elementos de POO
 ├── vehiculos/
 │    ├── Motor.java          ← objeto contenido (composición)
 │    └── Auto.java           ← objeto contenedor (composición)
 ├── calculos/
 │    └── Aritmetica.java     ← demuestra el uso de static
 └── Principal.java           ← punto de entrada (método main)
```

---

## Temas Tratados

### 1. Pensando en Objetos


En POO un programa se modela como un conjunto de **objetos que interactúan entre sí**.
Un objeto es una unidad que posee tres características fundamentales:

| Característica | Descripción | En Java |
|---|---|---|
| **Estado** | Los datos que describe al objeto | Atributos (variables de instancia) |
| **Comportamiento** | Las acciones que puede realizar | Métodos |
| **Identidad** | Lo que lo hace único | Su referencia en memoria |

Un objeto puede representar una entidad física (un gato, un auto) o abstracta (un número, una fecha).

**Ejemplos del mundo real**

| Objeto | Atributos | Métodos |
|---|---|---|
| `Gato` | nombre, color, edad, maullido | `maullar()`, `comer()`, `dormir()` |
| `Auto` | modelo, puertas, chasis, motor | `acelerar()`, `frenar()`, `estacionar()` |
| `Motor` | marca, potenciaHP, encendido | `encender()`, `apagar()` |
| `CuentaBancaria` | saldo, límite | `depositar()`, `retirar()` |

> Un objeto puede contener **otros objetos como atributos**. Por ejemplo, un `Auto`
> tiene un `Motor`. Esto se llama **composición**.

---

### 2. Clases y Objetos


Una **clase** es el molde o plantilla que define los atributos y métodos comunes
a un conjunto de objetos similares. Un **objeto** es una instancia concreta de esa clase.

```
Clase GATO (molde)          Objetos (instancias)
─────────────────           ────────────────────
- nombre : String    →      mamba  = new Gato("Mamba",  "Negra", 11, "Miau")
- color  : String    →      siames = new Gato("Siamés", "Blanco", 3, "Meow")
- edad   : int       →      gatito = new Gato("Gatito", "Purr")
+ maullar()
+ comer()
```

Todos los objetos comparten la **misma estructura** (clase) pero tienen
**distintos valores** (identidades).

**Declarar vs. Instanciar**

```java
// Solo declarar (la variable existe, el objeto NO)
Gato mamba;

// Instanciar (crea el objeto en el heap con "new")
mamba = new Gato("Mamba", "Negra", 11, "Miau");

// Ambos pasos juntos (lo más común)
Gato siames = new Gato("Siamés", "Blanco", 3, "Meow");
```

---

### 3. Estructura de una Clase


Toda clase Java sigue este orden canónico:

```
1. package   → organización del proyecto
2. import    → clases externas que se usarán
3. class     → declaración de la clase
   ├── atributos   → estado (variables de instancia)
   ├── constructor → inicialización al crear el objeto
   ├── getters/setters → acceso controlado a atributos privados
   └── métodos     → comportamiento del objeto
```

**`package`**
- Indica el paquete al que pertenece la clase.
- Organiza clases relacionadas y evita conflictos de nombres.
- Si no se declara, la clase pertenece al paquete por defecto.

```java
package animales;
```

**`import`**
- Permite usar clases de otros paquetes.
- `java.lang` (String, Math, Object...) se importa automáticamente.

```java
import java.util.Scanner;
import vehiculos.Motor;
```

**Declaración de la clase**
- El nombre debe coincidir exactamente con el nombre del archivo `.java`.
- Se recomienda `PascalCase` para los nombres de clases.

```java
public class NombreClase {
    // ...
}
```

**Atributos (variables de instancia)**

```java
// Sintaxis: [modificador] tipo nombreAtributo;
private String nombre;
private int    edad;
```

**Constructor**

Método especial que se ejecuta al crear el objeto con `new`. Inicializa los atributos.
Puede haber **más de un constructor** (sobrecarga).

```java
// Constructor por defecto (sin parámetros)
public Gato() {
    this.nombre = "Sin nombre";
    this.edad   = 0;
}

// Constructor con parámetros
public Gato(String nombre, int edad) {
    this.nombre = nombre;  // "this" distingue atributo del parámetro
    this.edad   = edad;
}
```

**`this`**

Hace referencia al **objeto actual**. Se usa cuando el parámetro tiene
el mismo nombre que el atributo, para evitar ambigüedad.

```java
// Sin this: "nombre = nombre" asigna el parámetro a sí mismo (bug)
// Con this: this.nombre = nombre  ← atributo = parámetro
```

**Métodos**

```java
// Sintaxis:
// [modificador] tipoRetorno nombreMetodo(parametros) {
//     instrucciones;
//     [return expresion];
// }

public void maullar() {               // void: no devuelve nada
    System.out.println(maullido);
}

public float calcularImc(float altura, float peso) {  // devuelve float
    return peso / (altura * altura);
}
```

---

### 4. Modificadores de Acceso y Encapsulamiento


Java controla quién puede acceder a los miembros de una clase mediante **modificadores de acceso**:

| Modificador | Accesible desde |
|---|---|
| `public` | Cualquier lugar |
| `protected` | La misma clase y subclases |
| `private` | Solo dentro de la propia clase |
| *(default)* | Solo dentro del mismo paquete |

**Encapsulamiento** es el principio de **ocultar los datos internos** de un objeto y
permitir el acceso solo a través de métodos controlados.

**Buenas prácticas:**
- Atributos → `private` (o `protected`)
- Métodos → `public`

```java
public class Gato {
    private String nombre;   // solo accesible dentro de Gato
    private int    edad;

    // Acceso desde afuera SOLO a través de getters/setters
    public String getNombre() { return nombre; }
    public void   setNombre(String nombre) { this.nombre = nombre; }
}
```

**¿Por qué encapsular?**

```java
// Sin encapsulamiento: acceso directo, sin control
gato.edad = -5;   // ¡nadie lo impide!

// Con encapsulamiento: el setter puede validar
public void setEdad(int edad) {
    if (edad >= 0) {
        this.edad = edad;      // solo se asigna si es válido
    } else {
        System.out.println("Error: edad inválida");
    }
}
```

**Variables y métodos `static`**

Cuando un miembro es `static`:
- Pertenece a la **clase**, no a los objetos.
- Se accede con `NombreClase.miembro` (sin instanciar).
- Existe una **única copia** compartida.

```java
// Constante de clase (static + final)
public static final double PI = 3.1416;

// Método estático: se llama sin crear objeto
public static int sumar(int a, int b) {
    return a + b;
}

// Llamada desde otro lugar:
Aritmetica.sumar(4, 5);      // correcto
System.out.println(Aritmetica.PI);
```

---

### 5. Métodos Especiales


Son métodos que no agregan comportamiento nuevo, pero facilitan el uso y
representación de los objetos.

#### Getters y Setters

```java
public class Gato {
    private String nombre;

    // Getter: obtiene el valor
    public String getNombre() {
        return nombre;
    }

    // Setter: modifica el valor (puede incluir validaciones)
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
```

#### `toString()`

Pertenece a `Object`. Se llama automáticamente cuando se imprime un objeto.

```java
// Sin sobrescribir:
System.out.println(gato);   // → animales.Gato@4a574795  (inútil)

// Sobrescribiendo:
@Override
public String toString() {
    return "Gato [nombre=" + nombre + ", edad=" + edad + "]";
}

System.out.println(gato);   // → Gato [nombre=Mamba, edad=11]
```

> Útil para depuración, logs e impresión de listas de objetos.

#### `equals()`

Compara **contenido**, no direcciones de memoria.

```java
// Sin sobrescribir: equals funciona igual que == (compara referencias)
// Con sobrescribir: compara los atributos que definamos

@Override
public boolean equals(Object obj) {
    Gato otro = (Gato) obj;
    return this.nombre.equals(otro.nombre);
}

gato1.equals(gato2)   // true si tienen el mismo nombre
gato1 == gato2        // true solo si apuntan al MISMO objeto en memoria
```

#### `hashCode()`

Debe sobrescribirse **siempre que se sobrescriba `equals()`**.
Dos objetos iguales según `equals` deben tener el mismo `hashCode`.
Se usa en `HashMap` y `HashSet`.

#### `getClass()`

Devuelve la clase real del objeto en tiempo de ejecución.

```java
gato.getClass().getName()   // → "animales.Gato"
```

---

### 6. Sobrecarga de Constructores y Métodos


La **sobrecarga** permite tener múltiples versiones de un constructor o método
con el mismo nombre pero diferente lista de parámetros (tipo o cantidad).
Java decide cuál usar según los argumentos que se pasen.

```java
// Sobrecarga de constructores
public Gato() { ... }                                  // sin parámetros
public Gato(String nombre, String maullido) { ... }    // 2 parámetros
public Gato(String nombre, String color, int edad, String maullido) { ... }  // 4 parámetros

// Sobrecarga de métodos
public void sumar(int a, int b) { ... }
public void sumar(double a, double b) { ... }
public void sumar(double a, double b, double c) { ... }
```

---

### 7. Composición (un objeto contiene otro objeto)


Un objeto puede tener **otros objetos como atributos**. A esto se lo llama **composición**
y modela la relación "TIENE UN".

```
Auto  TIENE UN  Motor
```

```java
// Paso 1: crear el objeto contenido
Motor motorFord = new Motor("Ford", 180);

// Paso 2: crear el objeto contenedor pasándole el motor
Auto corolla = new Auto("Corolla", 4, "ABC-12345", motorFord);

// El Auto puede delegar comportamiento al Motor
corolla.arrancar();   // internamente llama a motor.encender()
```

---

### 8. Estructura de un Programa Java


Todo programa Java está formado por clases. La ejecución siempre comienza
en el método especial `main`.

```java
public class Principal {
    public static void main(String[] args) {
        // instrucciones
    }
}
```

| Modificador | Por qué |
|---|---|
| `public` | Debe ser accesible desde la JVM |
| `static` | La JVM lo llama sin crear un objeto |
| `void` | No devuelve ningún valor |
| `String[] args` | Argumentos opcionales de línea de comandos |

> Solo puede existir **un único `main`** por aplicación.
> En proyectos reales suele haber muchas clases, pero un solo punto de entrada.

---

## Cómo usar estos ejemplos

1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/darkwhiskers/POO_Clase02.git
   ```

2. **Compilar desde la raíz del proyecto:**
   ```bash
   javac animales/Gato.java vehiculos/Motor.java vehiculos/Auto.java calculos/Aritmetica.java Principal.java
   ```

3. **Ejecutar:**
   ```bash
   java Principal
   ```

4. **Generar Javadoc:**
   ```bash
   javadoc -d doc -encoding UTF-8 -subpackages animales:vehiculos:calculos Principal.java
   ```

---

## Referencia Rápida

| Concepto | Descripción | Ejemplo |
|---|---|---|
| Objeto | Instancia de una clase con estado, comportamiento e identidad | `new Gato("Mamba", ...)` |
| Clase | Molde/plantilla para crear objetos | `public class Gato { }` |
| Atributo | Variable que describe el estado del objeto | `private String nombre;` |
| Constructor | Método especial que inicializa el objeto | `public Gato(String n) { }` |
| `this` | Referencia al objeto actual | `this.nombre = nombre;` |
| Encapsulamiento | Ocultar atributos y exponer solo métodos | Atributos `private` + getters/setters |
| `private` | Solo accesible dentro de la clase | `private int edad;` |
| `public` | Accesible desde cualquier lugar | `public void saludar() { }` |
| `static` | Pertenece a la clase, no a los objetos | `Aritmetica.sumar(4,5)` |
| `static final` | Constante de clase | `static final double PI = 3.1416;` |
| Getter | Devuelve el valor de un atributo privado | `getNombre()` |
| Setter | Modifica el valor de un atributo privado | `setNombre(x)` |
| `toString()` | Representación textual del objeto | `@Override public String toString()` |
| `equals()` | Comparación por contenido | `@Override public boolean equals()` |
| Sobrecarga | Mismo nombre, distintos parámetros | `Gato()` y `Gato(String, int)` |
| Composición | Un objeto contiene otro objeto | `Auto` tiene un `Motor` |
| `main` | Punto de entrada de la aplicación | `public static void main(String[] args)` |

---

*Realizado por **Miguel Silva C.** — UTN INSPT*
*GitHub: [github.com/darkwhiskers](https://github.com/darkwhiskers)*
*Licencia: CC BY-NC-ND 4.0*
