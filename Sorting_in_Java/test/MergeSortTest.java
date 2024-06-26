import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


public class MergeSortTest extends SorterTest {

    @Override
    public  <T extends Comparable<T>> void runSort(List<T> input, List<T> expected) {
        Sorter.mergeSort(input);
        Assertions.assertEquals(expected, input);
    }

    @Test
    public void testOnSorted() {
        super.runSortOnSorted();
    }

    @Test
    public void testOnRandom() {
        super.runSortOnRandom();
    }

    @Test
    public void testOnReversed() {
        super.runSortOnReversed();
    }
}
