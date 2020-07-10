package Examen2P1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Iterator;

public class CollegueGUI extends JFrame implements ActionListener{
    private JButton b1, b2, b3;
    private JMenuItem i1, i2, i3, i4;
    private JMenu menu;
    private JMenuBar menuBar;
    private JRadioButton rb1, rb2, rb3;
    private ButtonGroup grupo;
    private JTextArea t1;
    private JScrollPane scroll;
    public EnrolledStudents enrolledStudents = new EnrolledStudents();
    public offeredCourses off = new offeredCourses();
    
    public void asignar(EnrolledStudents enrolledStudents, offeredCourses off){
        this.enrolledStudents = enrolledStudents;
        this.off = off;
    }
    
    public CollegueGUI() {
        //Creamos la ventana principal
        setBounds(300, 200, 500, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        //setResizable(false);
        initComponents();
    }
    
    private void initComponents(){
        i1 = new JMenuItem("Add new Student");
        i2 = new JMenuItem("Enrroled Student");
        i3 = new JMenuItem("Exit");
        menu = new JMenu("Menu");
        menuBar = new JMenuBar();
        menu.add(i1);
        menu.add(i2);
        menu.add(i3);
        menuBar.add(menu);
        setJMenuBar(menuBar);
        
        JPanel panel = new JPanel();
        t1 = new JTextArea(20, 20);
        add(t1);
        t1.setLineWrap(true);
        t1.setWrapStyleWord(true);
        t1.setEditable(false);
        t1.setBounds(20, 20, 250, 200);
        b1 = new JButton("Add newStudent");
        b2 = new JButton("Enrrolled Student");
        rb1 = new JRadioButton("OrderByName");
        rb2 = new JRadioButton("OrderById");
        add(b1);
        add(b2);
        
        grupo = new ButtonGroup();
        grupo.add(rb1);
        grupo.add(rb2);
        add(rb1);
        add(rb2);
        
        rb1.setBounds(280, 40, 150, 25);
        rb2.setBounds(280, 70, 150, 25);
        b1.setBounds(280, 130, 150, 25);
        b2.setBounds(280, 160, 150, 25);
        showStudent();
        b1.addActionListener(this);
        b2.addActionListener(this);
    }
    
    public static void main(String[] args){
        CollegueGUI prueba = new CollegueGUI();
    }
    
    public void showStudent(){
        String res = "";
        //Iterator<Student> ite = enrolledStudents.arr.iterator();
        Student es;
        //while (ite.hasNext()){
        for (int i = 0; i < enrolledStudents.arr.size(); i++){        
            es = enrolledStudents.arr.get(i);
            res += es.toString() + "\n";
        }
        t1.setText(res);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1){
            AddStudents nuevoE = new AddStudents();
            nuevoE.asignar(enrolledStudents, off);
        }
        if (e.getSource() == b2){
           AddCourses co = new AddCourses();
        }
    }
}