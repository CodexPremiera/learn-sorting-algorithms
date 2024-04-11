#include "test/sorter_test.h"

int main() {
    SorterTester* tester = new SorterTester();

    tester->testBubbleSort();
    tester->testSelectionSort();

    return 0;
}
