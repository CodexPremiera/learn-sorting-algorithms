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
    template<typename T>
    void static shell(std::vector<T>& list) {
        int size = list.size();

        for (int gap = size / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < size; i++) {
                int j = i;

                while (j >= gap && list[j] < list[j - gap]) {
                    T temp = list[j];
                    list[j] = list[j - gap];
                    list[j - gap] = temp;
                    j -= gap;
                }
            }
        }
    } // END OF SHELL SORT


    /**
     * MERGE SORT
     *
     * <p> The mergeList sort algorithm is a divide-and-conquer algorithm that
     * divides the list into two halves, then sorts each half, and merges them
     * back together.
     *
     * <p> In this implementation, the merge() method recursively divides
     * the list into a left and a right sublist and performs merge on each
     * of them. Once sorted, the left and right are mergeList together using the
     * mergeList() helper method.
     *
     * <ul>
     * <li> Worst-case Time Complexity: `O(n log₂n)`
     * <li> Average-case Time Complexity: `O(n log₂n)`
     * <li> Best-case Time Complexity: `O(n log₂n)`
     * */
    template<typename T>
    static void mergeList(std::vector<T>& merged, const std::vector<T>& left, const std::vector<T>& right) {
        merged.clear();

        int leftSize = left.size();
        int rightSize = right.size();
        int leftCount = 0;
        int rightCount = 0;

        while (leftCount < leftSize && rightCount < rightSize) {
            const T& leftCurrent = left[leftCount];
            const T& rightCurrent = right[rightCount];

            if (leftCurrent <= rightCurrent) {
                merged.push_back(leftCurrent);
                leftCount++;
            } else {
                merged.push_back(rightCurrent);
                rightCount++;
            }
        }

        while (leftCount < leftSize)
            merged.push_back(left[leftCount++]);

        while (rightCount < rightSize)
            merged.push_back(right[rightCount++]);
    }

    template<typename T>
    static void merge(std::vector<T>& list) {
        int listSize = list.size();
        if (listSize <= 1) return;

        int middle = listSize / 2;
        std::vector<T> left(list.begin(), list.begin() + middle);
        std::vector<T> right(list.begin() + middle, list.end());

        merge(left);
        merge(right);

        mergeList(list, left, right);
    } // END OF MERGE SORT


    /**
     * QUICK SORT
     *
     * <p> The quick sort algorithm is a divide-and-conquer algorithm that uses
     * a pivot to divide a list between the elements greater than the pivot and
     * the elements lesser than the pivot.
     *
     * <p> In this implementation, the quick() method recursively calls the
     * partition() method to find the pivot index. The partition() method divides
     * the list into two sides—one greater and one lesser than the pivot. Then the
     * quick() method is called on each side.
     *
     * <ul>
     * <li> Worst-case Time Complexity: `O(n log₂n)`
     * <li> Average-case Time Complexity: `O(n log₂n)`
     * <li> Best-case Time Complexity: `O(n log₂n)`
     * */
    template<typename T>
    int static partition(std::vector<T>& list, int low, int high) {
        int pivotIndex = low + (high - low) / 2;
        T pivot = list[pivotIndex];
        std::swap(list[pivotIndex], list[high]);
        int swapMarker = low;
        for (int current = low; current < high; current++) {
            if (list[current] > pivot)
                continue;

            if (swapMarker != current)
                std::swap(list[swapMarker], list[current]);

            swapMarker++;
        }
        std::swap(list[swapMarker], list[high]);
        return swapMarker;
    }

    template<typename T>
    static void quick(std::vector<T>& list, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, low, high);
            quick(list, low, pivotIndex - 1);
            quick(list, pivotIndex + 1, high);
        }
    }

    template<typename T>
    static void quick(std::vector<T>& list) {
        quick(list, 0, list.size() - 1);
    }
    // END OF QUICK SORT
};
