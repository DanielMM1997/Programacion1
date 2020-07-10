/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen2P1;

import java.util.List;
import java.util.LinkedList;
/**
 * Tihs class represent the courses offered by the college
 */
public class offeredCourses {
    private List<Course> courses;
    
    public offeredCourses() {
        courses = new LinkedList<>();
    }
    
    public void addCourse(Course course) {
        courses.add(course);
    }
    
    public Course getCourse(int code) {
        for (Course c: courses) {
            if (c.getCode() == code) {
                return c;
            }
        }
        return null;
    }
    
    public List<Course> getCourses(){
        return new LinkedList<>(courses);
    }
}