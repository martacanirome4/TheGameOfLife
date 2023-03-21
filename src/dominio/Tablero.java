package dominio;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
// Tablero de El Juego de la Vida

public class Tablero {
    private static int DIMENSION = 30;
    // matriz que representa el estado actual del tablero
    private int[][] estadoActual = new int[DIMENSION+2][DIMENSION+2];
    // matriz que representa el estado siguiente del tablero
    // le indicamos que es 30x30 pero realmente es 32x32 para no salirnos del tablero al recorrer y calcular en límites
    private int[][] estadoSiguiente = new int[DIMENSION+2][DIMENSION+2];

    // lee el estado inicial de un fichero llamado 'matriz'
    public void leerEstadoActual(){
        try {
            Scanner fichero = new Scanner(new File("matriz.txt"));
            for (int i = 0; i < DIMENSION; i++) {
                String linea = fichero.nextLine();
                for (int j = 0; j < DIMENSION; j++) {
                    estadoActual[i+1][j+1] = Integer.parseInt(String.valueOf(linea.charAt(j)));
                }
            }

            for (int i = 1; i < DIMENSION+1; i++) {
                for (int j = 1; j < DIMENSION+1; j++) {
                    int vecinasVivas = estadoActual[i - 1][j - 1] + estadoActual[i - 1][j] + estadoActual[i - 1][j + 1]
                            + estadoActual[i][j - 1] + estadoActual[i][j + 1] + estadoActual[i + 1][j - 1] +
                            estadoActual[i + 1][j] + estadoActual[i + 1][j + 1];
                    if (estadoActual[i][j] == 1 && (vecinasVivas == 2 || vecinasVivas == 3)) {
                        estadoSiguiente[i][j] = 1;
                    } else if (estadoActual[i][j] == 0 && vecinasVivas == 3) {
                        estadoSiguiente[i][j] = 1;
                    } else {
                        estadoSiguiente[i][j] = 0;
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /* * Genera un estado inicial aleatorio. Para cada celda
          * genera un número aleatorio en el intervalo [0, 1). Si
          * el número es menor que 0,5, entonces la celda está
          * inicialmente viva. En caso contrario, está muerta. */
    public void generarEstadoActualPorMontecarlo(){
        // La secuencia de ceros y unos generada es guardada
        // en ‘estadoActual‘ y, utilizando las reglas del juego
        // de la vida, se insertan los ceros y unos
        // correspondientes en ‘estadoSiguiente‘.
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                estadoActual[i+1][j+1] = (int) Math.round(Math.random());
            }
        }

        for (int i = 1; i < DIMENSION+1; i++) {
            for (int j = 1; j < DIMENSION+1; j++) {
                int vecinasVivas = estadoActual[i - 1][j - 1] + estadoActual[i - 1][j] + estadoActual[i - 1][j + 1]
                        + estadoActual[i][j - 1] + estadoActual[i][j + 1] + estadoActual[i + 1][j - 1] +
                        estadoActual[i + 1][j] + estadoActual[i + 1][j + 1];
                if (estadoActual[i][j] == 1 && (vecinasVivas == 2 || vecinasVivas == 3)) {
                    estadoSiguiente[i][j] = 1;
                } else if (estadoActual[i][j] == 0 && vecinasVivas == 3) {
                    estadoSiguiente[i][j] = 1;
                } else {
                    estadoSiguiente[i][j] = 0;
                }
            }
        }
    }


    /** Transita al estado siguiente según las reglas del
     * juego de la vida. */
    public void transitarAlEstadoSiguiente(){
        // La variable ‘estadoActual‘ pasa a tener el contenido
        // de ‘estadoSiguiente‘ y, éste útimo atributo pasar a
        // reflejar el siguiente estado.
        estadoActual = estadoSiguiente;
        estadoSiguiente = new int[DIMENSION+2][DIMENSION+2];
        for (int i = 1; i < DIMENSION+1; i++) {
            for (int j = 1; j < DIMENSION+1; j++) {
                int vecinasVivas = estadoActual[i - 1][j - 1] + estadoActual[i - 1][j] + estadoActual[i - 1][j + 1]
                        + estadoActual[i][j - 1] + estadoActual[i][j + 1] + estadoActual[i + 1][j - 1] +
                        estadoActual[i + 1][j] + estadoActual[i + 1][j + 1];
                if (estadoActual[i][j] == 1 && (vecinasVivas == 2 || vecinasVivas == 3)) {
                    estadoSiguiente[i][j] = 1;
                } else if (estadoActual[i][j] == 0 && vecinasVivas == 3) {
                    estadoSiguiente[i][j] = 1;
                } else {
                    estadoSiguiente[i][j] = 0;
                }
            }
        }
    }

    /* * Devuelve, en modo texto, el estado actual.
          * @return el estado actual. */
    @Override
    public String toString(){

        StringBuilder cadena = new StringBuilder();
        for (int i = 1; i < DIMENSION+1; i++) {
            for (int j = 1; j < DIMENSION+1; j++) {
                if (estadoActual[i][j] == 0) {
                    cadena.append(" ");
                } else {
                    cadena.append("x");
                }
            }
            cadena.append("\n");
        }
        return cadena.toString();
    }

}