#include <iostream>
#include <cstdlib>
#include <ctime>
#include <algorithm>

using namespace std;

// Function to partition an array around a pivot
int partition(int arr[], int left, int right, int& comparisons) {
    int pivotIndex = left + rand() % (right - left + 1);
    int pivotValue = arr[pivotIndex];
    swap(arr[pivotIndex], arr[right]);
    int storeIndex = left;

    for (int i = left; i < right; i++) {
        if (arr[i] < pivotValue) {
            swap(arr[i], arr[storeIndex]);
            storeIndex++;
            comparisons++;
        }
    }

    swap(arr[storeIndex], arr[right]);
    return storeIndex;
}

// Function to perform randomized select on an array
int randomizedSelect(int arr[], int left, int right, int k, int& comparisons) {
    if (left == right) {
        return arr[left];
    }

    int pivotIndex = partition(arr, left, right, comparisons);
    int pivotRank = pivotIndex - left + 1;

    if (k == pivotRank) {
        return arr[pivotIndex];
    } else if (k < pivotRank) {
        return randomizedSelect(arr, left, pivotIndex - 1, k, comparisons);
    } else {
        return randomizedSelect(arr, pivotIndex + 1, right, k - pivotRank, comparisons);
    }
}

// Function to print an array
void printArray(int arr[], int n) {
    for (int i = 0; i < n; i++)
        cout << arr[i] << " ";
    cout << endl;
}

int main() {
    int arr[] = {3, 5, 7, 2, 1, 4, 6};
    int n = sizeof(arr) / sizeof(arr[0]);
    int k = 3;
    int comparisons = 0;

    srand(time(nullptr));
    int kthSmallest = randomizedSelect(arr, 0, n - 1, k, comparisons);

    cout << "The " << k << "th smallest element is " << kthSmallest << endl;
    cout << "Number of comparisons: " << comparisons << endl;

    return 0;
}
