package ExamenOrd18_19;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.TitledBorder;

public class CollegeGUI extends JFrame{
    
    // Atributos
    private JButton bAdd, bEnroll;
    private JRadioButton rbName, rbId;
    private JTextArea texto;
    private JScrollPane scroll;
    private JMenuItem add, enroll, exit;
    private JMenu menu;
    private JMenuBar menuBar;
    private ButtonGroup grupo;
    private EnrolledStudents enrolledStudents = new EnrolledStudents();
    private OfferedCourses offeredCourses = new OfferedCourses();
    
    private void init(OfferedCourses offeredCourses, EnrolledStudents enrolledStudents) {
        offeredCourses.addCourse(new Course("Mathematic", 100));
        offeredCourses.addCourse(new Course("Language", 101));
        offeredCourses.addCourse(new Course("History", 102));
        offeredCourses.addCourse(new Course("Geography", 103));
        offeredCourses.addCourse(new Course("Physics", 104));
        offeredCourses.addCourse(new Course("Biology", 105));
        offeredCourses.addCourse(new Course("Chemistry", 106));
        offeredCourses.addCourse(new Course("Earth Sciencs", 107));
        Student s1 = new Student("Fulano", 4);
        s1.enrollCourse(offeredCourses.getCourse(100));
        s1.enrollCourse(offeredCourses.getCourse(101));
        enrolledStudents.addStudent(s1);
        Student s2 = new Student("Mengano", 2);
        s2.enrollCourse(offeredCourses.getCourse(101));
        s2.enrollCourse(offeredCourses.getCourse(103));
        enrolledStudents.addStudent(s2);
        enrolledStudents.addStudent(new Student("Zutano", 3));
        enrolledStudents.addStudent(s2);
    }
    
    public CollegeGUI() {
        setLocation(300, 200);
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init(offeredCourses, enrolledStudents);
        initComponents();
        ponerComponentes();
        addListener();
        setVisible(true);
    }
    
    private void initComponents() {
        add = new JMenuItem("add new student");
        enroll = new JMenuItem("Enroll student in curse");
        exit = new JMenuItem("Exit");
        menu = new JMenu("Menu");
        menu.add(add);
        menu.add(enroll);
        menu.add(exit);
        menuBar = new JMenuBar();
        menuBar.add(menu);
        setJMenuBar(menuBar);
        bAdd = new JButton("Add new student");
        bEnroll = new JButton("Enroll student");
        rbName = new JRadioButton("Order student by name", true);
        rbId = new JRadioButton("Order student by id");
        grupo = new ButtonGroup();
        grupo.add(rbName);
        grupo.add(rbId);
        scroll = new JScrollPane();
        texto = new JTextArea();
        texto.setEditable(false);
        texto.setColumns(20);
        texto.setRows(10);
        scroll.setViewportView(texto);
        String res = "";
        for(Student stu : enrolledStudents.getStudentsOrderByName()) {
            res += stu.toString() + "\n";
        }
        texto.setText(res);
    }
    
    private void ponerComponentes() {
        JPanel principal = new JPanel(new BorderLayout());
        JPanel radio = new JPanel();
        radio.setLayout(new BoxLayout(radio, BoxLayout.Y_AXIS));
        radio.setBorder(new TitledBorder("ListOrder"));
        radio.add(rbName);
        radio.add(rbId);
        JPanel der = new JPanel();
        der.setLayout(new BoxLayout(der, BoxLayout.Y_AXIS));
        der.add(radio);
        der.add(bAdd);
        der.add(bEnroll);
        principal.add(scroll, BorderLayout.WEST);
        principal.add(der, BorderLayout.CENTER);
        add(principal);
    }
    
    private void addListener() {
        rbName.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String res = "";
                for(Student stu : enrolledStudents.getStudentsOrderByName()) {
                    res += stu.toString() + "\n";
                }
                texto.setText(res);
            }
        });
        rbId.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String res = "";
                for(Student stu : enrolledStudents.getStudentsOrderById()) {
                    res += stu.toString() + "\n";
                }
                texto.setText(res);
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        add.addActionListener(new GestorEventoAdd());
        bAdd.addActionListener(new GestorEventoAdd());
        bEnroll.addActionListener(new GestorEventoEnroll());
        enroll.addActionListener(new GestorEventoEnroll());
    }

    private class GestorEventoAdd implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            NewStudentDlg añadir = new NewStudentDlg(CollegeGUI.this);
            añadir.setVisible(true);
            enrolledStudents.addStudent(new Student(añadir.getFilmTitle(), Integer.parseInt(añadir.getYear())));
            String res = "";
                for(Student stu : enrolledStudents.getStudentsOrderById()) {
                    res += stu.toString() + "\n";
                }
                texto.setText(res);
        }
    }

    private class GestorEventoEnroll implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            EnrolledStudentDlg enroll = new EnrolledStudentDlg(CollegeGUI.this);
            //enroll
        }
    }
}