package Interfaz;

import java.util.*;
        
public class Sequence implements Expresion{

    private ArrayList<Expresion> secuencia;
    
    public Sequence(){
        secuencia = new ArrayList<>();
    }
    
    public boolean add(Expresion e){
        secuencia.add(e);
        return false;
    }
    
    public boolean remove(int pos){
        secuencia.remove(pos);
        return false;
    }
    
    @Override
    public int evaluate(){
        int res = 0;
        for (Expresion c: secuencia){
            res = c.evaluate();
        }
        return res;
    }
    
    @Override
    public String toString(){
        String res = "";
        for (Expresion c: secuencia){
            res += c.toString() + "; ";
        }
        return res;
    }
}