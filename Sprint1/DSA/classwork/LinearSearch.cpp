#include <iostream>
using namespace std;
int linearSearch(int arr[], int size, int target){
    for (int i=0;i<size;i++){
        if(arr[i]== target){
            return i;
        }
    }
}

int main(){
    int arr[]={10,25,30,45,50};
    int size=sizeof(arr)/sizeof(arr[0]);
    int target;

    cout<<"Enter the element to search ";
    cin>>target;

    int result = linearSearch(arr,size,target);
    if(result!=-1){
        cout<<"Element found at index "<< result <<endl;
    }else{
        cout<<"Element not found in the array "<<endl;
    }
}