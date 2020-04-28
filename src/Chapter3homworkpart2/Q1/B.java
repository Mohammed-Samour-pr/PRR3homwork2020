package Chapter3homworkpart2.Q1;

import java.util.function.Function;

/**
 *
 * @author 
 */
public class B {

    public static void main(String[] args) {
        Function<String, String> toUpper_lambda = String::toUpperCase;
        System.out.println(toUpper_lambda.apply("fgdfg"));
    }
}
