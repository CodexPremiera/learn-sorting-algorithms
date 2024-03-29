import java.util.List;

public class Sorter {

    /* SORTING ALGORITHMS */

    /**
     * BUBBLE SORT
     *
     * <p> The bubble sort algorithm is infamous for being so slow.
     * The algorithm iterates through the list, finds the largest
     * element in each iteration and 'bubbles-it-up' to the end.
     *
     * <li> Worst-case Time Complexity: `O(n²)`
     * <li> Average-case Time Complexity: `O(n²)`
     * <li> Best-case Time Complexity: `O(n)`
     * */
    public static <T extends Comparable<T>> void bubble(List<T> list) {
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


    /**
     * SELECTION SORT
     *
     * <p> The selection sort algorithm divides the list into two sections:
     * the sorted section and the unsorted section. The algorithm iterates
     * through the list, 'selects' the index of the smallest in each iteration
     * and places it to the current position.
     *
     * <li> Worst-case Time Complexity: `O(n²)`
     * <li> Average-case Time Complexity: `O(n²)`
     * <li> Best-case Time Complexity: `O(n²)`
     * */
    public static <T extends Comparable<T>> void selection(List<T> list) {
        int size = list.size();
        int last = size - 1;

        for (int i = 0; i < last; i++) {
            int minIndex = i;

            // iterate only through the unsorted section
            for (int j = i; j < size; j++) {
                T current = list.get(j);
                T minElement = list.get(minIndex);

                boolean currentIsLesser = current.compareTo(minElement) < 0;
                if (currentIsLesser)
                    minIndex = j;
            }

            // swap with min index
            if (minIndex != i) {
                T temp = list.get(i);
                list.set(i, list.get(minIndex));
                list.set(minIndex, temp);
            }
        }
    } // END OF SELECTION SORT


    /**
     * INSERTION SORT
     *
     * <p> The insertion sort algorithm divides the list into two sections:
     * the sorted section and the unsorted section. The algorithm iterates
     * through the list, 'inserts' the current element into the correct position
     * in the sorted section.
     *
     * <li> Worst-case Time Complexity: `O(n²)`
     * <li> Average-case Time Complexity: `O(n²)`
     * <li> Best-case Time Complexity: `O(n)`
     * */
    public static <T extends Comparable<T>> void insertion(List<T> list) {
        int size = list.size();

        for (int i = 1; i < size; i++) {
            int j = i;

            while (j >= 1 &&
                    list.get(j).compareTo(list.get(j - 1)) < 0) {
                T temp = list.get(j);
                list.set(j, list.get(j - 1));
                list.set(j - 1, temp);
                j--;
            }
        }
    } // END OF INSERTION SORT


    /**
     * SHELL SORT
     *
     * <p> The shell sort algorithm is considered as an optimization
     * of insertion. Whereas insertion sort compares and swaps on every
     * adjacent element, shell sort does so at certain gaps first before
     * on each adjacent. By doing so, the list would be much closer to
     * sorted when performing the insertion sort in the end.
     *
     * <p> Shell sort also follows different increments in their gaps.
     * However, the most common is the original increment. Gaps in this
     * increment is a set of 'halves of the length (n)'. The gap starts
     * with the n/2, followed by n/4, n/8, and so on until 1.
     *
     * <li> Worst-case Time Complexity: `O(n²)`
     * <li> Average-case Time Complexity: `O(n log₂n)`
     * <li> Best-case Time Complexity: `O(n log₂n)`
     * */
    public static <T extends Comparable<T>> void shell(List<T> list) {
        int size = list.size();

        for (int gap = size / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < size; i++) {
                int j = i;

                while (j >= gap &&
                        list.get(j).compareTo(list.get(j - gap)) < 0) {
                    T temp = list.get(j);
                    list.set(j, list.get(j - gap));
                    list.set(j - gap, temp);
                    j -= gap;
                }
            }
        }
    } // END OF SHELL SORT

}
