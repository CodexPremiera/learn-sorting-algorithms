import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


public abstract class SorterTest {
    /* FIELDS */
    private final int sampleSize = 20000;
    private final List<Integer> intList = generateList(sampleSize, Integer.class);
    private final List<Double> doubleList = generateList(sampleSize, Double.class);
    private final List<Character> charList = generateList(sampleSize, Character.class);
    private final List<String> stringList = generateList(sampleSize, String.class);


    /* RANDOM LISTS */
    public final Map<String, List<?>> randomLists = Map.of(
            "INT", intList,
            "DOUBLE", doubleList,
            "CHAR", charList,
            "STRING", stringList
    );

    /* SORTED LISTS */
    public final Map<String, List<?>> sortedLists = Map.of(
            "INT", sortList(intList),
            "DOUBLE", sortList(doubleList),
            "CHAR", sortList(charList),
            "STRING", sortList(stringList)
    );


    /* REVERSED LISTS */
    public final Map<String, List<?>> reversedLists = Map.of(
            "INT", reverseList(intList),
            "DOUBLE", reverseList(doubleList),
            "CHAR", reverseList(charList),
            "STRING", reverseList(stringList)
    );


    /* HELPER METHODS */
    private  <T extends Comparable<T>> List<T> generateList(int size, Class<T> type) {
        List<T> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(generateRandomValue(type));
        }
        return list;
    }

    private <T extends Comparable<T>> T generateRandomValue(Class<T> type) {
        if (type == Integer.class)
            return type.cast((int) (Math.random() * 2000));

        else if (type == Double.class)
            return type.cast(Math.random() * 2000);

        else if (type == Character.class)
            return type.cast((char) ('a' + Math.random() * 26));

        else if (type == String.class) {
            StringBuilder sb = new StringBuilder();
            int length = (int) (Math.random() * 10) + 1;
            for (int i = 0; i < length; i++) {
                sb.append((char) ('a' + Math.random() * 26));
            }
            return type.cast(sb.toString());
        }

        else
            throw new IllegalArgumentException("Unsupported type: " + type.getSimpleName());
    }

    private <T extends Comparable<T>> List<T> sortList(List<T> list) {
        List<T> newList = new ArrayList<>(list);
        Collections.sort(newList);
        return newList;
    }

    private <T extends Comparable<T>> List<T> reverseList(List<T> list) {
        List<T> newList = new ArrayList<>(list);
        Collections.reverse(newList);
        return newList;
    }
    

    /* TESTER METHODS */
    @SuppressWarnings("unchecked")
    public void runSortOnRandom() {
        runSort((List<Integer>) randomLists.get("INT"), (List<Integer>) sortedLists.get("INT"));
        runSort((List<Double>) randomLists.get("DOUBLE"), (List<Double>) sortedLists.get("DOUBLE"));
        runSort((List<Character>) randomLists.get("CHAR"), (List<Character>) sortedLists.get("CHAR"));
        runSort((List<String>) randomLists.get("STRING"), (List<String>) sortedLists.get("STRING"));
    }

    @SuppressWarnings("unchecked")
    public void runSortOnSorted() {
        runSort((List<Integer>) sortedLists.get("INT"), (List<Integer>) sortedLists.get("INT"));
        runSort((List<Double>) sortedLists.get("DOUBLE"), (List<Double>) sortedLists.get("DOUBLE"));
        runSort((List<Character>) sortedLists.get("CHAR"), (List<Character>) sortedLists.get("CHAR"));
        runSort((List<String>) sortedLists.get("STRING"), (List<String>) sortedLists.get("STRING"));
    }

    @SuppressWarnings("unchecked")
    public void runSortOnReversed() {
        runSort((List<Integer>) reversedLists.get("INT"), (List<Integer>) sortedLists.get("INT"));
        runSort((List<Double>) reversedLists.get("DOUBLE"), (List<Double>) sortedLists.get("DOUBLE"));
        runSort((List<Character>) reversedLists.get("CHAR"), (List<Character>) sortedLists.get("CHAR"));
        runSort((List<String>) reversedLists.get("STRING"), (List<String>) sortedLists.get("STRING"));
    }

    
    /* ABSTRACT METHODS */
    public abstract <T extends Comparable<T>> void runSort(List<T> input, List<T> expected);

    @Test
    abstract public void testOnSorted();

    @Test
    abstract public void testOnRandom();

    @Test
    abstract public void testOnReversed();
}
