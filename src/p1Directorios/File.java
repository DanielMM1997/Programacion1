package p1Directorios;

public class File extends Element{
    
    // Atributos 
    private int tam;
    private Directory dire;
    
    // Constructor 
    public File (String name, int tam, Directory dire) {
        super(name, dire);
        this.setName(name);
        this.tam = tam;
        this.dire = dire;    
        dire.add(this);
    }
    
    public void setSize(int tam) {
        this.tam = tam;
    }
    
    @Override
    public int getSize() {
        return tam;
    }
}
