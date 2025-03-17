import java.util.*;

 public class SortJobApplicantsbySalary {
    public static void heapSort(int[] arr) {
        int n = arr.length;

        //Build a Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        //Extract elements from the heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Swap the root (maximum element) with the last element
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            //Reheapify the reduced heap
            heapify(arr, i, 0);
        }
    }

    // Method to maintain the heap property(max-heap)
    public static void heapify(int[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // Left child
        int right = 2 * i + 2; // Right child

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child is larger than the largest so far
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            // Swap root with the largest element
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Recursively heapify the affected subtree
            heapify(arr, n, largest);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of job applicants: ");
        int n = sc.nextInt();

        // Initialize an array to hold the salary demands
        int[] salaries = new int[n];

        // Ask the user to input the salary demands
        System.out.println("Enter the salary demands of the applicants:");
        for (int i = 0; i < n; i++) {
            System.out.print("Salary of applicant " + (i + 1) + ": ");
            salaries[i] = sc.nextInt();
        }

        // Calling the heap sort method to sort the salary demands
        heapSort(salaries);

        // Printing the sorted array of salary demands
        System.out.println("\nSorted salary demands (ascending order):");
        for (int salary : salaries) {
            System.out.print(salary + " ");
        }
    }
}

