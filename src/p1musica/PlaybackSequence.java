package p1musica;

public class PlaybackSequence extends Playable{

    // Atributos 
    private Playable[] secu;
    
    // Constructor
    public PlaybackSequence(String name) {
        super(name);
        secu = new Playable[0];
    }
    
    public void add (Playable ne) {
        Playable[] nSecu = new Playable[secu.length+1];
        System.arraycopy(secu, 0, nSecu, 0, secu.length);
        nSecu[secu.length+1] = ne;
        secu = nSecu;
    }
    
    public void set(int pos, Playable p) {
        secu[pos] = p;
    }
    
    public void remove (int pos) {
        Playable[] nSecu = new Playable[secu.length-1];
        for (int i = 0; i < secu.length; i++) {
            if (i != pos) {
                nSecu[i] = secu[i];
            }
        }
        secu = nSecu;
    }
    
    public void insert (int pos, Playable np) {
        Playable[] nSecu = new Playable[secu.length+1];
        System.arraycopy(secu, 0, nSecu, 0, pos);
        nSecu[pos] = np;
        System.arraycopy(secu, pos+1, nSecu, pos, secu.length-1-pos);
        secu = nSecu;
    }
    
    @Override
    public String toString() {
        String res = this.getName() + ":{";
        for (int i = 1; i < secu.length; i++) {
            res += secu[i].toString() + ",";
        }
        return res + "}";
    }
    
    @Override
    public int play() {
        int res = 0;
        for (int i = 0; i < secu.length; i++) {
            res += secu[i].duration();
        }
        return res;
    }
    
    @Override
    public int profit() {
        return 0;
    }
}
