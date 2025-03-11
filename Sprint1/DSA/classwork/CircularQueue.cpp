#include <iostream>
using namespace std;

int front, rear;
int *arr;
int queueSize = 0; 
int maxSize;

bool isEmpty() {
    return (queueSize == 0);
}

void enqueue(int data) {
    if (queueSize == maxSize) {
        cout << "Queue is full. Cannot enqueue " << data << endl;
        return;
    }
    if (rear == -1) {
        front = rear = 0;
        arr[rear] = data;
    } else {
        rear = (rear + 1) % maxSize;
        arr[rear] = data;
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
        front = (front + 1) % maxSize;
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
    for (int i = front; i != rear; i = (i + 1) % maxSize) {
        cout << arr[i] << " ";
    }
    cout << arr[rear] << endl;
}

void peek() {
    if (isEmpty()) {
        cout << "Queue is empty. No element to peek" << endl;
        return;
    }
    cout << "Peek element is " << arr[front] << endl;
}

int main() {
    front = rear = -1;
    queueSize = 0;

    cout << "Enter the maximum size of the queue: ";
    cin >> maxSize;
    arr = new int[maxSize];

    int capacity;
    cout << "Enter the capacity of the queue: ";
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
        cout << "5. Peek" << endl;
        cout << "6. Exit" << endl;
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
                peek();
                break;
            case 6:
                delete[] arr;
                return 0;
            default:
                cout << "Invalid choice. Please choose again." << endl;
        }
    }

    delete[] arr;
    return 0;
}

