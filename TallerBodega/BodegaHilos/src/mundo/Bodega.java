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
    
   

    public Bodega() {
        cantidad = 0;
        cantArtTipoUno = 0;
        cantArtTipoDos = 0;
    }

    public void descargarArticulo(int ti) {
        if (ti == 1) {
            while (cantidad + VOLUMEN1 >= CAPACIDAD_MAX)
                ;
            cantidad = cantidad + VOLUMEN1;
            cantArtTipoUno++;

        }

        if (ti == 2) {
            while (cantidad + VOLUMEN2 >= CAPACIDAD_MAX) 
               ;

            cantidad = cantidad + VOLUMEN2;
            cantArtTipoDos++;
        }
        
        System.out.println("Paquetes tipo 1 : " + cantArtTipoUno + ", Paquetes tipo 2: " + cantArtTipoDos);
    }

    public void crearPaquete() {
        while(cantArtTipoUno < 3 || cantArtTipoDos < 4)
            ;
        
            cantArtTipoUno = cantArtTipoUno - 3;
            cantArtTipoDos = cantArtTipoDos - 4;
            cantidad = cantidad - (VOLUMEN1 * 3 + VOLUMEN2 * 4);
            System.out.println("Se creo un paquete");
            System.out.println("Paquetes tipo 1 : " + cantArtTipoUno + ", Paquetes tipo 2: " + cantArtTipoDos);
        
    }
}
