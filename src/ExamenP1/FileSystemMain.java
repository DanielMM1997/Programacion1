package ExamenP1;

public class FileSystemMain {

    public static void main(String[] args) {
        Directory root = new Directory("", null);
        Directory fs = new Directory("fs", root);
        File f1 = new File("FileSystemMain.java", 23, root);
        File f2 = new File("Element.java", 13, fs);
        File f3 = new File("File.java", 12, fs);
        Directory test = new Directory("test", fs);
        File f4 = new File("FileSystemTest.java", 3, test);
        
        System.out.println("Elementos: " + root.getElements().toString());
        System.out.println("root.getSize() = " + root.getSize()); // Debe dar 51

        f4.setSize(5);
        System.out.println("root.getSize() = " + root.getSize()); // Debe dar 53
        
        System.out.println("root.getPath() = " + root.getPath()); // Debe dar ristra vacía
        System.out.println("fs.getPath() = " + fs.getPath()); // Debe dar /fs
        System.out.println("f4.getPath() = " + f4.getPath()); // Debe dar /fs/test/FileSystemTest.java
        fs.setName("file_system");

        System.out.println("root.getPath() = " + root.getPath()); // Debe dar ristra vacía
        System.out.println("fs.getPath() = " + fs.getPath()); // Debe dar /file_system
        System.out.println("f4.getPath() = " + f4.getPath()); // Debe dar /file_system/test/FileSystemTest.java

        // run JUnit Test
        //org.junit.runner.JUnitCore.main("PracticarTestFileSystemTest");
        
    }
}
