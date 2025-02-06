#include <iostream>
using namespace std;

const int MAX_SIZE = 10;

int front, rear;
int arr[MAX_SIZE];
int queueSize = 0; 

bool isEmpty() {
    return (queueSize == 0);
}

void enqueue(int data) {
    if (queueSize == MAX_SIZE) {
        cout << "Queue is full. Cannot enqueue " << data << endl;
        return;
    }
    if (rear == -1) {
        front = rear = 0;
        arr[rear] = data;
    } else {
        arr[++rear] = data;
    }
    queueSize++;
}

void dequeue() {
    if (isEmpty()) {
        cout << "Queue is empty. Cannot dequeue" << endl;
        return;
    }
    if (front == rear) {
        front = rear = -1;
    } else {
        front++;
    }
    queueSize--;
}

void showFront() {
    if (isEmpty()) {
        cout << "Queue is empty. No front element" << endl;
        return;
    }
    cout << "Front element is " << arr[front] << endl;
}

void displayQueue() {
    if (isEmpty()) {
        cout << "Queue is empty" << endl;
        return;
    }
    cout << "Queue elements are: ";
    for (int i = front; i <= rear; i++) {
        cout << arr[i] << " ";
    }
    cout << endl;
}

int main() {
    front = rear = -1;
    queueSize = 0;

    int capacity;
    cout << "Enter the capacity of the queue (max " << MAX_SIZE << "): ";
    cin >> capacity;

    cout << "Enter the elements of the queue: ";
    for (int i = 0; i < capacity; i++) {
        int data;
        cin >> data;
        enqueue(data);
    }

    while (true) {
        cout << "1. Enqueue" << endl;
        cout << "2. Dequeue" << endl;
        cout << "3. Show Front" << endl;
        cout << "4. Display Queue" << endl;
        cout << "5. Exit" << endl;
        int choice;
        cin >> choice;

        switch (choice) {
            case 1: {
                int data;
                cout << "Enter the data to enqueue: ";
                cin >> data;
                enqueue(data);
                break;
            }
            case 2:
                dequeue();
                break;
            case 3:
                showFront();
                break;
            case 4:
                displayQueue();
                break;
            case 5:
                return 0;
            default:
                cout << "Invalid choice. Please choose again." << endl;
        }
    }

    return 0;
}