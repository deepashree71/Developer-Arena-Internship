let tasks = loadTasks();
let currentFilter = "all";

const form = document.getElementById("taskForm");
const input = document.getElementById("taskInput");
const dueDate = document.getElementById("dueDate");
const priority = document.getElementById("priority");
const filterButtons = document.querySelectorAll(".filters button");

function addTask(text, date, priority) {
  tasks.push({
    id: generateId(),
    text,
    date,
    priority,
    completed: false
  });
  saveTasks(tasks);
  applyFilter();
}

function deleteTask(id) {
  tasks = tasks.filter(task => task.id !== id);
  saveTasks(tasks);
  applyFilter();
}

function toggleTask(id) {
  tasks = tasks.map(task =>
    task.id === id ? { ...task, completed: !task.completed } : task
  );
  saveTasks(tasks);
  applyFilter();
}

function applyFilter() {
  let filtered = tasks;
  if (currentFilter === "active") filtered = tasks.filter(t => !t.completed);
  if (currentFilter === "completed") filtered = tasks.filter(t => t.completed);
  renderTasks(filtered);
}

form.addEventListener("submit", e => {
  e.preventDefault();
  addTask(input.value, dueDate.value, priority.value);
  form.reset();
});

filterButtons.forEach(btn => {
  btn.addEventListener("click", () => {
    filterButtons.forEach(b => b.classList.remove("active"));
    btn.classList.add("active");
    currentFilter = btn.dataset.filter;
    applyFilter();
  });
});

document.getElementById("clearCompleted").addEventListener("click", () => {
  tasks = tasks.filter(task => !task.completed);
  saveTasks(tasks);
  applyFilter();
});

document.getElementById("themeToggle").addEventListener("click", () => {
  document.body.classList.toggle("dark");
});

applyFilter();
