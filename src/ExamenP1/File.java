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
public class File extends Element{
    private String name;
    private int size;
    private Directory direc;
    
    public File(String name, int size, Directory direc){
        super(name, size);
        this.direc = direc;
    }
    
    public void setSize(int tam){
        this.size = tam;
    }
    
    @Override
    public Directory getParent(){
        return this.direc;
    }
    
    @Override
    public int getSize(){
        return this.size;
    }
    
    @Override
    public String getPath(){
        String res = "/";
        return res;
    }
}
