package buscarpalabras;

public class AuxiliarString {    
    public static String[] palabras(String cadena) {
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
    
    public static String[] palabrasDistintas(String cadena) {
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
        for (int i = 0; i < pos; i++) {
            for (int j = 0; j < pos; j++) {
                if (words[i].equals(words[j])) {
                    
                } else {
                    words2[i] = words[j];
                }
            }
        }
        return words2;
    }
}
