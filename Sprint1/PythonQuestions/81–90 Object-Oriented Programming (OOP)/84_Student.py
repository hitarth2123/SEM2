class Student:
    def __init__(self, name, student_id, grades=None):
        self.name = name
        self.student_id = student_id
        self.grades = grades if grades is not None else []

    def calculate_average_grade(self):
        if len(self.grades) == 0:
            return 0
        return sum(self.grades) / len(self.grades)

    def get_user_input(self):
        self.name = input("Enter student's name: ")
        self.student_id = input("Enter student's ID: ")
        num_grades = int(input("Enter number of grades: "))
        for i in range(num_grades):
            grade = float(input(f"Enter grade {i+1}: "))
            self.grades.append(grade)

    def display_info(self):
        print(f"Name: {self.name}")
        print(f"Student ID: {self.student_id}")
        print(f"Grades: {self.grades}")
        print(f"Average Grade: {self.calculate_average_grade()}")

student = Student("", "")
student.get_user_input()
student.display_info()


