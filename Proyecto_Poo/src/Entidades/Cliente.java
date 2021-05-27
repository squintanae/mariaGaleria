package Entidades;

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
public class Cliente {

    private long codigoCliente;
    private long cedula;
    private String nombre;
    private String Apellidos;
    private String direccionEntrega;
    private long telefono;

    public Cliente() {
    }

    public Cliente(long codigoCliente, long cedula, String nombre, String Apellidos, String direccionEntrega, long telefono) {
        this.codigoCliente = codigoCliente;
        this.cedula = cedula;
        this.nombre = nombre;
        this.Apellidos = Apellidos;
        this.direccionEntrega = direccionEntrega;
        this.telefono = telefono;
    }

    public long getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(long codigoCliente) {
        this.codigoCliente = codigoCliente;
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

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

}
