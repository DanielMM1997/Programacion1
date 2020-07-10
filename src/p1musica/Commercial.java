package p1musica;

public class Commercial extends Playable {

    // Atributo
    private String file;
    private int bene;
    
    public Commercial (String name, String file, int bene) {
        super(name);
        this.file = file;
        this.bene = bene;
    }
    
    @Override
    public int play () {
        return 0;
    }
    
    @Override
    public int profit () {
        return bene;
    }
    
    
}
