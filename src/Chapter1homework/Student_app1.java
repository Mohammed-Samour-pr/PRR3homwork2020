/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter1homework;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Mohammed
 */
public class Student_app1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        Student std[] = {
            new ArtStudent(120181466, "Mohammed_1", "IT", 50, 60, 53),
            new ArtStudent(120181466, "Mohammed_2", "IT", 55, 86, 10),
            new ArtStudent(120181466, "Mohammed_3", "IT", 85, 60, 93),
            new ItStudent(120181204, "Ali_1", "IT", 36, 96, 86),
            new ItStudent(120181204, "Ali_2", "IT", 54, 88, 73),
            new ItStudent(120181204, "Ali_3", "IT", 100, 97, 74)

        };
//        //Sort students by average/Grade
//        for (int j = 0; j < std.length; j++) {
//            for (int i = 0; i < std.length - 1; i++) {
//                if (std[i + 1].getGrade() > std[i].getGrade()) {
//                    Student temp = std[i];
//                    std[i] = std[i + 1];
//                    std[i + 1] = temp;
//                }
//
//            }
//        }
//
//        //end Sort
        //print student information .
        for (Student student : std) {
            System.out.println(student);

        } //end print
//
//        //Print out all student information on a text file
//        File file = new File("Student.txt");
//        FileWriter fw = new FileWriter(file);
//        PrintWriter pw = new PrintWriter(fw);
//        for (Student student : std) {
//            pw.println(student);
//        }
//        pw.close();
//        fw.close();
////end Print out all student information on a text file
        String s = "Electronic design management system";

        System.out.println(s.toUpperCase());

    }

}
