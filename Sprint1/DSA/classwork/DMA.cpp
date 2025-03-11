#include <iostream>
using namespace std;
int main() {
    int* num1 = new int;
    int* num2 = new int;
    int* sum = new int;

    cout << "Enter first number: ";
    cin >> *num1;
    cout << "Enter second number: ";
    cin >> *num2;

    *sum = *num1 + *num2;

    cout << "Sum: " << *sum << std::endl;

    delete num1;
    delete num2;
    delete sum;

    return 0;
}

