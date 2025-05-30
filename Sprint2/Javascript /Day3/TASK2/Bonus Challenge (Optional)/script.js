// Wait for the DOM to be fully loaded before executing the script
document.addEventListener('DOMContentLoaded', function() {
    // DOM Elements
    const taskInput = document.getElementById('taskInput');
    const addTaskBtn = document.getElementById('addTaskBtn');
    const taskList = document.getElementById('taskList');
    
    // Load tasks from localStorage when the page loads
    let tasks = JSON.parse(localStorage.getItem('tasks')) || [];
    
    // Display tasks from localStorage
    function displayTasks() {
        taskList.innerHTML = '';
        tasks.forEach((task, index) => {
            const li = document.createElement('li');
            li.className = `task-item ${task.completed ? 'completed' : ''}`;
            li.innerHTML = `
                <input type="checkbox" class="task-checkbox" ${task.completed ? 'checked' : ''} data-index="${index}">
                <span class="task-text">${task.text}</span>
                <button class="delete-btn" data-index="${index}">Delete</button>
            `;
            taskList.appendChild(li);
        });
        
        // Add event listeners to checkboxes and delete buttons
        document.querySelectorAll('.task-checkbox').forEach(checkbox => {
            checkbox.addEventListener('change', toggleTask);
        });
        
        document.querySelectorAll('.delete-btn').forEach(button => {
            button.addEventListener('click', deleteTask);
        });
        
        // Save tasks to localStorage
        localStorage.setItem('tasks', JSON.stringify(tasks));
    }
    
    // Add a new task
    function addTask() {
        const text = taskInput.value.trim();
        if (text) {
            tasks.push({ text, completed: false });
            taskInput.value = '';
            displayTasks();
        }
    }
    
    // Toggle task completion
    function toggleTask(e) {
        const index = e.target.dataset.index;
        tasks[index].completed = !tasks[index].completed;
        displayTasks();
    }
    
    // Delete a task
    function deleteTask(e) {
        const index = e.target.dataset.index;
        tasks.splice(index, 1);
        displayTasks();
    }
    
    // Event listeners
    addTaskBtn.addEventListener('click', addTask);
    taskInput.addEventListener('keypress', function(e) {
        if (e.key === 'Enter') {
            addTask();
        }
    });
    
    // Initial display of tasks
    displayTasks();
});
