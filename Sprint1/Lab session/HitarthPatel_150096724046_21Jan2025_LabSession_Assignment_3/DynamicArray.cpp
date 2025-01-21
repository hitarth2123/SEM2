#include <iostream>
using namespace std;

int main() {
    int size;
    cout << "Enter array size: ";
    cin >> size;

    int* arr = new int[size];

    for (int i = 0; i < size; ++i) {
        arr[i] = i * 10;
    }

    int sum = 0;
    for (int i = 0; i < size; ++i) {
        sum += arr[i];
    }
    double average = static_cast<double>(sum) / size;

    cout << "Array elements: ";
    for (int i = 0; i < size; ++i) {
        cout << arr[i] << " ";
    }
    cout << "\nSum: " << sum << "\nAverage: " << average << endl;

    delete[] arr;

    return 0;
}

