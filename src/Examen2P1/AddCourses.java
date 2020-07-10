package Examen2P1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddCourses extends JFrame implements ActionListener{
    private JButton b1, b2;
    private JLabel l1, l2;
    private JComboBox t1, t2;
    public EnrolledStudents enrolledStudents = new EnrolledStudents();
    public offeredCourses off = new offeredCourses();
    
    public void asignar(EnrolledStudents enrolledStudents, offeredCourses off){
        this.enrolledStudents = enrolledStudents;
        this.off = off;
    }
    
    public AddCourses(){
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
        t1 = new JComboBox();
        t2 = new JComboBox();

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(b1);
        add(b2);
        
        l1.setBounds(10, 20, 100, 25);
        t1.setBounds(120, 20, 100, 20);
        l2.setBounds(10, 50, 100, 25);
        t2.setBounds(120, 50, 100, 20);
        b1.setBounds(50, 120, 80, 20);
        b2.setBounds(150, 120, 80, 20);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1){
            
        }
        if (e.getSource() == b2){
        
        }
    }
    
    public static void main(String[] args){
        AddCourses co = new AddCourses();
    }
}