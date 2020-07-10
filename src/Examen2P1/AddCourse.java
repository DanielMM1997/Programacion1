package Examen2P1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class AddCourse extends JDialog {
    private offeredCourses off;
    private EnrolledStudents enroll;
    private JLabel label1, label2;
    String [] str2;
    String[] str;
    private JComboBox combo1, combo2;
    private JButton boton1, boton2;
    
    public AddCourse(offeredCourses off, EnrolledStudents enroll){
        this.off = off;
        this.enroll = enroll;
        init();
    }
    
    public void init(){
        label1 = new JLabel("Student:");
        label2 = new JLabel("Course:");
        combo1 = new JComboBox();
        combo2 = new JComboBox();
        boton1 = new JButton("Aceptar");
        boton2 = new JButton("Cancelar");
        Container panel = getContentPane();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        JPanel id = new JPanel();
        JPanel name = new JPanel();
        JPanel botones = new JPanel();
        id.setLayout(new FlowLayout());
        name.setLayout(new FlowLayout());
        botones.setLayout(new FlowLayout());
        id.add(label1);
        name.add(label2);
        id.add(combo1,BorderLayout.EAST);
        botones.add(boton1,BorderLayout.WEST);
        botones.add(boton2,BorderLayout.EAST);
        name.add(combo2,BorderLayout.EAST);
        panel.add(name,BorderLayout.EAST);
        panel.add(id,BorderLayout.EAST);
        panel.add(botones,BorderLayout.SOUTH);
        
        List<Course> list = off.getCourses();
        str = new String[list.size()];
        int x = 0;
        Iterator<Course> ite = list.iterator();
        Course aux;
        while (ite.hasNext()){
            aux = ite.next();
            str[x] = aux.getName();
            x++;
        }
        for (int i = 0; i < str.length; i++){
            combo2.addItem(str[i]);
        }
        
        List<Student> list2 = enroll.getStudentsOrderByName();
        Iterator<Student> ite2 = list2.iterator();
        Student aux2;
        str2 = new String[list2.size()];
        int a = 0;
        while (ite2.hasNext()){
            aux2 = ite2.next();
            str2[a] = aux2.getName();
            a++;
        }
        for (int i = 0; i < str2.length; i++){
            combo1.addItem(str2[i]);
        }
        boton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                int ae = combo1.getSelectedIndex();
                int ac = combo2.getSelectedIndex();
                String resCourse = str[ae];
                String resStudent = str2[ac];
                Student auxiliar;
                Student auxiliar2 = null;
                Iterator<Student> ite5 = enroll.arr.iterator();
                while (ite5.hasNext()){
                    auxiliar = ite5.next();
                    if(auxiliar.getName().equals(resStudent)){
                        auxiliar2 = auxiliar;
                    }
                }
                Course aux5;
                Course aux6 = null;
                Iterator<Course>ite6 = off.getCourses().iterator();
                while (ite6.hasNext()){
                    aux5 = ite6.next();
                    if(aux5.getName().equals(resCourse)){
                        aux6 = aux5;
                    }
                }
                List<Course> lista = (List)auxiliar2.getEnrolledCourse();
                Iterator<Course> ite8 = lista.iterator();
                Course aux9;
                boolean are = true;
                while (ite8.hasNext()){
                    aux9 = ite8.next();
                    if(aux9.getName().equals(aux6.getName())){
                        are = false;
                    }
                }
                if(are == true){
                    auxiliar2.enrolledCourse(aux6);
                    dispose();
                }else{
                    //Falta poner de que salga mensaje de error con esto:JOptionPane.showMessageDialog();
                    JOptionPane.showMessageDialog(boton1,
                            "Introduce bien los valores.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        boton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
            }
        });
        pack();
        setVisible(true);
    }
    public static void main (String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception e) {
        }
        new JavaSwing();
    }
}
