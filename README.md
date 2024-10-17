[celulas2]:https://github.com/Veppam2/icc-practica5/blob/main/images/Celulas2.png
[celulas1]:https://github.com/Veppam2/icc-practica5/blob/main/images/Celulas1.png

# ICC - Autómatas Celulares

## Equipo de enseñanza
* Ricchy Alaín Pérez Chevanier <alain.chevanier@ciencias.unam.mx>
* Manuel Alcántara Juárez <manuelalcantara52@ciencias.unam.mx>
* Víctor Emiliano Cruz Hernández <v23ec02@ciencias.unam.mx>

## Objetivo

Que el alumno ejercite los pilares de la programación orientada a objetos en Java para representar un Autómata Celular 

## Introducción

El juego de la vida es el mejor ejemplo de un autómata celular, diseñado por el matemático británico John Horton Conway en 1970.
Desde su publicación, ha atraído mucho interés debido a la gran variabilidad de la evolución de los patrones. Se considera que la vida es un buen ejemplo de emergencia y auto organización. Es interesante para los científicos, matemáticos, economistas y otros observar cómo patrones complejos pueden provenir de la implementación de reglas muy sencillas. 

Para muchos aficionados, el juego de la vida sólo era un desafío de programación y una manera divertida de usar ciclos de la CPU. Para otros, sin embargo, el juego adquirió más connotaciones filosóficas. Desarrolló un seguimiento casi fanático a lo largo de los años 1970 hasta mediados de los 80.


## Indicaciones generales

Los ejercicios describen un paso a completar que debe de implementarse en el código que se les proporcina.

En general, hay dos objetivos a cumplir:
1. Deben de familiarizarse cómo interactúa la clase principal `VentanaPrincipal` como encargada de la interfaz gráfica y completar la clase `Imagen`.

En su mayor parte, la clase `VentanaPrincipal` ya está completa, por lo que en la práctica no deben de agregar código en ella. Por otro lado, hay que indicar cómo se va a dibujar una "rejilla" utilizando la clase `Imagen`. 

2. Hay que implementar tres autómatas celulares en sus respectivas clases:
* Un autómata con el patrón Gosper Glum en la clase `GosperGun`
* Un autómata que simule un Incendio Forestal en la clase `BosqueEnLLamas`
* Un autómata con el patrón de la Regla 90 en la clase `ReglaNoventa`

## Autómatas Celulares

Un autómata celular (AC) es un objeto matemático, compuesto de células dispuestas en una rejilla de una forma determinada. Cada celda en la rejilla se modifica en pasos discretos de tiempo, siguiendo un conjunto de reglas basadas en el estado de las celdas vecinas. Las reglas del autómata son aplicadas iterativamente a un número deseado de unidades de tiempo. 

La malla es formada por cuadrados ("células") que se extiende por el infinito en todas las direcciones. Cada célula tiene su propia vecindad, que son las células que están próximas a ella, incluso en las diagonales. 

### Modelo de Von Neumann

En el modelo de Von Neumann cada estado de una célula del arreglo localizada en una posición `(i,j)` (en donde `i` es la columna y `j` es el renglón) en un tiempo t estará determinado por los valores de los estados en que se encuentran las células localizadas en las posiciones `(i-1,j), (i+1,j), (i,j+1), (i,j-1)`.

### Modelo de John Conway

John Conway, descubrió un tipo de vecindad parecida a la de von Neumann, con la variante de que se toma en cuenta a los vecinos ubicados en las esquinas. A este tipo de vecindad se le conoce como vecindad Moore.

<img src="https://github.com/Veppam2/icc-practica5/blob/main/images/Vecinos.png" width="40%">

Las células tienen dos estados: 
* Vivas o Encendidas (Color azul), o
* Muertas o Apagadas (Color blanco)

El estado inicial de las celdas en la rejilla puede ser definido de manera determinada o de manera aleatoria, además, existen dos tipos de vecindades para calcular el estado próximo de una célula. El estado de todas las células se tiene en cuenta para calcular el estado de las mismas al turno siguiente. Todas las células se actualizan simultáneamente.

