question=int(input("Enter the question numbers"))
if (question ==1):
    #WAP to greet the user 
    name=input("\nEnter your name :")
    print("Namaste ",name)
    print("Hello ",name)
    print("Bonjour ",name)
    print("Jai shree Krishna ",name)
    
else if(question ==2):
        #   WAP to take  reverse the name
        name=input("\nEnter your name :")
         print(name[::-1]

#WAP to take the input and check whether the number is divisble by 5 or not
n =int(input("\nEnter the number"))
if (n % 5==0):
    print("\nyes")
else:
    print("\nno")


#WAP to take input and print t o multiples till 30
n=int(input("\nEnter the number : "))

for i in range(1,31):
    print(n,"*",i,"*",n*i)
    

#WAP to print star pyranmid 

n=int(input("Enter the number "))
for i in range(1,n+1):
    print("* " * i);

#WAP to check the input number is prime or not 
n=int(input("\n Enter the number "))
for i in range(2,n):
    if n%i==0:
        print("\n",n,"it is not a prime")
        break;
    else:
        print("\n",n,"its is not a prime")
        break;
    

    