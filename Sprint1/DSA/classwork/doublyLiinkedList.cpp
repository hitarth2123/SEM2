#include <iostream>
using namespace std;
struct Node {
int data;
Node* prev; // Pointer to previous node
Node* next; // Pointer to next node
};
void insertAtBeginning(Node* &head, int value) {
Node* newNode = new Node();
newNode->data = value;
newNode->prev = nullptr;
newNode->next = head;
if (head != nullptr) {
head->prev = newNode;
}
head = newNode;
}
void displayForward(Node* head) {
Node* temp = head;
cout << "Forward: ";
while (temp != nullptr) {
cout << temp->data << " -> ";
temp = temp->next;
}
cout << "NULL" << endl;
}

void insertAtEnd(Node* &head, int value) {
    Node* newNode = new Node();
    newNode->data = value;
    newNode->prev = nullptr;
    newNode->next = nullptr;
    if (head == nullptr) {
        head = newNode;
    } else {
        Node* temp = head;
        while (temp->next != nullptr) {
            temp = temp->next;
        }
        temp->next = newNode;
        newNode->prev = temp;
    }
}
void insertAfter(Node* head ,int targetValue, int newValue){
    Node* temp= head;
    while(temp != nullptr && temp-> data!=targetValue)
{
    temp= temp->next;
} if (temp==nullptr){
    cout<<"node with value "<<targetValue<<"not found!"<<endl;
    return;
}
Node* newNode= new Node () ;
 newNode-> data=newValue;
 newNode->next=temp->next;
 newNode->prev=temp;
 if(temp->next!=nullptr){
    temp->next->prev=newNode;
 }temp->next=newNode;
}

void displayBackward(Node* head,int value) {
Node* newNode =new Node();
newNode ->data= value;
newNode-> next=nullptr;

if(head ==nullptr){
    newNode->prev=nullptr;
    head=newNode;
    return;
}
Node* temp= head;
while(temp->next!=nullptr){
    temp=temp->next;
}
temp->next=newNode;
newNode->prev=temp;

}

int main() {
Node* head = nullptr; // Initialize empty list
insertAtBeginning(head, 10);
insertAtBeginning(head, 20);
insertAtEnd(head,60);
cout << "Doubly Linked List (Forward): ";
displayForward(head);
cout << "Doubly Linked List (Backward): ";
displayBackward(head, 0);
return 0;
}