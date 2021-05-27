/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Control.ControlGaleria;
import Control.IControlGaleria;
import Entidades.Artista;
import Entidades.Cliente;
import Entidades.Compra;
import Entidades.Cuadro;
import Entidades.Obra;
import Excepciones.excepcionDatosCliente;
import Excepciones.excepcionDatosInstaModi;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author JANET
 */
public class MenuFXMLDocumentController {
    private IControlGaleria servicios = ControlGaleria.getInstance();
    private final ObservableList<Obra> listaObras = FXCollections.observableArrayList();
    private final ObservableList<Artista> listaArtistas = FXCollections.observableArrayList();
    private final ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();
    private final ObservableList<Compra> listaCompras = FXCollections.observableArrayList();
    private final ObservableList<Obra> listaObrasDisponibles = FXCollections.observableArrayList();

    @FXML
    private TabPane pantallaGestionar;
    
    @FXML
    private Label tituloInicio;
    @FXML
    private Label LabelSantiago;
    @FXML
    private Label LabelQuintana;
    @FXML
    private Label LabelMaria;
    @FXML
    private Label LabelJanet;
    
    @FXML
    private Button botonGanancias;
    @FXML
    private Button botonSalir;
    
    @FXML
    private ImageView ImagenBlancoUno;
    @FXML
    private ImageView imagenBlancoDos;
    @FXML
    private ImageView imagenVader;
    
   
    @FXML
    private Rectangle rectangulo;
    @FXML
    private Label tituloObras;
    @FXML
    private Button botonVisualizarObras;
    @FXML
    private Button botonBuscar;
    @FXML
    private Button botonNuevaObra;
    @FXML
    private Label LabelTitulo;
    @FXML
    private ChoiceBox<String> ChoiceBoxTitulo;
    @FXML
    private ChoiceBox<String> ChoiceBoxArtista;
    @FXML
    private Label LabelArtista;
    @FXML
    private TextField TextFieldAño;
    @FXML
    private Label LabelAño;
    @FXML
    private Button botonMasDetalles;
    @FXML
    private Button botonModificar;
    @FXML
    private Button botonComprar;
    @FXML
    private Button botonEliminar;
    @FXML
    private ImageView imagenBB8;
    @FXML
    private ChoiceBox<String> ChoiceBoxCliente;
    @FXML
    private Label tituloClientes;
    @FXML
    private Button botonNuevoCliente;
    @FXML
    private Label LabelClientesRegistrado;
    @FXML
    private ChoiceBox<String> ChoiceBoxClientes;
    @FXML
    private TextField TextFieldDireccion;
    @FXML
    private TextField TextFieldTelefono;
    @FXML
    private TextField TextFieldCedula;
    @FXML
    private Label LabelCodigo;
    @FXML
    private Label LabelNombreCompleto;
    @FXML
    private Label LabelCedula;
    @FXML
    private Label LabelTelefono;
    @FXML
    private Label LabelDireccion;
    @FXML
    private Label tituloCompras;
    @FXML
    private TableView<Compra> tablaCompras;
    @FXML
    private TableColumn<Compra, String> ColTitulo;
    @FXML
    private TableColumn<Compra, String> ColTipo;
    @FXML
    private TableColumn<Compra, LocalDate> ColFechaCompra;
    @FXML
    private ChoiceBox<String> ChoiceBoxFiltrar;
    @FXML
    private Label LabelFiltrar;
    @FXML
    private ChoiceBox<String> ChoiceBoxMes;
    @FXML
    private Label LabelMes;
    @FXML
    private ImageView fondoVaderInicio;
    @FXML
    private Tab inicioMenu;
    @FXML
    private Tab obrasMenu;
    @FXML
    private ImageView fondoVaderObras;
    @FXML
    private Tab clientesMenu;
    @FXML
    private ImageView fondoVaderClientes;
    @FXML
    private Tab comprasMenu;
    @FXML
    private ImageView fondoVaderCompras;
    @FXML
    private Button botonModificarObra;
    @FXML
    private Button botonEliminarObra;
    @FXML
    private TextField TextFieldCodigoCliente;
    @FXML
    private Button botonEliminarCompra;
    @FXML
    private Label LabelAñoCompra;
    @FXML
    private TextField TextFieldAñoCompra;
    @FXML
    private TableView<Obra> tablaObras;
    @FXML
    private TableColumn<Obra, String> colObrasTitulo;
    @FXML
    private TableColumn<Obra, Long> colObrasCodigo;
    @FXML
    private TableColumn<Obra, String> colObrasTipo;
    @FXML
    private Button botonBuscarObras;
    @FXML
    private ChoiceBox<String> ChoiceBoxBusqueda;
    @FXML
    private Button botonAplicarBusqueda;
    @FXML
    private ChoiceBox<String> ChoiceBoxVisualizacion;
    @FXML
    private Button botonAplicarVisualizacion;
    @FXML
    private Button botonVisualizarTodasObras;
    @FXML
    private TextField TextFieldNombre;
    @FXML
    private TextField TextFieldApellido;
    @FXML
    private Label LabelNombreCompleto1;
    @FXML
    private Label LabelClientesRegistrado1;
    @FXML
    private CheckBox CheckboxModificar;
    @FXML
    private Label LabelClientesRegistrado11;
    @FXML
    private TableColumn<Compra, String> ColCliente;
    @FXML
    private TableColumn<Compra, Long> ColCodigoCompra;
    @FXML
    private Button botonAplicarCompra;
    
    
    public void initialize(URL url, ResourceBundle rb) {
 
    } 

