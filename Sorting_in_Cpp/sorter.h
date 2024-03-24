#ifndef SORTING_IN_CPP_SORTER_H
#define SORTING_IN_CPP_SORTER_H

#endif //SORTING_IN_CPP_SORTER_H

#include <vector>
#include <algorithm>

using namespace std;

template<typename T>
class Sorter {
public:
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
    void bubble(vector<T>& list) {
        int last = list.size() - 1;

        for (int i = 0; i < last; i++) {
            bool didSwap = false;
            int startOfSorted = last - i;

            // iterate only through the unsorted section
            for (int j = 0; j < startOfSorted; j++) {
                // record values
                T current = list[j];
                T next = list[j + 1];

                // check if current > next
                if (current > next) {
                    swap(list[j], list[j + 1]);
                    didSwap = true;
                }
            }

            if (!didSwap)
                break;
        }
    } // END OF BUBBLE SORT
};
