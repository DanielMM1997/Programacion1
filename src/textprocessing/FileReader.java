package textprocessing;

public class FileReader extends Thread{
    private FileNames fn;
    private FileContents fc;
    
    public FileReader(FileNames fn, FileContents fc){
        this.fn = fn;
        this.fc = fc;
    }
    
    public void run() {
        String res = fn.getName();
        fc.registerWriter();
        while (res != null){
            fc.addContents(Tools.getContents(res));
            res = fn.getName();
        }
        fc.unregisterWriter();
    }
}
