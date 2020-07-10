package Interfaz;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class OperacionesGUI extends JFrame implements ActionListener{
    private JLabel l1, l2, l3, l4, l5, l6;
    private JTextField t1, t2, t3, t4;
    private JRadioButton rb1, rb2, rb3;
    private JButton b1;
    private ButtonGroup bg;
    private int bp;
    
    public OperacionesGUI(){
        setBounds(300, 200, 400, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        iniciar();
    }
    
    private void iniciar(){
        l1 = new JLabel("Variable");
        l2 = new JLabel("a = ");
        l3 = new JLabel("b = ");
        l4 = new JLabel("c = ");
        l5 = new JLabel("Expresiones a elegir");
        l6 = new JLabel("Resultado");
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        bg = new ButtonGroup();
        rb1 = new JRadioButton("(a+(b+c))");
        rb2 = new JRadioButton("(a=(a+b))");
        rb3 = new JRadioButton("(a+b), (b+c), (a+c)");
        b1 = new JButton("Calcular");
        
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(l6);
        add(t1);
        add(t2);
        add(t3);
        add(t4);
        bg.add(rb1);
        bg.add(rb2);
        bg.add(rb3);
        add(rb1);
        add(rb2);
        add(rb3);
        
        add(b1);
        
        l1.setBounds(20, 20, 100, 20);
        l2.setBounds(20, 45, 20, 20);
        l3.setBounds(20, 65, 20, 20);
        l4.setBounds(20, 85, 20, 20);
        l5.setBounds(20, 130, 150, 20);
        t1.setBounds(50, 45, 40, 20);
        t2.setBounds(50, 65, 40, 20);
        t3.setBounds(50, 85, 40, 20);
        rb1.setBounds(20, 150, 100, 20);
        rb2.setBounds(130, 150, 100, 20);
        rb3.setBounds(240, 150, 100, 20);
        l6.setBounds(200, 90, 100, 20);
        t4.setBounds(260, 90, 80, 20);
        b1.setBounds(240, 40, 100, 20);
        b1.addActionListener(this);
        rb1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                bp = 1;
            }
        });
        rb2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                bp = 2;
            }
        });
        rb3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                bp = 3;
            }
        });
        
    }
    
    public static void main(String res[]){
        OperacionesGUI ope = new OperacionesGUI();
    }
    
    public void RadioBotones(ActionEvent e){
    
    }
    
    public void actionPerformed(ActionEvent e){
        if (bp == 1){
            String a = t1.getText();
            int v1 = Integer.valueOf(a);
            String b = t2.getText();
            int v2 = Integer.valueOf(b);
            String c = t3.getText();
            int v3 = Integer.valueOf(c);            
            Variable va1 = new Variable(a, v1);
            Variable va2 = new Variable(b, v2);
            Variable va3 = new Variable(c, v3);            
            Expresion ex1 = new Plus(va1, va2);
            Expresion ex2 = new Plus(ex1, va3);
            t4.setText(String.valueOf(ex2.evaluate()));
            
        }
        if (bp == 2){
            String a = t1.getText();
            int v1 = Integer.valueOf(a);
            String b = t2.getText();
            int v2 = Integer.valueOf(b);
            String c = t3.getText();
            int v3 = Integer.valueOf(c);
            Variable va1 = new Variable(a, v1);
            Variable va2 = new Variable(b, v2);
            Variable va3 = new Variable(c, v3);
            Expresion ex1 = new Plus(va1, va2);
            Expresion ex2 = new Plus(ex1, va3);
            
            t4.setText(String.valueOf(ex2.evaluate()));
        }
        if (bp == 3){
            String a = t1.getText();
            int v1 = Integer.valueOf(a);
            String b = t2.getText();
            int v2 = Integer.valueOf(b);
            String c = t3.getText();
            int v3 = Integer.valueOf(c);
            Variable va1 = new Variable(a, v1);
            Variable va2 = new Variable(b, v2);
            Variable va3 = new Variable(c, v3);
        }
    }
}