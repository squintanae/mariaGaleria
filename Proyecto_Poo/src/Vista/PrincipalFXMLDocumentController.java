/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author JANET
 */
public class PrincipalFXMLDocumentController implements Initializable {
    
    @FXML
    private AnchorPane fondoPrincipal;
    @FXML
    private ImageView fondoVader;
    @FXML
    private Label tituloBienvenido;
    @FXML
    private Label tituloGaleria;
    @FXML
    private Label tituloMariaVader;
    @FXML
    private Button botonComenzar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void principalComenzar(ActionEvent event) {
        
    }
    
}