    @FXML
    private void inicioGanancias(ActionEvent event) {
        double ganancia = servicios.gananciaTotal();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText("Ganacia de MariaVader.jpg");
        alert.setContentText("El total recaudado por la galeria es: " + Double.toString(ganancia));
        alert.showAndWait();
    }

    @FXML
    private void inicioSalir(ActionEvent event) {
    }

    @FXML
    private void obrasVisualizarObras(ActionEvent event) {
        tablaObras.setItems(listaObrasDisponibles);
        ChoiceBoxVisualizacion.disableProperty().set(true);
        botonAplicarVisualizacion.disableProperty().set(true);
        ChoiceBoxCliente.disableProperty().set(false);
        botonComprar.disableProperty().set(false);
        botonEliminarObra.disableProperty().set(false);
        botonModificarObra.disableProperty().set(false);
    }

    @FXML
    private void obrasNuevaObra(ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ObrasInsertarFXMLDocument.fxml"));
            Parent root = loader.load();
            
            ObrasInsertarFXMLDocumentController controllerObras = loader.getController();
            controllerObras.configurarObra(listaObrasDisponibles.get(0).getCodigoObra(),false);

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.setTitle("Galeria MariaVader.jpg!");
            stage.getIcons().add(new Image("file:IconoGaleria.png"));
            stage.show();
            cerrarMenu(botonModificarObra);
    }

    @FXML
    private void obrasMasDetalles(ActionEvent event) throws IOException{
        
    }

