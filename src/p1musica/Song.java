package p1musica;

public class Song extends Playable {

    // Atributos
    private String file;
    private int dura;
    
    // Constructor
    public Song (String name, String file, int dura) {
        super(name);
        this.file = file;
        this.dura = dura;
    }
    
    @Override
    public int play() {
        return dura;
    }
    
    @Override
    public int profit () {
        return 0;
    }
}
