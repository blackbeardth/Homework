#include <iostream>

using namespace std;

// Function to swap two elements
void swap(int &a, int &b) {
    int temp = a;
    a = b;
    b = temp;
}

// Function to heapify a subtree rooted at index i
void heapify(int arr[], int n, int i, int& count) {
    int largest = i;  // Initialize largest as root
    int left = 2*i + 1;  // left child index
    int right = 2*i + 2;  // right child index
 
    // If left child is larger than root
    if (left < n && arr[left] > arr[largest]) {
        largest = left;
        count++;
    }
 
    // If right child is larger than largest so far
    if (right < n && arr[right] > arr[largest]) {
        largest = right;
        count++;
    }
 
    // If largest is not root
    if (largest != i) {
        swap(arr[i], arr[largest]);
 
        // Recursively heapify the affected sub-tree
        heapify(arr, n, largest, count);
    }
}

// Main function to do heap sort
void heapSort(int arr[], int n, int& count) {
    // Build heap (rearrange array)
    for (int i = n / 2 - 1; i >= 0; i--)
        heapify(arr, n, i, count);
 
    // One by one extract an element from heap
    for (int i = n - 1; i > 0; i--) {
        // Move current root to end
        swap(arr[0], arr[i]);
 
        // call max heapify on the reduced heap
        heapify(arr, i, 0, count);
    }
}

// Function to print an array
void printArray(int arr[], int size) {
    for (int i = 0; i < size; i++)
        cout << arr[i] << " ";
    cout << endl;
}

int main() {
    int arr[] = {12, 11, 13, 5, 6, 7};
    int n = sizeof(arr) / sizeof(arr[0]);
    int count = 0;

    heapSort(arr, n, count);

    cout << "Sorted array is \n";
    printArray(arr, n);
    cout << "Number of comparisons: " << count << endl;

    return 0;
}
