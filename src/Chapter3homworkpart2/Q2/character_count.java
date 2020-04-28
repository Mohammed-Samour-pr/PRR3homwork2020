package Chapter3homworkpart2.Q2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author 
 */
public class character_count {

    public static void main(String[] args) {
        try {
            Map<String, Long> character_count = Files
                    .lines(Paths.get("files/text.txt"))
                    .parallel()
                    .flatMap(line -> Arrays.stream(line.toLowerCase().split("")))
                    .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
            character_count.forEach((character, value) -> System.out.println(character + ":" + value));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
