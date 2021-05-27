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
public class ArchivoCompras {
    @XmlElement(name = "Compras")
    private ArrayList<Compra> registros = new ArrayList<>();
    
    public ArchivoCompras() {
    }
    
    public ArchivoCompras(ArrayList<Compra> registros){
        this.registros = registros;
    }
    
    public ArrayList<Compra> getRegistros() {
        return registros;
    }
}