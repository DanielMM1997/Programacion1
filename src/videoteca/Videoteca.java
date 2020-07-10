package videoteca;
import java.util.*;

public class Videoteca implements Comparable<Film>{
    
    // Atributos
    private String name;
    private SortedSet<Film> films;
    
    // Constructor
    public Videoteca(String name) {
        this.name = name;
        setOrder(0);
    }
    
    public boolean add(Film nFilm) {
        return films.add(nFilm);
    }
    
    public void setOrder(int ord) {
        if (ord == 0) {
            films = new TreeSet<>(new OrdenTitleYear());
        }
        if (ord == 1) {
            
        }
    }
    
    public Set<Film> getFilms() {
        if (films.size() == 0) {
            return null;
        } else {
            return films;
        }
    }
    
    public Set<String> getGenres() {
        SortedSet<String> genres = new TreeSet<>(new OrdenGenre());
        Iterator<Film> ite = films.iterator();
        int count = 0;
        while (ite.hasNext()) {   //recorre los films
            Film actual = ite.next();
            for (Film i : films) {  //recorre la lista de genero
                if (actual.getGenre().equals(i.getGenre())){
                    count++;
                }
            }
            genres.add(actual.getGenre() + ": " + count);
            count = 0;
        }
        return genres;
    }
    
    @Override
    public String toString() {
        String res = name + ":\n";
        int i = 1;
        for (Film f : films) {
            res += i + ") " + f.toString() + "\n";
            i++;
        }
        return res.substring(0, res.length()-1);
    }

    @Override
    public int compareTo(Film f) {
        if (this.toString().compareToIgnoreCase(f.toString()) > 0 ) {
            return 1;
        }
        if (this.toString().compareToIgnoreCase(f.toString()) < 0 ) {
            return -1;
        }
        return 0;
    }
    /*
    @Override
    public int compare(Film f1, Film f2) {
        if (f1.getTitle().compareToIgnoreCase(f2.getTitle()) > 0 ) {
            return 1;
        } else if (f1.getTitle().compareToIgnoreCase(f2.getTitle()) < 0 ) {
            return -1;
        } else {
            return f1.getYear()-f2.getYear();
        }
    }*/
        
    public class OrdenTitleYear implements Comparator<Film>{
        @Override
        public int compare(Film f1, Film f2) {
            if (f1.getTitle().compareToIgnoreCase(f2.getTitle()) > 0 ) {
                return 1;
            } else if (f1.getTitle().compareToIgnoreCase(f2.getTitle()) < 0 ) {
                return -1;
            } else {
                return (f1.getYear() > f2.getYear()) ? 1 : -1;
            }
        }
    }

    
    public class OrdenGenre implements Comparator<String> {
        @Override
        public int compare(String f1, String f2) {
            return (f1.compareToIgnoreCase(f2) > 0) ? 1 : -1;
        }
    }
    
}