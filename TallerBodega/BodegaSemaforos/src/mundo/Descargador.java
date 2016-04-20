/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author distribuidos
 */
public class Descargador extends Thread {

    Bodega bodega;

    public Descargador(Bodega bod) {
        bodega = bod;
    }

    public void run() {
        Random RandomTiempoDescargar = new Random();
        Random RandomTipoItem = new Random();
        int tipo;
        while (true) {
            int tiempoDescargando = RandomTiempoDescargar.nextInt(10);
            tipo = RandomTipoItem.nextInt(2) + 1;
            System.out.println("Descargando articulo de tipo " + tipo + " En "  + tiempoDescargando + " Segundos");
            try {
                sleep(tiempoDescargando * 1000);
            } catch (Exception e) {
            }

            System.out.println("Ingresa un nuevo articulo de tipo " + tipo);
            try {
                bodega.descargarArticulo(tipo);
            } catch (InterruptedException ex) {
                Logger.getLogger(Descargador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
