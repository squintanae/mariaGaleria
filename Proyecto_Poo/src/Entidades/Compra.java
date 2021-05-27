package Entidades;

import java.time.LocalDate;
import java.util.Calendar;

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
public class Compra {

    private long codigoCompra;
    private LocalDate fecha;
    private boolean pagado;
    private Obra compraObra;
    private Cliente compraCliente;

    public Compra() {
        this.codigoCompra = 0;
        this.fecha = LocalDate.now();
        this.pagado = false;
    }

    public Compra(long codigoCompra, LocalDate fecha, boolean pagado, Obra compraObra, Cliente compraCliente) {
        this.codigoCompra = codigoCompra;
        this.fecha = fecha;
        this.pagado = pagado;
        this.compraObra = compraObra;
        this.compraCliente = compraCliente;
    }

    public long getCodigoCompra() {
        return codigoCompra;
    }

    public void setCodigoCompra(long codigoCompra) {
        this.codigoCompra = codigoCompra;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public Obra getCompraObra() {
        return compraObra;
    }

    public void setCompraObra(Obra compraObra) {
        this.compraObra = compraObra;
    }

    public Cliente getCompraCliente() {
        return compraCliente;
    }

    public void setCompraCliente(Cliente compraCliente) {
        this.compraCliente = compraCliente;
    }

    public void asignarClienteObra(Cliente cliente, Obra obra) {
        setCompraObra(obra);
        setCompraCliente(cliente);
    }

    public boolean relacionClienteObra(Cliente cliente, Obra obra) {
        if (compraCliente == cliente && compraObra == obra) {
            return true;
        }
        return false;
    }
}
