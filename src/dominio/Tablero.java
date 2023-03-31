package dominio;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Esta clase es responsable de leer el tablero de un
 * fichero en forma de ceros y unos, ir transitando de
 * estados e ir mostrando dichos estados.
 */
public class Tablero {
    // Pasaremos el tamaño de dimension del tablero como 30x30
    // Realmente el archivo será de 32x32 para evitar problemas con los bordes, por lo que hacemos dimension+2
    private static int dimension = 30;
    private int[][] estado_actual = new int[dimension+2][dimension+2];
    private int[][] estado_siguiente = new int[dimension+2][dimension+2];

    /**
     * Lee el estado inicial del fichero "matriz.txt"
     * La secuencia de ceros y unos del fichero es guardada en ‘estadoActual‘ y, utilizando las reglas del juego
     * de la vida, se insertan los ceros y unos correspondientes en ‘estadoSiguiente‘
     */
    /**
     * @param args
     * @return result
     * @throws FileNotFoundException
     * @throws InterruptedException
     */
    public void leerEstadoActual(){
        try {
            Scanner file = new Scanner(new File("matriz.txt"));
            for (int i=0; i<dimension; i++) {
                String linea = file.nextLine();
                for (int j=0; j<dimension; j++) {
                    estado_actual[i+1][j+1] = Integer.parseInt(String.valueOf(linea.charAt(j)));
                }
            }

            /** Genera un estado inicial aleatorio. Para cada celda
             * genera un número aleatorio en el intervalo [0, 1). Si
             * el número es menor que 0,5, entonces la celda está
             * inicialmente viva. En caso contrario, está muerta. */
            for (int i=1; i<dimension+1; i++) {
                for (int j=1; j<dimension+1; j++) {
                    // Recorremos las 8 casillas que rodean a la actual, o sus 'vecinas'
                    int vecinas_vivas = estado_actual[i-1][j-1]
                                        + estado_actual[i-1][j]
                                        + estado_actual[i-1][j+1]
                                        + estado_actual[i][j-1]
                                        + estado_actual[i][j+1]
                                        + estado_actual[i+1][j-1]
                                        + estado_actual[i+1][j]
                                        + estado_actual[i+1][j+1];
                    if (estado_actual[i][j]==1 && (vecinas_vivas==2 || vecinas_vivas==3)) {
                        estado_siguiente[i][j] = 1;
                    } else if (estado_actual[i][j]==0 && vecinas_vivas==3) {
                        estado_siguiente[i][j] = 1;
                    } else {
                        estado_siguiente[i][j] = 0;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /** La secuencia de ceros y unos generada es guardada en ‘estado_actual‘ y,
     * utilizando las reglas del juego de la vida,
     * se insertan los ceros y unos correspondientes en ‘estadoSiguiente‘.
     * Transita al estado siguiente según las reglas del juego.
     * **/
    /**
     * @param estado_actual
     * @param estado_siguiente
     * @param dimension
     * @return estado_siguiente
     * @throws InterruptedException
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void generarEstadoActualPorMontecarlo(){

        for (int i=0; i<dimension; i++) {
            for (int j=0; j<dimension; j++) {
                estado_actual[i+1][j+1] = (int) Math.round(Math.random());
            }
        }
        for (int i = 1; i<dimension+1; i++) {
            for (int j=1; j<dimension+1; j++) {
                int vecinas_vivas = estado_actual[i-1][j-1]
                                    + estado_actual[i-1][j]
                                    + estado_actual[i-1][j+1]
                                    + estado_actual[i][j-1]
                                    + estado_actual[i][j+1]
                                    + estado_actual[i+1][j-1]
                                    + estado_actual[i+1][j]
                                    + estado_actual[i+1][j+1];
                if (estado_actual[i][j]==1 && (vecinas_vivas==2 || vecinas_vivas==3)) {
                    estado_siguiente[i][j] = 1;
                } else if (estado_actual[i][j]==0 && vecinas_vivas==3) {
                    estado_siguiente[i][j] = 1;
                } else {
                    estado_siguiente[i][j] = 0;
                }
            }
        }
    }


    /** La variable ‘estado_actual‘ pasa a tener el contenido de ‘estadoSiguiente‘ y,
     * éste útimo atributo pasar a reflejar el siguiente estado.**/
    public void transitarAlEstadoSiguiente(){

        estado_actual = estado_siguiente;
        estado_siguiente = new int[dimension+2][dimension+2];
        for (int i=1; i<dimension+1; i++) {
            for (int j=1; j<dimension+1; j++) {
                int vecinas_vivas = estado_actual[i-1][j-1]
                                    + estado_actual[i-1][j]
                                    + estado_actual[i-1][j+1]
                                    + estado_actual[i][j-1]
                                    + estado_actual[i][j+1]
                                    + estado_actual[i+1][j-1]
                                    + estado_actual[i+1][j]
                                    + estado_actual[i+1][j+1];
                if (estado_actual[i][j]==1 && (vecinas_vivas==2 || vecinas_vivas==3)) {
                    estado_siguiente[i][j] = 1;
                } else if (estado_actual[i][j]==0 && vecinas_vivas==3) {
                    estado_siguiente[i][j] = 1;
                } else {
                    estado_siguiente[i][j] = 0;
                }
            }
        }
    }

    @Override
    public String toString(){

        StringBuilder resultado = new StringBuilder();
        for (int i=1; i<dimension+1; i++) {
            for (int j=1; j<dimension+1; j++) {
                if (estado_actual[i][j] == 0) { resultado.append(" ");}
                else { resultado.append("x");}
            }
            resultado.append("\n");
        }
        return resultado.toString();
    }

}