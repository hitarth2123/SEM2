#include <iostream>
using namespace std;
    
        void Insertionsort(int arr[], int size) {
                 for(int i=1;i<size;i++){
                        int key=arr[i];
                        int j=i-1;
                        while(j>=0 && arr[j]>key){
                            arr[j+1] =arr[j];
                            j--;
                       }
                        arr[j+1]=key;
                    }
        }
    
    

int main()
{
    int size;
    cout << "\nEnter the size of array ";
    cin >> size;
    int arr[size];
    cout << "\nEnter the elements of array ";
    for (int i = 0; i < size; i++)
    {
        cin >> arr[i];
    }
     cout << "\nOriginal array is ";
    for (int i = 0; i < size; i++)
    {
        cout << arr[i] << " ";
    }
    
    Insertionsort(arr, size);
    cout << "\nSorted array is ";
    for (int i = 0; i < size; i++)
    {
        cout << arr[i] << " ";
    }
    return 0;
}