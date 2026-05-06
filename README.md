# Gestor de Biblioteca
**Instancia Evaluativa 1 — Interfaz Grafica (consola)**  
Materia: Interfaz Grafica | Analista en Sistemas  
Fecha de entrega: 12 mayo 2026

---

## Descripcion del proyecto

Sistema de gestion de biblioteca desarrollado en Java que permite administrar
libros, socios, prestamos y devoluciones desde la consola.
Se aplican los conceptos de Programacion Orientada a Objetos:
clases abstractas, interfaces, herencia y polimorfismo.

---

## Integrantes y roles

| Nombre | Rol |
|--------|-----|
| Joaquin Baigorria | Intro, demo, Main y menu interactivo |
| [Compañero 1] | Interfaz Prestable + clase abstracta MaterialBiblioteca |
| [Compañero 2] | Clase Libro (herencia, super, Override, encapsulamiento) |
| [Compañero 3] | Clase Biblioteca (ArrayList, busqueda, polimorfismo) |

---

## Estructura del proyecto

```
GestorBiblioteca/
 └── src/
      └── main/
           └── java/
                └── biblioteca/
                     ├── Prestable.java          <- Interfaz: contrato prestar/devolver
                     ├── MaterialBiblioteca.java <- Clase abstracta base
                     ├── Libro.java              <- Clase concreta (hereda MaterialBiblioteca)
                     ├── Socio.java              <- Clase para gestionar socios
                     ├── Biblioteca.java         <- Logica central del sistema
                     └── Main.java               <- Punto de entrada, menu interactivo
```

### Relacion entre clases

```
<<interface>>
Prestable
  prestar()
  devolver()
      |
      | implements
      v
<<abstract>>
MaterialBiblioteca
  # titulo, anio, prestado
  + prestar() [abstracto]
  + devolver() [abstracto]
      |
      | extends
      v
Libro
  - autor, isbn
  + prestar()      <- implementacion concreta
  + devolver()     <- implementacion concreta
  + toString()

Socio              <- clase independiente
  - nombre, idSocio

Biblioteca         <- gestiona listas de Material y Socio
  - List<MaterialBiblioteca>
  - List<Socio>
  + agregarMaterial()
  + listarMateriales()
  + buscarPorTitulo()
  + prestarMaterial()
  + devolverMaterial()
  + agregarSocio()
  + listarSocios()
```

---

## Instrucciones de ejecucion

### Requisitos
- JDK 21 o superior
- Apache NetBeans 29 (o cualquier IDE compatible con Maven)
- Apache Maven (incluido en NetBeans)

### Pasos

1. Clonar o descargar el repositorio
```bash
git clone https://github.com/Jbaigorria22/GestorBiblioteca.git
```

2. Abrir el proyecto en NetBeans:
   **File → Open Project** → seleccionar la carpeta `GestorBiblioteca`

3. Ejecutar la clase `Main.java`:
   Click derecho sobre `Main.java` → **Run File** (Shift+F6)

4. Interactuar con el menu en la consola

### Ejemplo de uso
```
============================
   GESTOR DE BIBLIOTECA
============================
1) Agregar libro
2) Listar materiales
3) Buscar por titulo
4) Prestar material
5) Devolver material
6) Agregar socio
7) Listar socios
8) Salir
Elegi una opcion: 1
Titulo: El principito
Autor: Saint-Exupery
ISBN: 978-0156012195
Anio: 1943
Material agregado: El principito
```

---

## Conceptos de POO aplicados

| Concepto | Donde se aplica |
|----------|----------------|
| **Interfaz** | `Prestable` define el contrato que deben cumplir todos los materiales |
| **Clase abstracta** | `MaterialBiblioteca` agrupa atributos comunes sin poder instanciarse directamente |
| **Herencia** | `Libro` extiende `MaterialBiblioteca` y hereda sus atributos |
| **Polimorfismo** | `Biblioteca` trabaja con `List<MaterialBiblioteca>` sin importar si es Libro u otro tipo |
| **Encapsulamiento** | Atributos `private` con getters/setters en todas las clases |
| **Sobrescritura** | `@Override` en `prestar()`, `devolver()` y `toString()` en `Libro` |

