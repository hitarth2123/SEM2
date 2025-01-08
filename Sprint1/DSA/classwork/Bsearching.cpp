#include <iostream>
using namespace std;

int BinarySearch(int arr[],int size ,int target , int mid, int l,int r){
    l=0;
    r=size;
    mid=l+r/2;

    while (l <= r) {
        mid = l + (r - l) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            l = mid + 1;
        } else {
            r = mid - 1;
        }
    }
    return -1;
}

int main(){
    int arr[]={10,20,30,40,50};
    int size=sizeof(arr)/sizeof(arr[0]);
    int target,mid,l,r;


    cout<<"Enter the element to search ";
    cin>>target;
    cout<<"Size of array is "<<size<<endl;

    int result = BinarySearch(arr,size,target,mid,l,r);
    if(result!=-1){
        cout<<"Element found at index "<< result <<endl;
    }else{
        cout<<"Element not found in the array "<<endl;
    }

}