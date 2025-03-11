#include <iostream>
using namespace std;

struct  Student{
    char name[50];
    int age;
    float marks;
};

int main(){
Student a;
cout<<"Enter your name "<<endl;
cin.getline(a.name,50);
cout<<"Enter your age "<<endl;
cin>>a.age;
cout<<"Enter your marks "<<endl;
cin>>a.marks;

cout<<endl<<"Student detials are :-"<<endl<<"Name:- "<<a.name<<endl<<"Age:- "<<a.age<<endl<<"Marks:- "<<a.marks;\

return 0;
}