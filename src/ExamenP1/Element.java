package ExamenP1;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danie
 */
public abstract class Element {
    private String name;
    private int size;
    
    public Element(String name){
        this.name = name;
    }
    public Element(String name, int size){
        this(name);
        this.size = size;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String nuevo){
        name = nuevo;
    }
    
    public abstract Directory getParent();
    
    public abstract int getSize();
    
    public abstract String getPath();
}