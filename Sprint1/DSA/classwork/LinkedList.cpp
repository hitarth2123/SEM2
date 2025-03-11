#include <iostream>
using namespace std;
struct Node {
    int data;
    Node* next;
};
void insertAtBeginning(Node* &head, int value) {
    Node* newNode = new Node();
    newNode->data = value;
    newNode->next = head;
    head = newNode;
}
void insertAtEnd(Node* &head, int value) {
    Node* newNode = new Node();
    newNode->data = value;
    newNode->next = nullptr;
    if (head == nullptr) {
        head = newNode;
        return;
    }
    Node* temp = head;
    while (temp->next != nullptr) {
        temp = temp->next;
    }
    temp->next = newNode;
}
void insertAfterName(Node* &head, int value, int name) {
    Node* newNode = new Node();
    newNode->data = value;
    if (head == nullptr) {
        head = newNode;
        return;
    }
    Node* temp = head;
    while (temp->next != nullptr && temp->data != name) {
        temp = temp->next;
    }
    if (temp->data == name) {
        newNode->next = temp->next;
        temp->next = newNode;
    }
}
void display(Node* head) {
    Node* temp = head;
    while (temp != nullptr) {
        cout << temp->data << " -> ";
        temp = temp->next;
    }
    cout << "NULL" << endl;
}
void deleteNode(Node* &head, int value) {
    if (head == nullptr) return;
    if (head->data == value) {
        Node* temp = head;
        head = head->next;
        delete temp;
        return;
    }
    Node* current = head;
    Node* previous = nullptr;
    while (current != nullptr && current->data != value) {
        previous = current;
        current = current->next;
    }
    if (current != nullptr) {
        previous->next = current->next;
        delete current;
    }
}
int main() {
    Node* head = nullptr;
    insertAtBeginning(head, 10);
    insertAtBeginning(head, 20);
    insertAtEnd(head, 30);
    insertAtEnd(head, 40);
    insertAfterName(head, 45, 30);
    cout << "Updated Linked List: ";
    display(head);
    deleteNode(head, 30);
    cout << "Linked List after deleting 30: ";
    display(head);
    return 0;
}