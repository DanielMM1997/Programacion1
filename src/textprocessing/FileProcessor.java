package textprocessing;
import java.util.*;

public class FileProcessor extends Thread{
    private FileContents fc;
    private WordFrequencies wf;
    private Map<String, Integer> words;
    
    public FileProcessor(FileContents fc, WordFrequencies wf){
        this.fc = fc;
        this.wf = wf;
        words = new HashMap<String, Integer>();
    }
    
    private String[] getPalabras(String cadena) {
        String[] words = new String[cadena.length()/2+1];
        String pala = "";
        int pos = 0;
        for (int i = 0; i < cadena.length(); i++) {
            pala = "";
            while (Character.isLetterOrDigit(cadena.charAt(i))) {
                pala += Character.toString(cadena.charAt(i));
                i++;
                if (i == cadena.length()) {
                    break;
                }                
            }
            if (pala.length() != 0) {
                words[pos] = pala;
                pos++;
            }
        }
        String[] words2 = new String[pos];
        System.arraycopy(words, 0, words2, 0, pos);
        return words2;
    }
    
    public void run() {
        String res = fc.getContents();
        while (res != null){
            String aux[] = getPalabras(res);
            for (int i = 0; i < aux.length; i++) {
                words.put(aux[i], (words.containsKey(aux[i])) ? words.get(aux[i]) + 1 : 1);
            }
            wf.addFrequencies(words);
            res = fc.getContents();
        }
    }
}