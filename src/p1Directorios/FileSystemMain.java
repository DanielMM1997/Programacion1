package p1Directorios;

public class FileSystemMain {

    public static void main(String[] args) {
        Directory root = new Directory("root", null);
        Directory fs = new Directory("fs", root);
        File f1 = new File ("casa", 5, root);
        File f2 = new File("cosa", 20, fs);
        File f3 = new File("apuntes", 50, fs);
        Directory test = new Directory ("test", fs);
        File f4 = new File("testfile", 32, test);
        
        System.out.println("DEbe dar 5: " + f1.getSize());
        System.out.println("Debe dar 107: " + root.getSize());
        f4.setSize(22);
        System.out.println("Debe dar 97: " + root.getSize());
        System.out.println("Debe dar vacia: " + root.getPath());
        System.out.println("Debe dar /fs: " + fs.getPath());
        System.out.println("Debe dar /fs/cosa: " + f2.getPath());
        fs.setName("ec");
        System.out.println("");
        System.out.println("Debe dar vacia: " + root.getPath());
        System.out.println("Debe dar /ec: " + fs.getPath());
        System.out.println("Debe dar /ec/test/testfile: " + f4.getPath());
    }
}
