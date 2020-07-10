/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repaso;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
 *
 * @author danie
 */
public class TiendaGUI extends JFrame implements ActionListener{
    private List lista1, lista2;
    private Button añadir, pagar, historial;
    public JTextField precio;
    public Productos tienda;
    
    public void assing(Productos tienda){
        this.tienda = tienda;
    }
    
    public TiendaGUI(){
        setBounds(300, 150, 500, 420);
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        iniciarElementos();
    }
    
    private void iniciarElementos(){
        lista1 = new List();
        lista2 = new List();
        añadir = new Button("Añadir");    
        pagar = new Button("Pagar");
        historial = new Button("historial");
        precio = new JTextField();
        add(lista1);
        add(lista2);
        add(añadir);   
        add(pagar);
        add(historial);
        add(precio);
        lista1.setBounds(20, 50, 150, 250);
        lista2.setBounds(280, 50, 150, 250);
        añadir.setBounds(180, 100, 80, 25);
        pagar.setBounds(50, 320, 80, 25);
        historial.setBounds(350, 320, 80, 25);
        precio.setBounds(350, 320, 80, 25);
        añadir.addActionListener(this);
        pagar.addActionListener(this);
        historial.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == pagar){
            PagoGUI pago = new PagoGUI();            
            pago.assing(tienda);
            pago.showProductos();
            pago.showPrecio();
        } 
        if (e.getSource() == añadir){
            añadirCarrito();
        }
        
        if(e.getSource() == historial){
            HistorialForm historialform = new HistorialForm();
            historialform.assing(tienda);
            historialform.showHistorial();
        }
    }
    
    public void showProductos(){
        lista1.removeAll();
        for (int i = 0; i < tienda.productosSize(); i ++){
            lista1.add(tienda.productos.get(i).getNombre());
        }
    }
    
    public void añadirCarrito(){
        Producto selected;
        int active = lista1.getSelectedIndex();
        for (int i = 0; i < tienda.productos.size(); i++){
            if (active == i){
                selected = tienda.productos.get(i);
                tienda.addCarrito(selected);
                lista2.add(selected.getNombre());
            }
        }
        showPrecio();
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
