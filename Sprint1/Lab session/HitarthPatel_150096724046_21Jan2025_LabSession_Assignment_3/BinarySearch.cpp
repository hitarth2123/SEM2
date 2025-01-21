#include <iostream>
#include <stdexcept>
using namespace std;

class BinarySearch {
public:
    int search(int arr[], int size, int key) {
        if (!isSorted(arr, size)) {
            throw invalid_argument("Array is not sorted");
        }

        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) {
                return mid; 
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; 
    }

private:
    bool isSorted(int arr[], int size) {
        for (int i = 0; i < size - 1; ++i) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
};

int main() {
    int size;
    cout << "Enter array size: ";
    cin >> size;

    int* arr = new int[size];
    cout << "Enter array elements: ";
    for (int i = 0; i < size; ++i) {
        cin >> arr[i];
    }

    int key;
    cout << "Enter the key to search: ";
    cin >> key;

    BinarySearch search;
    try {
        int result = search.search(arr, size, key);                if (result != -1) {
            cout << "Element found at index " << result << std::endl;
        } else {
            cout << "Element not found" << std::endl;
        }
    } catch (const std::exception& e) {
        cerr << "Error: " << e.what() << std::endl;
    }

    delete[] arr;

    return 0;
}