package textprocessing;
import java.util.*;
public class FileNames {
    
    private Queue<String> queue;
    private boolean flag = false;
    
    public FileNames() {
        queue = new PriorityQueue<String>();
    }
    
    public void addName(String fileName) {
        queue.add(fileName);
    }
    
    public synchronized String getName() {
        if (flag) {
            return null;
        }
        while(queue.size() <= 0) {
            try {
                wait();   
            } catch (InterruptedException e){};
        }
        notifyAll();
        return queue.poll();
    }
    
    public synchronized void noMoreNames() {
        if (queue.size() == 0) {
            flag = true;
        }
    }
}