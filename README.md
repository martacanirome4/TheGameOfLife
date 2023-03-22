# TheGameOfLife
Este es un proyecto de implementación del Juego de la Vida de John Conway (1970) en Java.
Este juego es un autómata celular, que consiste en una cuadrícula de células (fichero matriz 30x30) que pueden estar vivas o muertas.
En cada iteración, el estado de cada célula cambia de acuerdo con las reglas del juego.
Se genera el estado de las células en cada iteración mediante el método probabilístico de Montecarlo.

"El objetivo del juego es encontrar patrones que evolucionen de manera interesante, algo que la gente ha estado haciendo durante más de 50 años."
Fuente: https://conwaylife.com/

## Reglas del juego
Las reglas del juego implementadas en este proyecto son las siguientes:
1. Si una célula está viva y dos o tres de sus vecinas también lo están, entonces continúa viva en el estado siguiente.
2. Si una célula está muerta y tres de sus vecinas están vivas, entonces pasa a estar viva en el estado siguiente.
3. El resto de células pasan a estar muertas en el estado siguiente.

## Cómo compilar y ejecutar el proyecto
Para compilar y ejecutar el proyecto, sigue estos pasos:

- Clona este repositorio en tu computadora.
- Abre una terminal y navega al directorio del proyecto.
- Ejecuta el comando 'make compilar' para compilar el proyecto.
- Ejecuta el comando 'make ejecutar' para ejecutar el programa.

## Cómo jugar
Una vez que el programa se ejecute, se mostrará la cuadrícula del juego en la consola. Las células vivas se representan con un *, 
mientras que las células muertas se representan con un espacio en blanco.

¡Disfruta del juego!

## Visualmente
![gameoflife](https://user-images.githubusercontent.com/50625677/226908814-96dba668-8440-48fe-a4bc-cc51e6b664bf.jpg)
Fuente: https://complexsystemstheory.net/2020/04/13/john-conway-and-the-game-of-life/

## Autor
Marta Canino Romero, @martacanirome4 - GitHub 2023

