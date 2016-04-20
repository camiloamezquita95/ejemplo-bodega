/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

import java.util.concurrent.Semaphore;

/**
 *
 * @author distribuidos
 */
public class Bodega {

    public final static int CAPACIDAD_MAX = 200;
    public final static int VOLUMEN1 = 10;
    public final static int VOLUMEN2 = 15;

    private int cantidad;
    private int cantArtTipoUno;
    private int cantArtTipoDos;

    private Semaphore mutex;
    private Semaphore capacidadMaxicma;
    private Semaphore cantArtTipo1;
    private Semaphore cantArtTipo2;

    public Bodega()  {
        cantArtTipoUno = 0;
        cantArtTipoDos = 0;
        mutex = new Semaphore(1);
        cantArtTipo1 = new Semaphore(0);
        cantArtTipo2 = new Semaphore(0);
        capacidadMaxicma = new Semaphore(CAPACIDAD_MAX);
    }

    public void descargarArticulo(int ti) throws InterruptedException {
        if (ti == 1) {
            mutex.acquire();
            capacidadMaxicma.acquire(VOLUMEN1);
            cantArtTipo1.release();
            cantArtTipoUno++;
        }

        if (ti == 2) {
            mutex.acquire();
            capacidadMaxicma.acquire(VOLUMEN2);
            cantArtTipo2.release();
            cantArtTipoDos++;
        }
        System.out.println("Paquetes tipo 1 : " + cantArtTipoUno + ", Paquetes tipo 2: " + cantArtTipoDos);
        mutex.release();
    }

    public void crearPaquete() throws InterruptedException {
        mutex.acquire();
        cantArtTipo1.acquire(3);
        cantArtTipo2.acquire(4);
        cantArtTipoUno = cantArtTipoUno - 3;
        cantArtTipoDos = cantArtTipoDos - 4;
        capacidadMaxicma.release(VOLUMEN1 * 3 + VOLUMEN2 * 4);        
        System.out.println("Se creo un paquete");
        System.out.println("Paquetes tipo 1 : " + cantArtTipoUno + ", Paquetes tipo 2: " + cantArtTipoDos);
        mutex.release();
    }
}
