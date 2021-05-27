/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidades.Artista;
import Entidades.Cliente;
import Entidades.Compra;
import Entidades.Cuadro;
import Entidades.Escultura;
import Entidades.Instalacion;
import Entidades.Material;
import Entidades.Obra;
import Enumeraciones.Clasificacion;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;


/**
 *
 * @author Hp
 */
public interface IControlGaleria {
//    public boolean persistirXMLCompras();
//    public boolean persistirXMLObras();
//    public boolean persistirXMLClientes();
//    public boolean persistirXMLArtistas();         
            
    Obra buscarObra(String titulo);

    Map<Long,Obra> buscarObra(int anio);

    Map<Long, Obra> buscarObraArtista(long cod);

    Artista buscarArtista(long cod);

    Obra encontrarObra(long codigo);
    
    Cliente buscarCliente(long codigo);
    
    void asignarArtistaObra(Artista artista, Obra obra);

    void asignarNuevaObra(Artista artista, Obra obra);

    void agregarNuevoArtista(Artista artista);

    boolean agregarNuevoCliente(Cliente cliente);

    public Compra nuevaCompra(Obra obra, Cliente cliente, LocalDate fecha);    
    
    boolean verificarRelacionCompra(Obra obra, Cliente cliente);

    long generarCodigoCompra();

    Map<Long,Obra> obrasDisponibles();

    boolean existeListObraCompra(Map<Long,Obra> obras, Compra compra);

    Map<Long,Compra> busqAnioMes(int mes, int anio);

    ArrayList<Artista> artistasTOP();

    boolean listaArtistaVerificar(Map<Long,Artista> lstArtistas, long codigo);

    Compra buscarCompra(long codigo);

    void borrarCompra(long codigo);

    boolean borrarCliente(long codigo);
    
    boolean borrarObra(long codigo);
    
    ArrayList<Escultura> lstEscultura();
    
    ArrayList<Cuadro> lstCuadro();
    
    ArrayList<Instalacion> lstInstalacion();
    
    ArrayList<Compra> lstComprasCuadro();
    
    float gananciaTotal();
    
    void cambiarClasi(Cuadro cuadri);
    
    Material valiLst(Instalacion insta, long codiM);
    
    boolean veriCodMaterial(ArrayList<Material> lst, long codigo);
    
    ArrayList<Obra> getListaObrasDisponibles();
    
    ArrayList<Obra> getListaObras();
    
    ArrayList<Cliente> getListaClientes();
    
    ArrayList<Artista> getListaArtistas();
    
    ArrayList<Compra> getListaCompras();
    
    boolean modificarCliente(long codigo, long cedula, String nombre, String Apellido, String dirreccion, long telefono);

    boolean modificaCuadro (long codigo, long nCodigo, String titulo, LocalDate fecha, String dimension ,float precio, String tema,String tecnica, Clasificacion clasificacion );

    boolean modificaEscultura(long codigo, long nCodigo, String titulo, LocalDate fecha, String dimension ,float precio, long codiMaterial,double peso , String nombreMaterial, String descriMaterial  );

    boolean modificaInstalacion(long codigo, long nCodigo, String titulo, LocalDate fecha, String dimension ,float precio, String descri  );
    
    Map<Long, Artista> mapaArregloObra (ArrayList<Artista>lista);
    
     public void agregarLista(Obra obra);
}
