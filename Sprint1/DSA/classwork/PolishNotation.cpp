#include <iostream>
#include <stack>
#include <cmath>
using namespace std;

int postfixevalution(string S){
    stack<int>st;
    for (int i=0;i<S.length();i++){
        if(S[i]>='0'&& S[i]<='9'){
            st.push(S[i]-'0');
        }else{
            int op2=st.top();
            st.pop();
            int op1=st.top();
            st.pop();

            switch(S[i]){
                case '+':
                    st.push(op1+op2);
                    break;
                case '-':
                    st.push(op1-op2);
                    break;
                case '/':
                    st.push(op1/op2);
                    break;
                case '*':
                    st.push(op1*op2);
                    break;
                case '^':
                    st.push(pow(op1,op2));
                    break;

            }
        }
    }
    return st.top();
}
int main(){
    string S;
    cout << "Enter the postfix expression: ";
    cin >> S;
    cout << "Result: " << postfixevalution(S) << endl;
    return 0;
}
