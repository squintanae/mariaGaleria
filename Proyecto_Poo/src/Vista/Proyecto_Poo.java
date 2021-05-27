/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Control.ControlGaleria;
import Control.IControlGaleria;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author JANET
 */
public class Proyecto_Poo extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MenuFXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("Galeria MariaVader.jpg!");
        stage.getIcons().add(new Image("file:IconoGaleria.png"));
        stage.show();
        
//                stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
//
//            @Override
//            public void handle(WindowEvent we) {
//                IControlGaleria servicios = ControlGaleria.getInstance();
//                servicios.persistirXMLArtistas();
//                servicios.persistirXMLObras();
//                servicios.persistirXMLClientes();
//                servicios.persistirXMLCompras();
//            }
//        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
