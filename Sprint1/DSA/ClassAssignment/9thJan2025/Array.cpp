#include<iostream>
using namespace std;

void traverseArray(int arr[], int size) {
    for(int i = 0; i < size; i++) {
        cout << arr[i] << " ";
    }
}

int main() {
    int size;
    cout << "Enter the size of the array: ";
    cin >> size;
    int arr[size];
    cout << "Enter elements of the array: ";
    for(int i = 0; i < size; i++) {
        cin >> arr[i];
    }
    traverseArray(arr, size);
    return 0;
}

