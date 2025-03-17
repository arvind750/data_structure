import java.util.*;

public class SortEmployeeIds{
    public static void insertionSort(int[] employeeIDs){
        int n = employeeIDs.length;
        
     // traverse through 1 to n-1 elements(unsorted part)
        for (int i = 1; i < n; i++){
            int key = employeeIDs[i]; // element to be inserted
            int j = i - 1;
            // move elements
            while (j >= 0 && employeeIDs[j] > key){
                employeeIDs[j + 1] = employeeIDs[j];
                j = j - 1;
            }
    // place the key element into the correct position
            employeeIDs[j + 1] = key;
        }
    }
    
    //display fun
    public static void displayEmployeeIDs(int[] employeeIDs){
        for (int id : employeeIDs) {
            System.out.print(id + " ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        // Input the number of employees
        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();
        
        // Create an array to store employee IDs
        int[] employeeIDs = new int[n];
        
        // Input the employee IDs
        System.out.println("Enter the employee IDs of " + n + " employees:");
        for (int i = 0; i < n; i++){
            employeeIDs[i] = sc.nextInt();
        }
        
        // display the employee IDs before sorting
        System.out.println("Employee IDs before sorting:");
        displayEmployeeIDs(employeeIDs);
        
        // sorting happend using insertion sort
        insertionSort(employeeIDs);
        
        // now display employee Ids after sorting
        System.out.println("Employee IDs after sorting in ascending order:");
        displayEmployeeIDs(employeeIDs);
    }
}
