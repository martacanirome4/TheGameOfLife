# 🧬 The Game of Life

**Implementación en Java del Juego de la Vida de John Conway (1970)**  
Un autómata celular clásico donde una cuadrícula de células evoluciona siguiendo reglas simples... y genera patrones sorprendentes

![gameoflife](https://user-images.githubusercontent.com/50625677/226908814-96dba668-8440-48fe-a4bc-cc51e6b664bf.jpg)

> _“El objetivo del juego es encontrar patrones que evolucionen de manera interesante, algo que la gente ha estado haciendo durante más de 50 años.”_  
> — [conwaylife.com](https://conwaylife.com/)

---

## 🧩 Descripción del Proyecto

Este proyecto implementa el Juego de la Vida en Java sobre una **matriz de 30x30**. Cada célula puede estar **viva** o **muerta**, y cambia de estado en cada iteración según las reglas de Conway, utilizando un enfoque probabilístico basado en el **método de Montecarlo** para generar los estados iniciales.

---

## 📜 Reglas del Juego

| Estado actual | Vecinas vivas | Estado siguiente |
| ------------- | ------------- | ---------------- |
| Viva          | 2 o 3         | Viva             |
| Muerta        | 3             | Viva             |
| Cualquier otro| —             | Muerta           |

---

## ⚙️ Cómo compilar y ejecutar

```bash
# Clona este repositorio
git clone https://github.com/tuusuario/TheGameOfLife.git
cd TheGameOfLife

# Compila el proyecto
make compilar

# Ejecuta el juego
make ejecutar
```

---

## 🎮 Cómo jugar

- Al ejecutarlo, verás la **cuadrícula** en la consola.
- Las **células vivas** se muestran como `*` y las **muertas** como espacio en blanco.
- Observa cómo los patrones evolucionan de forma dinámica en cada iteración.

---

## 🧠 Visual del Juego

![gameoflife](https://user-images.githubusercontent.com/50625677/226908814-96dba668-8440-48fe-a4bc-cc51e6b664bf.jpg)

Fuente de la imagen: [complexsystemstheory.net](https://complexsystemstheory.net/2020/04/13/john-conway-and-the-game-of-life/)

---

## 👩‍💻 Autoría

Desarrollado por **Marta Canino Romero**  
[@martacanirome4](https://github.com/martacanirome4) – GitHub 2023
