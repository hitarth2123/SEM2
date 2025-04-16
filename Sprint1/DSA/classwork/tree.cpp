#include <iostream>
using namespace std;
// Structure for a tree node
struct Node {
    int data;
    Node* left;
    Node* right;
};
// Function to create a new node
Node* createNode(int value) {
    Node* newNode = new Node();
    newNode->data = value;
    newNode->left = newNode->right = nullptr;
    return newNode;
}
// In-Order Traversal (Left → Root → Right)
void inOrder(Node* root) {
    if (root == nullptr) return;
    inOrder(root->left);
    cout << root->data << " ";
    inOrder(root->right);
}
// Pre-Order Traversal (Root → Left → Right)
void preOrder(Node* root) {
    if (root == nullptr) return;
    cout << root->data << " ";
    preOrder(root->left);
    preOrder(root->right);
}
// Post-Order Traversal (Left → Right → Root)
void postOrder(Node* root) {
    if (root == nullptr) return;
    postOrder(root->left);
    postOrder(root->right);
    cout << root->data << " ";
}
// Main function
int main() {
    // Creating root node
    Node* root = createNode(1);
    // Creating child nodes
    root->left = createNode(2);
    root->right = createNode(3);
    root->left->left = createNode(4);
    root->left->right = createNode(5);
    root->right->left = createNode(6);
    root->right->right = createNode(7);
    cout << "In-Order Traversal: ";
    inOrder(root);
    cout << endl;
    cout << "Pre-Order Traversal: ";
    preOrder(root);
    cout << endl;
    cout << "Post-Order Traversal: ";
    postOrder(root);
    cout << endl;
    return 0;
}