package aplicacion;

import dominio.Tablero;

import java.util.concurrent.TimeUnit;
import java.lang.InterruptedException;

public class Principal {
    public static viod main (String[] args) {
        try
        {
            Tablero tabler = new Tablero();
            System.out.println("SIMULACIÓN CON TABLERO LEÍDO");
            tablero.leerEstadoActual();
            System.out.println(tablero);
            for(int i = 0; i<= 5; i++)
            {
                TimeUnit.SECONDS.sleep(1);
                tablero.transitarAlEstadoSiguiente();
                System.out.println(tablero);
            }

            System.out.println("SIMULACIÓN CON TABLERO CREADO MEDIANTE MONTECARLO");
            tablero.generarEstadoActualPorMontecarlo();
            System.out.println(tablero);
            for(int i = 0; i<= 15; i++)
            {
                TimeUnit.SECONDS.sleep(1);
                tablero.transitarAlEstadoSiguiente();
                System.out.println(tablero);
            }
        }
        catch(InterruptedException e)
        {
            System.out.println(e);
        }
    }
}