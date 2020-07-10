package Interfaz;

public class Variable implements Expresion{
    
    private String name;
    private int value;
    
    public Variable(String name){
        this.name = name;
        this.value = 0;
        
    }
    public Variable(String name, int value){
        this.name = name;
        this.value = value;
    }
    
    public void setValue(int value){
        this.value = value;
    }
    
    @Override
    public int evaluate(){
        return this.value;
    }
    
    @Override
    public String toString(){
        return this.name;
    }
}