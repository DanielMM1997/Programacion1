/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen2P1;

public class Course {
    private int code; // Unique numeric identifier of the course
    private String name; // Unique name identifier of the course
    
    public Course(int code, String name) {
        this.code = code;
        this.name = name;
    }
    
    public int getCode() {
        return this.code;
    }
    
    public String getName() {
        return this.name;
    }
    
    @Override
    public String toString() {
        return "(" + this.getCode() + ") " + this.getName();
    }
}
