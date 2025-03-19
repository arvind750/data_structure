class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskScheduler {
    private Task head;
    private Task tail;
    private Task currentTask;

    public void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            tail.next = head;
            currentTask = head;
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head;
        }
    }

    public void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            tail.next = head;
            currentTask = head;
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head;
        }
    }

    public void addAtPosition(int taskId, String taskName, int priority, String dueDate, int position) {
        if (position <= 1) {
            addAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }

        Task newTask = new Task(taskId, taskName, priority, dueDate);
        Task temp = head;
        int count = 1;

        while (temp.next != head && count < position - 1) {
            temp = temp.next;
            count++;
        }

        newTask.next = temp.next;
        temp.next = newTask;

        if (temp == tail) {
            tail = newTask;
        }
    }

    public void removeTask(int taskId) {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }

        Task temp = head, prev = null;

        while (temp.taskId != taskId) {
            if (temp.next == head) {
                System.out.println("Task not found.");
                return;
            }
            prev = temp;
            temp = temp.next;
        }

        if (temp == head && temp.next == head) {
            head = tail = null;
            return;
        }

        if (temp == head) {
            head = head.next;
            tail.next = head;
        } else if (temp == tail) {
            tail = prev;
            tail.next = head;
        } else {
            prev.next = temp.next;
        }

        if (currentTask == temp) {
            currentTask = currentTask.next;
        }

        System.out.println("Task with ID " + taskId + " removed.");
    }

    public void viewCurrentTask() {
        if (currentTask == null) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("Current Task: " + currentTask.taskName + " (Priority: " + currentTask.priority + ")");
    }

    public void moveToNextTask() {
        if (currentTask != null) {
            currentTask = currentTask.next;
        }
    }

    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        Task temp = head;
        do {
            System.out.println(temp.taskId + " | " + temp.taskName + " | Priority: " + temp.priority + " | Due: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        Task temp = head;
        boolean found = false;

        do {
            if (temp.priority == priority) {
                System.out.println(temp.taskId + " | " + temp.taskName + " | Due: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks found with priority " + priority);
        }
    }
}

public class TaskManager {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        scheduler.addAtEnd(101, "Complete Report", 2, "2025-03-10");
        scheduler.addAtBeginning(102, "Prepare Presentation", 1, "2025-03-05");
        scheduler.addAtEnd(103, "Team Meeting", 3, "2025-03-12");
        scheduler.addAtPosition(104, "Submit Budget", 2, "2025-03-08", 2);

        scheduler.displayTasks();

        System.out.println("\nViewing current task:");
        scheduler.viewCurrentTask();
        scheduler.moveToNextTask();
        scheduler.viewCurrentTask();

        System.out.println("\nSearching tasks by priority:");
        scheduler.searchByPriority(2);

        System.out.println("\nRemoving a task:");
        scheduler.removeTask(102);

        scheduler.displayTasks();
    }
}
