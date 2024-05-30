package implement;


    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    class LinkedList {
        Node head;

        // 1. Inserting a Node at Any Given Position
        public void insertAtPos(int data, int position) {
            if (position < 1) {
                throw new IllegalArgumentException("Invalid position");
            }

            Node newNode = new Node(data);
            if (position == 1) {
                newNode.next = head;
                head = newNode;
                return;
            }

            Node current = head;
            int count = 1;
            while (current != null && count < position - 1) {
                current = current.next;
                count++;
            }

            if (current == null) {
                throw new IndexOutOfBoundsException("Position out of bounds");
            }

            newNode.next = current.next;
            current.next = newNode;
        }

        // 2. Deleting a Node at Any Given Position
        public void deleteAtPosition(int position) {
            if (position < 1) {
                throw new IllegalArgumentException("Invalid position");
            }

            if (position == 1) {
                head = head.next;
                return;
            }

            Node current = head;
            int count = 1;
            while (current != null && count < position - 1) {
                current = current.next;
                count++;
            }

            if (current == null || current.next == null) {
                throw new IndexOutOfBoundsException("Position out of bounds");
            }

            current.next = current.next.next;
        }

        // 3. Deleting a Node After a Given Node
        public void deleteAfterNode(Node prevNode) {
            if (prevNode == null || prevNode.next == null) {
                throw new IllegalArgumentException("Node not found or last node");
            }

            prevNode.next = prevNode.next.next;
        }

        // 4. Searching a Node in a Singly Linked List
        public boolean searchNode(int data) {
            Node current = head;
            while (current != null) {
                if (current.data == data) {
                    return true;
                }
                current = current.next;
            }
            return false;
        }
    }
//5. implementing stack  push pop isempty peek
    class Stack {
        Node top;

        public void push(int data) {
            Node newNode = new Node(data);
            newNode.next = top;
            top = newNode;
        }


        public int pop() {
            if (isEmpty()) {
                throw new RuntimeException("Stack underflow");
            }

            int data = top.data;
            top = top.next;
            return data;
        }


        public int peek() {
            if (isEmpty()) {
                throw new RuntimeException("Stack underflow");
            }
            return top.data;
        }

        public boolean isEmpty() {
            return top == null;
        }
    }
