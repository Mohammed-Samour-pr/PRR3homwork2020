/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter3homworkpart1;

/**
 *
 * @author PC
 */
public class Student_class {

    private int id;
    private String name;
    private String major;
    private double geade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getGeade() {
        return geade;
    }

    public void setGeade(double geade) {
        this.geade = geade;
    }

    @Override
    public String toString() {
        return "    " + getId() + "            " + getName() + "            " + getMajor() + "            " + getGeade();
    }

    public int compareTo(Object o) {
        double Geades = ((Student_class) o).getGeade();
        return (int) (this.geade - Geades);
    }

}
