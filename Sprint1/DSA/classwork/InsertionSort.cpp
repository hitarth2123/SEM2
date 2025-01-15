#include <iostream>
using namespace std;
    class InsertionSort {
    public:
        void sort(int arr[], int size) {
        for(int i=1;i<size;i++){
            int key=arr[i];
            int j=i-1;
        
        while(j>=0 &&arr[j]>key){
            arr[j+1] =arr[i];
            j--;
        }
        arr[j+1]=key;
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
     cout << "Original array is ";
    for (int i = 0; i < size; i++)
    {
        cout << arr[i] << " ";
    }
    InsertionSort insertionSort;
    insertionSort.sort(arr, size);
    cout << "Sorted array is ";
    for (int i = 0; i < size; i++)
    {
        cout << arr[i] << " ";
    }
    return 0;
}