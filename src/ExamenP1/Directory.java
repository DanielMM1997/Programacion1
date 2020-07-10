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
public class Directory extends Element{
    private String name;
    private Element[] archivos;
    private Directory direc;
    
    public Directory(String name, Directory direc){
        super(name);
        this.direc = direc;
        this.archivos = new Element[0];
    }
    
    public Element get(String name){
        Element res = null;
        for (Element c: archivos){
            if (c.getName()== name){
                res = c;
            }
        }
        return res;
    }
    
    public void add(Element dire){
        Element[] nuevo = new Element[this.archivos.length+1];
        for (int i = 0; i < archivos.length; i++){
            nuevo[i] = archivos[i];
        }
        nuevo[archivos.length-1] = dire;
        archivos = nuevo;
    }
    
    public Element[] getElements(){
        return archivos;
    }
    
    @Override
    public Directory getParent(){
        return this.direc;
    }
    
    @Override
    public int getSize(){
        int res = 0;
        for (Element c : archivos){
            res += c.getSize();
        }
        return res;
    }
    
    @Override
    public String getPath(){
        String res = "/";
        return res;
    }
    
    @Override
    public String toString(){
        String res = "";
        for (Element archivo : archivos) {
            res += archivo.getName() + ", ";
        }
        return res;
    }
}
