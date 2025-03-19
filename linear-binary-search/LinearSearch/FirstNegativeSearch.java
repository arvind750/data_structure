import java.util.Scanner;

public class FirstNegativeSearch {
    // Method to perform Linear Search for the first negative number
    public static int findFirstNegative(int[] arr) {
        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) { // Check if the element is negative
                return i; // Return the index of the first negative number
            }
        }
        return -1; // Return -1 if no negative number is found
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Taking input for array size
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        
        // Taking input for array elements
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        // Calling the method to find the first negative number
        int index = findFirstNegative(arr);
        
        // Output the result
        if (index != -1) {
            System.out.println("First negative number found at index: " + index);
        } else {
            System.out.println("No negative number found in the array.");
        }
        
        sc.close(); // Close the scanner
    }
}
