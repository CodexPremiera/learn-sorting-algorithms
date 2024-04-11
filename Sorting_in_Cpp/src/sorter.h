#ifndef SORTING_IN_CPP_SORTER_H
#define SORTING_IN_CPP_SORTER_H

#endif //SORTING_IN_CPP_SORTER_H

#include <vector>
#include <algorithm>

using namespace std;

class Sorter {
public:
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
    template<typename T>
    void static bubble(vector<T>& list) {
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
                if (!(current > next))
                    continue;

                // swap current and next
                std::swap(list[j], list[j + 1]);
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
    template <typename T>
    void static selection(std::vector<T>& list) {
        int size = list.size();
        int last = size - 1;

        for (int i = 0; i < last; i++) {
            int minIndex = i;

            for (int j = i; j < size; j++) {
                if (!(list[j] < list[minIndex]))
                    continue;

                minIndex = j;
            }

            if (minIndex != i)
                std::swap(list[i], list[minIndex]);
        }
    }


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
    template<typename T>
    void static insertion(std::vector<T>& list) {
        int size = list.size();

        for (int i = 1; i < size; i++) {
            int j = i;

            while (j >= 1 && list[j] < list[j - 1]) {
                T temp = list[j];
                list[j] = list[j - 1];
                list[j - 1] = temp;
                j--;
            }
        }
    }
};
