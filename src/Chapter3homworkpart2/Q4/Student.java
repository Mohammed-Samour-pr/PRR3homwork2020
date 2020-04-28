package Chapter3homworkpart2.Q4;

/**
 *
 * @author 
 */
public class Student implements Comparable<Student> {

    private int id;
    private String name;
    private String major;
    private double grade;

    public Student(int id, String name, String major, double grade) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.grade = grade;
    }

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

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public int compareTo(Student s) {
        if (this.grade > s.grade) {
            return -1;
        } else if (this.grade < s.grade) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return String.format("%-5s %-10s %-10s %8.2f", id, name, major, grade);
    }
}
