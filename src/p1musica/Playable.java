package p1musica;

public abstract class Playable {
    
    // Atributos 
    private String name;
    private int dura;
    
    public abstract int play();
    
    public abstract int profit();
    
    public Playable (String name) {
        this.name = name;
    }
    
    public String getName () {
        return name;
    }
    
    public int duration () {
        return dura;
    }
    
    @Override 
    public String toString() {
        return name + "(" + dura + ")";
    }
}
