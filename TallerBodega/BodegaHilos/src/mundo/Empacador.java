/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

import java.util.Random;

/**
 *
 * @author distribuidos
 */
public class Empacador extends Thread {

    private Bodega bodega;

    public Empacador(Bodega bod) {
        bodega = bod;
    }

    public void run() {
        Random RandomTiempoEmpacando = new Random();
        while (true) {
            int tiempoEmpacando = RandomTiempoEmpacando.nextInt(10);
            System.out.println("Tiempo Empacando :" + tiempoEmpacando + " segundos");            
            try{
                sleep(tiempoEmpacando*1000);             
                System.out.println("Se creo el paquete");
                bodega.crearPaquete();                 
            }catch(Exception e){}
            
        }
    }
}
