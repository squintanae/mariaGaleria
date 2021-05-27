/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Hp
 */
public class ArchivoObras {
    @XmlElement(name = "Obras")
    private ArrayList<Obra> registros = new ArrayList<>();
    
    public ArchivoObras() {
    }
    
    public ArchivoObras(ArrayList<Obra> registros){
        this.registros = registros;
    }
    
    public ArrayList<Obra> getRegistros() {
        return registros;
    }
}