---

## Desafios encontrados

- **Encoding en consola Windows**: Los caracteres especiales (tildes, enie) se mostraban
  como `?` en la consola de NetBeans. Se resolvio eliminando acentos de los mensajes
  de consola y configurando UTF-8 en el `pom.xml`.

- **Clase Main incorrecta**: Maven ejecutaba por defecto la clase generada automaticamente
  (`GestorBibloteca.java`) en lugar de `biblioteca.Main`. Se resolvio configurando
  `<mainClass>biblioteca.Main</mainClass>` en el `pom.xml` y usando Shift+F6
  sobre el archivo correcto.

- **Estructura de paquetes**: NetBeans con Maven genera un paquete automatico
  (`com.mycompany.gestorbibloteca`). Se trabajo en un paquete separado `biblioteca`
  para mantener el codigo organizado.

---

## Uso de IA y herramientas externas

Este proyecto fue desarrollado con asistencia de **Claude (Anthropic)** como herramienta
de apoyo al aprendizaje. A continuacion se documenta el uso de manera transparente,
tal como requiere la catedra.

### Prompt inicial utilizado

> "Hola Claude. Estoy cursando la materia de programacion en la facultad y necesito
> desarrollar un Gestor de Biblioteca en Java como trabajo grupal.
> Mi objetivo: No solo quiero el codigo, necesito entender profundamente la logica
> para explicarlo en un video y documentar el proceso en
> un archivo README.
> Especificaciones tecnicas: Lenguaje Java (JDK 21), IDE Apache NetBeans 29,
> Arquitectura POO.
> Plan de trabajo paso a paso: no me des todo el codigo de una, vamos por etapas.
> En este primer turno: explicame que clases crear, dame el codigo de Libro,
> y explicame por que usamos encapsulamiento (private)."

### Como se uso la IA

- Se pidio el codigo **por etapas** (primero Libro, luego MaterialBiblioteca,
  luego Biblioteca y Main) para poder entender cada parte antes de continuar.
- Cada bloque de codigo fue **explicado conceptualmente** antes de ser implementado.
- Los errores de ejecucion (encoding, clase Main incorrecta) fueron diagnosticados
  y resueltos en conjunto con la herramienta.
- El codigo final fue **revisado y comprendido** por cada integrante para poder
  explicarlo en el video.

### Lo que NO hizo la IA
- No ejecuto ni probo el codigo (eso lo hicimos nosotros en NetBeans).
- No tomo decisiones de diseño sin explicarlas primero.
- No reemplazo la comprension del equipo: cada integrante puede explicar
  su parte asignada.

---

## Video explicativo

Duracion: ~10 minutos  
Cada integrante explica su parte con camara encendida y codigo en pantalla.

### Guia de lo que explica cada uno

**Joaquin — Intro + Main**
- Demo en vivo del menu funcionando
- Como funciona el do-while con switch
- Por que usamos scanner.nextLine() despues de nextInt()
- Como se maneja la entrada invalida con hasNextInt()

**Compañero 1 — Prestable + MaterialBiblioteca**
- Que es una interfaz y para que sirve
- Que es una clase abstracta y por que no se puede instanciar
- Por que usamos las dos juntas en lugar de solo una

**Compañero 2 — Clase Libro**
- Que hace extends MaterialBiblioteca
- Que hace super(titulo, anio) en el constructor
- Por que usamos @Override en prestar() y devolver()
- Encapsulamiento: private + getters/setters

**Compañero 3 — Clase Biblioteca**
- Que es un ArrayList y por que lo usamos
- Como funciona buscarPorTitulo con equalsIgnoreCase
- Polimorfismo: por que la lista es de MaterialBiblioteca y no de Libro

---

*Proyecto desarrollado para la materia Interfaz Grafica— Analista en Sistemas*