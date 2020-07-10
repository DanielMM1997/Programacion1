package textprocessing;
import java.util.Map;
import java.util.HashMap;

public class WordFrequencies {
    private Map<String, Integer> words;
    
    public void addFrequencies(Map<String,Integer> f){
        this.words = f;
    }
    
    public Map<String,Integer> getFrequencies(){
        return words;
    }
}
