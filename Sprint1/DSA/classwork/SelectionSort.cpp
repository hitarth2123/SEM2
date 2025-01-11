#include <iostream>
using namespace std;
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
    int rough;
    for (int i = 0; i < size; i++)
    {
        for (int j = i + 1; j < size; j++)
        {
            if (arr[i] > arr[j])
            {
                rough = arr[i];
                arr[i] = arr[j];
                arr[j] = rough;
            }
        }
    }
    cout << "Sorted array is ";
    for (int i = 0; i < size; i++)
    {
        cout << arr[i] << " ";
    }
    return 0;
}