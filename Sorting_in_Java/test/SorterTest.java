import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SorterTest {

    /* TEST BUBBLE SORT */
    @Test
    public void testBubbleSort() {
        new Thread(() -> testBubbleSortByClass(Integer.class)).start();
        new Thread(() -> testBubbleSortByClass(Double.class)).start();
        new Thread(() -> testBubbleSortByClass(Character.class)).start();
        new Thread(() -> testBubbleSortByClass(String.class)).start();
    }

    private <T extends Comparable<T>> void testBubbleSortByClass(Class<T> type) {
        // make lists of certain size
        List<T> list = generateList(2000000, type);

        List<T> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);

        List<T> reverseList = new ArrayList<>(sortedList);
        Collections.reverse(reverseList);

        // test lists
        new Thread(() -> testBubbleSortAList(list, sortedList)).start();
        new Thread(() -> testBubbleSortAList(sortedList, sortedList)).start();
        new Thread(() -> testBubbleSortAList(reverseList, sortedList)).start();
    }

    <T extends Comparable<T>> void testBubbleSortAList(List<T> input, List<T> expected) {
        Sorter.bubble(input);
        Assertions.assertEquals(expected, input);
    } // END TEST BUBBLE SORT


    /* TEST SELECTION SORT */
    @Test
    public void testSelectionSort() {
        new Thread(() -> testSelectionSortByClass(Integer.class)).start();
        new Thread(() -> testSelectionSortByClass(Double.class)).start();
        new Thread(() -> testSelectionSortByClass(Character.class)).start();
        new Thread(() -> testSelectionSortByClass(String.class)).start();
    }

    private <T extends Comparable<T>> void testSelectionSortByClass(Class<T> type) {
        // make lists of certain size
        List<T> list = generateList(2000000, type);

        List<T> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);

        List<T> reverseList = new ArrayList<>(sortedList);
        Collections.reverse(reverseList);

        // test lists
        new Thread(() -> testSelectionSortAList(list, sortedList)).start();
        new Thread(() -> testSelectionSortAList(sortedList, sortedList)).start();
        new Thread(() -> testSelectionSortAList(reverseList, sortedList)).start();
    }

    <T extends Comparable<T>> void testSelectionSortAList(List<T> input, List<T> expected) {
        Sorter.selection(input);
        Assertions.assertEquals(expected, input);
    } // END TEST SELECTION SORT
    
    

    /* HELPER METHODS */
    public <T extends Comparable<T>> List<T> generateList(int size, Class<T> type) {
        List<T> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(generateRandomValue(type));
        }
        return list;
    }

    private <T extends Comparable<T>> T generateRandomValue(Class<T> type) {
        if (type == Integer.class)
            return type.cast((int) (Math.random() * 1000));

        else if (type == Double.class)
            return type.cast(Math.random() * 1000);

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

}
