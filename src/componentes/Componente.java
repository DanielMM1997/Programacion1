package componentes;
public abstract class Componente implements Cloneable{
    
    @Override
    public abstract String toString();
    
    public int nCaracteres() {
        int count = 0;
        for (int i = 0; i < toString().length(); i++) {
            if (toString().charAt(i) != ' ') {
                count++;
            } 
        }
        return count;
    }
    
    public int nPalabras() {
        int count = 0;
        count = toString().split("\\s+").length;
        if (toString().charAt(0) == ' ') {
            count--;
        }
        return count;
    }
    
    public abstract Componente copia();
}