#include <iostream>
using namespace std;

int binarySearch(int arr[], int left, int right, int target) 
{
    while (left <= right) {
        int mid = left + (right - left) / 2;
        
        if (arr[mid] == target)
            return mid;
        
        if (arr[mid] < target)
            left = mid + 1;
        else
            right = mid - 1;
    }
    return -1; 
}
int main() 
{
    int arr[] = {5, 10, 15, 20, 25};
    int size = sizeof(arr) / sizeof(arr[0]);
    int target = 15;

    int result = binarySearch(arr, 0, size - 1, target);

    if (result != -1) {
        cout << "Element found at index " << result << "." << endl;
    } else {
        cout << "Element not found." << endl;
    }

    return 0;
}