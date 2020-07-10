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
public class Producto {
    private String nombre;
    private int precio;
    
    public Producto(String nombre, int precio){
        this.nombre = nombre;
        this.precio = precio;        
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public int getPrecio(){
        return precio;
    }
    
    
}
