class ToDoList:
    def __init__(self):
        self.tasks = []

    def add_task(self, task):
        self.tasks.append({"task": task, "done": False})
        print(f"Task '{task}' added successfully!")

    def mark_done(self, task_number):
        try:
            self.tasks[task_number - 1]["done"] = True
            print(f"Task {task_number} marked as done!")
        except IndexError:
            print("Invalid task number.")

    def view_tasks(self):
        if not self.tasks:
            print("No tasks found.")
            return
        print("\nYour Tasks:")
        print("-" * 40)
        for i, task in enumerate(self.tasks, start=1):
            status = "✓" if task["done"] else "✗"
            print(f"{i}. [{status}] {task['task']}")
        print("-" * 40)

    def save_tasks(self, filename):
        try:
            with open(filename, 'w') as f:
                for task in self.tasks:
                    f.write(f"{task['task']},{task['done']}\n")
            print("Tasks saved successfully!")
        except Exception as e:
            print(f"Error saving tasks: {e}")

    def load_tasks(self, filename):
        try:
            with open(filename, 'r') as f:
                self.tasks = []  # Clear existing tasks
                for line in f:
                    task, done = line.strip().split(',')
                    self.tasks.append({"task": task, "done": done == 'True'})
            print("Tasks loaded successfully!")
        except FileNotFoundError:
            print("No saved tasks found. Starting with empty list.")
        except Exception as e:
            print(f"Error loading tasks: {e}")

def display_menu():
    print("\n=== TODO LIST MENU ===")
    print("1. Add Task")
    print("2. Mark Task as Done")
    print("3. View Tasks")
    print("4. Save Tasks")
    print("5. Load Tasks")
    print("6. Quit")
    print("===================")

todo = ToDoList()
filename = 'tasks.txt'

todo.load_tasks(filename)

while True:
    display_menu()
    choice = input("\nChoose an option (1-6): ")
    
    if choice == "1":
        task = input("Enter a task: ")
        todo.add_task(task)
    
    elif choice == "2":
        todo.view_tasks()
        try:
            task_number = int(input("Enter the task number to mark as done: "))
            todo.mark_done(task_number)
        except ValueError:
            print("Please enter a valid number.")
    
    elif choice == "3":
        todo.view_tasks()
    
    elif choice == "4":
        todo.save_tasks(filename)
    
    elif choice == "5":
        todo.load_tasks(filename)
    
    elif choice == "6":
        print("Saving tasks before quitting...")
        todo.save_tasks(filename)
        print("Goodbye!")
        break
    
    else:
        print("Invalid choice. Please choose a number between 1 and 6.")


