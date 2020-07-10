package textprocessing;
import java.util.*;

public class FileContents {
    private Queue<String> queue;
    private int registerCount = 0;
    private boolean closed = false;
    private int maxFiles;
    private int maxChars;
    
    public FileContents(int maxFiles, int maxChars) {
        this.maxFiles = maxFiles;
        this.maxChars = maxChars;
        queue = new PriorityQueue();
    }
    
    public void registerWriter() {
        registerCount = 1; 
    }
    
    public void unregisterWriter() {
        registerCount = 0;
    }
    
    public synchronized void addContents(String contents) {
        System.out.println("ha entrado en filecontent");
        while (queue.size() > maxFiles || contents.length() >= maxChars ) {
            try {
                wait();
                System.out.println("me quedo esperando....");
            } catch(InterruptedException e) {}
        }
        if (!closed) {
            queue.add(contents);
            notifyAll();
        } 
        if (queue.size() == 0){
            closed = true;
        }
        
    }
    
    public synchronized String getContents() {
        while(queue.size() == 0) {
            if (registerCount == 0) {
                return null;
            }
            try {
                wait();   
            } catch (InterruptedException e){};
        }
        
        notifyAll();
        return queue.poll();
    }
}
