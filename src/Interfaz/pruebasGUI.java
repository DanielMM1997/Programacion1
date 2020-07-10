package Interfaz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class pruebasGUI extends JFrame implements ActionListener {
    private JButton b1, b2, b3;
    private JLabel texto;
    private JTextField esc, esc1;
    private JMenu menu;
    private JMenuItem item1, item2;
    private JMenuBar menuBar;
    private JRadioButton r1, r2, r3;
    private JComboBox box;
    private JPanel panel;
    private JList<String> lista;
    private int alarma = 0;

    public pruebasGUI(){
        Toolkit pantalla = Toolkit.getDefaultToolkit();
        Dimension tamPantalla = pantalla.getScreenSize();
        int altura = tamPantalla.height;
        int ancho = tamPantalla.width;
        //etSize (ancho/2, altura/2);
        //setLocation(ancho/4, altura/4);
        setBounds(ancho/3, altura/3, 520, 260);
        setTitle("prueba");
        //setResizable(false);
        setLayout(null);
        
        //setOpacity(0.5f);
        esc = new JTextField ("");        
        esc1 = new JTextField ("Mi nombre es");        
        add(esc);
        add(esc1);
        esc.setBounds(100, 65, 180, 25); 
        esc.setEditable(false);
        esc1.setBounds(100, 100, 180, 20);
        esc1.setEditable(false);
        texto = new JLabel ("La frase es: ");
        add(texto);
        texto.setBounds(20, 65, 100, 25);
        
        //Añadir botones
        b1 = new JButton ("Di hola");        
        b2 = new JButton ("Di adios");        
        b3 = new JButton ("Saluda");
        add(b1);
        add(b2);
        add(b3);
        b1.setBounds(20, 20, 80, 25);
        b2.setBounds(110, 20, 80, 25);
        b3.setBounds(200, 20, 80, 25);        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);    
       
        //Añadir el menu
        menu = new JMenu("Menu");
        menuBar = new JMenuBar();
        item1 = new JMenuItem("Opciones");
        item2 = new JMenuItem("Salir");
        menu.add(item1);
        menu.add(item2);  
        menuBar.add(menu);
        setJMenuBar(menuBar);        
        item1.addActionListener(new gestorMenu());
        item2.addActionListener(new gestorMenu());
        
        //Añadir RadioButton
        r1 = new JRadioButton("Mensual", false);  
        r2 = new JRadioButton("Quincenal", false);
        r3 = new JRadioButton("Semanal", false);
        r1.setBounds(300, 20, 100, 20);
        r2.setBounds(300, 40, 100, 20);
        r3.setBounds(300, 60, 100, 20);
        r1.addActionListener(new gestorRB());
        r2.addActionListener(new gestorRB());
        r3.addActionListener(new gestorRB());    
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
        add(r1);
        add(r2);
        add(r3);  
        
        //Añadir comboBox 
        String[] res = {"Dani", "Juan", "Pepe", "Sara"};
        box = new JComboBox(res);
        add(box);
        box.setBounds(20, 100, 70, 20);
        box.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                esc1ActionPerformed(e);
            }
        });
        
        //Lista
        String[] list = {"1", "2", "3", "4"};
        lista = new JList<String>(list);
        add(lista);
        
        lista.setBounds(300, 100, 80, 50);
        /*
        item1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                item1ActionPerformed(e);
            }
        });
        item2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                esc.setText("Abierto");
            }
        });*/
        
        panel = new JPanel();
        add(panel);
        panel.setBounds(0, 0, ancho, altura);
        panel.setBackground(Color.CYAN);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        Object botonPulsado = e.getSource();
        if (botonPulsado == b1){
            esc.setText("Hola");
        }
        if (botonPulsado == b2){
            esc.setText("Adios");
        }
        if (botonPulsado == b3){
            esc.setText("Saludos");
        }
    }
    
    private class gestorMenu implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if (e.getSource() == item1){
                switch(alarma){
                    case 1:
                        esc.setText("Ha fijado alarma mensual");
                        break;
                    case 2:
                        esc.setText("Ha fijado alarma quincenal");
                        break;
                    case 3:
                        esc.setText("Ha fijado alarma semanal");
                        break;
                    default:
                        esc.setText("No ha fijado alarma");
                        break;
                }
            }
            if (e.getSource() == item2){
                int respuesta = JOptionPane.showConfirmDialog(item2, "¿Seguro que quieres salir?", 
                        "Error", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (respuesta == 0) {
                    dispose();
                }
            }
        }
    }
    
    private class gestorRB implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if (e.getSource() == r1){
                alarma = 1;
            }
            if (e.getSource() == r2){
                alarma = 2;
            }
            if (e.getSource() == r3){
                alarma = 3;
            }
        }
    }
    
    public void esc1ActionPerformed(ActionEvent e){
        int pos = box.getSelectedIndex();
        if (pos == 0){
            esc1.setText("Mi nombre es: Dani");
        }
        if (pos == 1){
            esc1.setText("Mi nombre es: Juan");
        }
        if (pos == 2){
            esc1.setText("Mi nombre es: Pepe");
        }
        if (pos == 3){
            esc1.setText("Mi nombre es: Sara");
        }
    }
    /*
    public void item1ActionPerformed(ActionEvent e){
        esc.setText("Cerrado");
    }*/
    
    public static void main(String[] args){
        pruebasGUI ventana = new pruebasGUI();
    }
}
