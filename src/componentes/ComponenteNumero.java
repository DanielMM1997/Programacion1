package componentes;
public class ComponenteNumero extends Componente implements Cloneable {
    
    private int num;
    
    public ComponenteNumero (int num) {
        this.num = num;
    }
    
    @Override
    public String toString() {
        return Integer.toString(num);
    }
    
    @Override
    public Componente copia() {
        try {
            return this.clone();
        } catch (CloneNotSupportedException ex) {
            return null;
        }
    }
    
    @Override
    public ComponenteNumero clone() throws CloneNotSupportedException {
        ComponenteNumero copia = (ComponenteNumero) super.clone();
        copia.num = num;
        return copia;
    }
    
}