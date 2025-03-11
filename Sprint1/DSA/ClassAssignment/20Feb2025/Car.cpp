#include <iostream>
using namespace std;

struct Car{
    char brand[50];
    float price ;
};

int main(){
    Car c[3];
    for ( int i=0;i<3;i++){
        cout<<"Enter the brand of Car"<<i+1<<endl;
        cin.getline(c[i].brand,50);
        cout<<"Enter the price of Car"<<i+1<<endl;
        cin>>c[i].price;
    }

      for ( int i=0;i<3;i++){
        cout<<"Details of Car"<<i+1<<" :- "<<endl;
       
        cout<<"Brand :- "<<c[i].brand<<endl<<"Price :- "<<c[i].price;
      
    }
}