import java.util.Scanner;

class CustomQueue {
    private int maxSize;
    private int[] queueArray;
    private int front;
    private int rear;
    private int size;

    public CustomQueue(int size) {
        maxSize = size;
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
        this.size = 0;
    }

    // Enqueue
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue Overflow! Cannot enqueue " + value);
        } else {
            rear = (rear + 1) % maxSize;
            queueArray[rear] = value;
            size++;
            System.out.println(value + " enqueued into queue.");
        }
    }

    // Dequeue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow! Cannot dequeue.");
            return -1;
        } else {
            int value = queueArray[front];
            front = (front + 1) % maxSize;
            size--;
            System.out.println(value + " dequeued from queue.");
            return value;
        }
    }

    // Peek front
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        } else {
            return queueArray[front];
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == maxSize;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("Queue elements (front to rear): ");
        for (int i = 0; i < size; i++) {
            System.out.print(queueArray[(front + i) % maxSize] + " ");
        }
        System.out.println();
    }
}

class QueueInteractive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter queue size: ");
        int size = sc.nextInt();

        CustomQueue queue = new CustomQueue(size);

        while (true) {
            System.out.println("\nChoose operation: 1-Enqueue 2-Dequeue 3-Peek 4-Display 5-Exit");
            System.out.print("Your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to enqueue: ");
                    int value = sc.nextInt();
                    queue.enqueue(value);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    int front = queue.peek();
                    if (front != -1)
                        System.out.println("Front element: " + front);
                    break;
                case 4:
                    queue.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}

