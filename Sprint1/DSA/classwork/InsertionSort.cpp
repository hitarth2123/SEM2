#include <iostream>
using namespace std;
    
        void Insertionsort(int arr[], int size) {
        for(int i=1;i<size;i++){
            int key=arr[i];
            cout<< "\nkey ="<< key;
            int j=i-1;
            cout<<"\nj = " << j;
        
        while(j>=0 && arr[j]>key){
            arr[j+1] =arr[j];
            cout <<"\narr[j+1] = "<< arr[j+1];  // value to compare with
            j--;
        }
        arr[j+1]=key;
         cout << "\narr[j+1] = "<<arr[j+1]; 
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