Debemos aclarar que solo para los autómatas `ReglaNoventa` y `BosqueEnLLamas` en la malla todas las celda tienen igual número de vecinos. Es decir:
* Las celdas de hasta arriba tienen como vecinos superiores las celdas que se encuentran hasta la parte inferior.
* Las celdas de hasta abajo tienen como vecinos inferiores las celdas que se encuentran hasta la parte superior.
* Lo mismo para para las celdas que se encuentran hasta el extremo izquierdo.

Para el autómata `GosperGun` en la malla los vecinos no se comportan como anteriormente se describe, si no hay celdas superiores, no se toma en cuenta alguna otra. Mismo caso ante la ausencia de celdas inferiores, izquierdas y derechas.

### Planeador Gosper Glum

En la aparición original del juego en la revista, Conway ofreció un premio de 50 dólares por el descubrimiento de patrones que crecieran indefinidamente. El primero fue descubierto por Bill Gosper en noviembre de 1970. Entre los patrones que crecen indefinidamente se encuentran las "pistolas",  que son estructuras fijas en el espacio que generan planeadores u otras naves espaciales; "locomotoras", que se mueven y dejan un rastro de basura y "rastrillos", que se mueven y emiten naves espaciales. 
El primer planeador que se ha descubierto sigue siendo el más pequeño que se conoce:

<img src="https://github.com/Veppam2/icc-practica5/blob/main/images/GosperGun.png" width="50%">

Las transiciones para este autómata dependen del número de células vecinas vivas:
* Una célula muerta con exactamente 3 células vecinas vivas "nace" (al turno siguiente estará viva).
* Una célula viva con 2 ó 3 células vecinas vivas sigue viva, en otro caso muere o permanece muerta (por "soledad" o "superpoblación").

### El Bosque en Llamas
El modelo de bosque en llamas es un AC probabilístico. Para el modelado se van a seguir las reglas definidas por Drossel y Schwabl las cuales se citan a continuación:

* Una celda con un árbol ardiendo pasa a ser una celda vacía.
* Una celda con un árbol pasa a arder si al menos un vecino cercano esta ardiendo.
* En una celda vacía, con la probabilidad `p = 0.001`, se establece un nuevo árbol.
* En una celda con un árbol, con una probabilidad `f = 0.00001`, este pasa a ser un árbol ardiendo.

Los estados posibles de cada celda de AC son:

* Celda con árbol ardiendo (Color Rojo)
* Celda con árbol normal (Color Verde)
* Celda vacía, sin árbol (Color Blanco)

### Regla 90 de Stephen Wolfram

Woldfram introduce una serie de reglas para autómatas unidimensionales, en ellos solo se tiene un arreglo de celdas, y los posibles vecinos de una celda solo son el que se encuentra a su izquierda y a su derecha. Cada celda solo puede tener dos posibles estados
* Célula viva (Color Azul)
* Eélula muerta (Color Blanco)

Su regla 90 esta dado por las siguientes transiciones entre estados:

<img src="https://github.com/Veppam2/icc-practica5/blob/main/images/ReglaNoventa.png" width="60%">

Lo cual se interpreta de la siguiente manera:
* La casilla actual es la que tiene vecino izquierdo y derecho. Su siguiente estado es la casilla abajo de esta.
* Para el primer `0`: Si una celda esta viva y sus dos vecinos también están vivos la celda pasa a morir.
* Para el primer `1`: Si una celda esta viva, su vecino de la izquierda también esta vivo pero su vecino de la derecha esta muerto, entonces la celda permanece viva.
* Así sucesivamente se construyen las 6 reglas que faltan.

