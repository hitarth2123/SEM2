#include <iostream>
using namespace std;

void merge(int arr[], int l, int m, int size) {
    int i, j, k;
    int n1 = m - l + 1;
    int n2 = size - m;

    int L[n1], Size[n2];

    for (i = 0; i < n1; i++)
        L[i] = arr[l + i];
    for (j = 0; j < n2; j++)
        Size[j] = arr[m + 1 + j];

    i = 0;
    j = 0;
    k = l;
    while (i < n1 && j < n2) {
        if (L[i] <= Size[j]) {
            arr[k] = L[i];
            i++;
        }
        else {
            arr[k] = Size[j];
            j++;
        }
        k++;
    }

    while (i < n1) {
        arr[k] = L[i];
        i++;
        k++;
    }

    while (j < n2) {
        arr[k] = Size[j];
        j++;
        k++;
    }
}

void mergeSort(int arr[], int l, int size) {
    if (l < size) {
        int m = l + (size - l) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, size);
        merge(arr, l, m, size);
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

    mergeSort(arr, 0, size - 1);
    cout << "Sorted array is ";
    for (int i = 0; i < size; i++) {
        cout << arr[i] << " ";
    }
    return 0;
}
