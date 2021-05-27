package Entidades;

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
public class Escultura extends Obra {

    private String material;
    private double peso;
    private Material tipoMaterial;

    public Escultura() {
        super();
    }

    public Escultura(double peso, Material tipoMaterial, long codigoObra, String titulo, LocalDate fecha, float precioRef, String dimensiones) {
        super(codigoObra, titulo, fecha, precioRef, dimensiones);

        this.peso = peso;
        this.tipoMaterial = tipoMaterial;
        super.setTipo("Escultura");
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Material getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(Material tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    @Override
    public float CalcularPrecio() {
        if (peso < 10) {
            return super.getPrecioRef();
        } else {
            return (float) (super.getPrecioRef() + super.getPrecioRef() * (peso - 10) * 0.01);
        }
    }
}
