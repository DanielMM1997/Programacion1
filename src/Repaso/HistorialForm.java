/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repaso;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author danie
 */
public class HistorialForm extends JFrame{
    private List lista1, lista2;
    public Productos tienda;
    
    public void assing(Productos tienda){
        this.tienda = tienda;
    }
    
    public HistorialForm(){
        setBounds(300, 200, 400, 400);
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lista1 = new List();
        lista2 = new List();
        add(lista1);
        add(lista2);
        lista1.setBounds(20, 20, 100, 200);
        lista2.setBounds(20, 200, 100, 200);
    }
    
    public void showHistorial(){
        
    }
}
