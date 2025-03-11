#include <iostream>

using namespace std;

const int SIZE = 5;
int arr[SIZE];
int front = -1, rear = -1;

void enQueue(int value) {
    if ((front == 0 && rear == SIZE - 1) || (rear == (front - 1) % (SIZE - 1))) {
        cout << "Queue is Full" << endl;
        return;
    }

    else if (front == -1) {
        front = rear = 0;
        arr[rear] = value;
    }

    else if (rear == SIZE - 1 && front != 0) {
        rear = 0;
        arr[rear] = value;
    }

    else {
        rear++;
        arr[rear] = value;
    }
}

int peek() {
    if (front == -1) {
        cout << "Queue is Empty" << endl;
        return -1;
    }
    return arr[front];
}

int main() {
    int choice, value;
    while (true) {
        cout << "1. Enqueue\n2. Peek\n3. Exit\nEnter your choice: ";
        cin >> choice;
        switch (choice) {
            case 1:
                cout << "Enter the value to be enqueued: ";
                cin >> value;
                enQueue(value);
                break;
            case 2:
                cout << "Peek value: " << peek() << endl;
                break;
            case 3:
                exit(0);
            default:
                cout << "Invalid choice" << endl;
        }
    }
    return 0;
}



