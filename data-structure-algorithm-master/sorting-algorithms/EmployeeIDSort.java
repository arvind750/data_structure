import java.util.Scanner;

public class EmployeeIDSort {

    
    public static void insertionSort(int[] employeeIDs) {
        int n = employeeIDs.length;
        for (int i = 1; i < n; i++) {
            int key = employeeIDs[i];
            int j = i - 1;

            while (j >= 0 && employeeIDs[j] > key) {
                employeeIDs[j + 1] = employeeIDs[j];
                j--;
            }
            employeeIDs[j + 1] = key;
        }
    }

    public static void displayArray(int[] employeeIDs) {
        for (int id : employeeIDs) {
            System.out.print(id + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of employee IDs: ");
        int n = sc.nextInt();

        int[] employeeIDs = new int[n];
        System.out.println("Enter the employee IDs:");
        for (int i = 0; i < n; i++) {
            employeeIDs[i] = sc.nextInt();
        }

        System.out.println("\nEmployee IDs before sorting:");
        displayArray(employeeIDs);

        insertionSort(employeeIDs);

        System.out.println("\nEmployee IDs after sorting:");
        displayArray(employeeIDs);

        sc.close();
    }
}
