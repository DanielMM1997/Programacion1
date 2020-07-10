package buscarpalabras;
public class UsaAuxiliarString {
    
    public static void main(String [] args) {
        String frase = "En un lugar de la un Mancha&decuyo¿¿?2131nombre de no";
              
        System.out.println("Todas las palabras:");
        String[] words = AuxiliarString.palabras(frase);
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i] + " ");
        }
        
        System.out.println("Todas las palabras sin repetición");
        String[] differentsWords = AuxiliarString.palabrasDistintas(frase);
        for (int i = 0; i < differentsWords.length; i++) {
            System.out.println(differentsWords[i] + " ");
        }
    }
}
