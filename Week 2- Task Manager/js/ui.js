const taskList = document.getElementById("taskList");
const totalTasks = document.getElementById("totalTasks");
const completedTasks = document.getElementById("completedTasks");
const activeTasks = document.getElementById("activeTasks");

function renderTasks(tasks) {
  taskList.innerHTML = "";

  tasks.forEach(task => {
    const li = document.createElement("li");
    li.className = `task ${task.completed ? "completed" : ""}`;
    li.draggable = true;

    li.innerHTML = `
      <span>
        <input type="checkbox" ${task.completed ? "checked" : ""} />
        ${task.text} (${task.priority})
      </span>
      <button data-id="${task.id}">❌</button>
    `;

    li.querySelector("input").addEventListener("change", () => toggleTask(task.id));
    li.querySelector("button").addEventListener("click", () => deleteTask(task.id));

    taskList.appendChild(li);
  });

  updateStats(tasks);
}

function updateStats(tasks) {
  const total = tasks.length;
  const completed = tasks.filter(t => t.completed).length;
  const active = total - completed;

  totalTasks.textContent = `Total: ${total}`;
  completedTasks.textContent = `Completed: ${completed}`;
  activeTasks.textContent = `Active: ${active}`;
}
