#include <iostream>
using namespace std;

struct Node {
    int data;
    Node* next;
};

void insertAtBeginning(Node* &head, int value) {
    Node* newNode = new Node();
    newNode->data = value;

    if (head == nullptr) { 
        newNode->next = newNode;
        head = newNode;
    } else {
        Node* temp = head;
        while (temp->next != head) { 
            temp = temp->next;
        }
        newNode->next = head;
        temp->next = newNode;
        head = newNode;
    }
}

void insertAtEnd(Node* &head, int value) {
    Node* newNode = new Node();
    newNode->data = value;

    if (head == nullptr) { 
        newNode->next = newNode;
        head = newNode;
    } else {
        Node* temp = head;
        while (temp->next != head) { 
            temp = temp->next;
        }
        temp->next = newNode;
        newNode->next = head;
    }
}

void insertAtTarget(Node* &head, int target, int value) {
    if (head == nullptr) { 
        cout << "List is empty, cannot insert after target." << endl;
        return;
    }

    Node* temp = head;
    while (temp->data != target && temp->next != head) { 
        temp = temp->next;
    }

    if (temp->data == target) {
        Node* newNode = new Node();
        newNode->data = value;

        newNode->next = temp->next;
        temp->next = newNode;
        return;
    } else {
        cout << "Value not found in the list" << endl;
    }
}

void deleteAtTarget(Node* &head, int target) {
    if (head == nullptr) { 
        cout << "List is empty, cannot delete target." << endl;
        return;
    }

    Node* temp = head;
    Node* prev = nullptr;
    while (temp->data != target && temp->next != head) { 
        prev = temp;
        temp = temp->next;
    }

    if (temp->data == target) {
        if (prev == nullptr) {
            Node* next = temp->next;
            while (next->next != head) {
                next = next->next;
            }
            next->next = temp->next;
            head = temp->next;
        } else {
            prev->next = temp->next;
        }
        delete temp;
        return;
    } else {
        cout << "Value not found in the list" << endl;
    }
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
    Node* head = nullptr; 

    insertAtBeginning(head, 10);
    insertAtBeginning(head, 20);

    cout << "Circular Linked List: ";
    display(head);

    insertAtBeginning(head, 30);
    display(head);

    insertAtBeginning(head, 40);
    insertAtBeginning(head, 50);
    display(head);

    insertAtEnd(head, 60);
    display(head);

    insertAtTarget(head, 10, 70);
    display(head);

    deleteAtTarget(head, 20);
    display(head);

    return 0;
}