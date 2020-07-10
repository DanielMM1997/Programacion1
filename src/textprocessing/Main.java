package textprocessing;
import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) {
        FileNames fileNames = new FileNames();
        FileContents fileContents = new FileContents(30, 100 * 1024);
        WordFrequencies wordFrequencies = new WordFrequencies();

        Tools.fileLocator(fileNames, "datos");
        //System.out.println(Tools.getContents("/datos/Abuela.txt"));
        
        //Cree e inicie los hilos AQUÍ, 2 FileReader y 3 FileProcessor
        
        FileReader fr1 = new FileReader(fileNames, fileContents);
        FileReader fr2 = new FileReader(fileNames, fileContents);
        FileProcessor fp1 = new FileProcessor(fileContents, wordFrequencies);
        FileProcessor fp2 = new FileProcessor(fileContents, wordFrequencies);
        FileProcessor fp3 = new FileProcessor(fileContents, wordFrequencies);
        
        //Iniciamos la ejecución de los hilos
        fr1.start(); 
        fr2.start();
        fp1.start();
        fp2.start();
        fp3.start();
        
        //Esperar a que terminen los hilos creados
        
        try{
            fr1.join(1000); 
            fr2.join(1000);
            fp1.join(1000);
            fp2.join(1000);
            fp3.join(1000);
        } catch(Exception e){};
        
        for( String palabra : Tools.wordSelector(wordFrequencies.getFrequencies())) {
            System.out.println(palabra);
        }
        fileNames.noMoreNames();
    }
}

class Tools {
    
    public static void fileLocator(FileNames fn, String dirname){
        File dir = new File(dirname);
        if ( ! dir.exists() ){
            return;
        }
        if ( dir.isDirectory() ) {
            String[] dirList = dir.list();
            for ( String name: dirList ) {
                if ( name.equals(".") || name.equals("..") ) {
                    continue;
                }
                fileLocator(fn, dir + File.separator + name);
            }
        } else {
            fn.addName(dir.getAbsolutePath());
            //System.out.println(dir.getAbsolutePath());
        }
    }
    
    public static class Order implements Comparator< Map.Entry<String,Integer> > {
        public int compare(Map.Entry<String,Integer> o1, Map.Entry<String,Integer> o2) {
            if ( o1.getValue().compareTo(o2.getValue()) == 0 ) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return o2.getValue().compareTo(o1.getValue());
        }
    }
    
    public static List<String> wordSelector(Map<String,Integer> wf){
        Set<Map.Entry<String,Integer>> set=wf.entrySet();
        Set<Map.Entry<String,Integer>> orderSet= new TreeSet<Map.Entry<String,Integer>>(
            new Order());
        orderSet.addAll(set);
        List<String> l = new LinkedList<String>();
        int i=0;
        for ( Map.Entry<String,Integer> pair: orderSet){
            l.add(pair.getValue() + " " + pair.getKey() );
            if (++i >= 10 ) break;
        }
        return l;
    }

    public static  String getContents(String fileName){
        StringBuilder text = new StringBuilder();
        try {
            FileInputStream fis = new FileInputStream( fileName );
            BufferedReader br = new BufferedReader( new InputStreamReader(fis, "UTF-8") );
            String line;
            while (( line = br.readLine()) != null) {
                text.append(line);
                text.append("\n");
            }
        } catch (IOException e) {
            return "Error: " + e.getMessage();
        }
        return text.toString();
    }
    
}
