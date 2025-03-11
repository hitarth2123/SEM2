
#include <iostream>
using namespace std;
void swap(int* a, int* b) {
    *a = *a + *b;
    *b = *a - *b;
    *a = *a - *b;
}
void swapp(int* a, int* b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}


int main() {
    int q=0;
    cout <<"1.Write a program to swap two integers using pointers (without using a temporary variable.)"<<endl<<"2.Write a program to dyanamically allocate an array of n integers, take input from the user and find the sum of the all elements."<<endl<<"3.Write a program to swap two integers using pointers (using a temporary variables)."<<endl<<"4.Write a program  to find the greates of two integrs using pointers ."<<endl<<"5.Write a program to find the greatestamong three integers usign pointers."<<endl;
    cin>>q;
    
    if(q==1){
    int x, y;

    cout << "Enter the value of x: ";
    cin >> x;
    cout << "Enter the value of y: ";
    cin >> y;

    cout << "Before swap: x = " << x << ", y = " << y << std::endl;

    swap(&x, &y);

    cout << "After swap: x = " << x << ", y = " << y << std::endl;

    return 0;
    }
    else if (q==2)
    {    int n, sum = 0;
    cout << "Enter the number of elements: ";
    cin >> n;

    int *arr = new int[n];

    cout << "Enter the elements: ";
    for(int i = 0; i < n; i++) {
        cin >> arr[i];
        sum += arr[i];
    }

    cout << "Sum of elements: " << sum;

    delete[] arr;
    return 0; 
    }
    else if (q==3)
    {
          int x, y;

    cout << "Enter the value of x: ";
    cin >> x;
    cout << "Enter the value of y: ";
    cin >> y;

    cout << "Before swap: x = " << x << ", y = " << y << std::endl;

    swapp(&x, &y);

    cout << "After swap: x = " << x << ", y = " << y << std::endl;

    return 0;
    }
    else if (q==4)
    {
            int x, y;

    cout << "Enter the value of x: ";
    cin >> x;
    cout << "Enter the value of y: ";
    cin >> y;

    int *ptr1 = &x;
    int *ptr2 = &y;

    if (*ptr1 > *ptr2) {
        cout << "The greatest number is: " << *ptr1;
    } else {
        cout << "The greatest number is: " << *ptr2;
    }

    return 0;
    }
    else if (q==5)
    {
         int x, y, z;

    cout << "Enter the value of x: ";
    cin >> x;
    cout << "Enter the value of y: ";
    cin >> y;
    cout << "Enter the value of z: ";
    cin >> z;

    int *ptr1 = &x;
    int *ptr2 = &y;
    int *ptr3 = &z;

    if (*ptr1 > *ptr2 && *ptr1 > *ptr3) {
        cout << "The greatest number is: " << *ptr1;
    } else if (*ptr2 > *ptr1 && *ptr2 > *ptr3) {
        cout << "The greatest number is: " << *ptr2;
    } else {
        cout << "The greatest number is: " << *ptr3;
    }

    return 0;
    }
    else{
        cout<< "Exited";
         return 0;
    }
}
