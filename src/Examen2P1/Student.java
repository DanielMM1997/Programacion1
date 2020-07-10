/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen2P1;

import java.util.*;
/*
public class Student {
    private String name;
    private int id;
    private ArrayList<Course> courseArrayList = new ArrayList<Course>();
    
    public Student(int id, String name){
        this.id = id;
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public int getId(){
        return id;
    }
    public boolean enrolledCourse(Course cour){
        Course actual;
        String aux;
        for (Course i: courseArrayList){
            aux = i.getName();
            if (aux.equals(cour.getName())){
                return false;
            }
        }
        courseArrayList.add(cour);
        return true;
    }
    public boolean unenrollCourse(int id){
        Iterator<Course> ite = courseArrayList.iterator();
        Course actual;
        int aux;
        while (ite.hasNext()){
            actual = ite.next();
            aux = actual.getCode();
            if (aux == id){
                courseArrayList.remove(actual);
                return true;
            }
        }
        return false;
    }
    
    //Ver que tiene de peculiar las colecciones, que las ordena de manera diferente que las ArrayList
    public Collection <Course> getEnrolledCourse(){
        Collection <Course> toReturn = new ArrayList<>();
        Iterator <Course> ite = courseArrayList.iterator();
        Course cour;
        while (ite.hasNext()){
            cour = ite.next();
            toReturn.add(cour);
        }
        return toReturn;
    }
    
    @Override
    public boolean equals(Object obj){
        if (obj instanceof Student){
            Student aux =(Student)obj;
            if (aux.getId() == this.getId()){
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
    @Override
    public String toString(){
        String est = this.getId() + "-" + this.getName();
        String res = "[";
        Course cour;
        Iterator<Course> ite = this.courseArrayList.iterator();
        while(ite.hasNext()){
            cour = ite.next();
            res += cour.getCode() + ": " + cour.getName() + ", ";
        }
        String fin = est + res + "]";
        return fin;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        return hash;
    }
}
*/

public class Student {
    private String name;
    private int id;
    private Set<Course> materias;
    
    public Student(int id, String name){
        this.name = name;
        this.id = id;
        materias = new HashSet<>();
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getName(){
        return this.name;
    }
    /*
    public Iterator <Course> ite(){
        Iterator <Course> ite = materias.iterator();
        while(ite.hasNext()){
            Course aux = ite.next();
        }
        return ite;
    }*/
    
    public boolean enrolledCourse(Course nueva){
        boolean res = materias.add(nueva);
        return res;
    }
    
    public boolean unRolledCourse(int id){
        Iterator <Course> ite = materias.iterator();
        while(ite.hasNext()){
            Course aux = ite.next();
            if (aux.getCode() == id){
                materias.remove(aux);
                return true;
            }
        }
        return false;
    }
      
    public Collection <Course> getEnrolledCourse(){
        Collection <Course> toReturn = new ArrayList<>();
        Iterator <Course> ite = materias.iterator();
        Course cour;
        while (ite.hasNext()){
            cour = ite.next();
            toReturn.add(cour);
        }
        return toReturn;
    }

    @Override
    public String toString(){
        String res = this.getId() + "-" + this.getName();
        String ca = "[";
        Iterator<Course> ite = this.materias.iterator();
        Course c;
        while (ite.hasNext()){
            c = ite.next();
            ca += c.toString() + ", ";
        }
        //ca.substring(0, ca.length()-2);
        return res + ca + "]" + "\n";
    }
    
    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        if (obj instanceof Student) {
            Student aux = (Student) obj;
            if (this.name.equals(aux.getName())){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public int hashCode(){
        int res = 31;
        res = 17 * res + ((name == null) ? 0 : name.hashCode());
        return res;
    }
}
