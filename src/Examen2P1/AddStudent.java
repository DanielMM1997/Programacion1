package Examen2P1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddStudent extends JDialog {
    EnrolledStudents enrolledStudents = new EnrolledStudents();
    private JLabel label1, label2;
    private JTextField textfield1, textfield2;
    private JButton aceptar, cerrar;
    public AddStudent(EnrolledStudents enrolledStudents){
        this.enrolledStudents = enrolledStudents;
        init();
    }
    private void init(){
        label1 = new JLabel("Student id");
        label2 = new JLabel("Student name");
        textfield1 = new JTextField(15);
        textfield2 = new JTextField(15);
        aceptar = new JButton("Aceptar");
        cerrar = new JButton("Cerrar");
        Container panel = getContentPane();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        JPanel id = new JPanel();
        JPanel name = new JPanel();
        JPanel botones = new JPanel();
        id.setLayout(new FlowLayout());
        name.setLayout(new FlowLayout());
        botones.setLayout(new FlowLayout());
        id.add(label2);
        id.add(textfield2, BorderLayout.EAST);
        name.add(label1);
        name.add(textfield1, BorderLayout.EAST);
        botones.add(aceptar, BorderLayout.WEST);
        botones.add(cerrar, BorderLayout.EAST);
        panel.add(name, BorderLayout.EAST);
        panel.add(id, BorderLayout.EAST);
        panel.add(botones, BorderLayout.SOUTH);
        aceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                aceptarBoton(evt);
            }
        });
        cerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cerrarBoton(evt);
            }
        });

        pack();
        setVisible(true);
    }
    private void aceptarBoton(ActionEvent evt) {
        String aux = textfield2.getText();
        int aux2 = Integer.parseInt(textfield1.getText());
        Student es = new Student(aux2, aux);
        enrolledStudents.addStudent(es);
        dispose();
    }

    private void cerrarBoton(java.awt.event.ActionEvent evt) {
        dispose();
    }
    public static void main (String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception e) {
        }
        new JavaSwing();
    }
}