    @FXML
    private void obrasModificar(ActionEvent event) throws IOException {
        int seleccion = tablaObras.getSelectionModel().selectedIndexProperty().get();
        if (seleccion == -1) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Información");
            alert.setHeaderText("Error al seleccionar la Obra");
            alert.setContentText("Debe seleccionar una Obra de la lista para modificar");
            alert.showAndWait();
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ObrasInsertarFXMLDocument.fxml"));
            Parent root = loader.load();
            
            ObrasInsertarFXMLDocumentController controllerObras = loader.getController();
            controllerObras.configurarObra(listaObrasDisponibles.get(seleccion).getCodigoObra(),true);

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.setTitle("Galeria MariaVader.jpg!");
            stage.getIcons().add(new Image("file:IconoGaleria.png"));
            stage.show();
            cerrarMenu(botonModificarObra);
        }

    }
    private void cerrarMenu(Button button){
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void obrasComprar(ActionEvent event) {
        int seleccion = tablaObras.getSelectionModel().selectedIndexProperty().get();
        if (seleccion == -1) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Información");
            alert.setHeaderText("Error al seleccionar la Obra");
            alert.setContentText("Para eliminar usted debe seleccionar una Obra de la lista");
            alert.showAndWait();
        } else {
            if(ChoiceBoxCliente.getValue().equals("")){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Información");
                alert.setHeaderText("Comprar la Obra");
                alert.setContentText("Seleccione el Cliente que comprará la obra");
                alert.showAndWait();
            }else{
                String[] elementos = ChoiceBoxCliente.getValue().split("-");
                long codigo = Long.parseLong(elementos[1]);
                Cliente cliente = servicios.buscarCliente(codigo);
                servicios.nuevaCompra(listaObrasDisponibles.get(seleccion), cliente, LocalDate.now());
                ChoiceBoxCliente.setValue("");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Información");
                alert.setHeaderText("Comprar la Obra");
                alert.setContentText("La obra ha sido comprada exitosamente");
                alert.showAndWait();
                listaCompras.setAll(servicios.getListaCompras());
                servicios.borrarObra(listaObrasDisponibles.get(seleccion).getCodigoObra());
                listaObrasDisponibles.setAll(servicios.getListaObrasDisponibles());
            }
            listaCompras.setAll(servicios.getListaCompras());
            listaObrasDisponibles.setAll(servicios.getListaObrasDisponibles());
        }
    }

    @FXML
    private void obrasEliminar(ActionEvent event) {
        int seleccion = tablaObras.getSelectionModel().selectedIndexProperty().get();
        if (seleccion == -1) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Información");
            alert.setHeaderText("Error al seleccionar la Obra");
            alert.setContentText("Para eliminar usted debe seleccionar una Obra de la lista");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmación de eliminar Obra");
            alert.setHeaderText("Eliminar una Obra");
            alert.setContentText("¿Está seguro que desea eliminar la Obra?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                servicios.borrarObra(listaObrasDisponibles.get(seleccion).getCodigoObra());
                servicios.borrarObra(listaObras.get(seleccion).getCodigoObra());
                listaObrasDisponibles.setAll(servicios.getListaObrasDisponibles());
                listaObras.setAll(servicios.getListaObras());
            } 
            listaObrasDisponibles.setAll(servicios.getListaObrasDisponibles());
            listaObras.setAll(servicios.getListaObras());
        }
    }


    @FXML
    private void clientesBuscar(ActionEvent event) {
        ChoiceBoxClientes.setValue("");
        if (TextFieldCodigoCliente.getText().equals("")){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText("Busqueda de Cliente");
        alert.setContentText("Ingrese el codigo del Cliente que quiere buscar" );
        alert.showAndWait();
        }else{
            long codigo = Long.parseLong(TextFieldCodigoCliente.getText());
            Cliente cliente = servicios.buscarCliente(codigo);
            if(cliente == null){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Información");
                alert.setHeaderText("Busqueda de Cliente");
                alert.setContentText("El cliente con ese código no existe. Intenta de nuevo" );
                alert.showAndWait();
            }else{
                TextFieldCodigoCliente.setText(String.valueOf(cliente.getCodigoCliente()));
                TextFieldNombre.setText(cliente.getNombre());
                TextFieldApellido.setText(cliente.getApellidos());
                TextFieldCedula.setText(String.valueOf(cliente.getCedula()));
                TextFieldTelefono.setText(String.valueOf(cliente.getTelefono()));
                TextFieldDireccion.setText(String.valueOf(cliente.getDireccionEntrega()));
            }
        }
    }
    
    

    @FXML
    private void clientesNuevoCliente(ActionEvent event) {
        try {
            verificarEspeciosInstaModi();
            long codigo = Long.parseLong(TextFieldCodigoCliente.getText());
            String nombre = TextFieldNombre.getText();
            String apellido = TextFieldApellido.getText();
            long cedula = Long.parseLong(TextFieldCedula.getText());
            long telefono = Long.parseLong(TextFieldTelefono.getText());
            String direccion = TextFieldDireccion.getText();

            Cliente cliente = new Cliente(codigo,cedula,nombre, apellido, direccion, telefono);
            if(!servicios.agregarNuevoCliente(cliente)){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Información");
                alert.setHeaderText("Nuevo Cliente");
                alert.setContentText("El codigo del Cliente ya existe, intenta de nuevo" );
                alert.showAndWait();
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Información");
                alert.setHeaderText("Nuevo Cliente");
                alert.setContentText("Cliente agregado exitosamente" );
                alert.showAndWait();

                ObservableList<String> itemsClientes = FXCollections.observableArrayList();
                for(Cliente c : listaClientes){
                    String codigoCliente = Long.toString(c.getCodigoCliente());
                    itemsClientes.add(c.getApellidos() + "-" + codigoCliente);
                }
                itemsClientes.add(TextFieldApellido.getText() + "-" + TextFieldCodigoCliente.getText());
                ChoiceBoxClientes.getItems().setAll(itemsClientes);
            }
           mostrarDatosCliente(null);
        } catch(excepcionDatosCliente ex){
            ex.msjError();
        } catch(Exception ex){
            errorTipoDato();
        }
    }

    @FXML
    private void clienteModificar(ActionEvent event) {
        if (!CheckboxModificar.isSelected()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Información");
            alert.setHeaderText("Modificar un Cliente");
            alert.setContentText("Habilite la opción Modificar" );
            alert.showAndWait();
        }else{
            long codigo = Long.parseLong(TextFieldCodigoCliente.getText());
            String nombre = TextFieldNombre.getText();
            String apellido = TextFieldApellido.getText();
            long cedula = Long.parseLong(TextFieldCedula.getText());
            long telefono = Long.parseLong(TextFieldTelefono.getText());
            String direccion = TextFieldDireccion.getText();
            Cliente cliente = servicios.buscarCliente(codigo);
            
            if(servicios.modificarCliente(codigo, cedula, nombre, apellido, direccion, telefono)){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Información");
                alert.setHeaderText("Modificar un Cliente");
                alert.setContentText("Se ha modificado exitosamente el Cliente " + codigo);
                alert.showAndWait();
                ObservableList<String> itemsClientes = FXCollections.observableArrayList();
                for(Cliente c : listaClientes){
                    String codigoCliente = Long.toString(c.getCodigoCliente());
                    itemsClientes.add(c.getApellidos() + "-" + codigoCliente);
                }
                ChoiceBoxClientes.getItems().setAll(itemsClientes);
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Información");
                alert.setHeaderText("Modificar un Cliente");
                alert.setContentText("El Cliente no existe");
                alert.showAndWait(); 
            }
        }
    }

    @FXML
    private void clienteEliminar(ActionEvent event) {
        if (TextFieldCodigoCliente.getText().equals("")){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText("Eliminar un Cliente");
        alert.setContentText("No hay Cliente para eliminar, por favor busca el Cliente" );
        alert.showAndWait();
        }else{
            long codigo = Long.parseLong(TextFieldCodigoCliente.getText());
            if(!servicios.borrarCliente(codigo)){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Información");
                alert.setHeaderText("Eliminar un Cliente");
                alert.setContentText("El Cliente esta asociado a una compra, no fue posible eliminarlo" );
                alert.showAndWait();
            }else{
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmación de eliminar Cliente");
                alert.setHeaderText("Eliminar un Cliente");
                alert.setContentText("¿Está seguro que desea eliminar el Cliente " + codigo + "?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    servicios.borrarCliente(codigo);
                    listaClientes.setAll(servicios.getListaClientes());
                    
                    ObservableList<String> itemsClientes = FXCollections.observableArrayList();
                    for(Cliente c : listaClientes){
                        String codigoCliente = Long.toString(c.getCodigoCliente());
                        itemsClientes.add(c.getApellidos() + "-" + codigoCliente);
                    }
                    ChoiceBoxClientes.getItems().setAll(itemsClientes);
                } 
                listaClientes.setAll(servicios.getListaClientes());
            }
        }
        mostrarDatosCliente(null);
    }

    @FXML
    private void comprasEliminar(ActionEvent event) {
        int seleccion = tablaCompras.getSelectionModel().selectedIndexProperty().get();
        if (seleccion == -1) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Información");
            alert.setHeaderText("Error al seleccionar la Compra");
            alert.setContentText("Para eliminar usted debe seleccionar una Compra de la lista");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmación de eliminar Obra");
            alert.setHeaderText("Eliminar una Compra");
            alert.setContentText("¿Está seguro que desea eliminar la Compra?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                servicios.borrarCompra(listaCompras.get(seleccion).getCodigoCompra());
                listaCompras.setAll(servicios.getListaCompras());
            } 
            listaCompras.setAll(servicios.getListaCompras());
        }
    }
    
    private void mostrarDatosCliente(Cliente cliente){
        if(cliente != null){
            TextFieldCodigoCliente.setText(Long.toString(cliente.getCodigoCliente()));
            TextFieldNombre.setText(cliente.getNombre());
            TextFieldApellido.setText(cliente.getApellidos());
            TextFieldCedula.setText(Long.toString(cliente.getCedula()));
            TextFieldTelefono.setText(Long.toString(cliente.getTelefono()));
            TextFieldDireccion.setText(cliente.getDireccionEntrega());
        }else{
            TextFieldCodigoCliente.setText("");
            TextFieldNombre.setText("");
            TextFieldApellido.setText("");
            TextFieldCedula.setText("");
            TextFieldTelefono.setText("");
            TextFieldDireccion.setText("");
        }
    }
    
    private void configurarTablaCompra(){
        
        ColTitulo.setCellValueFactory(new Callback<CellDataFeatures<Compra, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(CellDataFeatures<Compra, String> data){
                return new ReadOnlyStringWrapper( data.getValue().getCompraObra().getTitulo() );
            }
        });

        ColCliente.setCellValueFactory(new Callback<CellDataFeatures<Compra, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(CellDataFeatures<Compra, String> data){
                return new ReadOnlyStringWrapper( data.getValue().getCompraCliente().getApellidos() );
            }
        });
                
        PropertyValueFactory<Compra, Long> codigoProperty = new PropertyValueFactory<Compra, Long>("codigoCompra");
        ColCodigoCompra.setCellValueFactory(codigoProperty);
        
        ColTipo.setCellValueFactory(new Callback<CellDataFeatures<Compra, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(CellDataFeatures<Compra, String> data){
                return new ReadOnlyStringWrapper( data.getValue().getCompraObra().getTipo());
            }
        });
 
        PropertyValueFactory<Compra, LocalDate> fechaProperty = new PropertyValueFactory<Compra, LocalDate>("fecha");
        ColFechaCompra.setCellValueFactory(fechaProperty);
    }
    
    private void configurarTablaObra(){
        PropertyValueFactory<Obra, String> tituloProperty = new PropertyValueFactory<Obra, String>("titulo");
        colObrasTitulo.setCellValueFactory(tituloProperty);

        PropertyValueFactory<Obra, Long> codigoProperty = new PropertyValueFactory<Obra, Long>("codigoObra");
        colObrasCodigo.setCellValueFactory(codigoProperty);
        
        PropertyValueFactory<Obra, String> tipoProperty = new PropertyValueFactory<Obra, String>("tipo");
        colObrasTipo.setCellValueFactory(tipoProperty);
        
    }


    @FXML
    private void iniciarObrasMenu(Event event) {
        listaClientes.clear();
        listaObrasDisponibles.clear();
        listaObras.clear();
        listaArtistas.clear();
        
        configurarTablaObra();
        listaObras.addAll(servicios.getListaObras());
        listaArtistas.addAll(servicios.getListaArtistas());
        listaClientes.addAll(servicios.getListaClientes());
        listaObrasDisponibles.addAll(servicios.getListaObrasDisponibles());
        
        
        ObservableList<String> itemsTitulo = FXCollections.observableArrayList();
        for(Obra o : listaObras){
            itemsTitulo.add(o.getTitulo());
        }
        
        ObservableList<String> itemsArtistas = FXCollections.observableArrayList();
        for(Artista a : listaArtistas){
            String codigo = Long.toString(a.getCodigoArtista());
            itemsArtistas.add(a.getNombre() + "-" + codigo);
        }
        
        ObservableList<String> itemsClientes = FXCollections.observableArrayList();
        itemsClientes.add("");
        for(Cliente c : listaClientes){
            String codigo = Long.toString(c.getCodigoCliente());
            itemsClientes.add(c.getApellidos() + "-" + codigo);
        }
        
        ChoiceBoxBusqueda.setItems(FXCollections.observableArrayList(
        "", "Titulo", "Artista", "Año"));
        
        ChoiceBoxVisualizacion.setItems(FXCollections.observableArrayList(
        "", "Cuadro", "Escultura", "Instalacion"));
        
        ChoiceBoxTitulo.getItems().setAll(itemsTitulo);
        ChoiceBoxArtista.getItems().setAll(itemsArtistas);
        ChoiceBoxCliente.getItems().setAll(itemsClientes);
        ChoiceBoxCliente.setValue("");
        
        ChoiceBoxTitulo.disableProperty().set(true);
        ChoiceBoxArtista.disableProperty().set(true);
        TextFieldAño.disableProperty().set(true);
        
        ChoiceBoxVisualizacion.disableProperty().set(true);
        botonAplicarVisualizacion.disableProperty().set(true);
        
        desactivarBotonesObraDisponible();
    }

    @FXML
    private void iniciarClientesMenu(Event event) {
        listaClientes.clear();
        listaClientes.addAll(servicios.getListaClientes());
        ObservableList<String> itemsClientes = FXCollections.observableArrayList();
        for(Cliente c : listaClientes){
            String codigo = Long.toString(c.getCodigoCliente());
            itemsClientes.add(c.getApellidos() + "-" + codigo);
        }
        
        ChoiceBoxClientes.getItems().setAll(itemsClientes);
       
        ChoiceBoxClientes.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) ->  mostrarDatosClienteCodigo(newValue));
       
    }

    @FXML
    private void iniciarComprasMenu(Event event) {
        listaCompras.clear();
        listaCompras.addAll(servicios.getListaCompras());
        configurarTablaCompra();
        ChoiceBoxFiltrar.setItems(FXCollections.observableArrayList(
        "Todas las compras", "Compras asociadas a un cuadro", "Mes y año"));
        
        TextFieldAñoCompra.disableProperty().setValue(true);
        ChoiceBoxMes.disableProperty().setValue(true);
        
        tablaCompras.setItems(listaCompras);
        
        ChoiceBoxFiltrar.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) ->  mostrarDatosOpciones(newValue));
        
         ChoiceBoxMes.setItems(FXCollections.observableArrayList(
        "","Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio",
         "Agosto","Septiembre","Ocutbre","Noviembre","Diciembre"));
    }

    @FXML
    private void obrasBuscar(ActionEvent event) {
    ChoiceBoxVisualizacion.disableProperty().set(true);
    botonAplicarVisualizacion.disableProperty().set(true);
    
    desactivarBotonesObraDisponible();
    ObservableList<Obra> listaObrasEncontradas = FXCollections.observableArrayList();
    listaObrasEncontradas.clear();
    if(ChoiceBoxBusqueda.getValue().equals("Titulo")){
        if (ChoiceBoxTitulo.getValue().equals("")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Información");
            alert.setHeaderText("Busqueda de Obra por Titulo");
            alert.setContentText("No se encuentra seleccionado un Titulo" );
            alert.showAndWait();
        }else{
            Obra obraTitulo = servicios.buscarObra(ChoiceBoxTitulo.getValue()); 
            listaObrasEncontradas.add(obraTitulo);
        }
    } else if(ChoiceBoxBusqueda.getValue().equals("Artista")){
        if (ChoiceBoxArtista.getValue().equals("")){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText("Busqueda de Obra por Artista");
        alert.setContentText("No se encuentra seleccionado un Artista" );
        alert.showAndWait();
        }else{
            String[] elementos = ChoiceBoxArtista.getValue().split("-");
            long codigo = Long.parseLong(elementos[1]);
            Map<Long,Obra> obraArtista = servicios.buscarObraArtista(codigo);
            if(obraArtista.isEmpty() || obraArtista.equals(null)){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Información");
                alert.setHeaderText("Busqueda de Obra por Artista");
                alert.setContentText("Este Artista no tiene obras" );
                alert.showAndWait();
            }else{
                listaObrasEncontradas.addAll(obraArtista.values());
            }
        }
    }else if(ChoiceBoxBusqueda.getValue().equals("Año")){
        if (TextFieldAño.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Información");
            alert.setHeaderText("Busqueda de Obra por Año");
            alert.setContentText("No se encuentra ingresado un Año" );
            alert.showAndWait();
        }else{
            int codigo = Integer.parseInt(TextFieldAño.getText());
            Map<Long,Obra> obraAño = servicios.buscarObra(codigo);
            if(obraAño==null){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Información");
                alert.setHeaderText("Busqueda de Obra por Año");
                alert.setContentText("En este Año no hay obras" );
                alert.showAndWait();
            }else{
            listaObrasEncontradas.addAll(obraAño.values());
            }
        }
    }
    
    tablaObras.setItems(listaObrasEncontradas);
        
    }

    @FXML
    private void obrasAplicar(ActionEvent event) {
       ChoiceBoxTitulo.setValue("");
       ChoiceBoxArtista.setValue("");
       TextFieldAño.setText("");
       ChoiceBoxVisualizacion.disableProperty().set(true);
       botonAplicarVisualizacion.disableProperty().set(true);
       
       desactivarBotonesObraDisponible();
       if(ChoiceBoxBusqueda.getValue().equals("--")){
            ChoiceBoxTitulo.disableProperty().set(true);
            ChoiceBoxArtista.disableProperty().set(true);
            TextFieldAño.disableProperty().set(true);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Información");
            alert.setHeaderText("Error al elegir criterio");
            alert.setContentText("Escoja un criterio de busqueda" );
            alert.showAndWait();
        }else if(ChoiceBoxBusqueda.getValue().equals("Titulo")){
            ChoiceBoxTitulo.disableProperty().set(false);
            ChoiceBoxArtista.disableProperty().set(true);
            TextFieldAño.disableProperty().set(true);
        }else if(ChoiceBoxBusqueda.getValue().equals("Artista")){
            ChoiceBoxTitulo.disableProperty().set(true);
            ChoiceBoxArtista.disableProperty().set(false);
            TextFieldAño.disableProperty().set(true);
        }else{
            ChoiceBoxTitulo.disableProperty().set(true);
            ChoiceBoxArtista.disableProperty().set(true);
            TextFieldAño.disableProperty().set(false);
        }
       tablaObras.getItems().clear();
    }

    @FXML
    private void obrasAplicarVisualizacion(ActionEvent event) {
        desactivarBotonesObraDisponible();
        ObservableList<Obra> listaObrasEncontradas = FXCollections.observableArrayList();
        listaObrasEncontradas.clear();
       if(ChoiceBoxVisualizacion.getValue().equals("--") || ChoiceBoxVisualizacion.getValue().equals(null)){
           listaObrasEncontradas.addAll(listaObras);
        }else if(ChoiceBoxVisualizacion.getValue().equals("Cuadro")){
            listaObrasEncontradas.addAll(servicios.lstCuadro());
        }else if(ChoiceBoxVisualizacion.getValue().equals("Escultura")){
            listaObrasEncontradas.addAll(servicios.lstEscultura());
        }else if(ChoiceBoxVisualizacion.getValue().equals("Instalacion")){
            listaObrasEncontradas.addAll(servicios.lstInstalacion());
        }
       tablaObras.setItems(listaObrasEncontradas);
       ChoiceBoxVisualizacion.setValue("");
    }

    @FXML
    private void obrasVisualizarTodasObras(ActionEvent event) {
        desactivarBotonesObraDisponible();
        tablaObras.setItems(listaObras);
        ChoiceBoxVisualizacion.disableProperty().set(false);
        botonAplicarVisualizacion.disableProperty().set(false);
    }
    
    public void desactivarBotonesObraDisponible(){
        ChoiceBoxCliente.setValue("");
        ChoiceBoxCliente.disableProperty().set(true);
        botonComprar.disableProperty().set(true);
        botonEliminarObra.disableProperty().set(true);
        botonModificarObra.disableProperty().set(true);
    }
    
    public void mostrarDatosClienteCodigo(String info){
        String[] elementos = info.split("-");
        long codigo = Long.parseLong(elementos[1]);
        Cliente cliente = servicios.buscarCliente(codigo);
        mostrarDatosCliente(cliente);
    }
    
    public void mostrarDatosOpciones(String op){
       TextFieldAñoCompra.setText("");
       ChoiceBoxMes.setValue("");
       TextFieldAñoCompra.disableProperty().setValue(true);
       ChoiceBoxMes.disableProperty().setValue(true); 
       ObservableList<Compra> listaComprasEncontradas = FXCollections.observableArrayList();
        listaComprasEncontradas.clear();
        if(ChoiceBoxFiltrar.getValue().equals("Todas las compras")){
            listaComprasEncontradas.addAll(listaCompras);
        }else if(ChoiceBoxFiltrar.getValue().equals("Compras asociadas a un cuadro")){
            listaComprasEncontradas.addAll(servicios.lstComprasCuadro());
        }else if(ChoiceBoxFiltrar.getValue().equals("Mes y año")){
            TextFieldAñoCompra.disableProperty().setValue(false);
            ChoiceBoxMes.disableProperty().setValue(false);   
        }
        tablaCompras.setItems(listaComprasEncontradas);
    }

    @FXML
    private void clientesCheckBoxModificar(ActionEvent event) {
        if(CheckboxModificar.isSelected()){
            if(TextFieldCodigoCliente.getText().equals("")){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Información");
                alert.setHeaderText("Modificar Cliente");
                alert.setContentText("Seleccione o Busque el Cliente que desee modificar" );
                alert.showAndWait();
                CheckboxModificar.setSelected(false);
            }else{
                TextFieldCodigoCliente.disableProperty().set(true);
                botonBuscar.disableProperty().set(true);
            }
        }
    }

    @FXML
    private void comprasAplicar(ActionEvent event) {
        if(TextFieldAñoCompra.getText().equals("") || ChoiceBoxMes.getValue().equals("")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Información");
            alert.setHeaderText("Filtrar por Mes y Año");
            alert.setContentText("Por favor llena todo los espacios");
            alert.showAndWait();
        }else{
            int anio = Integer.parseInt(TextFieldAñoCompra.getText());
            int seleccion = ChoiceBoxMes.getSelectionModel().getSelectedIndex(); 
            ObservableList<Compra> listaComprasEncontradas = FXCollections.observableArrayList();
            listaComprasEncontradas.clear();
            listaComprasEncontradas.addAll(servicios.busqAnioMes(seleccion, anio).values());
            if(listaComprasEncontradas.isEmpty()){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Información");
                alert.setHeaderText("Filtrar por Mes y Año");
                alert.setContentText("No hay compras asociadas a este Mes y Año");
                alert.showAndWait();
            }else{
                tablaCompras.setItems(listaComprasEncontradas);
            }
        }
    }
    
        private void verificarEspeciosInstaModi() throws excepcionDatosCliente {
        if (TextFieldCodigoCliente.getText().equals("") || TextFieldNombre.getText().equals("") ||
           TextFieldApellido.getText().equals("") || TextFieldCedula.getText().equals("") ||
           TextFieldTelefono.getText().equals("") || TextFieldDireccion.getText().equals("")) {
            throw new excepcionDatosCliente();
        }
    }
        private void errorTipoDato() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText("Error al ingresar los datos");
        alert.setContentText("Debe ingresar solo numeros en ciertos valores");
        alert.showAndWait();
    }
}
