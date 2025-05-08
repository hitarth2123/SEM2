const body = document.body;
const button = document.querySelector("#Mode");
const ADD = document.querySelector("#add");
const input = document.querySelector("input");
const outputDiv = document.querySelector("#output");

// Dark mode toggle
button.addEventListener("click", () => {
    body.classList.toggle("dark");
});

// Add todo item
ADD.addEventListener("click", () => {
    const todoText = input.value.trim();
    if (todoText === "") return; // Don't add empty items

    // Create a container for each todo item
    const todoItem = document.createElement("div");
    todoItem.className = "todo-item";

    // Create the todo text element
    const todoTextElement = document.createElement("span");
    todoTextElement.textContent = todoText;
    
    // Create delete button
    const delButton = document.createElement("button");
    delButton.className = "delete-btn";
    delButton.textContent = "delete";
    
    // Add event listener to delete button
    delButton.addEventListener("click", () => {
        todoItem.remove();
    });

    // Append elements to todo item container
    todoItem.appendChild(todoTextElement);
    todoItem.appendChild(delButton);
    
    // Append todo item to output div
    outputDiv.appendChild(todoItem);
    
    // Clear input field
    input.value = "";
});


