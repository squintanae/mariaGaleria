/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Control.ControlGaleria;
import Control.IControlGaleria;
import Entidades.Artista;
import Entidades.Cuadro;
import Entidades.Escultura;
import Entidades.Instalacion;
import Entidades.Material;
import Entidades.Obra;
import Enumeraciones.Clasificacion;
import Excepciones.excepcionDatosCuadro;
import Excepciones.excepcionDatosCuadroModi;
import Excepciones.excepcionDatosEscultura;
import Excepciones.excepcionDatosEsculturaModi;
import Excepciones.excepcionDatosInstaModi;
import Excepciones.excepcionDatosInstalacion;
import Excepciones.excepcionDatosMaterial;
import Excepciones.excepctionCodigo;
import Excepciones.exceptionCodigoRepetido;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author JANET
 */
public class ObrasInsertarFXMLDocumentController {

    private IControlGaleria servicios = ControlGaleria.getInstance();
    private final ObservableList<Artista> listaArtistas = FXCollections.observableArrayList();
    private Obra obra;
    private ObservableList<Material> listaMateriales = FXCollections.observableArrayList();
    private ArrayList<Artista> artistasNuevaObra = new ArrayList<>();
    private ArrayList<Material> materialesNuevaObra = new ArrayList<>();
    boolean modificar;

    @FXML
    private AnchorPane fondoPrincipal;
    @FXML
    private Button botonNuevaObra;
    @FXML
    private TextField TextFieldGestionarObraCodigo;
    @FXML
    private TextField TextFieldGestionarObraTitulo;
    @FXML
    private DatePicker DatePickerGestionarObra;
    @FXML
    private TextField TextFieldGestionarObraPrecio;
    @FXML
    private TextField TextFieldGestionarObraDimensiones;
    @FXML
    private ChoiceBox<String> ChoiceBoxGestionarObraTipo;
    @FXML
    private Tab GestionarObraCuadro;
    @FXML
    private TextField TextFieldTema;
    @FXML
    private TextField TextFieldTecnica;
    @FXML
    private ChoiceBox<Clasificacion> ChoiceBoxClasificacion;
    @FXML
    private Tab GestionarObraEscultura;
    @FXML
    private TextField TextFieldPesoEscultura;
    @FXML
    private TextField TextFieldMaterialEscultura;
    @FXML
    private TextField TextFieldCodigoMaterialEscultura;
    @FXML
    private Tab GestionarObraInstalacion;
    @FXML
    private TableView<Material> tablaMateriales;
    @FXML
    private TableColumn<Material, String> colNombreMaterial;
    @FXML
    private TableColumn<Material, Long> colCodigoMaterial;
    @FXML
    private TableColumn<Material, String> colDescripcionMaterial;
    @FXML
    private Button botonAgregarMaterial;
    @FXML
    private TextArea TextAreaDescripcionInstalacion;
    @FXML
    private TextField TextFieldCodigoInstalacion;
    @FXML
    private TextField TextFieldNombreInstalacion;
    @FXML
    private TextArea TextAreaDescripcionMaterial;
    @FXML
    private Tab GestionarObraNuevoArtista;
    @FXML
    private TextField TextFieldCodigoArtista;
    @FXML
    private TextField TextFieldTelefonoArtista;
    @FXML
    private TextField TextFieldCedulaArtista;
    @FXML
    private TextField TextFieldApellidoArtista;
    @FXML
    private TextField TextFieldNombreArtista;
    @FXML
    private DatePicker DataPickerFechaNacimiento;
    @FXML
    private Button botonAgregarArtista;
    @FXML
    private ChoiceBox<String> ChoiceBoxGestionarArtista;
    @FXML
    private Button botonNuevoArtista;
    @FXML
    private Button botonModificar;
    @FXML
    private Button botonVolver;
    @FXML
    private TableView<Artista> tablaArtista;
    @FXML
    private TableColumn<Artista, String> colNombreArtista;
    @FXML
    private TableColumn<Artista, String> colApellidoArtista;
    @FXML
    private TableColumn<Artista, Long> colCodigoArtista;
    @FXML
    private TextArea TextAreaEscultura;

