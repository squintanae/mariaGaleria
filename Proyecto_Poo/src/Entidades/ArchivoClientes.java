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
public class ArchivoClientes {
    @XmlElement(name = "Clientes")
    private ArrayList<Cliente> registros = new ArrayList<>();
    
    public ArchivoClientes() {
    }
    
    public ArchivoClientes(ArrayList<Cliente> registros){
        this.registros = registros;
    }
    
    public ArrayList<Cliente> getRegistros() {
        return registros;
    }
}
