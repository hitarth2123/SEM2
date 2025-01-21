#include <iostream>
using namespace std;

template <typename T>
int linearSearch(T arr[], int size, T key) {
    for (int i = 0; i < size; ++i) {
        if (arr[i] == key) {
            return i; 
        }
    }
    return -1; 
}

int main() {
    int size;
    cout << "Enter the size of the array: ";
    cin >> size;

    int* arr = new int[size];
    cout << "Enter the elements of the array: ";
    for (int i = 0; i < size; ++i) {
        cin >> arr[i];
    }

    int key;
    cout << "Enter the key to search: ";
    cin >> key;

    int result = linearSearch(arr, size, key);
    if (result != -1) {
        cout << "Element found at index " << result << endl;
    } else {
        cout << "Element not found" << endl;
    }

    delete[] arr;

    return 0;
}