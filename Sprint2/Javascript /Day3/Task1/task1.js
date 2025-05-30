// Task 1: Greet Me
function updateGreeting() {
    const language = document.getElementById('languageInput').value || 'JavaScript';
    document.getElementById('task1').textContent = `I am learning ${language}!`;
}
updateGreeting(); // Initialize with default value

// Task 2: Create a Greeting Function
function greet(name) {
    return `Hello, ${name}!`;
}

function updateGreetingFunction() {
    const name = document.getElementById('greetingInput').value || 'there';
    document.getElementById('task2').textContent = greet(name);
}

// Task 3: Even or Odd
function checkEvenOdd() {
    const num = parseInt(document.getElementById('numberInput').value);
    if (isNaN(num)) {
        document.getElementById('task3').textContent = 'Please enter a valid number';
        return;
    }
    const result = num % 2 === 0 ? 'Even' : 'Odd';
    document.getElementById('task3').textContent = `${num} is ${result}`;
}

// Task 4: Countdown Timer
let countdown = '';
for (let i = 5; i >= 1; i--) {
    countdown += i + '\n';
}
document.getElementById('task4').textContent = countdown + 'Boom!';

// Task 5: Print All Colors
let colors = [];

function addColor() {
    const colorInput = document.getElementById('colorInput');
    if (colorInput.value.trim() !== '') {
        colors.push(colorInput.value.trim());
        colorInput.value = '';
        updateColorsDisplay();
    }
}

function updateColorsDisplay() {
    document.getElementById('task5').textContent = colors.length > 0 
        ? colors.join('\n') 
        : 'No colors added yet';
}

updateColorsDisplay();

// Task 6: Button Click Alert
document.getElementById('alertButton').addEventListener('click', () => {
    alert('You clicked me!');
});

// Task 7: Change the Paragraph Text
document.getElementById('changeTextBtn').addEventListener('click', () => {
    document.getElementById('changeText').textContent = 'Text Changed!';
});

// Task 8: Generate a Random Number
const randomNum = Math.floor(Math.random() * 100);
document.getElementById('task8').textContent = `Random number: ${randomNum}`;

// Task 9: Simple Add Function
function add(a, b) {
    return a + b;
}

function addNumbers() {
    const num1 = parseFloat(document.getElementById('num1').value) || 0;
    const num2 = parseFloat(document.getElementById('num2').value) || 0;
    const sum = add(num1, num2);
    document.getElementById('task9').textContent = `${num1} + ${num2} = ${sum}`;
}

// Initialize with default values
document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('num1').value = '5';
    document.getElementById('num2').value = '3';
    addNumbers();
});

// Task 10: Login Status
const isLoggedIn = true;
if (isLoggedIn) {
    document.getElementById('task10').textContent = 'Welcome back!';
}

// Task 11: String Length
const word = 'JavaScript';
document.getElementById('task11').textContent = `"${word}" has ${word.length} characters`;

// Task 12: Add to Fruits Array
let fruits = ['Apple', 'Banana'];
fruits.push('Orange');
document.getElementById('task12').textContent = fruits.join(', ');

// Task 13: Break a Loop at 5
let loopResult = '';
for (let i = 0; i < 10; i++) {
    if (i === 5) break;
    loopResult += i + ' ';
}
document.getElementById('task13').textContent = `Numbers: ${loopResult} (stopped at 5)`;

// Task 14: Find Variable Type
const someVar = [1, 2, 3];
document.getElementById('task14').textContent = `Type of [1, 2, 3] is: ${typeof someVar}`;

// Task 15: Make Text Red
document.getElementById('colorBtn').addEventListener('click', () => {
    document.getElementById('colorText').style.color = 'red';
});