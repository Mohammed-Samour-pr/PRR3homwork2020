package Chapter3homworkpart2.Q1;

/**
 *
 * @author
 */
public class D {

    public static void main(String[] args) {
        Operation<Integer> print = value -> System.out.printf("%d\n", value);
        print.display(20);
    }

    private interface Operation<T> {

        void display(T t);
    }

}
