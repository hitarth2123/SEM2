#include <iostream>
using namespace std;

void BubbleSort(int arr[], int size) {
    for (int i = 0; i < size - 1; i++) {
        for (int j = 0; j < size - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                arr[j] = arr[j + 1];
                int sort = arr[j];
                arr[j + 1] = sort;
            }
        }
    }
}


int main() {
    int size;
    cout << "Enter the size of array ";
    cin >> size;
    int arr[size];
    cout << "Enter the elements of array ";
    for (int i = 0; i < size; i++) {
        cin >> arr[i];
    }

    BubbleSort(arr, size);
    cout << "Sorted array is ";
    for (int i = 0; i < size; i++) {
        cout << arr[i] << " ";
    }
    return 0;
}

