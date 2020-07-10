package buscarVector;

public class PosicionMatriz {
    
    private int fila;
    private int columna;
    
    public PosicionMatriz (int fila, int columna){
        this.fila = fila;
        this.columna = columna;
    }
    
    public int dameFila() {
        return fila;
    }
    
    public int dameColumna() {
        return columna;
    }

    @Override
    public boolean equals(Object as) {
        return true;
    }
    
    @Override
    public String toString() {
        return "[" + this.dameFila() + "]" + "[" + this.dameColumna() + "]";
    }
}