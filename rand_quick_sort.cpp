#include <iostream>
#include <cstdlib>

using namespace std;

int partition(int arr[], int low, int high, int& count) {
    int pivot = arr[high];
    int i = (low - 1);

    for (int j = low; j <= high - 1; j++) {
        count++;
        if (arr[j] < pivot) {
            i++;
            swap(arr[i], arr[j]);
        }
    }
    swap(arr[i + 1], arr[high]);
    return (i + 1);
}

int random_partition(int arr[], int low, int high, int& count) {
    int random = low + rand() % (high - low);
    swap(arr[random], arr[high]);
    return partition(arr, low, high, count);
}

int randomized_quicksort(int arr[], int low, int high, int& count) {
    if (low < high) {
        int pi = random_partition(arr, low, high, count);
        randomized_quicksort(arr, low, pi - 1, count);
        randomized_quicksort(arr, pi + 1, high, count);
    }
    return count;
}

int main() {
    int arr[] = { 10, 7, 8, 9, 1, 5 };
    int n = sizeof(arr) / sizeof(arr[0]);
    int count = 0;
    randomized_quicksort(arr, 0, n - 1, count);
    cout << "Sorted array: ";
    for (int i = 0; i < n; i++)
        cout << arr[i] << " ";
    cout << endl << "Total comparisons: " << count;
    return 0;
}
