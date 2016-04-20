/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

/**
 *
 * @author distribuidos
 */
public class Programa {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        //Creacion de los Hilos
         Bodega bodega = new Bodega();         
         Empacador empacador = new Empacador(bodega);
         Descargador descargador = new Descargador(bodega);
         
         //Ejecucion
         empacador.start();
         descargador.start();
         
    }
    
}
