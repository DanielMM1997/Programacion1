package p1Directorios;

public class Directory extends Element{
    
    //Atributos 
    private Directory dire;
    private Element[] elementos;
    
    public Directory(String name, Directory dire) {
        super(name, dire);
        this.setName(name);
        this.dire = dire;
        elementos = new Element[0];
        if (dire != null){
            dire.add(this);
        }
    }
    
    public void add (Element ele) {
        Element[] nelem = new Element[elementos.length+1];
        for (int i = 0; i < elementos.length; i++) {
            nelem[i] = elementos[i];
        }
        nelem[elementos.length] = ele;
        elementos = nelem;
    }
    
    public Element[] getElement () {
        return elementos;
    }
    
    public Element getElement(String name) {
        Element res = null;
        for (int i = 0; i < elementos.length; i++) {
            if (elementos[i].getName().equals(name)) {
                res = elementos[i];
            }
        }
        return res;
    }
    
    public int getSize() {
        int res = 0;
        for (int i = 0; i < elementos.length; i++) {
            res += elementos[i].getSize();
        }
        return res;
    }
}
