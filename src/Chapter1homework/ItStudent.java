/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter1homework;

/**
 *
 * @author PC
 */
public class ItStudent extends Student {

    private int midTerm;
    private int project;
    private int finalTerm;

    public ItStudent(int id, String name, String major, int midTerm, int project, int finalTerm) {
        super(id, name, major);
        this.midTerm = midTerm;
        this.project = project;
        this.finalTerm = finalTerm;
        this.setGrade((midTerm * 0.30) + (project * 0.30) + (finalTerm * 40));
    }

    public int getMidTerm() {
        return midTerm;
    }

    public void setMidTerm(int midTerm) {
        this.midTerm = midTerm;
    }

    public int getProject() {
        return project;
    }

    public void setProject(int project) {
        this.project = project;
    }

    public int getFinalTerm() {
        return finalTerm;
    }

    public void setFinalTerm(int finalTerm) {
        this.finalTerm = finalTerm;
    }

}
