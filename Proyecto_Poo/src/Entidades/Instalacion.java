package Entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

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
public class Instalacion extends Obra {

    private String descripcion;
    private ArrayList<Material> material;

    public Instalacion() {
        super();
    }

    public Instalacion(String descripcion, ArrayList<Material> material, long codigoObra, String titulo, LocalDate fecha, float precioRef, String dimensiones) {
        super(codigoObra, titulo, fecha, precioRef, dimensiones);
        this.descripcion = descripcion;
        super.setTipo("Instalacion");
        if (material.size() != 0) {
            this.material = material;
        } else {
            this.material = new ArrayList<>();
        }    
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Material> getMaterial() {
        return material;
    }

    public void setMaterial(ArrayList<Material> material) {
        this.material = material;
    }

    @Override
    public float CalcularPrecio() {
        int cantDist = CantDistMate();
        return (float) (super.precioRef + (super.precioRef * 0.05 * cantDist));
    }

    private int CantDistMate() {
        Map<String, Material> lstCrack = new TreeMap<>();
        for (Material mat : material) {
            lstCrack.put(mat.getNombre(), mat);
        }
        return lstCrack.size();
    }

}
