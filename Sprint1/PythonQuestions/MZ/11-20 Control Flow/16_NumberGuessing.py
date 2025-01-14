import random
random_number = random.randint(1, 100)
guessed_correctly = False
while not guessed_correctly:
    user_guess = int(input("Guess a number between 1 and 100: "))
    if user_guess == random_number:
        print("Congratulations! You've guessed the number correctly.")
        guessed_correctly = True
    elif user_guess < random_number:
        print("Your guess is too low. Try again.")
    else:
        print("Your guess is too high. Try again.")