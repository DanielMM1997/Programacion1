package p1Directorios;

public abstract class Element {

    // Atributos
    private String name;
    private Directory dire;
    
    public Element(String name, Directory dire){
        this.name=name;
        this.dire=dire;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public Directory getParent() {
        return dire;
    }
    
    public abstract int getSize();
    
    public String getPath() {
        String res="";
        if(dire!=null){
            res+=dire.getPath();
        }
        if(name.isEmpty()){
            return res;
        }
        return res+"/"+name;
    }
}
