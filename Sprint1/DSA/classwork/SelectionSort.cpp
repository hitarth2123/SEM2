#include <iostream>
using namespace std;
    class SelectionSort {
    public:
        void sort(int arr[], int size) {
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    if (arr[i] > arr[j]) {
                        int rough = arr[i];
                        arr[i] = arr[j];
                        arr[j] = rough;
                    }
                }
            }
        }
    };
int main()
{
    int size;
    cout << "Enter the size of array ";
    cin >> size;
    int arr[size];
    cout << "Enter the elements of array ";
    for (int i = 0; i < size; i++)
    {
        cin >> arr[i];
    }

    SelectionSort selectionSort;
    selectionSort.sort(arr, size);
    cout << "Sorted array is ";
    for (int i = 0; i < size; i++)
    {
        cout << arr[i] << " ";
    }
    return 0;
}