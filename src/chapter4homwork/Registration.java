/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter4homwork;

/**
 *
 * @author PC
 */
public class Registration {

    private int studentid;
    private int courseid;
    private String semester;

    public Registration() {
    }

    public Registration(int studentid, int courseid, String semester) {
        this.studentid = studentid;
        this.courseid = courseid;
        this.semester = semester;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "Student id: " + studentid + " course id: " + courseid + " semester" + semester;
    }

}
