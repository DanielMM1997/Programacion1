package conjuntoenteros;

import java.util.Arrays;

public class ConjuntoDeEnteros {
    
    public int[] elementos;
    private int cardinal;
    
    public ConjuntoDeEnteros() {
        elementos = new int[0];
        cardinal = 0;
    }
    
    public ConjuntoDeEnteros(int[] elementos) {
        if (elementos.length == 0) {
            this.elementos = new int[0];
            this.cardinal = 0;
        } else {
            this.elementos = new int [1];
            this.elementos[0] = elementos[0];
            this.cardinal = 1;
            for (int i = 1; i < elementos.length; i++) {
                añade(elementos[i]);
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ConjuntoDeEnteros other = (ConjuntoDeEnteros) obj;
        if (this.cardinal != other.cardinal) {
            return false;
        }
        if (!Arrays.equals(this.elementos, other.elementos)) {
            return false;
        }
        return true;
    }
    
    public int cardinal() {
        return this.cardinal;
    }
    
    public boolean estáVacío() {
        if (cardinal == 0) {
            return true;
        }
        return false;
    }
    
    public boolean pertenece(int ne) {
        for (int i = 0; i < cardinal; i++) {
            if (ne == elementos[i]) {
                return true;
            }
        }
        return false;
    }
    
    public boolean equals(ConjuntoDeEnteros conj) {
        if (cardinal != conj.cardinal()) {
            return false;
        }
        for (int i = 0; i < conj.cardinal(); i++) {
            if (!pertenece(conj.elementos[i])) {
                return false;
            }
        }
        return true;
    }
    
    public boolean contenido(ConjuntoDeEnteros conj) {
        for (int i = 0; i < conj.cardinal(); i++) {
            if (!pertenece(conj.elementos[i])) {
                return false;
            }
        }
        return true;
    }
    
    public int[] elementos() {
        return this.elementos;
    }
    
    //la union se esta haciendo al reves
    public ConjuntoDeEnteros unión(ConjuntoDeEnteros conj) {
        for (int i = 0; i < conj.cardinal(); i++) {
            añade(conj.elementos[i]);
        }
        return this;
    }
    
    public ConjuntoDeEnteros intersección(ConjuntoDeEnteros conj) {
        int pos = 0;
        int[] elementos2 = new int[cardinal];
        for (int i = 0; i < conj.cardinal(); i++) {
            if (pertenece(conj.elementos[i])) {
                //quitar2(conj.elementos[i]);                
                elementos2[pos] = conj.elementos[i];
                pos++;
            }
        }    //{1, 2, 3, 4, 5} {2, 0, 1} = {1, 2}
        int[] elementos3 = new int[pos];
        System.arraycopy(elementos2, 0, elementos3, 0, pos);
        elementos = elementos3;
        cardinal = pos;
        return this;
    }
    
    public ConjuntoDeEnteros diferencia(ConjuntoDeEnteros conj) {
        for (int i = 0; i < conj.cardinal(); i++) {
            if (pertenece(conj.elementos[i])) {
                quitar(conj.elementos[i]); 
            }
        }    //{1, 2, 3, 4, 5} {2, 1} = {3, 4, 5}
        return this;
    }
    
    public boolean añade(int ne) {
        if (cardinal == 0) {
            elementos = new int [1];
            elementos[0] = ne;
            cardinal = 1;
            return true;
        } else if (cardinal == 10) {
            return false;    
        } else if (!pertenece(ne)) {
            int[] elementos2 = new int[cardinal+1];
            System.arraycopy(elementos, 0, elementos2, 0, cardinal);
            elementos2[cardinal] = ne;
            cardinal++;            
            elementos = elementos2;
            return true;
        }
        return false;
    }
    
    private boolean quitar(int ne) {
        if (cardinal == 0) {
            return false;
        }
            int[] elementos2 = new int[cardinal];
            int pos = 0;
            for (int i = 0; i < cardinal; i++) {
                if (ne != this.elementos[i]) {
                    elementos2[pos] = elementos[i];
                    pos++;
                }
            }
            cardinal--;    
            int[] elementos3 = new int[cardinal];
            System.arraycopy(elementos2, 0, elementos3, 0, cardinal);
            elementos = elementos3;
            return true;
    }
    
    private boolean quitar2(int ne) {
        if (cardinal == 0) {
            return false;
        }
        int[] elementos2 = new int[cardinal];
        int pos = 0;
        for (int i = 0; i < cardinal; i++) {
            if (ne != this.elementos[i]) {
                elementos2[pos] = elementos[i];
                pos++;
            }
        }
        cardinal--;    
        int[] elementos3 = new int[cardinal];
        System.arraycopy(elementos2, 0, elementos3, 0, cardinal-1);
        elementos = elementos3;
        return true;
    }
}