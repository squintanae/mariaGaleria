/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidades.ArchivoArtistas;
import Entidades.ArchivoClientes;
import Entidades.ArchivoCompras;
import Entidades.ArchivoObras;
import Entidades.Artista;
import Entidades.Cliente;
import Entidades.Compra;
import Entidades.Cuadro;
import Entidades.Escultura;
import Entidades.Instalacion;
import Entidades.Material;
import Entidades.Obra;
import Enumeraciones.Clasificacion;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import javax.xml.bind.JAXB;

/**
 *
 * @author Hp
 */
public class ControlGaleria implements IControlGaleria{
    private Map<Long, Obra> listaObras;
    private Map<Long,Artista> listaArtistas;
    private Map<Long,Compra> listaCompras;
    private Map<Long,Cliente> listaClientes;
    
//    private static final String FILE_NAME_OBRASXML = "E:\\Proyecto_Poo_Final\\Proyecto_Poo\\test\\Obras.xml";
//    private static final String FILE_NAME_CLIENTESXML = "E:\\Proyecto_Poo_Final\\Proyecto_Poo\\test\\Clientes.xml";
//    private static final String FILE_NAME_ARTISTASXML = "E:\\Proyecto_Poo_Final\\Proyecto_Poo\\test\\Artistas.xml";
//    private static final String FILE_NAME_COMPRASXML = "E:\\Proyecto_Poo_Final\\Proyecto_Poo\\test\\Compras.xml";
    
    public static ControlGaleria control;
    private final GestionObras gestionObras;
    private final GestionClientes gestionCliente;

    private ControlGaleria(){
        this.gestionObras = new GestionObras();
        this.gestionCliente = new GestionClientes();
        this.listaObras = gestionObras.crearObras(); //Cargar obras
        this.listaArtistas = gestionObras.crearArtista(); //Cargar artistas
        this.listaCompras = new TreeMap<>();
        this.listaClientes = gestionCliente.crearClientes(); //Cargar lista de clientes
        
//        leerObrasXML();
//        leerClientesXML();
//        leerArtistasXML();
//        leerComprasXML();
         iniciarRelaciones();
    }
    
    public static ControlGaleria getInstance(){
        if (control == null) {
            control = new ControlGaleria();
        }
        return control;
    }
    
