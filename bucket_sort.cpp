#include <iostream>
#include <algorithm>

using namespace std;

// Function to perform insertion sort on a bucket
void insertionSort(float bucket[], int size, int& comparisons) {
    for (int i = 1; i < size; i++) {
        float key = bucket[i];
        int j = i - 1;

        while (j >= 0 && bucket[j] > key) {
            bucket[j + 1] = bucket[j];
            j--;
            comparisons++;
        }

        bucket[j + 1] = key;
    }
}

// Function to perform bucket sort
void bucketSort(float arr[], int n, int& comparisons) {
    // Create an array of empty buckets
    float buckets[n][n];
    int bucketSize[n] = {0};

    // Add elements to the buckets
    for (int i = 0; i < n; i++) {
        int index = n * arr[i];
        buckets[index][bucketSize[index]] = arr[i];
        bucketSize[index]++;
    }

    // Sort the buckets and concatenate the sorted buckets
    int index = 0;
    for (int i = 0; i < n; i++) {
        if (bucketSize[i] > 0) {
            insertionSort(buckets[i], bucketSize[i], comparisons);
            for (int j = 0; j < bucketSize[i]; j++) {
                arr[index++] = buckets[i][j];
                comparisons++;
            }
        }
    }
}

// Function to print an array
void printArray(float arr[], int n) {
    for (int i = 0; i < n; i++)
        cout << arr[i] << " ";
    cout << endl;
}

int main() {
    float arr[] = {0.42, 0.32, 0.33, 0.52, 0.37, 0.47, 0.51};
    int n = sizeof(arr) / sizeof(arr[0]);
    int comparisons = 0;

    bucketSort(arr, n, comparisons);

    cout << "Sorted array is \n";
    printArray(arr, n);
    cout << "Number of comparisons: " << comparisons << endl;

    return 0;
}
