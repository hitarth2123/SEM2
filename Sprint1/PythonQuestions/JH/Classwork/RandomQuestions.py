while True:
    print("\nChoose an option:")
    print("1. Greet the user")
    print("2. Reverse the name")
    print("3. Check divisibility by 5")
    print("4. Print multiples")
    print("5. Print star pyramid")
    print("6. Check prime number")
    print("7. Exit")
    
    choice = int(input("Enter your choice: "))
    
    if choice == 1:
        #WAP to greet the user 
        name=input("\nEnter your name :")
        print("Namaste ",name)
        print("Hello ",name)
        print("Bonjour ",name)
        print("Jai shree Krishna ",name)
    elif choice == 2:
        #   WAP to take  reverse the name
        name=input("\nEnter your name :")
        print(name[::-1])
    elif choice == 3:
        #WAP to take the input and check whether the number is divisble by 5 or not
        n =int(input("\nEnter the number"))
        if (n % 5==0):
            print("\nyes")
        else:
            print("\nno")
    elif choice == 4:
        #WAP to take input and print to multiples till 30
        n=int(input("\nEnter the number : "))
        for i in range(1,31):
            print(n,"*",i,"*",n*i)
    elif choice == 5:
        #WAP to print star pyramid 
        n=int(input("Enter the number "))
        for i in range(1,n+1):
            print("* " * i)
    elif choice == 6:
        #WAP to check the input number is prime or not 
        n=int(input("\n Enter the number "))
        is_prime = True
        for i in range(2,n):
            if n%i==0:
                is_prime = False
                break
        if is_prime:
            print("\n",n,"is a prime")
        else:
            print("\n",n,"is not a prime")
    elif choice == 7:
        break
    else:
        print("Invalid choice. Please choose a valid option.")