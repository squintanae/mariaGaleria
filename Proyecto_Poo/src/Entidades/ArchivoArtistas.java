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
public class ArchivoArtistas {
    @XmlElement(name = "Artistas")
    private ArrayList< Artista> registros = new ArrayList<>();
    
    public ArchivoArtistas() {
    }
    
    public ArchivoArtistas(ArrayList< Artista> registros){
        this.registros = registros;
    }
    
    public ArrayList< Artista> getRegistros() {
        return registros;
    }
}
