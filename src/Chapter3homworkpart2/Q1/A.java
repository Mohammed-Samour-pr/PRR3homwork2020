package Chapter3homworkpart2.Q1;

import java.util.function.Consumer;

/**
 *
 * @author 
 */
public class A {
    public static void main(String[] args) {
        Consumer<Integer> print = value -> System.out.println(value);
        print.accept(20);
    }
}
