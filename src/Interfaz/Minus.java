package Interfaz;

public class Minus implements Expresion{
    private Expresion aa;
    private Expresion bb;
    
    public Minus(Expresion aa, Expresion bb){
        this.aa = aa;
        this.bb = bb;
    }
    
    @Override
    public int evaluate(){
        return aa.evaluate() - bb.evaluate();
    }
    
    @Override
    public String toString(){
        return "(" + aa.toString() + "-" + bb.toString() + ")";
    }
    
}