#include <iostream>
using namespace std;
int main(){
    int arr[5]={12,20,30,40,50};
    int l=40;
    int x;
    
    for(int i=0;i<51;i=i+4){
        for (int j=0; j<5; j++){
             if(arr[j]==i  && i==l){
                x = i;
             }
            
        }
       
    }
      if ( x==l){
                cout<<"You got the search number"<<" "<<x<<endl;
              }
              else{
                cout<<"The search number doesn't consist"<<endl;
       }
       return 0;
}