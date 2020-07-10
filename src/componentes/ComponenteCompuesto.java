package componentes;
public class ComponenteCompuesto extends Componente{
    
    private Componente[] secuencia;
    private int cardinal;
    
    public ComponenteCompuesto () {
        secuencia = new Componente[100];
        cardinal = 0;
    }
    
    public void añade (Componente com) {
        if (cardinal == 100) {
            return;
        } else {
            secuencia[cardinal] = com;
            cardinal++;
        }
    }
    
    public int cardinal() {
        return cardinal;
    }
    
    public void modifica (int pos, Componente com) {
        if (pos < 0 && pos > cardinal()) {
            return;
        }
        
    }
    
    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < cardinal(); i++) {
            res += secuencia[i].toString();
        }
        return res;
    }
    
    @Override
    public int nCaracteres() {
        int count = 0;
        for (int i = 0; i < cardinal(); i++) {
            count += secuencia[i].nCaracteres();
        }
        return count;
    }
    
    @Override
    public int nPalabras() {
        int count = 0;
        for (int i = 0; i < cardinal(); i++) {
            count += secuencia[i].nPalabras();
        }
        return count;
    }
    
    @Override
    public Componente copia() {
        ComponenteCompuesto copia = new ComponenteCompuesto();
        for (int i = 0; i < cardinal; i++) {
            copia.añade(secuencia[i]);
        }
        return copia;
    }
    
}