Debido a que este es un autómata unidimensional y nuestra representación grafica es para autómatas bidimensionales, lo que haremos es lo siguiente:
* Pintaremos solo una celda viva en la mitad de la primera columna de la rejilla. Llamemos esta `j`.
* Cuando evolucione dejaremos la primera columna `j` tal cual y generaremos su evolución en la siguiente columna `j+1`, y así sucesivamente.
* Cuando la evolución llegue a la última columna disponible de la malla, ocuparemos la casilla `0` para la siguiente evolución del autómata, y se podrá volver a empezar.

  
## Desarrollo
En esta práctica trabajarás con una base de código construida con Java 17+ y Maven Wrapper, 
también proveemos pruebas unitarias escritas con la biblioteca **Junit 5.7.2** que te 
darán retrospectiva inmediatamente sobre el funcionamiento de tu implementación.

Para ejecutar las pruebas necesitas ejecutar el siguiente comando:

```
$ env ENV=github ./mvnw test
```

Para ejecutar las pruebas contenidas en una única clase de pruebas, utiliza 
un comando como el siguiente:

```
$ ./mvnw -Dtest=MyClassTest test
```

En el código que recibirás la clase **App** tiene un método __main__ que puedes ejecutar 
como cualquier programa escrito en __Java__. Para eso primero tienes que empaquetar 
la aplicación y finalmente ejecutar el jar generado. Utiliza un comando como el que 
sigue:

```
$ ./mvnw package
... o saltando las pruebas unitarias
$ ./mvnw package -DskipTests
...
...
$ ./mvnw exec:java 
```

## Configuración de los git hooks para formatear el código

Antes de empezar a realizar commits que contenga tu solución
tienes que configurar un módulo de git que te ayudará a 
formatear tu código.

```
./mvnw git-code-format:install-hooks
```

## Forma de trabajo

