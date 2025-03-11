#include <iostream>
using namespace std;

struct Rectangle{
    float length;
    float width;

};
void Area(Rectangle a){
   cout<<"Area of the Rectangle is :-"<<a.length * a.width<<endl;

}
int main(){

    Rectangle b;
    cout<<"Enter the length of the Rectangle :-"<<endl;
    cin>>b.length;
    cout<<"Enter the width of the Rectangle :-"<<endl;
    cin>>b.width;

    Area(b);

}