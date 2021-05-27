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
public class excepcionDatosEscultura extends Exception {
    
   public excepcionDatosEscultura() {
       System.out.println("Error datos en blanco");
   }
   public void msjError(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Información");
            alert.setHeaderText("Error al crear la escultura");
            alert.setContentText("Debe llenar todos los espacios");
            alert.showAndWait();
   }
}
