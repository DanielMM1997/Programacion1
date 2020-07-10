package Examen2P1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddStudents extends JFrame implements ActionListener{
    private JButton b1, b2;
    private JLabel l1, l2;
    private JTextField t1, t2;
    public EnrolledStudents enrolledStudents = new EnrolledStudents();
    public offeredCourses off = new offeredCourses();
    
    public void asignar(EnrolledStudents enrolledStudents, offeredCourses off){
        this.enrolledStudents = enrolledStudents;
        this.off = off;
    }
    
    public AddStudents(){
        setBounds(300, 200, 300, 200);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        iniciar();
    }
    
    private void iniciar(){
        b1 = new JButton("Aceptar");
        b2 = new JButton("Cancelar");
        l1 = new JLabel("Student ID: ");
        l2 = new JLabel("Student name: ");
        t1 = new JTextField();
        t2 = new JTextField();
        
        add(b1);
        add(b2);
        add(l1);
        add(l2);
        add(t1);
        add(t2);
        
        l1.setBounds(20, 20, 150, 20);
        l2.setBounds(20, 50, 150, 20);
        t1.setBounds(130, 20, 100, 20);
        t2.setBounds(130, 50, 100, 20);
        b1.setBounds(50, 90, 80, 25);
        b2.setBounds(150, 90, 80, 25);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1){
            String id = t1.getText();
            String name = t2.getText();
            if (id.equals("") || name.equals("")){
                JOptionPane.showMessageDialog(b1, "Introduce bien los valores.",
                            "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                for (Student c: enrolledStudents.arr){
                    if (c.getId() == Integer.valueOf(id)){
                        JOptionPane.showMessageDialog(b1, "El alumno ya esta matriculado",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    }else{
                        Student nuevo = new Student(Integer.valueOf(id), name);
                        enrolledStudents.arr.add(nuevo);            
                        setVisible(false);
                    }
                }                
            }            
        }
        if (e.getSource() == b2){
        
        }
    }
}