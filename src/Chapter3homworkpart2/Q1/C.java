package Chapter3homworkpart2.Q1;

/**
 *
 * @author 
 */
public class C {

    public static void main(String[] args) {
        Operation print = () -> {
            return "Welcome to lambdas!";
        };
        System.out.println(print.display());
    }

    private interface Operation {

        String display();
    }
}
