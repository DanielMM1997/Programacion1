package componentes;
public class ComponenteTexto extends Componente implements Cloneable{
    
    private String texto;
    
    public ComponenteTexto (String texto) {
        this.texto = texto;
    }
    
    @Override
    public String toString() {
        return texto;
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
    public ComponenteTexto clone() throws CloneNotSupportedException {
        ComponenteTexto copia = (ComponenteTexto) super.clone();
        copia.texto = this.texto;
        return copia;
    }
   
}