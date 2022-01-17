/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author Alan.Ryan
 */
public class Student {
    
    private String name;
    private int grade1;
    private int grade2;
    private int grade3;

    public Student(String name, int grade1, int grade2, int grade3) {
        this.name = name;
        this.grade1 = grade1;
        this.grade2 = grade2;
        this.grade3 = grade3;
    }

    public String getName() {
        return name;
    }

    public int getGrade1() {
        return grade1;
    }

    public int getGrade2() {
        return grade2;
    }

    public int getGrade3() {
        return grade3;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade1(int grade1) {
        this.grade1 = grade1;
    }

    public void setGrade2(int grade2) {
        this.grade2 = grade2;
    }

    public void setGrade3(int grade3) {
        this.grade3 = grade3;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", grade1=" + grade1 + ", grade2=" + grade2 + ", grade3=" + grade3 + '}';
    }
    
    
    
}
