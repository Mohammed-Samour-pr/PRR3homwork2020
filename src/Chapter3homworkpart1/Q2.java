/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter3homworkpart1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author PC
 */
public class Q2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Scanner input;
        ArrayList<String> namelist = new ArrayList<>();
        File file;
        try {
            file = new File("file.txt");
            input = new Scanner(file);

            while (input.hasNextLine()) {
                String[] data = input.nextLine().split(" ");
                namelist.addAll(Arrays.asList(data));
            }
        } catch (IOException ex) {
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < namelist.size(); i++) {
            sb.append(namelist.get(i) + " ");
        }
        String SS = sb.toString();
        System.out.println("the String : " + SS);
        System.out.println("The letters and the number of repetitions .... ");
        character_Count(SS);
        System.out.println("-------------------------\nWords and number of repetitions .... ");
        word_Count(SS);
    }

    public static void character_Count(String text) {
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        char[] arrays = text.toCharArray();
        for (char c : arrays) {
            if (hashMap.containsKey(c)) {
                hashMap.put(c, hashMap.get(c) + 1);
            } else {
                hashMap.put(c, 1);
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static void word_Count(String text) {
        String item[] = text.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        for (String t : item) {
            if (map.containsKey(t)) {
                map.put(t, map.get(t) + 1);
            } else {
                map.put(t, 1);
            }
        }
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key + " : " + map.get(key));
        }
    }
}
