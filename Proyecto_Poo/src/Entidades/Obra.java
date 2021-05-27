package Entidades;

import Control.LocalDateAdapter;
import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * PROYECTO POO Sistema de Control de una GalerÍa de Arte
 *
 * Autores
 *
 * JANET CHEN HE 
 * MARIA JOSE NIÑO RODRIGUEZ 
 * DAVID SANTIAGO QUINTANA ECHAVARRIA
 *
 */
public abstract class Obra {

    protected long codigoObra;
    protected String titulo;
    protected LocalDate fecha;
    protected float precioRef;
    protected String dimensiones;
    protected Map<Long, Artista> artistas;
    protected String tipo;

    public Obra() {
        this.artistas = new TreeMap<>();
    }

    public Obra(long codigoObra, String titulo, LocalDate fecha, float precioRef, String dimensiones) {
        this.codigoObra = codigoObra;
        this.titulo = titulo;
        this.fecha = fecha;
        this.precioRef = precioRef;
        this.dimensiones = dimensiones;
        this.artistas = new TreeMap<>();
    }

    public long getCodigoObra() {
        return codigoObra;
    }

    public void setCodigoObra(long codigoObra) {
        this.codigoObra = codigoObra;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public float getPrecioRef() {
        return precioRef;
    }

    public void setPrecioRef(float precioRef) {
        this.precioRef = precioRef;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public void asignarArtista(long codi, Artista artista) {
        this.artistas.put(codi, artista);
    }

    public boolean verificarArtista(Artista artista) {

        return artistas.containsValue(artista);
    }

    public Map<Long, Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(Map<Long, Artista> artistas) {
        this.artistas = artistas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public abstract float CalcularPrecio();
    

}
