#ifndef SORTING_IN_CPP_SORTER_TESTER_H
#define SORTING_IN_CPP_SORTER_TESTER_H

#endif //SORTING_IN_CPP_SORTER_TESTER_H

#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <random>
#include "../src/sorter.h"

using namespace std;

class SorterTester {
private:
    // Function to check if a vector is sorted
    template<typename T>
    bool isSorted(const vector<T>& vec) {
        for (size_t i = 1; i < vec.size(); ++i) {
            if (vec[i] < vec[i - 1])
                return false;
        }
        return true;
    }

    template<typename T>
    vector<T> generateRandomVector(int size) {
        vector<T> vec;
        random_device rd;
        mt19937 gen(rd());
        uniform_int_distribution<> dis(1, 1000); // Adjust range as per requirement

        for (int i = 0; i < size; ++i) {
            vec.push_back(dis(gen)); // Generate random element and append
        }

        return vec;
    }

    vector<string> generateRandomStrVector(int size) {
        const int maxLength = 10;
        vector<string> vec;
        random_device rd;
        mt19937 gen(rd());
        uniform_int_distribution<> lenDis(1, maxLength);
        uniform_int_distribution<> charDis(32, 126); // ASCII printable characters

        for (int i = 0; i < size; ++i) {
            int length = lenDis(gen);
            string str;
            for (int j = 0; j < length; ++j) {
                str.push_back(char(charDis(gen)));
            }
            vec.push_back(str);
        }

        return vec;
    }

public:
    // BUBBLE SORT TEST
    void testBubbleSort() {
        const int vectorSize = 2000;

        // Test for integers
        vector<int> unsortedIntegers = generateRandomVector<int>(vectorSize);
        Sorter::bubble(unsortedIntegers);
        if (!isSorted(unsortedIntegers)) {
            cerr << "Bubble sort failed for integers" << endl;
            return;
        }

        // Test for doubles
        vector<double> unsortedDoubles = generateRandomVector<double>(vectorSize);
        Sorter::bubble(unsortedDoubles);
        if (!isSorted(unsortedDoubles)) {
            cerr << "Bubble sort failed for doubles" << endl;
            return;
        }

        // Test for chars
        vector<char> unsortedChars = generateRandomVector<char>(vectorSize);
        Sorter::bubble(unsortedChars);
        if (!isSorted(unsortedChars)) {
            cerr << "Bubble sort failed for chars" << endl;
            return;
        }

        // Test for strings
        vector<string> unsortedStrings = generateRandomStrVector(vectorSize);
        Sorter::bubble(unsortedStrings);
        if (!isSorted(unsortedStrings)) {
            cerr << "Bubble sort failed for strings" << endl;
            return;
        }

        cout << "Bubble sort passed" << endl;
    } // END OF BUBBLE SORT TEST


};
