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
public class excepctionCodigo extends Exception {
   long  valor;

   public excepctionCodigo(long x) {
      valor = x;
   }
   public void msjError(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText("Error con el codigo");
        alert.setContentText("El ingresado debe contener 7 numeros");
        alert.showAndWait();
   }
   @Override
   public String toString() {
      return "Ingreso:[" + valor + "]";
   }
}
