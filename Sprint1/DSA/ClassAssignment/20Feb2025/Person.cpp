#include <iostream>
using namespace std;

struct Person{
    char name[50]; 
    int age ;
    float  height ;
};

int main(){
    Person a ;
cout<< "Enter your name :-"<<endl;
cin.getline(a.name,50);
cout<<"Enter you age :-"<<endl;
cin>>a.age;
cout<<"Enter your height :-"<<endl;
cin>>a.height;

cout<<"Person Information is :-"<<endl<<"Name :- "<<a.name<<endl<<"Age :- "<<a.age<<endl<<"Height :- "<<a.height<<endl;

}