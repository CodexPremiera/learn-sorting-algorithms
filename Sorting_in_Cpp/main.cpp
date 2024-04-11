#include "test/sorter_test.h"

int main() {
    SorterTester* tester = new SorterTester();

    tester->testBubbleSort();
    tester->testSelectionSort();
    tester->testInsertionSort();
    tester->testShellSort();
    tester->testMergeSort();
    tester->testQuickSort();

    return 0;
}
