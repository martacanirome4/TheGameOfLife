package dominio;
// Tablero de El Juego de la Vida

public class Tablero {
    private static int DIMENSION = 30;
    // matriz que representa el estado actual del tablero
    private int[][] estadoActual = new int[DIMENSION+2][DIMENSION+2];
    // matriz que representa el estado siguiente del tablero
    // le indicamos que es 30x30 pero realmente es 32x32 para no salirnos del tablero al recorrer y calcular en límites
    private int[][] estadoSiguiente = new int[DIMENSION+2][DIMENSION+2];

    // lee el estado inicial de un fichero llamado 'matriz'
    public void leerEstadoActtual(){
        // ...
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
    }


    /** Transita al estado siguiente según las reglas del
     * juego de la vida. */
    public void transitarAlEstadoSiguiente(){
        // La variable ‘estadoActual‘ pasa a tener el contenido
        // de ‘estadoSiguiente‘ y, éste útimo atributo pasar a
        // reflejar el siguiente estado.
    }

    /* * Devuelve, en modo texto, el estado actual.
          * @return el estado actual. */
    @Override
    public String toString(){
        return ""; // modificar
    }


}