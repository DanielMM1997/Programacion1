package ExamenOrd18_19;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class NewStudentDlg extends JDialog{

    // Panel principal del diálogo
    private Container contentPane;

    // Componentes visuales del diálogo
    private final JTextField titleTxf;
    private final JTextField yearTxf;
    private final JButton okBtn;
    private final JButton cancelBtn;
    
    /**
     * Constructor del diálogo al que se le pasa una referencia 
     * a la ventana principal de la que depende
     * 
     * @param f referencia al frame de la ventana principal
     */ 
    public NewStudentDlg(JFrame f) {

        // Se inicializan las opciones del diálogo
        super(f, "Add new student");
        setResizable(false);
        setModal(true);
        setLocationRelativeTo(f);

        // Se crea el componente para introducir el título de la película
        titleTxf = new JTextField(10);
        titleTxf.addActionListener(okHandler);

        // Se crea el componente para introducir el año de la película
        yearTxf = new JTextField(10);
        yearTxf.addActionListener(okHandler);

        // Se crean los botones de interacción con el diálogo
        okBtn = new JButton("Aceptar");
        okBtn.addActionListener(okHandler);
        cancelBtn = new JButton("Cancelar");
        cancelBtn.addActionListener(cancelHandler);

        // Interfaz del panel principal al que se le añaden los componentes visuales
        contentPane = getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        addEntryLine("Student ID   ", yearTxf, FlowLayout.RIGHT);
        addEntryLine("Student name", titleTxf, FlowLayout.LEFT);
        addButtons();
        
        pack(); 
    }
    
    // Listener que valida los datos de la nueva película
    private ActionListener okHandler= new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            if (getYear().matches("^(\\d)+$") && getFilmTitle().matches("\\w+")) {
                setVisible(false);
            }            
        }
    };

    // Listener que descarta los datos de la nueva película
    private ActionListener cancelHandler = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            setVisible(false);
        }
    };

    /**
     * Añade un nuevo componente al panel principal precedido con 
     * una etiqueta y con la alineación indicada
     */ 
    private void addEntryLine(String text, JComponent comp, int aling){
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(aling));
        panel.add(new JLabel(text + ":"));
        panel.add(comp);
        contentPane.add(panel);
    }

    /**
     * Añade los botones de la aplicación al panel principal 
     */ 
    private void addButtons(){
        JPanel buttons = new JPanel();
        buttons.add(okBtn);
        buttons.add(cancelBtn);
        contentPane.add(buttons);
    }

    /**
     * Devuelve el nombre de la película
     * 
     * @return título de la película introducida
     */ 
    public String getFilmTitle() {
        return titleTxf.getText();
    }

    /**
     * Devuelve el año de estreno de la película
     * 
     * @return año de la película introducida
     */ 
    public String getYear() {
        return yearTxf.getText();
    }
}