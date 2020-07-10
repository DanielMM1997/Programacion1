package Examen2P1;
import java.util.*;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JavaSwing extends JFrame {
    //Creamos todos los botones y demás aunqeu este codigo nos lo viene dado ya por el profesor es facil de entender ya que lo tienen muy ordenado
    public EnrolledStudents enrolledStudents = new EnrolledStudents();
    public offeredCourses off = new offeredCourses();
    private Student es1,es2,es3;
    private Course cor1,cor2,cor3;
    private JTextArea data;
    private JRadioButton orderName;
    private JRadioButton orderId;
    private JButton addStudent;
    private JButton enrollStudent;

    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem itemAddStudent, itemEnrollStudent, itemExit;
    
    public void assing(EnrolledStudents enrolledStudents, offeredCourses off){
        this.enrolledStudents = enrolledStudents;
        this.off = off;
    }
    //Aqui inicializo para ver si funciona lo que he escrito
    public void inicializarStudent(){
        cor1 = new Course(1, "Lengua");
        cor2 = new Course(2, "Mates");
        cor3 = new Course(3, "Programacion");
        es1 = new Student(1, "Alfredo");
        es2 = new Student(2, "Perez");
        es3 = new Student(3, "Bubalcaba");
        off.addCourse(cor1);
        off.addCourse(cor2);
        off.addCourse(cor3);
        es1.enrolledCourse(cor1);
        es1.enrolledCourse(cor2);
        es2.enrolledCourse(cor3);
        enrolledStudents.addStudent(es1);
        enrolledStudents.addStudent(es2);
        enrolledStudents.addStudent(es3);
    }
    //Se construye el menú
    private void constructMenu() {
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menu = new JMenu("Menu");
        //estos son las pasteñas del menú
        itemAddStudent = new JMenuItem("Add new student");
        itemEnrollStudent = new JMenuItem("Enroll student in course");
        itemExit = new JMenuItem("Exit");
        menu.add(itemAddStudent);
        menu.add(itemEnrollStudent);
        menu.add(itemExit);
        menuBar.add(menu);
        itemAddStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                createStudent(evt);
            }
        });
        itemExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
            }
        });
    }
    //Creamos este metodo donde enseña los estudiantes por nombre
    public void showStudent(ActionEvent evt){
        //inicializarStudent();
        List<Student> list;
            list = enrolledStudents.getStudentsOrderByName();
            Iterator<Student> ite = list.iterator();
            String res = "";
            Student aux;
            while(ite.hasNext()){
                aux = ite.next();
                res += aux.toString() + "\n";
            }
            data.setText(res);
    }
    //Añadir las  asignaturas te manda a un JDialog
    public void addCourse(ActionEvent evt){
        AddCourse course = new AddCourse(off, enrolledStudents);
    }
    //Creamos estudiante y te manda a un JDialog
    public void createStudent(ActionEvent evt){
        new AddStudent(enrolledStudents);
    }
    //Ordenamos los students por ID
    public void showStudentId(ActionEvent evt){
        //inicializarStudent();
        List<Student> list = enrolledStudents.getStudentsOrderById();
        Iterator<Student> ite = list.iterator();
        String res = "";
        Student aux;
        while (ite.hasNext()){
            aux = ite.next();
            res += aux.toString() + "\n";
        }
        data.setText(res);
    }
    //Creamos el resto de botones y demas
    private Component constructControls() {
        orderName = new JRadioButton("Order by student's name", false);
        orderId = new JRadioButton("Order by student's id", false);
        ButtonGroup bg = new ButtonGroup();
        bg.add(orderName);
        bg.add(orderId);
        addStudent = new JButton("Add new student");
        enrollStudent = new JButton("Enroll student in course");
        JPanel east = new JPanel();
        east.setLayout(new BoxLayout(east, BoxLayout.PAGE_AXIS));
        JPanel order = new JPanel();
        order.setLayout(new BoxLayout(order, BoxLayout.PAGE_AXIS));
        order.add(orderName);
        order.add(orderId);
        order.setBorder(BorderFactory.createTitledBorder("List order"));
        east.add(order);
        east.add(addStudent);
        east.add(enrollStudent);
        //inicializarStudent();
        List<Student> list = enrolledStudents.getStudentsOrderById();
        Iterator<Student> ite = list.iterator();
        String res = "";
        Student aux;
        while (ite.hasNext()){
            aux = ite.next();
            res += aux.toString()+ "\n";
        }
        data.setText(res);
        orderName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showStudent(evt);
            }
        });
        orderId.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                showStudentId(evt);
            }
        });
        addStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                createStudent(evt);
            }
        });
        enrollStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addCourse(evt);
            }
        });
        return east;
    }

    private Component constructInfo() {
        data = new JTextArea();
        data.setEditable(false);
        return new JScrollPane(data);
    }

    public JavaSwing(){
        super("College Management");
        constructMenu();
        JPanel pane = new JPanel();
        pane.setLayout(new BorderLayout());
        pane.add(constructInfo(), BorderLayout.CENTER);
        pane.add(constructControls(), BorderLayout.EAST);
        setContentPane(pane);
        setLocation(300,150);
        setSize(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main (String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception e) {
        }
        new JavaSwing();
    }
}