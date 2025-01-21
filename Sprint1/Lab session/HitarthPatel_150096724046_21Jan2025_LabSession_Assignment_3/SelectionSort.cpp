#include <iostream>
#include <chrono>
#include <stdexcept>

class Student {
private:
    std::string name;
    int score;

public:
    Student(std::string name, int score) : name(name), score(score) {}

    bool operator<(const Student& other) const {
        return score < other.score;
    }

    std::string getName() const {
        return name;
    }

    int getScore() const {
        return score;
    }

    void setName(const std::string& name) {
        this->name = name;
    }

    void setScore(int score) {
        this->score = score;
    }
};

void selectionSort(Student arr[], int size) {
    if (arr == nullptr || size <= 0) {
        throw std::invalid_argument("Invalid input");
    }

    for (int i = 0; i < size - 1; ++i) {
        int minIndex = i;
        for (int j = i + 1; j < size; ++j) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }
        if (minIndex != i) {
            Student temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}

int main() {
    try {
        Student students[] = {Student("John", 85), Student("Alice", 95), Student("Bob", 75)};
        int size = sizeof(students) / sizeof(students[0]);

        auto start = std::chrono::high_resolution_clock::now();
        selectionSort(students, size);
        auto end = std::chrono::high_resolution_clock::now();

        std::cout << "Sorted array:" << std::endl;
        for (int i = 0; i < size; ++i) {
            std::cout << students[i].getName() << ": " << students[i].getScore() << std::endl;
        }

        auto duration = std::chrono::duration_cast<std::chrono::microseconds>(end - start);
        std::cout << "Time taken: " << duration.count() << " microseconds" << std::endl;
    } catch (const std::exception& e) {
        std::cerr << "Error: " << e.what() << std::endl;
        return 1;
    }

    return 0;
}