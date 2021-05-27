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
public class Artista {

    private long codigoArtista;
    private long cedula;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private long telefono;
    private Map<Long, Obra> obras;

    public Artista() {
        this.obras = new TreeMap<>();
    }

    public Artista(long codigoArtista, long cedula, String nombre, String apellido, LocalDate fechaNacimiento, long telefono) {
        this.codigoArtista = codigoArtista;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.obras = new TreeMap<>();
    }

    public long getCodigoArtista() {
        return codigoArtista;
    }

    public void setCodigoArtista(long codigoArtista) {
        this.codigoArtista = codigoArtista;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public Map<Long, Obra> getObras() {
        return obras;
    }

    public void setObras(Map<Long, Obra> obras) {
        this.obras = obras;
    }

    public void agregarObra(Long cod, Obra obra) {
        obras.put(cod, obra);
    }

    public boolean verificarObra(Obra obra) {
        return obras.containsValue(obra);
    }
}
