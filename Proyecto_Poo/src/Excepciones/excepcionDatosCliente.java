/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

import javafx.scene.control.Alert;

/**
 *
 * @author david
 */
public class excepcionDatosCliente extends Exception{
    
   public excepcionDatosCliente() {
       System.out.println("Error datos en blanco");
   }
   public void msjError(){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Información");
                alert.setHeaderText("Nuevo Cliente");
                alert.setContentText("Hay dato(s) vacio(s), por favor llene el/los dato(s) que falta" );
                alert.showAndWait();
   }
}
