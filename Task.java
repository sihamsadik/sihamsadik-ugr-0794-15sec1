package todolist;


// Task class
    class Task {
        private String title;
        private String description;
        private boolean completed;

        public Task(String title, String description) {
            this.title = title;
            this.description = description;
            this.completed = false; // Initialize as not completed
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public boolean isCompleted() {
            return completed;
        }

        public void markCompleted() {
            completed = true;
        }
    }

    // Node class
    class Node {
        private Task task;
        private Node next;

        public Node(Task task) {
            this.task = task;
            this.next = null;
        }

        public Task getTask() {
            return task;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    // ToDoList class
    class ToDoList {
        private Node head;

        public void addToDo(Task task) {
            Node newNode = new Node(task);
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.getNext() != null) {
                    current = current.getNext();
                }
                current.setNext(newNode);
            }
        }

        public void markToDoAsCompleted(String title) {
            Node current = head;
            while (current != null) {
                if (current.getTask().getTitle().equals(title)) {
                    current.getTask().markCompleted();
                    return;
                }
                current = current.getNext();
            }
            System.out.println("Task with title '" + title + "' not found.");
        }

        public void viewToDoList() {
            Node current = head;
            while (current != null) {
                Task task = current.getTask();
                System.out.println("Title: " + task.getTitle());
                System.out.println("Description: " + task.getDescription());
                System.out.println("Completed: " + task.isCompleted());
                System.out.println();
                current = current.getNext();
            }
        }
    }
      // Main class
    class Main {
        public static void main(String[] args) {
            ToDoList toDoList = new ToDoList();

            // Add tasks
            toDoList.addToDo(new Task("Buy groceries", "Milk, eggs, bread"));
            toDoList.addToDo(new Task("Read a book", "Finish 'To Kill a Mockingbird'"));
            toDoList.addToDo(new Task("Exercise", "30 minutes of jogging"));

            // Mark a task as completed
            toDoList.markToDoAsCompleted("Read a book");

            // View the to-do list
            toDoList.viewToDoList();
        }
    }