   private void iniciarRelaciones() {
        LocalDate fecha = LocalDate.of(2010, Month.JUNE, 14);
        
        asignarArtistaObra(listaArtistas.get((long)1001), listaObras.get((long)2000001));

        asignarArtistaObra(listaArtistas.get((long)1001), listaObras.get((long)2000001));
        asignarArtistaObra(listaArtistas.get((long)1001), listaObras.get((long)2000002));
        
        asignarArtistaObra(listaArtistas.get((long)1002), listaObras.get((long)2000000));
        asignarArtistaObra(listaArtistas.get((long)1002), listaObras.get((long)2000001));
        asignarArtistaObra(listaArtistas.get((long)1002), listaObras.get((long)2000002));
        asignarArtistaObra(listaArtistas.get((long)1002), listaObras.get((long)2000003));

        asignarArtistaObra(listaArtistas.get((long)1003), listaObras.get((long)2000003));
        asignarArtistaObra(listaArtistas.get((long)1003), listaObras.get((long)2000004));
        
        asignarArtistaObra(listaArtistas.get((long)1004), listaObras.get((long)2000005));
        
        
        asignarArtistaObra(listaArtistas.get((long)1005), listaObras.get((long)2000006));
        asignarArtistaObra(listaArtistas.get((long)1005), listaObras.get((long)2000007));
        
        asignarArtistaObra(listaArtistas.get((long)1006), listaObras.get((long)2000009));
        
        asignarArtistaObra(listaArtistas.get((long)1007), listaObras.get((long)2000010));
        
        long x=2000000;
        for (int i = 0; i < 7; i++,x++) {
            
            nuevaCompra(listaObras.get((long)x), listaClientes.get((long)3000), fecha);
        }
        nuevaCompra(listaObras.get((long)2000015), listaClientes.get((long)4000), fecha);
        nuevaCompra(listaObras.get((long)2000021), listaClientes.get((long)5000), fecha);
        
    }
   
//    private void leerObrasXML() {
//        ArrayList<Obra> obras = new ArrayList<>();
//        try ( BufferedReader input = Files.newBufferedReader(Paths.get(FILE_NAME_OBRASXML))) {
//            ArchivoObras registrosObras = JAXB.unmarshal(input, ArchivoObras.class);
//            obras = registrosObras.getRegistros();
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        }
//        for(Obra o : obras){
//            this.listaObras.put(o.getCodigoObra(),o);
//        }
//    }
//    
//    private void leerClientesXML() {
//        ArrayList<Cliente> clientes = new ArrayList<>();
//        try ( BufferedReader input = Files.newBufferedReader(Paths.get(FILE_NAME_CLIENTESXML))) {
//            ArchivoClientes registrosClientes = JAXB.unmarshal(input, ArchivoClientes.class);
//            clientes = registrosClientes.getRegistros();
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        }
//        for(Cliente c : clientes){
//            this.listaClientes.put(c.getCodigoCliente(),c);
//        }
//    }
//    
//    private void leerArtistasXML() {
//        ArrayList<Artista> artistas = new ArrayList<>();
//        try (BufferedReader input = Files.newBufferedReader(Paths.get(FILE_NAME_ARTISTASXML))) {
//            ArchivoArtistas registrosArtistas = JAXB.unmarshal(input, ArchivoArtistas.class);
//            artistas=registrosArtistas.getRegistros();
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        }
//        for(Artista a : artistas){
//            this.listaArtistas.put(a.getCodigoArtista(),a);
//        }
//    }
//    
//    private void leerComprasXML() {
//        ArrayList<Compra> compras = new ArrayList<>();
//        try (BufferedReader input = Files.newBufferedReader(Paths.get(FILE_NAME_COMPRASXML))) {
//            ArchivoCompras registrosCompras = JAXB.unmarshal(input, ArchivoCompras.class);
//            compras=registrosCompras.getRegistros();
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        }
//        for(Compra comp : compras){
//            this.listaCompras.put(comp.getCodigoCompra(),comp);
//        }
//    }
//    
//    @Override
//    public boolean persistirXMLObras() {
//        ArchivoObras registros = new ArchivoObras(getListaObras());
//        try ( BufferedWriter output
//                = Files.newBufferedWriter(Paths.get(FILE_NAME_OBRASXML))) {
//            JAXB.marshal(registros, output);
//            return true;
//        } catch (IOException ex) {
//            ex.printStackTrace();
//            return false;
//        }
//    }
//    
//    @Override
//    public boolean persistirXMLCompras() {
//        ArchivoCompras registros = new ArchivoCompras(getListaCompras());
//        try ( BufferedWriter output
//                = Files.newBufferedWriter(Paths.get(FILE_NAME_COMPRASXML))) {
//            JAXB.marshal(registros, output);
//            return true;
//        } catch (IOException ex) {
//            ex.printStackTrace();
//            return false;
//        }
//    }
//    
//    @Override
//    public boolean persistirXMLClientes() {
//        ArchivoClientes registros = new ArchivoClientes(getListaClientes());
//        try ( BufferedWriter output
//                = Files.newBufferedWriter(Paths.get(FILE_NAME_CLIENTESXML))) {
//            JAXB.marshal(registros, output);
//            return true;
//        } catch (IOException ex) {
//            ex.printStackTrace();
//            return false;
//        }
//    }
//    
//    @Override
//    public boolean persistirXMLArtistas() {
//        ArchivoArtistas registros = new ArchivoArtistas(getListaArtistas());
//        try ( BufferedWriter output
//                = Files.newBufferedWriter(Paths.get(FILE_NAME_ARTISTASXML))) {
//            JAXB.marshal(registros, output);
//            return true;
//        } catch (IOException ex) {
//            ex.printStackTrace();
//            return false;
//        }
//    }
    
    @Override
    public Obra buscarObra(String titulo) {
        for (Obra obra : listaObras.values()) {
            if (obra.getTitulo().equals(titulo)) {
                return obra;
            }
        }
        return null;
    }

    @Override
    public Map<Long, Obra> buscarObra(int anio) {
        Map<Long,Obra> resultados = new TreeMap<>();
        for (Obra obra : listaObras.values()) {
            if (anio == obra.getFecha().getYear()) {
                resultados.put(obra.getCodigoObra(),obra);
            }
        }
        if(resultados.isEmpty()){
            return null;
        }
        return resultados;
    }

    @Override
    public Map<Long, Obra> buscarObraArtista(long cod) {
        for (Artista artista : listaArtistas.values()) {
            if (artista.getCodigoArtista()== cod) {
                return artista.getObras();
            }
        }
        return null;
    }

    @Override
    public Artista buscarArtista(long cod) {
       return listaArtistas.get(cod);
    }

    @Override
    public Obra encontrarObra(long codigo) {
        return listaObras.get(codigo);
    }

    @Override
    public Cliente buscarCliente(long codigo) {
        for (Cliente cliente : listaClientes.values()) {
            if (cliente.getCodigoCliente() == codigo) {
                return cliente;
            }
        }
        return null;
    }

    @Override
    public void asignarArtistaObra(Artista artista, Obra obra) {
        if(artista == null || obra ==null){
            return;
        }
        Artista artist = buscarArtista(artista.getCodigoArtista());
        Obra obr = encontrarObra(obra.getCodigoObra());
        if (artist != null && obr != null) {
            if (!artista.verificarObra(obra) && !obra.verificarArtista(artista)) {
                artista.agregarObra(obra.getCodigoObra(), obra);
                obra.asignarArtista(artista.getCodigoArtista(), artista);
            }
        }
        return;
    }

    @Override
    public void asignarNuevaObra(Artista artista, Obra obra) {
        Artista artist = buscarArtista(artista.getCodigoArtista());
        Obra obr = encontrarObra(obra.getCodigoObra());
        if (artist != null && obr == null) {
            listaObras.put(obra.getCodigoObra(), obra);
            asignarArtistaObra(artista, obra);
        }
    }

    @Override
    public void agregarNuevoArtista(Artista artista) {
         if (listaArtistas.get(artista.getCodigoArtista()) == null) {
            listaArtistas.put(artista.getCodigoArtista(), artista);
        }
    }

    @Override
    public boolean agregarNuevoCliente(Cliente cliente) {
        Cliente cli = buscarCliente(cliente.getCodigoCliente());
        if (cli == null) {
            listaClientes.put(cliente.getCodigoCliente(), cliente);
            return true;
        }
        return false;
    }

    @Override
    public Compra nuevaCompra(Obra obra, Cliente cliente, LocalDate fecha) {
        Obra ob = encontrarObra(obra.getCodigoObra());
        Cliente cli = buscarCliente(cliente.getCodigoCliente());
        if(ob == null || cli == null){
            return null;
        }
        Compra compra = new Compra();
        if (verificarRelacionCompra(obra, cliente)) {
            return null;
        } else {
            compra.asignarClienteObra(cliente, obra);
            compra.setCodigoCompra(generarCodigoCompra());
            compra.setFecha(fecha);
            listaCompras.put(compra.getCodigoCompra(), compra);
            return compra;
        }
    }

    @Override
    public boolean verificarRelacionCompra(Obra obra, Cliente cliente) {
        if (listaCompras.size() == 0) {
            return false;
        } else {
            for (Compra compra : listaCompras.values()) {
                if (compra.relacionClienteObra(cliente, obra)) {
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    public long generarCodigoCompra() {
        int posicion = -1;
        if (listaCompras.isEmpty()) {
            return 4001;
        } else {
            return listaCompras.size() +4001;
        }
    }

    @Override
    public Map<Long, Obra> obrasDisponibles() {
        Map<Long,Obra> lstObrasDisponibles = new TreeMap<>();
        for (Obra obra : listaObras.values()) {
            lstObrasDisponibles.put(obra.getCodigoObra(), obra);
        }
        
        for (Compra compra : listaCompras.values()) {
            if (existeListObraCompra(lstObrasDisponibles, compra)) {
                lstObrasDisponibles.remove(compra.getCompraObra().getCodigoObra());
            }
        }
        return lstObrasDisponibles;
    }

    @Override
    public boolean existeListObraCompra(Map<Long, Obra> obras, Compra compra) {
        if(obras.get(compra.getCompraObra().getCodigoObra()) != null){
            return true;
        }
        return false;
    }

    @Override
    public Map<Long, Compra> busqAnioMes(int mes, int anio) {
        int mesCompra, anioCompra;
        Map<Long,Compra> comprasEsp = new TreeMap<>();
        for (Compra compra : listaCompras.values()) {
            mesCompra = compra.getFecha().getMonthValue();
            anioCompra = compra.getFecha().getYear();
            if (mesCompra == mes && anioCompra == anio) {
                comprasEsp.put(compra.getCodigoCompra(), compra);
            }
        }
        return comprasEsp;}

    @Override
    public ArrayList<Artista> artistasTOP() {
        Map<Long,Artista> lstTOP = new TreeMap<>();
        Map<Long, Artista> artistasAux = new TreeMap<>();
        Map<Long, Integer> lstTotal = new TreeMap<>();
        int auxInt = 0;
        Artista aux = new Artista();
        Artista auxM = new Artista();
        int pos = 0;
        int suma = 1;
        int aumento;
        //Busca los artistas con compras
        for (Compra compra : listaCompras.values()) {        
            artistasAux = compra.getCompraObra().getArtistas();
            for (Artista art : artistasAux.values()) {
                if (!(listaArtistaVerificar(lstTOP, art.getCodigoArtista())) ) {
                    lstTOP.put(art.getCodigoArtista(), art);
                    lstTotal.put(art.getCodigoArtista(),(int)1);
                } else {
                    lstTotal.replace(art.getCodigoArtista(), lstTotal.get(art.getCodigoArtista()), lstTotal.get(art.getCodigoArtista())+1);
                }
            }
        }
        ArrayList<Artista> artF = new ArrayList<>();
        ArrayList<Integer> valF = new ArrayList<>();
        for(Artista artt : lstTOP.values()){ 
            artF.add(artt);
            valF.add(lstTotal.get(artt.getCodigoArtista()));
        }
        //Organiza los artistas segun las ventas (mayor - menor)
        for (int i = 0; i < valF.size(); i++) {
            for (int j = i + 1; j < valF.size(); j++) {
                if (valF.get(i) < valF.get(j)) {
                    auxInt = valF.get(j);
                    valF.set(j, valF.get(i));
                    valF.set(i, auxInt);
                    aux = artF.get(j);
                    artF.set(j, artF.get(i));
                    artF.set(i, aux);
                }
            }
        }
        return artF;
    }

    @Override
    public boolean listaArtistaVerificar(Map<Long, Artista> lstArtistas, long codigo) {
        return lstArtistas.containsKey(codigo);
    }

    @Override
    public Compra buscarCompra(long codigo) {
        return listaCompras.get(codigo);
    }

    @Override
    public void borrarCompra(long codigo) {
        listaCompras.remove(codigo);
    }

    @Override
    public boolean borrarCliente(long codigo) {
        Cliente cliente = buscarCliente(codigo);
        
        for (Compra compra : listaCompras.values()) {
            if (compra.getCompraCliente().equals(cliente)) {
                return false;
            }
        }
        listaClientes.remove(codigo);
        return true;
    }

    @Override
    public boolean borrarObra(long codigo) {
        Obra obra = encontrarObra(codigo);
        for (Compra compra : listaCompras.values()) {
            if (compra.getCompraObra().equals(obra)) {
                return false;
            }
        }
        for (Artista artist : obra.getArtistas().values()) {
            artist.getObras().remove(obra.getCodigoObra());
        }
        listaObras.remove(obra.getCodigoObra());
        return true;
    }

    @Override
    public ArrayList<Escultura> lstEscultura() {
        ArrayList<Escultura> lst = new ArrayList<>(); 
        for(Obra obra: listaObras.values()){
            if(obra instanceof Escultura){
                Escultura esc = (Escultura)obra;
                lst.add(esc);
            }
        }
        return lst;
    }
    
    @Override
    public ArrayList<Cuadro> lstCuadro() {
        ArrayList<Cuadro> lst = new ArrayList<>(); 
        for(Obra obra: listaObras.values()){
            if(obra instanceof Cuadro){
                Cuadro esc = (Cuadro)obra;
                lst.add(esc);
            }
        }
        return lst;
    }
    
    @Override
    public ArrayList<Instalacion> lstInstalacion() {
        ArrayList<Instalacion> lst = new ArrayList<>(); 
        for(Obra obra: listaObras.values()){
            if(obra instanceof Instalacion){
                Instalacion esc = (Instalacion)obra;
                lst.add(esc);
            }
        }
        return lst;
    }
    
    

    @Override
    public ArrayList<Compra> lstComprasCuadro() {
        ArrayList<Compra> lst = new ArrayList<>(); 
        for(Compra compra: listaCompras.values()){
            if(compra.getCompraObra() instanceof Cuadro){
                lst.add(compra);
            }
        }
        return lst;
    }
    
    

    @Override
    public float gananciaTotal() {
        float total=0;
        for(Compra compra: listaCompras.values()){
            total+=compra.getCompraObra().CalcularPrecio();
        }
        return total;
    }

    @Override
    public void cambiarClasi(Cuadro cuadri) {
        if( listaObras.get(cuadri.getCodigoObra()) != null){
                if(cuadri.getClasificacion() == Clasificacion.OBRA_MAESTRA){
                    cuadri.setClasificacion(Clasificacion.OBRA_REPRESENTATIVA);
                }else{
                    cuadri.setClasificacion(Clasificacion.OBRA_MAESTRA);
                }
        }
    }

    @Override
    public Material valiLst(Instalacion insta, long codiM) {
        if( listaObras.get(insta.getCodigoObra()) != null){
            for(Material mat : insta.getMaterial()){
                if(mat.getCodigo() == codiM){
                    return mat;
                }
            }
            return null;
        }
        return null;
    }

    @Override
    public boolean veriCodMaterial(ArrayList<Material> lst, long codigo) {
        if(lst == null || lst.isEmpty()){
            return false;
        }
        for(Material mat: lst){
            if(mat.getCodigo()== codigo){
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<Obra> getListaObrasDisponibles() {
        ArrayList<Obra> obras = new ArrayList<>();
        for(Obra o : obrasDisponibles().values()){
            obras.add(o);
        }
        return obras;
    }
    
    @Override
    public ArrayList<Obra> getListaObras() {
        ArrayList<Obra> obras = new ArrayList<>();
        for(Obra o : listaObras.values()){
            obras.add(o);
        }
        return obras;
    }

    @Override
    public ArrayList<Cliente> getListaClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        for(Cliente c : listaClientes.values()){
            clientes.add(c);
        }
        return clientes;
    }

    @Override
    public ArrayList<Artista> getListaArtistas() {
        ArrayList<Artista> arts = new ArrayList<>();
        for(Artista a : listaArtistas.values()){
            arts.add(a);
        }
        return arts;
    }

    @Override
    public ArrayList<Compra> getListaCompras() {
        ArrayList<Compra> cmprs = new ArrayList<>();
        for(Compra c : listaCompras.values()){
            cmprs.add(c);
        }
        return cmprs;
    }
    
    @Override
    public boolean modificarCliente(long codigo, long cedula, String nombre, String Apellido, String dirreccion, long telefono){
        Cliente cliente = buscarCliente(codigo);
        if(cliente == null){
            return false;
        }
        cliente.setCedula(cedula);
        cliente.setNombre(nombre);
        cliente.setApellidos(Apellido);
        cliente.setDireccionEntrega(dirreccion);
        cliente.setTelefono(telefono);
        return true;
    }
    
    
    @Override
    public Map<Long, Artista> mapaArregloObra (ArrayList<Artista>lista){
        Map<Long, Artista> mapita = new TreeMap<>();
        for(Artista a: lista){
            mapita.put(a.getCodigoArtista(), a);
        }
        return mapita;
    }
    
    
    @Override
    public void agregarLista(Obra obra){
        System.out.println("ANTES DE");
        listaObras.put(obra.getCodigoObra(), obra);
        System.out.println("DESPUES DE");
        
    }
    
    @Override
    public boolean modificaCuadro (long codigo, long nCodigo, String titulo, LocalDate fecha, String dimension ,float precio, String tema,String tecnica, Clasificacion clasificacion ){
        Obra obra = encontrarObra(codigo) ;
        if(obra==null ){
            return false;
        }else{
            Cuadro cuadro = (Cuadro)obra;
            cuadro.setCodigoObra(nCodigo);
            cuadro.setTitulo(titulo);
            cuadro.setFecha(fecha);
            cuadro.setDimensiones(dimension);
            cuadro.setPrecioRef(precio);
            cuadro.setTecnica(tecnica);
            cuadro.setTema(tema);
            cuadro.setClasificacion(clasificacion);
            
            return true;
        }
    }
    @Override
    public boolean modificaEscultura(long codigo, long nCodigo, String titulo, LocalDate fecha, String dimension ,float precio, long codiMaterial,double peso , String nombreMaterial, String descriMaterial  ){
        Obra obra = encontrarObra(codigo) ;
        if(obra==null ){
            return false;
        }else{
            Escultura escultura = (Escultura)obra;
            escultura.setCodigoObra(nCodigo);
            escultura.setTitulo(titulo);
            escultura.setFecha(fecha);
            escultura.setDimensiones(dimension);
            escultura.setPrecioRef(precio);
            escultura.setPeso(peso);
            escultura.getTipoMaterial().setCodigo(codigo);
            escultura.getTipoMaterial().setNombre(nombreMaterial);
            escultura.getTipoMaterial().setDescripcion(descriMaterial);
            return true;
        }
    }
    
    @Override
    public boolean modificaInstalacion(long codigo, long nCodigo, String titulo, LocalDate fecha, String dimension ,float precio, String descri  ){
        Obra obra = encontrarObra(codigo) ;
        if(obra==null ){
            return false;
        }else{
            Instalacion instalacion = (Instalacion)obra;
            instalacion.setCodigoObra(nCodigo);
            instalacion.setTitulo(titulo);
            instalacion.setFecha(fecha);
            instalacion.setDimensiones(dimension);
            instalacion.setPrecioRef(precio);
            instalacion.setDescripcion(descri);
            
            return true;
        }
    }
    
}
