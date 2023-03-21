import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Main {
    public static void main(String[] args) {
        Stream<Integer> stream = new ArrayList<>(Arrays.asList(1, 2, 4, 6, 8, 17, 33)).stream();

        FindMinMax.findMinMax(
                stream,
                Comparator.naturalOrder(),
                (x, y) -> System.out.printf("min: %s, max: %s%n", x, y)
        );

        stream.close();

        //Задание 2
        System.out.println("Количество четных чисел " + countEvenNumber(stream.collect(Collectors.toList())));
    }

    public static int countEvenNumber(List<Integer> integers) {
        return (int) integers.stream()
                .filter(i -> i % 2 == 0)
                .peek(System.out::println)
                .count();
    }
}
