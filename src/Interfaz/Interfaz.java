/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Interfaz extends JFrame implements ActionListener {
    private JLabel contadorLbl;
    private JTextField contadorJtf;
    private JButton incBtn, decBtn;

    public Interfaz(String title) {
        super(title);
        //setTitle("Ventana Prueba");
        setLocation(300,300);
        setSize(400, 70);
        setResizable(false);
        setLayout(new FlowLayout());
        contadorLbl = new JLabel("Contador: ");
        contadorJtf = new JTextField("0", 5);
        contadorJtf.setEditable(false);
        incBtn = new JButton("Incrementar");
        decBtn = new JButton("Decrementar");
        add(contadorLbl);
        add(contadorJtf);
        add(decBtn);
        add(incBtn);        
        
        incBtn.addActionListener(this);
        decBtn.addActionListener(this);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int cont = 0;
        if (e.getSource() == incBtn) {
            cont = Integer.parseInt(contadorJtf.getText()) + 1;
        } 
        if (e.getSource() == decBtn){
            cont = Integer.parseInt(contadorJtf.getText()) - 1;
        }
        contadorJtf.setText("" + cont);
    }
    
    public static void main(String[] arg) {
        Interfaz app1 = new Interfaz ("Ejemplo eventos");
    }
}