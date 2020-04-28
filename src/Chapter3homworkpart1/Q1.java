/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter3homworkpart1;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author PC
 */
public class Q1 {

    public static void main(String[] args) {
        List< Integer> list_1;
        list_1 = new LinkedList< Integer>();
        Random r = new Random();//اختيار الرقم العشوائء 
        int x = 0;
        while (x < 30) {
            int number = r.nextInt(100);
            list_1.add(number);
            x++;
        }
        int sum = 0;
        float average = 0;
        Collections.sort(list_1);
        int size = list_1.size();
        for (int j = 0; j < size; j++) {
            sum += list_1.get(j);
        }
        average = (sum / size);
        System.out.println(" number of elements = " + size);
        System.out.println("Sum of the elements = " + sum);
        System.out.println("floating-point average of the elements = " + average);
    }
}
