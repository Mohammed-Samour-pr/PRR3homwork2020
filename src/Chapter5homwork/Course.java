/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter5homwork;

/**
 *
 * @author PC
 */
public class Course {

    private int cid;
    private String course_name;
    private String room;

    public Course() {
    }

    public Course(int cid, String course_name, String room) {
        this.cid = cid;
        this.course_name = course_name;
        this.room = room;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Course id: " + cid + " Course name: " + course_name + " room: " + room;
    }

}
