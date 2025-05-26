// DOM elements
const form = document.getElementById('taskForm');
const input = document.getElementById('taskInput');
const list = document.getElementById('taskList');
const popup = document.getElementById('popup');

// Load tasks when page loads
if (localStorage.tasks) {
  JSON.parse(localStorage.tasks).forEach(task => addTaskToDOM(task));
}

// Add new task
form.onsubmit = e => {
  e.preventDefault();
  const text = input.value.trim();
  if (!text) return;
  
  const task = {
    id: Date.now(),
    text,
    done: false
  };
  
  addTaskToDOM(task);
  saveTask(task);
  input.value = '';
};

// Show welcome popup
document.getElementById('showPopupBtn').onclick = () => {
  popup.classList.remove('hidden');
  setTimeout(() => popup.classList.add('hidden'), 2000);
};

// Add task to DOM
function addTaskToDOM(task) {
  const li = document.createElement('li');
  li.innerHTML = `
    <span ${task.done ? 'class="completed"' : ''}>${task.text}</span>
    <button class="complete-btn">✓</button>
    <button class="delete-btn">✕</button>
  `;
  
  // Add event listeners
  li.querySelector('.complete-btn').onclick = toggleTask;
  li.querySelector('.delete-btn').onclick = deleteTask;
  
  list.appendChild(li);
  li.dataset.id = task.id;
}



// Toggle task completion
function toggleTask(e) {
  const li = e.target.closest('li');
  const span = li.querySelector('span');
  const tasks = JSON.parse(localStorage.tasks);
  
  const task = tasks.find(t => t.id == li.dataset.id);
  task.done = !task.done;
  
  if (task.done) {
    // Play celebration sound
    var audio = new Audio('./tada-fanfare-a-6313.mp3');
    audio.volume = 0.5;
    audio.play().catch(e => console.log('Audio play failed:', e));    
    // Show success message
    alert('🎉 Congratulations! You have successfully completed the task!');
    
    // Remove the task after a short delay
    setTimeout(() => {
      deleteTask(e);
    }, 1000);
  } else {
    span.classList.remove('completed');
    localStorage.tasks = JSON.stringify(tasks);
  }
}

// Delete task
function deleteTask(e) {
  const li = e.target.closest('li');
  const tasks = JSON.parse(localStorage.tasks)
    .filter(t => t.id != li.dataset.id);
  
  localStorage.tasks = JSON.stringify(tasks);
  li.remove();
}

// Save task to storage
function saveTask(task) {
  const tasks = localStorage.tasks ? JSON.parse(localStorage.tasks) : [];
  tasks.push(task);
  localStorage.tasks = JSON.stringify(tasks);
}