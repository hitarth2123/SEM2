#include<iostream>
using namespace std;
int main(){
   int a[10],b[10], c[10];
   cout<<"Enter the 10 intgers"<<endl;
   for(int i=0;i<10;i++) cin>>a[i];
   int j = 0;
   int k =0;
    for(int i=0;i<10;i++){
    if(a[i]%2==0){
       b[j]=a[i] ;
       j++;}
    else{
      c[k]=a[i] ;
      k++ ;}}
   cout<<"Even numbers are :- "<<endl;
      for(int i=0;i<j;i++)cout<<b[i]<<endl;
   cout<<"Odd numbers are :- "<<endl;
      for(int i=0;i<k;i++)cout<<c[i]<<endl; 
      };