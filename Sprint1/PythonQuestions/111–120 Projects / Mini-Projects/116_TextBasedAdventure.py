def start_game():
    print("Welcome to the Text-based Adventure Game!")
    print("You are in a dark room and there are two doors. Which one do you choose?")
    print("1. Door 1")
    print("2. Door 2")
    choice = input("Enter your choice: ")
    if choice == '1':
        room1()
    elif choice == '2':
        room2()
    else:
        print("Invalid choice. Please try again.")
        start_game()

def room1():
    print("You are in Room 1. There is a key on the table. What do you do?")
    print("1. Take the key")
    print("2. Leave the key")
    choice = input("Enter your choice: ")
    if choice == '1':
        print("You took the key. Now, where do you want to go?")
        start_game()
    elif choice == '2':
        print("You left the key. Now, where do you want to go?")
        start_game()
    else:
        print("Invalid choice. Please try again.")
        room1()

def room2():
    print("You are in Room 2. There is a locked door. What do you do?")
    print("1. Use the key")
    print("2. Leave the door")
    choice = input("Enter your choice: ")
    if choice == '1':
        print("You used the key and the door is now open. Congratulations, you have escaped!")
    elif choice == '2':
        print("You left the door. Now, where do you want to go?")
        start_game()
    else:
        print("Invalid choice. Please try again.")
        room2()

start_game()

