import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class Main {
    public static List<Integer> integerList = new ArrayList<>(List.of(
            44, 91, 15, 20, 77, 33, 908, 345));

    public static Long getCountForEvenInteger(List<Integer> integers) {
        return integers.stream().filter(integer -> integer % 2 == 0).count();
    }

    public static <A> void findMinMax(
            Stream<? extends A> stream,
            Comparator<? super A> order,
            BiConsumer<? super A, ? super A> minMaxConsumer) {

        List<A> items = (List<A>) stream.sorted(order).toList();
        if (!items.isEmpty()) {
            minMaxConsumer.accept(items.get(0), items.get(items.size() - 1));
        } else {
            minMaxConsumer.accept(null, null);
        }
    }

    public static void main(String[] args) {
        findMinMax(integerList.stream(), Integer::compareTo, (x, y) -> System.out.printf("min число: %s, max число: %s\n", x, y));
        System.out.println("Количество четных чисел: " + getCountForEvenInteger(integerList));
    }
}
