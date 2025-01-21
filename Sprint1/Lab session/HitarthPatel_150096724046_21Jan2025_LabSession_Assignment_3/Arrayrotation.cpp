#include <iostream>
using namespace std;

class ArrayRotation {
public:
    void leftRotate(int arr[], int size, int positions) {
        int* temp = new int[positions];
        for (int i = 0; i < positions; ++i) {
            temp[i] = arr[i];
        }
        for (int i = positions; i < size; ++i) {
            arr[i - positions] = arr[i];
        }
        for (int i = 0; i < positions; ++i) {
            arr[size - positions + i] = temp[i];
        }
        delete[] temp;
    }

     void rightRotate(int arr[], int size, int positions) {
        for (int i = 0; i < positions; ++i) {
            int temp = arr[size - 1];
            for (int j = size - 1; j > 0; --j) {
                arr[j] = arr[j - 1];
            }
            arr[0] = temp;
        }
    }

    void leftRotateReversal(int arr[], int size, int positions) {
        reverse(arr, 0, positions - 1);
        reverse(arr, positions, size - 1);
        reverse(arr, 0, size - 1);
    }

    void rightRotateReversal(int arr[], int size, int positions) {
        reverse(arr, 0, size - 1);
        reverse(arr, 0, positions - 1);
        reverse(arr, positions, size - 1);
    }

    void printArray(int arr[], int size) {
        for (int i = 0; i < size; ++i) {
            cout << arr[i] << " ";
        }
        cout << endl;
    }

private:
    void reverse(int arr[], int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
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

    int positions;
    cout << "Enter positions to rotate: ";
    cin >> positions;

    ArrayRotation rotation;
    rotation.leftRotate(arr, size, positions);
    cout << "Left rotated array: ";
    rotation.printArray(arr, size);

    rotation.rightRotate(arr, size, positions);
    cout << "Right rotated array: ";
    rotation.printArray(arr, size);

    rotation.leftRotateReversal(arr, size, positions);
    cout << "Left rotated array using reversal: ";
    rotation.printArray(arr, size);

    rotation.rightRotateReversal(arr, size, positions);
    cout << "Right rotated array using reversal: ";
    rotation.printArray(arr, size);

    delete[] arr;

    return 0;
}