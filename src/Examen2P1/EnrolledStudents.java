package Examen2P1;
import java.util.*;

public class EnrolledStudents {
    ArrayList<Student> arr;
    
    public EnrolledStudents(){
        arr = new ArrayList<>();
    }
    
    public boolean addStudent(Student es1){
        Iterator<Student> ite = arr.iterator();
        Student es;
        while (ite.hasNext()){
            es = ite.next();
            if (es.getId() == es1.getId()){
                return false;
            }
        }
        arr.add(es1);
        return true;
    }
    
    public boolean removeStudent(int a){
        Iterator<Student> ite = arr.iterator();
        Student es;
        while (ite.hasNext()){
            es = ite.next();
            if (es.getId() == a){
                arr.remove(es);
                return true;
            }
        }
        return false;
    }
    
    public Student getStudent(int a){
        Iterator<Student> ite = arr.iterator();
        Student es;
        while( ite.hasNext()){
            es = ite.next();
            if (es.getId() == a){
                return es;
            }
        }
        return null;
    }
    
    public List<Student> getStudentsByCourse(int a){
        Collection<Course> cour;
        Iterator<Student> ite = arr.iterator();
        Student es;
        List<Student> list = new ArrayList<>();
        while (ite.hasNext()){
            es = ite.next();
            cour = es.getEnrolledCourse();
            Iterator<Course> ite2 = cour.iterator();
            Course cour2;
            while (ite2.hasNext()){
                cour2 = ite2.next();
                if (cour2.getCode() == a){
                    list.add(es);
                }
            }
        }
        Collections.sort(list, new OrdenString());
        return list;
    }
    
    private class OrdenString implements Comparator<Student> {
        public int compare(Student a, Student b){
            if (a.getName().compareTo(b.getName()) > 0) {
                return 1;
            } else if (a.getName().compareTo(b.getName()) < 0){
                return -1;
            } else {
                if (a.getId() > b.getId()){
                    return 1;
                } else {
                    return -1;
                }
            }
        }
    }
    
    private class OrdenInt implements Comparator <Student> {
        public int compare (Student a, Student b){
            if (a.getId() > b.getId()){
                return 1;
            } else if (a.getId() < b.getId()){
                return -1;
            } else {
                return 0;
            }
        }
    }
    
    public List <Student> getStudentsOrderByName(){
        Iterator <Student> ite = arr.iterator();
        List<Student> list = new ArrayList<>();
        Student aux;
        while(ite.hasNext()){
            aux = ite.next();
            list.add(aux);
        }
        Collections.sort(list, new OrdenString());
        return list;
    }
    
    public List <Student> getStudentsOrderById(){
        Iterator <Student> ite = arr.iterator();
        List<Student> list = new ArrayList<>();
        Student aux;
        while(ite.hasNext()){
            aux = ite.next();
            list.add(aux);
        }
        Collections.sort(list, new OrdenInt());
        return list;
    }
}

/*
public class EnrolledStudents implements Comparable<EnrolledStudents>{
    private Set<Student> alumnos;
    
    public EnrolledStudents(){
        alumnos = new TreeSet<>();
    }
    
    public boolean addStudent(Student nuevo){
        Iterator<Student> ite = alumnos.iterator();
        Student res;
        while (ite.hasNext()){
            res = ite.next();
            if (res.getName().equals(nuevo.getName())){
                return false;
            }
        }
        alumnos.add(nuevo);
        return true;   
    }
    
    public boolean removeStudent(int id){
        Iterator<Student> ite = alumnos.iterator();
        Student res;
        while (ite.hasNext()){
            res = ite.next();
            if (res.getId() == id){
                alumnos.remove(res);
                return true;
            }
        }
        return false;
    }
    
    public Student getStudent(int id){        
        Iterator<Student> ite = alumnos.iterator();
        Student res;
        while (ite.hasNext()){
            res = ite.next();
            if (res.getId() == id){
                return res;
            }
        }
        return null;
    }
    
    public List<Student>getStudentByCourse(int a){
        Collection<Course> cour;
        Iterator<Student>ite=alumnos.iterator();
        Student es;
        List<Student>list=new ArrayList<Student>();
        while(ite.hasNext()){
            es=ite.next();
            cour=es.getEnrolledCourse();
            Iterator<Course>ite2=cour.iterator();
            Course cour2;
            while(ite2.hasNext()){
                cour2=ite2.next();
                if(cour2.getCode()==a){
                    list.add(es);
                }
            }
        }
        Collections.sort(list,new OrdenString());
        return list;
    }
    private static class OrdenString implements Comparator<Student> {
        public int compare(Student a, Student b){
            if(a.getName().compareTo(b.getName())>0) {
                return 1;
            }else if(a.getName().compareTo(b.getName())<0){
                return -1;
            }else{
                if(a.getId()>b.getId()){
                    return -1;
                }else{
                    return 1;
                }
            }
        }
    }
    private static class OrdenInt implements Comparator<Student>{
        public int compare(Student a, Student b){
            if(a.getId()>b.getId()){
                return -1;
            }else if(a.getId()<b.getId()){
                return 1;
            }else{
                return 0;
            }
        }
    }
    public List <Student> getStudentsOrderByName(){
        Iterator <Student> ite= alumnos.iterator();
        List<Student> list= new ArrayList<>();
        Student aux;
        while(ite.hasNext()){
            aux=ite.next();
            list.add(aux);
        }
        Collections.sort(list,new OrdenString());
        return list;
    }
    public List <Student> getStudentsOrderById(){
        Iterator <Student> ite= alumnos.iterator();
        List<Student> list= new ArrayList<>();
        Student aux;
        while(ite.hasNext()){
            aux=ite.next();
            list.add(aux);
        }
        Collections.sort(list,new OrdenInt());
        return list;
    }


    
    @Override
    public int compareTo(EnrolledStudents o) {
        return 0;
    }
 
    
}*/
