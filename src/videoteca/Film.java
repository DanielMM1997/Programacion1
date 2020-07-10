package videoteca;

import java.util.Objects;

public class Film {
    
    // Atributos
    private String title;
    private String genre;
    private int year;
    
    // Constructor
    public Film(String title, String genre, int year) {
        this.title = title;
        this.genre = genre;
        this.year = year;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getGenre() {
        return genre;
    }
    
    public int getYear() {
        return year;
    }
    
    @Override
    public String toString() {
        return title + " | " + genre + " | " + year;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.title);
        hash = 67 * hash + this.year;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Film) {
            Film film = (Film) obj;
            if (!this.title.equals(film.title)) {
                return false;
            }
            if (this.year != film.year) {
                return false;
            }
        }
        return false;
    }
    
    
}