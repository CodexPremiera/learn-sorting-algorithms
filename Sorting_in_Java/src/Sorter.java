import java.util.List;

public class Sorter<T extends Comparable<T>> {

    /* SORTING ALGORITHMS */

    /**
     * BUBBLE SORT
     *
     * <p> The bubble sort algorithm is infamous for being so slow.
     * The algorithm iterates through the list. On each iteration,
     * it iterates again to find the largest element of the list
     * and 'bubble-it-up' to the end.
     *
     * <li> Worst-case Time Complexity: `O(n²)`
     * <li> Average-case Time Complexity: `O(n²)`
     * <li> Best-case Time Complexity: `O(n²)`
     * */
    public void bubble(List<T> list) {
        int last = list.size() - 1;

        for (int i = 0; i < last; i++) {
            boolean didSwap = false;
            int startOfSorted = last - i;

            // iterate only through the unsorted section
            for (int j = 0; j < startOfSorted; j++) {
                // record values
                T current = list.get(j);
                T next = list.get(j + 1);

                // check if current > next
                boolean currentIsGreaterThanNext = current.compareTo(next) > 0;
                if (!currentIsGreaterThanNext)
                    continue;

                // swap current and next
                list.set(j, next);
                list.set(j + 1, current);
                didSwap = true;
            }

            if (!didSwap)
                break;
        }
    } // END OF BUBBLE SORT
}
