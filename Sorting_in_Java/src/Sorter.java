import java.util.List;

public class Sorter<T extends Comparable<T>> {

    /* METHODS */
    public void bubble(List<T> list) {
        int last = list.size() - 1;

        for (int i = 0; i < last; i++) {
            boolean didSwap = false;
            int startOfSorted = last - i;

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
    }
}
