class Employee:
    def __init__(self, name, ID, salary):
        self.name = name
        self.ID = ID
        self.salary = salary

    def display(self):
        print("Name:", self.name)
        print("ID:", self.ID)
        print("Salary:", self.salary)

class Manager(Employee):
    def __init__(self, name, ID, salary, department):
        super().__init__(name, ID, salary)
        self.department = department

    def display(self):
        super().display()
        print("Department:", self.department)

def get_user_input():
    name = input("Enter name: ")
    ID = input("Enter ID: ")
    salary = float(input("Enter salary: "))
    department = input("Enter department (optional): ")
    return name, ID, salary, department

def _main_():
    print("1. Employee")
    print("2. Manager")
    choice = int(input("Enter your choice: "))

    if choice == 1:
        name, ID, salary, _ = get_user_input()
        emp = Employee(name, ID, salary)
        print("Employee Details:")
        emp.display()
    elif choice == 2:
        name, ID, salary, department = get_user_input()
        mgr = Manager(name, ID, salary, department)
        print("Manager Details:")
        mgr.display()
    else:
        print("Invalid choice")

    print("\nOutput:")
    if choice == 1:
        print("Employee created with name", name, "and ID", ID)
    elif choice == 2:
        print("Manager created with name", name, "and ID", ID, "in department", department)

_main_() 