Recomendamos ampliamente utilizar el editor [IntelliJ](https://www.jetbrains.com/help/idea/installation-guide.html)
para realizar el desarrollo de la práctica.
También agrega el plugin de IntelliJ [SonarLint](https://www.sonarsource.com/products/sonarlint/features/jetbrains/).

## Entrega

Deja todo el código con tu solución en la rama __main__, pues por omisión es esta
rama la que compara __Github Classroom__ contra la versión inicial del código mediante
el __Pull Request__ llamado __Feedback__, el cual nosotros vamos a revisar
para evaluar tu entrega.

Para verificar que tu código cumple con la especificación, 
en tu __Pull Request__ debes de pasar las dos validaciones que 
hace __Github Actions__ sobre el código, una de ellas verifica 
que pasas las pruebas automatizadas, y la otra que hayas formateado
tu código con el plugin de maven.

Además, no olvides marcar en classroom la tarea como entregada y 
en ella incluir el enlace hacia el __Pull Request__ que contiene tu 
solución. 

La fecha de entrega de tu práctica va a ser el máximo entre la fecha en la que 
abriste el __Pull Request__ y la fecha en la que hiciste el último push al repositorio con tu 
solución.

## Actividades
Junto con este archivo recibirá una carpeta llamada src, que contiene 4 clases `AutomataCelular`,`Imagen`, `PruebaPinta`, y `VentanaPrincipal`. Ábralas todas y dele un vistazo a cada una de ellas.

## Parte 1. Interfaz Gráfica

Solo compile la clase `VentanaPrincipal` ejecutando `./mvnw package -DskipTests` y con ello se compilaran todos los demás archivos. Después podemos ejecutar la clase con el comando `./mvnw exec:java ` y tendrá que ver algo parecido a esto:

<img src="https://github.com/Veppam2/icc-practica5/blob/main/images/Imagen1.png" width="40%">

### Problema 1: Implementación de la rejilla (1 punto)

Lo primero que se ve es un cuadro negro pues hace falta implementar los métodos 
* `creategrid()` y
* `paint()`

Estos se encuentran en la clase `Imagen`. Podríamos decir que esta clase es el marco donde pintaremos nuestro autómata, y tiene un ancho y alto declarado con la variable
* `tam = numCells * sizeCell + numCells + 1`

* NOTA: Una observación importante es que la variable `tam` toma en cuenta las 40 casillas especificadas en la variable `numCell` de alto y ancho especificado en `20`. Además de ello toma en cuenta las `(numCells + 1)` líneas que representan las rejillas en nuestro marco.  

Lo primero que se necesita es un pinzel para poder pintar en el cuadro esto se hace mediante la instrucción 
* `Graphics2D gc = imagen.createGraphics();`

Este objeto tiene varios métodos que nos ayudan a pintar, los mas importantes que debes de considerar para esta practica son:
* `setColor()`
* `drawLine()`
* `fillRect()`

Podemos dirigirnos a la documentación para buscar información acerca de como trabajan estos métodos.

El segundo ejercicio es implementar el metodo `creategrid()` que pinta todo el marco de blanco y luego realiza una rejilla de color gris. El punto `(0,0)` de la imagen se encuentra en la esquina superior. Si todo salió bien al ejecutarlo deberás de ver algo como esto:

<img src="https://github.com/Veppam2/icc-practica5/blob/main/images/Imagen2.png" width="40%">

* NOTA: Es importante aclarar que esta rejilla es de exactamente 40 casillas por largo y ancho las cuales se especifican en la variable final `numCells`.

Ahora implementa el método `paint()`, aquí te pasan la matriz y la serie de colores que quieren que les pongas a cada cuadro, hay que realizar un poco de geometría para pintar los cuadros de su color respectivo sin que se sobrepongan en las líneas de la rejilla. Si todo salió bien al ejecutarlo nuevamente tendrás que ver:

<img src="https://github.com/Veppam2/icc-practica5/blob/main/images/Imagen3.png" width="40%">

Después de lograr esto, lo siguiente es implementar los autómatas.

## Parte 2. Implementación de Autómatas

Hay que implementar los autómatas mencionados en su respectiva clase, para ello primero implementa una clase abstracta `Automata` que contenga las características más importantes que tu creas que se utilizaran para todos los Autómatas, no te olvides de implementar la interface `AutomataCelular`. Después, implementa las tres clases para cada uno de los autómatas a realizar.

### Problema 2. Autómata con el patrón Gosper Glum  (3 puntos)
Un autómata  en la clase `GosperGun` que simule el autómata antes descrito. El estado inicial es el que se muestra a continuación:

<img src="https://github.com/Veppam2/icc-practica5/blob/main/images/GosperGun1.png" width="40%">

Después de algunas evoluciones, el autómata se ve como el siguiente, este autómata no termina y no tiene un vecindario de toro a contraparte de los otros dos autómatas:

<img src="https://github.com/Veppam2/icc-practica5/blob/main/images/GosperGun2.png" width="40%">

### Problema 3. Autómata simulando un Incendio Forestal  (3 puntos)
Un autómata que simule un Incendio Forestal en la clase `BosqueEnLLamas`. En el estado inicial, para cada casilla, hay que elegir de forma aleatoria si es una casilla vacía, con árbol normal o árbol incendiado. Por ejemplo, este es un estado inicial válido para este autómata: 

<img src="https://github.com/Veppam2/icc-practica5/blob/main/images/Forest1.png" width="40%">

Lo más probable es que en la evolución 1, se quede una rejilla vacía que irá incrementando el número de casillas con árboles hasta que se inicie un incendio, donde por ejemplo, en la siguiente imagen muestra cómo se propaga de acuerdo a las reglas de evolución de este autómata:

<img src="https://github.com/Veppam2/icc-practica5/blob/main/images/Forest2.png" width="40%">

### Problema 4. Autómata con el patrón de la Regla 90  (3 puntos)
Un autómata con el patrón de la Regla 90 adaptado bidimensionalmente en la clase `ReglaNoventa`. El estado inicial se muestra en la siguiente imagen:

<img src="https://github.com/Veppam2/icc-practica5/blob/main/images/ReglaNoventa1.png" width="40%">

Después en la evolución 15 se puede mostrar el siguiente estado del autómata, cabe mencionar que este autómata no termina cuando se llega hasta abajo en la rejilla, se continua hasta arriba continunando las evoluciones:

<img src="https://github.com/Veppam2/icc-practica5/blob/main/images/ReglaNoventa2.png" width="40%">
