import java.util.Scanner;

class Process {
    int processId;
    int burstTime;
    int priority;
    Process next;

    public Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private Process head = null;
    private Process tail = null;

    public void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            tail.next = head;
        } else {
            tail.next = newProcess;
            newProcess.next = head;
            tail = newProcess;
        }
    }

    public void removeProcess(int processId) {
        if (head == null) return;

        Process temp = head, prev = null;

        do {
            if (temp.processId == processId) {
                if (temp == head) {
                    head = head.next;
                    tail.next = head;
                } else if (temp == tail) {
                    prev.next = head;
                    tail = prev;
                } else {
                    prev.next = temp.next;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    public void simulateRoundRobin(int timeQuantum) {
        if (head == null) return;

        int totalTime = 0;
        int processCount = 0;
        int waitingTimeSum = 0, turnAroundTimeSum = 0;

        Process current = head;
        do {
            processCount++;
            current = current.next;
        } while (current != head);

        while (head != null) {
            current = head;
            boolean allCompleted = true;
            do {
                if (current.burstTime > 0) {
                    allCompleted = false;
                    int executionTime = Math.min(current.burstTime, timeQuantum);
                    current.burstTime -= executionTime;
                    totalTime += executionTime;
                    if (current.burstTime == 0) {
                        turnAroundTimeSum += totalTime;
                        waitingTimeSum += totalTime - executionTime;
                        removeProcess(current.processId);
                    }
                }
                current = current.next;
            } while (current != head);

            if (allCompleted) break;

            displayProcesses();
        }

        double avgWaitingTime = (double) waitingTimeSum / processCount;
        double avgTurnAroundTime = (double) turnAroundTimeSum / processCount;

        System.out.println("\nAverage Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turnaround Time: " + avgTurnAroundTime);
    }

    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in queue.");
            return;
        }

        System.out.println("\nCurrent Process Queue:");
        Process temp = head;
        do {
            System.out.println("Process ID: " + temp.processId + " | Burst Time: " + temp.burstTime + " | Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }
}

public class RoundRobinScheduling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        scheduler.addProcess(1, 10, 2);
        scheduler.addProcess(2, 5, 1);
        scheduler.addProcess(3, 8, 3);
        scheduler.addProcess(4, 6, 2);

        scheduler.displayProcesses();

        System.out.print("\nEnter Time Quantum: ");
        int timeQuantum = scanner.nextInt();

        scheduler.simulateRoundRobin(timeQuantum);

        scanner.close();
    }
}
