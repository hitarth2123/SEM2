#include <iostream>
using namespace std;

struct Node {
    int data;
    Node* next;
};

void insertAtBeginning(Node* &head, int value) {
    Node* newNode = new Node();
    newNode->data = value;

    if (head == nullptr) { // Empty list
        newNode->next = newNode;
        head = newNode;
    } else {
        Node* temp = head;
        while (temp->next != head) { // Find last node
        temp = temp->next;
    }
        newNode->next = head;
        temp->next = newNode;
        head = newNode;
    }
}
void insertAtEnding(Node* &head, int value) {
    Node* newNode = new Node();
    newNode->data = value;

    if (head == nullptr) { // Empty list
        newNode->next = newNode;
        head = newNode;
    } else {
        Node* temp = head;
        while (temp->next != head) { // Find last node
            temp = temp->next;
        }
        temp->next = newNode; // Link last node to new node
        newNode->next = head; // New node points to head
    }
}
 
void insertAtTarget(Node* &head, int target, int value) {
    Node* newNode = new Node();
    newNode->data = value;

    if (head == nullptr) { // Empty list
        cout << "List is empty. Cannot insert at target." << endl;
        return;
    }

    Node* temp = head;
    Node* prev = nullptr;
    do {
        if (temp->data == target) {
            newNode->next = temp;
            if (prev != nullptr) {
                prev->next = newNode;
            } else {
                head = newNode;
            }
            return;
        }
        prev = temp;
        temp = temp->next;
    } while (temp != head);

    cout << "Target not found in the list." << endl;
}
void display(Node* head) {
if (head == nullptr) {
    cout << "List is empty!" << endl;
    return;
}
Node* temp = head;
do {

    cout << temp->data << " -> ";
    temp = temp->next;
} while (temp != head);
    cout << "(Head)" << endl;
}

int main() {
    Node* head = nullptr; // Initialize empty list

    insertAtBeginning(head, 10);
    insertAtBeginning(head, 20);

    cout << "Circular Linked List: ";
    display(head);

    insertAtBeginning(head, 30);
    display(head);

    insertAtBeginning(head, 40);
    insertAtBeginning(head, 50);
    display(head);

    insertAtEnding(head, 60);
    cout << "After inserting 60 at the end: ";
    display(head);
   
    insertAtTarget(head, 70, 20);
    cout << "After inserting 70 at the target 20: ";
    display(head);
     return 0;

}

