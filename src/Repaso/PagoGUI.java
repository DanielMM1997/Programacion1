package Repaso;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class PagoGUI extends JFrame implements ActionListener{
    private List lista1;
    private Button b1;
    public JTextField precio;
    public Productos tienda;
    
    public void assing(Productos tienda){
        this.tienda = tienda;        
    }
    
    public PagoGUI(){
        setBounds(350, 200, 400, 250);
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lista1 = new List();
        b1 = new Button("Pagar");
        precio = new JTextField();
        add(lista1);
        add(b1);
        add(precio);
        lista1.setBounds(20, 30, 100, 150);
        b1.setBounds(200, 50, 70, 25);
        precio.setBounds(200, 100, 80, 25);
        precio.setEditable(false);
        b1.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e){
        
    }
    
    public void showProductos(){
        lista1.removeAll();
        for (int i = 0; i < tienda.carrito.size(); i ++){
            lista1.add(tienda.carrito.get(i).getNombre());
        }        
    }
    
    
    public void showPrecio(){
        int prec = 0;
        for (int i = 0; i < tienda.carritoSize(); i++){
            prec += tienda.carrito.get(i).getPrecio();
        }
        String precioFinal = String.valueOf(prec);
        precio.setText(precioFinal);
    }
}