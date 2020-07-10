package p1musica;

public class OwnAudio extends Playable {

    // Atributos 
    private String name;
    private String file;

    // Constructor 
    public OwnAudio (String name, String file) {
        super(name);
        this.file = file;
    }

    @Override
    public int play() {
        return 0;
    }

    @Override
    public int profit() {
        return 0;
    }
      
    
}
