student_grades = {
    "Alice": 90,
    "Bob": 85,
    "Charlie": 95,
    "David": 80
}

name = input("Enter a student's name: ")
if name in student_grades:
    print(f"{name}'s grade is: {student_grades[name]}")
else:
    print("Student not found.")