    public void configurarObra(long codigo, boolean op) {
        configurarTablaArtista();
        configurarTablaObra();
        modificar = op;
        ChoiceBoxGestionarArtista.getItems().clear();
        listaArtistas.addAll(servicios.getListaArtistas());

        ObservableList<String> itemsArtistasArt = FXCollections.observableArrayList();
        for (Artista a : listaArtistas) {
            String codiArt = String.valueOf(a.getCodigoArtista());
            itemsArtistasArt.add(a.getApellido() + "-" + codiArt);
        }

        ChoiceBoxGestionarArtista.getItems().setAll(itemsArtistasArt);
        ChoiceBoxGestionarObraTipo.setItems(FXCollections.observableArrayList(
                "Cuadro", "Escultura", "Instalacion"));
        ChoiceBoxGestionarObraTipo.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> elegirTipo(newValue));
        ChoiceBoxClasificacion.setItems(FXCollections.observableArrayList(Clasificacion.values()));
        tablaArtista.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> mostrarDatosArtista(newValue));
        tablaMateriales.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> mostrarDatosMaterial(newValue));
        if (op) {
            this.obra = servicios.encontrarObra(codigo);
            botonNuevaObra.disableProperty().set(true);
            TextFieldGestionarObraCodigo.setText(String.valueOf(obra.getCodigoObra()));
            TextFieldGestionarObraTitulo.setText(obra.getTitulo());
            // ChoiceBoxGestionarArtista.disableProperty().set(true);
            DatePickerGestionarObra.setValue(obra.getFecha());
            TextFieldGestionarObraDimensiones.setText(obra.getDimensiones());
            TextFieldGestionarObraPrecio.setText(String.valueOf(obra.getPrecioRef()));
            ChoiceBoxGestionarObraTipo.setValue(obra.getTipo());
            ChoiceBoxGestionarObraTipo.disableProperty().set(true);
            elegirTipo(obra.getTipo());
            if (obra.getTipo().equals("Cuadro")) {
                Cuadro cuadro = (Cuadro) obra;
                TextFieldTema.setText(cuadro.getTema());
                TextFieldTecnica.setText(cuadro.getTecnica());
                ChoiceBoxClasificacion.setValue(cuadro.getClasificacion());
            } else if (obra.getTipo().equals("Escultura")) {
                Escultura escultura = (Escultura) obra;
                TextFieldCodigoMaterialEscultura.setText(String.valueOf(escultura.getTipoMaterial().getCodigo()));
                TextFieldPesoEscultura.setText(String.valueOf(escultura.getPeso()));
                TextFieldMaterialEscultura.setText(escultura.getTipoMaterial().getNombre());
                TextAreaDescripcionMaterial.setText(escultura.getTipoMaterial().getDescripcion());
            } else if (obra.getTipo().equals("Instalacion")) {
                Instalacion instalacion = (Instalacion) obra;
                TextAreaDescripcionInstalacion.setText(instalacion.getDescripcion());
                configurarTablaObra();
                ObservableList<Material> itemsMaterialesInsta = FXCollections.observableArrayList();
                for (Material m : instalacion.getMaterial()) {
                    itemsMaterialesInsta.add(m);
                }
                tablaMateriales.setItems(itemsMaterialesInsta);
            }
            configurarTablaArtista();
            ObservableList<Artista> itemsArtistas = FXCollections.observableArrayList();
            for (Artista a : obra.getArtistas().values()) {
                itemsArtistas.add(a);
            }
            tablaArtista.setItems(itemsArtistas);
        } else {
            GestionarObraCuadro.disableProperty().set(true);
            GestionarObraEscultura.disableProperty().set(true);
            GestionarObraInstalacion.disableProperty().set(true);
            botonModificar.disableProperty().set(true);
        }
    }

    private void configurarTablaObra() {
        PropertyValueFactory<Material, String> nombreProperty = new PropertyValueFactory<Material, String>("nombre");
        colNombreMaterial.setCellValueFactory(nombreProperty);

        PropertyValueFactory<Material, Long> codigoProperty = new PropertyValueFactory<Material, Long>("codigo");
        colCodigoMaterial.setCellValueFactory(codigoProperty);

        PropertyValueFactory<Material, String> descripcionProperty = new PropertyValueFactory<Material, String>("descripcion");
        colDescripcionMaterial.setCellValueFactory(descripcionProperty);
    }

    private void configurarTablaArtista() {
        PropertyValueFactory<Artista, String> nombreProperty = new PropertyValueFactory<Artista, String>("nombre");
        colNombreArtista.setCellValueFactory(nombreProperty);

        PropertyValueFactory<Artista, Long> codigoProperty = new PropertyValueFactory<Artista, Long>("codigoArtista");
        colCodigoArtista.setCellValueFactory(codigoProperty);

        PropertyValueFactory<Artista, String> apellidoProperty = new PropertyValueFactory<Artista, String>("apellido");
        colApellidoArtista.setCellValueFactory(apellidoProperty);
    }

    @FXML
    private void NuevaObra(ActionEvent event) {
        ArrayList<Artista> lstArtistaObra = new ArrayList<>();
        configurarTablaObra();
        configurarTablaArtista();
        boolean f = false, e = false;

        try {
            long codigo = Long.parseLong(TextFieldGestionarObraCodigo.getText());
            verificarCodigoRepetido(codigo);
            verificarCodObra(codigo);
            String Titulo = TextFieldGestionarObraTitulo.getText();
            LocalDate fecha = DatePickerGestionarObra.getValue();
            String dimensiones = TextFieldGestionarObraDimensiones.getText();
            float precio = Float.parseFloat(TextFieldGestionarObraPrecio.getText());
            if (ChoiceBoxGestionarObraTipo.getValue().equals("Cuadro")) {
                try {
                    verificarEspeciosCuadro();
                    String tema = (TextFieldTema.getText());
                    String tecnica = TextFieldTecnica.getText();
                    Clasificacion clasificacion = ChoiceBoxClasificacion.getValue();
                    Obra obra = new Cuadro(tema, tecnica, clasificacion, codigo, Titulo, fecha, precio, dimensiones);
                    this.obra = obra;
                } catch (excepcionDatosCuadro ex) {
                    e = true;
                    ex.msjError();
                }

            } else if (ChoiceBoxGestionarObraTipo.getValue().equals("Escultura")) {
                try {
                    verificarEspeciosEscultura();
                    long codiMaterial = Long.parseLong(TextFieldCodigoMaterialEscultura.getText());
                    double peso = Double.parseDouble(TextFieldPesoEscultura.getText());
                    String nombreMaterial = TextFieldMaterialEscultura.getText();
                    String descripcionMatEscultura = TextAreaEscultura.getText();
                    Obra obra = new Escultura(peso, new Material(codiMaterial, nombreMaterial, descripcionMatEscultura), codigo, Titulo, fecha, precio, dimensiones);
                    this.obra = obra;
                } catch (excepcionDatosEscultura ex) {
                    e = true;
                    ex.msjError();
                }

            } else {
                try {
                    verificarEspeciosInstalacion();
                    String descripcionInsta = TextAreaDescripcionInstalacion.getText();
                    Obra obra = new Instalacion(descripcionInsta, materialesNuevaObra, codigo, Titulo, fecha, precio, dimensiones);
                    this.obra = obra;
                } catch (excepcionDatosInstalacion ex) {
                    e = true;
                    ex.msjError();
                }

            }
            servicios.agregarLista(obra);
            for (Artista a : artistasNuevaObra) {
                servicios.asignarArtistaObra(a, obra);
            }
        } catch (InputMismatchException ex) {
            errorTipoDato();
        } catch (excepctionCodigo ex) {
            ex.msjError();
            e = true;
        } catch (exceptionCodigoRepetido ex) {
            ex.msjError();
            e = true;
        } catch (Exception ex) {
            e = true;
            errorTipoDato();
        }
        if (e != true) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Información");
            alert.setHeaderText("Obra agregada");
            alert.setContentText("Obra agregada exitosamente");
            alert.showAndWait();
        }

    }

    @FXML
    private void iniciarCuadro(Event event) {
    }

    @FXML
    private void iniciarEscultura(Event event) {
    }

    private void cerrarModi(Button button) {
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void agregarMaterial(ActionEvent event) {
        Long codigo = Long.parseLong(TextFieldCodigoInstalacion.getText());
        String descripction = TextAreaDescripcionMaterial.getText();
        String nombre = TextFieldNombreInstalacion.getText();
        boolean f = false;
        try {
            veriDatosMaterial();
            if (modificar == true) {
                Instalacion instalacion = (Instalacion) this.obra;
                if (servicios.veriCodMaterial(instalacion.getMaterial(), codigo) == false) {
                    Material material = new Material(codigo, nombre, descripction);
                    ArrayList<Material> lista = instalacion.getMaterial();
                    lista.add(material);
                    instalacion.setMaterial(lista);
                    ObservableList<Material> itemsMaterialesInsta = FXCollections.observableArrayList();
                    for (Material m : instalacion.getMaterial()) {
                        itemsMaterialesInsta.add(m);
                    }
                    tablaMateriales.setItems(itemsMaterialesInsta);

                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Información");
                    alert.setHeaderText("Error al crear material");
                    alert.setContentText("Ya existe un material con este codigo");
                    alert.showAndWait();
                }
            } else {

                if (servicios.veriCodMaterial(materialesNuevaObra, codigo) == false) {
                    Material material = new Material(codigo, nombre, descripction);

                    materialesNuevaObra.add(material);
                    ObservableList<Material> itemsMaterialesInsta = FXCollections.observableArrayList();
                    for (Material m : materialesNuevaObra) {
                        itemsMaterialesInsta.add(m);
                    }
                    tablaMateriales.setItems(itemsMaterialesInsta);
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Información");
                    alert.setHeaderText("Error al crear material");
                    alert.setContentText("Ya existe un material con este codigo");
                    alert.showAndWait();
                }
            }
        } catch (excepcionDatosMaterial ex) {
            ex.msjError();
        }

    }

    @FXML
    private void iniciarInstalacion(Event event) {
    }

    @FXML
    private void agregarArtista(ActionEvent event) {
        long codigo = Long.parseLong(TextFieldCodigoArtista.getText());
        long cedula = Long.parseLong(TextFieldCedulaArtista.getText());
        String nombre = (TextFieldNombreArtista.getText());
        String apellido = (TextFieldApellidoArtista.getText());
        long telefono = Long.parseLong(TextFieldTelefonoArtista.getText());
        LocalDate fecha = DataPickerFechaNacimiento.getValue();
        if (modificar == true) {

            //ChoiceBoxGestionarArtista.getItems().clear();
            if (servicios.buscarArtista(codigo) != null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Información");
                alert.setHeaderText("Error al crear Artista");
                alert.setContentText("Ya existe un artista con este codigo");
                alert.showAndWait();
            } else {
                Artista artista = new Artista(codigo, cedula, nombre, apellido, fecha, telefono);
                servicios.agregarNuevoArtista(artista);
                servicios.asignarArtistaObra(artista, this.obra);
                tablaArtista.setItems(FXCollections.observableArrayList(obra.getArtistas().values()));
                listaArtistas.clear();

                listaArtistas.addAll(servicios.getListaArtistas());
                ObservableList<String> itemsArtistasArt = FXCollections.observableArrayList();

                itemsArtistasArt.clear();
                for (Artista a : listaArtistas) {
                    itemsArtistasArt.add(a.getApellido() + "-" + codigo);
                }
                ChoiceBoxGestionarArtista.getItems().setAll(itemsArtistasArt);

            }
            mostrarDatosArtista(null);
        } else {
            if (servicios.buscarArtista(codigo) != null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Información");
                alert.setHeaderText("Error al crear Artista");
                alert.setContentText("Ya existe un artista con este codigo");
                alert.showAndWait();
            } else {

                Artista artista = new Artista(codigo, cedula, nombre, apellido, fecha, telefono);

                artistasNuevaObra.add(artista);
                tablaArtista.setItems(FXCollections.observableArrayList(artistasNuevaObra));
                listaArtistas.clear();
                servicios.agregarNuevoArtista(artista);
                listaArtistas.addAll(servicios.getListaArtistas());
                ObservableList<String> itemsArtistasArt = FXCollections.observableArrayList();

                itemsArtistasArt.clear();
                for (Artista a : listaArtistas) {
                    itemsArtistasArt.add(a.getApellido() + "-" + codigo);
                }

                ChoiceBoxGestionarArtista.getItems().setAll(itemsArtistasArt);

            }
            mostrarDatosArtista(null);
        }
    }

    @FXML
    private void iniciarNuevoArtista(Event event) {
    }

    @FXML
    private void nuevoArtista(ActionEvent event) {
        if (modificar == true) {
            int index = ChoiceBoxGestionarArtista.getSelectionModel().selectedIndexProperty().get();
            if (index == -1) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Información");
                alert.setHeaderText("Error al seleccionar el Artista");
                alert.setContentText("Debe seleccionar un Artista para agregarlo a la obra ");
                alert.showAndWait();
            } else {
                Artista artista = servicios.buscarArtista(listaArtistas.get(index).getCodigoArtista());
                servicios.asignarArtistaObra(artista, this.obra);
                tablaArtista.setItems(FXCollections.observableArrayList(obra.getArtistas().values()));
            }
        } else {
            int index = ChoiceBoxGestionarArtista.getSelectionModel().selectedIndexProperty().get();

            if (index == -1) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Información");
                alert.setHeaderText("Error al seleccionar el Artista");
                alert.setContentText("Debe seleccionar un Artista para agregarlo a la obra ");
                alert.showAndWait();
            } else {
                Artista artista = servicios.buscarArtista(listaArtistas.get(index).getCodigoArtista());
                artistasNuevaObra.add(artista);
                tablaArtista.setItems(FXCollections.observableArrayList(artistasNuevaObra));
            }
        }

    }

    @FXML
    private void modificarObra(ActionEvent event) {
        long codigo = Long.parseLong(TextFieldGestionarObraCodigo.getText());
        String titulo = (TextFieldGestionarObraTitulo.getText());
        LocalDate fecha = DatePickerGestionarObra.getValue();
        String dimensiones = (TextFieldGestionarObraDimensiones.getText());
        float precio = Float.parseFloat(TextFieldGestionarObraPrecio.getText());
        boolean f = false, e = false;
        try {
            //verificarCodigoRepetido(codigo);
            verificarCodObra(codigo);

            if (this.obra.getTipo().equals("Cuadro")) {

                try {
                    verificarEspeciosCuadroModi();
                    String tema = (TextFieldTema.getText());
                    String tecnica = TextFieldTecnica.getText();
                    Clasificacion clasificacion = ChoiceBoxClasificacion.getValue();
                    if (servicios.modificaCuadro(this.obra.getCodigoObra(), codigo, titulo, fecha, dimensiones, precio, tema, tecnica, clasificacion) == false) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Información");
                        alert.setHeaderText("Error al modificar");
                        alert.setContentText("Codigo ya usado");
                        alert.showAndWait();
                        e = true;
                    }
                } catch (excepcionDatosCuadroModi ex) {
                    ex.msjError();
                    e = true;
                }

            } else if (this.obra.getTipo().equals("Escultura")) {
                try {
                    verificarEspeciosEscultuModi();
                    long codiMaterial = Long.parseLong(TextFieldCodigoMaterialEscultura.getText());
                    double peso = Double.parseDouble(TextFieldPesoEscultura.getText());
                    String nombreMaterial = TextFieldMaterialEscultura.getText();
                    String descripcionMatEscultura = TextAreaEscultura.getText();
                    if (servicios.modificaEscultura(this.obra.getCodigoObra(), codigo, titulo, fecha, dimensiones, precio, codiMaterial, peso, nombreMaterial, descripcionMatEscultura) == false) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Información");
                        alert.setHeaderText("Error al modificar");
                        alert.setContentText("Codigo ya usado");
                        alert.showAndWait();
                        e = true;
                    }
                } catch (excepcionDatosEsculturaModi rx) {
                    rx.msjError();
                    e = true;
                }

            } else {
                try {
                    verificarEspeciosInstaModi();
                    String descripcionInsta = TextAreaDescripcionInstalacion.getText();
                    if (servicios.modificaInstalacion(this.obra.getCodigoObra(), codigo, titulo, fecha, dimensiones, precio, descripcionInsta) == false) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Información");
                        alert.setHeaderText("Error al modificar");
                        alert.setContentText("Codigo ya usado");
                        alert.showAndWait();
                        e = true;
                    }

                } catch (excepcionDatosInstaModi ex) {
                    ex.msjError();
                }
            }

        } catch (InputMismatchException ex) {
            //errorTipoDato();
        } catch (excepctionCodigo ex) {
            ex.msjError();
            e = true;
        } catch (Exception ex) {
            e = true;
            errorTipoDato();
        }

        if (e != true) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Información");
            alert.setHeaderText("Modificacion exitosa");
            alert.setContentText("Su obra ha sido modificada exitosamente");
            alert.showAndWait();
        }
    }

    @FXML
    private void volver(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuFXMLDocument.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Galeria MariaVader.jpg!");
        stage.getIcons().add(new Image("file:IconoGaleria.png"));
        stage.show();
        cerrarModi(botonVolver);

    }

    public void elegirTipo(String tipo) {
        if (tipo == "Cuadro") {
            GestionarObraCuadro.disableProperty().set(false);
            GestionarObraEscultura.disableProperty().set(true);
            GestionarObraInstalacion.disableProperty().set(true);
        } else if (tipo == "Escultura") {
            GestionarObraEscultura.disableProperty().set(false);
            GestionarObraCuadro.disableProperty().set(true);
            GestionarObraInstalacion.disableProperty().set(true);
        } else if (tipo == "Instalacion") {
            GestionarObraInstalacion.disableProperty().set(false);
            GestionarObraCuadro.disableProperty().set(true);
            GestionarObraEscultura.disableProperty().set(true);
        }
    }

    private void errorTipoDato() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText("Error al ingresar los datos");
        alert.setContentText("Debe ingresar solo numeros en ciertos valores");
        alert.showAndWait();
    }

    private void mostrarDatosArtista(Artista artista) {
        if (artista != null) {
            TextFieldCodigoArtista.setText(String.valueOf(artista.getCodigoArtista()));
            TextFieldCedulaArtista.setText(String.valueOf(artista.getCedula()));
            TextFieldNombreArtista.setText(artista.getNombre());
            TextFieldApellidoArtista.setText(artista.getApellido());
            TextFieldTelefonoArtista.setText(String.valueOf(artista.getTelefono()));
            DataPickerFechaNacimiento.setValue(artista.getFechaNacimiento());
        } else {
            TextFieldCodigoArtista.setText("");
            TextFieldCedulaArtista.setText("");
            TextFieldNombreArtista.setText("");
            TextFieldApellidoArtista.setText("");
            TextFieldTelefonoArtista.setText("");
            DataPickerFechaNacimiento.setValue(LocalDate.now());
        }
    }

    private void mostrarDatosMaterial(Material material) {
        if (material != null) {
            TextFieldCodigoInstalacion.setText(String.valueOf(material.getCodigo()));
            TextFieldNombreInstalacion.setText(material.getNombre());
            TextAreaDescripcionMaterial.setText(material.getDescripcion());
        } else {
            TextFieldCodigoInstalacion.setText(String.valueOf(material.getCodigo()));
            TextFieldNombreInstalacion.setText(material.getNombre());
            TextAreaDescripcionMaterial.setText(material.getDescripcion());
        }
    }

    private void verificarCodObra(long a) throws excepctionCodigo {
        if (!(a <= 9999999 && a >= 1000000)) {
            throw new excepctionCodigo(a);
        }
    }

    private void verificarCodigoRepetido(long a) throws exceptionCodigoRepetido {
        if (servicios.encontrarObra(a) != null) {
            throw new exceptionCodigoRepetido();
        }
    }

    private void verificarEspeciosCuadro() throws excepcionDatosCuadro {
        if (TextFieldGestionarObraCodigo.getText().equals("") || TextFieldGestionarObraTitulo.getText().equals("") || DatePickerGestionarObra.getValue().equals("")
                || TextFieldGestionarObraDimensiones.getText().equals("") || TextFieldGestionarObraPrecio.getText().equals("") || ChoiceBoxGestionarObraTipo.equals("") || TextFieldTema.getText().equals("") || TextFieldTecnica.getText().equals("") || ChoiceBoxClasificacion.getValue().equals("") || artistasNuevaObra.isEmpty()) {
            throw new excepcionDatosCuadro();
        }
    }

    private void verificarEspeciosEscultura() throws excepcionDatosEscultura {
        if (TextFieldGestionarObraCodigo.getText().equals("") || TextFieldGestionarObraTitulo.getText().equals("") || DatePickerGestionarObra.getValue().equals("")
                || TextFieldGestionarObraPrecio.getText().equals("") || TextFieldGestionarObraDimensiones.getText().equals("") || artistasNuevaObra.isEmpty() || TextFieldCodigoMaterialEscultura.getText().equals("") || TextFieldPesoEscultura.getText().equals("") || TextFieldMaterialEscultura.getText().equals("") || TextAreaEscultura.getText().equals("")) {
            throw new excepcionDatosEscultura();
        }
    }

    private void verificarEspeciosInstalacion() throws excepcionDatosInstalacion {
        if (TextFieldGestionarObraCodigo.getText().equals("") || TextFieldGestionarObraTitulo.getText().equals("") || DatePickerGestionarObra.getValue().equals("")
                || TextFieldGestionarObraPrecio.getText().equals("") || TextFieldGestionarObraDimensiones.getText().equals("") || artistasNuevaObra.isEmpty() || TextAreaDescripcionInstalacion.getText().equals("") || materialesNuevaObra.isEmpty()) {
            throw new excepcionDatosInstalacion();
        }
    }

    private void veriDatosMaterial() throws excepcionDatosMaterial {
        if (TextFieldCodigoInstalacion.getText().equals("") || TextAreaDescripcionMaterial.getText().equals("") || TextFieldNombreInstalacion.getText().equals("")) {
            throw new excepcionDatosMaterial();
        }
    }

    private void verificarEspeciosCuadroModi() throws excepcionDatosCuadroModi {
        if (TextFieldGestionarObraCodigo.getText().equals("") || TextFieldGestionarObraTitulo.getText().equals("") || DatePickerGestionarObra.getValue().equals("")
                || TextFieldGestionarObraDimensiones.getText().equals("") || TextFieldGestionarObraPrecio.getText().equals("") || ChoiceBoxGestionarObraTipo.equals("") || TextFieldTema.getText().equals("") || TextFieldTecnica.getText().equals("") || ChoiceBoxClasificacion.getValue().equals("")) {
            throw new excepcionDatosCuadroModi();
        }
    }

    private void verificarEspeciosEscultuModi() throws excepcionDatosEsculturaModi {
        if (TextFieldGestionarObraCodigo.getText().equals("") || TextFieldGestionarObraTitulo.getText().equals("") || DatePickerGestionarObra.getValue().equals("")
                || TextFieldGestionarObraPrecio.getText().equals("") || TextFieldGestionarObraDimensiones.getText().equals("") || TextFieldCodigoMaterialEscultura.getText().equals("") || TextFieldPesoEscultura.getText().equals("") || TextFieldMaterialEscultura.getText().equals("") || TextAreaEscultura.getText().equals("")) {
            throw new excepcionDatosEsculturaModi();
        }
    }

    private void verificarEspeciosInstaModi() throws excepcionDatosInstaModi {
        if (TextFieldGestionarObraCodigo.getText().equals("") || TextFieldGestionarObraTitulo.getText().equals("") || DatePickerGestionarObra.getValue().equals("")
                || TextFieldGestionarObraPrecio.getText().equals("") || TextFieldGestionarObraDimensiones.getText().equals("") || TextAreaDescripcionInstalacion.getText().equals("")) {
            throw new excepcionDatosInstaModi();
        }
    }
}
