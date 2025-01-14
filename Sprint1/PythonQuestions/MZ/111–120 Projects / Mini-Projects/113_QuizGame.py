class QuizGame:
    def __init__(self):
        self.score = 0
        self.questions = [
            {"question": "What is the capital of France?", "options": ["Paris", "London", "Berlin", "Rome"], "answer": 0},
            {"question": "What is the largest planet in our solar system?", "options": ["Earth", "Saturn", "Jupiter", "Uranus"], "answer": 2},
            {"question": "Which programming language is used in this game?", "options": ["Python", "Java", "C++", "JavaScript"], "answer": 0},
            {"question": "What is the chemical symbol for gold?", "options": ["Ag", "Au", "Hg", "Pb"], "answer": 1},
            {"question": "Who painted the famous painting 'The Starry Night'?", "options": ["Leonardo da Vinci", "Vincent van Gogh", "Pablo Picasso", "Claude Monet"], "answer": 1},
            {"question": "What is the largest mammal on Earth?", "options": ["Blue whale", "Fin whale", "Humpback whale", "Sperm whale"], "answer": 0},
            {"question": "What is the smallest country in the world?", "options": ["Vatican City", "Monaco", "Nauru", "Tuvalu"], "answer": 0},
            {"question": "Who wrote the famous book 'To Kill a Mockingbird'?", "options": ["F. Scott Fitzgerald", "Harper Lee", "Jane Austen", "J.K. Rowling"], "answer": 1},
            {"question": "What is the highest mountain peak in the solar system?", "options": ["Mount Everest", "Olympus Mons", "Kilimanjaro", "Mount Fuji"], "answer": 1},
            {"question": "What is the farthest human-made object from Earth?", "options": ["International Space Station", "Hubble Space Telescope", "Voyager 1", "Mars Curiosity Rover"], "answer": 2},
        ]

    def ask_question(self, question):
        print(question["question"])
        for i, option in enumerate(question["options"]):
            print(f"{i+1}. {option}")
        answer = int(input("Enter the number of your answer: ")) - 1
        if answer == question["answer"]:
            self.score += 1
            print("Correct!")
        else:
            print(f"Sorry, the correct answer was {question['options'][question['answer']]}")

    def play(self):
        for question in self.questions:
            self.ask_question(question)
        print(f"Game over! Your final score is {self.score} out of {len(self.questions)}")

game = QuizGame()
game.play()


