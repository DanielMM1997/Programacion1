/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repaso;

/**
 *
 * @author danie
 */
public class busqueda {
    private int cox;
    private int coy;
    
    // Contructor de la clase busqueda
    public busqueda(int cox, int coy){
        this.cox = cox;
        this.coy = coy;
    }
    
    /* Devuelve la coordenada x */
    public int getCooX(){
        return cox;
    }
    
    /* Devuelve la coordenada y */
    public int getCooY(){
        return coy;
    }
    
    @Override
    public String toString(){
        String coordenadas = "";
        coordenadas = "[" + cox + "]" + "[" + coy + "]";
        return coordenadas;
    }

    
}
