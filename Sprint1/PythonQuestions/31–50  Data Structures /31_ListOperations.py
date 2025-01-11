my_list = [10, 20, 30, 40, 50]

print("Initial List:", my_list)

while True:
    print("\nList Operations:")
    print("1. Append")
    print("2. Insert")
    print("3. Remove")
    print("4. Pop")
    print("5. Display List")
    print("6. Exit")

    choice = int(input("Enter your choice: "))

    if choice == 1:
        append_element = int(input("Enter element to append: "))
        my_list.append(append_element)
        print("After Append:", my_list)
    elif choice == 2:
        insert_index = int(input("Enter index to insert: "))
        insert_element = int(input("Enter element to insert: "))
        my_list.insert(insert_index, insert_element)
        print("After Insert:", my_list)
    elif choice == 3:
        remove_element = int(input("Enter element to remove: "))
        if remove_element in my_list:
            my_list.remove(remove_element)
            print("After Remove:", my_list)
        else:
            print("Element not found in the list.")
    elif choice == 4:
        if my_list:
            pop_index = int(input("Enter index to pop: "))
            if pop_index < len(my_list):
                popped_element = my_list.pop(pop_index)
                print("After Pop:", my_list)
                print("Popped Element:", popped_element)
            else:
                print("Invalid index.")
        else:
            print("List is empty.")
    elif choice == 5:
        print("Current List:", my_list)
    elif choice == 6:
        break
    else:
        print("Invalid choice. Please choose a valid option.")



