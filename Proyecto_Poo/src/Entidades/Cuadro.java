package Entidades;

import Enumeraciones.Clasificacion;
import java.time.LocalDate;

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
public class Cuadro extends Obra {

    private String tema;
    private String tecnica;
    private Clasificacion clasificacion;

    public Cuadro() {
        super();
    }

    public Cuadro(String tema, String tecnica, Clasificacion clasificacion, long codigoObra, String titulo, LocalDate fecha, float precioRef, String dimensiones) {
        super(codigoObra, titulo, fecha, precioRef, dimensiones);
        this.tema = tema;
        this.tecnica = tecnica;
        this.clasificacion = clasificacion;
        super.setTipo("Cuadro");
    }

//    public Cuadro(int i, String la_Maria_estrellada, GregorianCalendar gregorianCalendar, int i0, String x45) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getTecnica() {
        return tecnica;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }

    public Clasificacion getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(Clasificacion clasificacion) {
        this.clasificacion = clasificacion;
    }

    @Override
    public float CalcularPrecio() {
        if (clasificacion == Clasificacion.OBRA_MAESTRA) {
            return (float) (super.getPrecioRef() + super.getPrecioRef() * 0.05);
        } else {
            return (float) (super.getPrecioRef() + super.getPrecioRef() * 0.03);
        }
    }


}
