import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SorterTest {
    private final int sampleSize = 8000;

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


    /* TEST BUBBLE SORT */
    @Test
    public void testBubbleSort() {
        testBubbleSortByClass(Integer.class);
        testBubbleSortByClass(Double.class);
        testBubbleSortByClass(Character.class);
        testBubbleSortByClass(String.class);
    }

    private <T extends Comparable<T>> void testBubbleSortByClass(Class<T> type) {
        // make lists of certain size
        List<T> list = generateList(sampleSize, type);

        List<T> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);

        List<T> reverseList = new ArrayList<>(sortedList);
        Collections.reverse(reverseList);

        // test lists
        testBubbleSortAList(list, sortedList);
        testBubbleSortAList(sortedList, sortedList);
        testBubbleSortAList(reverseList, sortedList);
    }

    <T extends Comparable<T>> void testBubbleSortAList(List<T> input, List<T> expected) {
        Sorter.bubble(input);
        Assertions.assertEquals(expected, input);
    } // END TEST BUBBLE SORT



    /* TEST SELECTION SORT */
    @Test
    public void testSelectionSort() {
        testSelectionSortByClass(Integer.class);
        testSelectionSortByClass(Double.class);
        testSelectionSortByClass(Character.class);
        testSelectionSortByClass(String.class);
    }

    private <T extends Comparable<T>> void testSelectionSortByClass(Class<T> type) {
        // make lists of certain size
        List<T> list = generateList(sampleSize, type);

        List<T> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);

        List<T> reverseList = new ArrayList<>(sortedList);
        Collections.reverse(reverseList);

        // test lists
        testSelectionSortAList(list, sortedList);
        testSelectionSortAList(sortedList, sortedList);
        testSelectionSortAList(reverseList, sortedList);
    }

    <T extends Comparable<T>> void testSelectionSortAList(List<T> input, List<T> expected) {
        Sorter.selection(input);
        Assertions.assertEquals(expected, input);
    } // END TEST SELECTION SORT



    /* TEST INSERTION SORT */
    @Test
    public void testInsertionSort() {
        testInsertionSortByClass(Integer.class);
        testInsertionSortByClass(Double.class);
        testInsertionSortByClass(Character.class);
        testInsertionSortByClass(String.class);
    }

    private <T extends Comparable<T>> void testInsertionSortByClass(Class<T> type) {
        // make lists of certain size
        List<T> list = generateList(sampleSize, type);

        List<T> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);

        List<T> reverseList = new ArrayList<>(sortedList);
        Collections.reverse(reverseList);

        // test lists
        testInsertionSortAList(list, sortedList);
        testInsertionSortAList(sortedList, sortedList);
        testInsertionSortAList(reverseList, sortedList);
    }

    <T extends Comparable<T>> void testInsertionSortAList(List<T> input, List<T> expected) {
        Sorter.insertion(input);
        Assertions.assertEquals(expected, input);
    } // END TEST INSERTION SORT


    
    /* TEST SHELL SORT */
    @Test
    public void testShellSort() {
        testShellSortByClass(Integer.class);
        testShellSortByClass(Double.class);
        testShellSortByClass(Character.class);
        testShellSortByClass(String.class);
    }

    private <T extends Comparable<T>> void testShellSortByClass(Class<T> type) {
        // make lists of certain size
        List<T> list = generateList(sampleSize, type);

        List<T> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);

        List<T> reverseList = new ArrayList<>(sortedList);
        Collections.reverse(reverseList);

        // test lists
        testShellSortAList(list, sortedList);
        testShellSortAList(sortedList, sortedList);
        testShellSortAList(reverseList, sortedList);
    }

    <T extends Comparable<T>> void testShellSortAList(List<T> input, List<T> expected) {
        Sorter.shell(input);
        Assertions.assertEquals(expected, input);
    } // END TEST SHELL SORT
}
