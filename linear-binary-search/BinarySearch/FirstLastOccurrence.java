import java.util.Scanner;

public class FirstLastOccurrence {
    
    // Method to find the first occurrence of the target
    public static int findFirst(int[] arr, int target) {
        int left = 0, right = arr.length - 1, result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                result = mid; // Potential first occurrence
                right = mid - 1; // Search in the left half
            } else if (arr[mid] < target) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }
        return result;
    }

    // Method to find the last occurrence of the target
    public static int findLast(int[] arr, int target) {
        int left = 0, right = arr.length - 1, result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                result = mid; // Potential last occurrence
                left = mid + 1; // Search in the right half
            } else if (arr[mid] < target) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        // Input sorted array
        System.out.println("Enter sorted array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Input target value
        System.out.print("Enter target value: ");
        int target = sc.nextInt();

        // Find first and last occurrence
        int first = findFirst(arr, target);
        int last = findLast(arr, target);

        // Output result
        if (first == -1) {
            System.out.println("Element not found.");
        } else {
            System.out.println("First occurrence at index: " + first);
            System.out.println("Last occurrence at index: " + last);
        }

        sc.close(); // Close scanner
    }
}
