import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class SearchChallenge {

    // Method to find the first missing positive integer using Linear Search
    public static int findFirstMissingPositive(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        
        // Store all positive numbers in a HashSet
        for (int num : arr) {
            if (num > 0) {
                set.add(num);
            }
        }

        // Check for the smallest missing positive number starting from 1
        int missing = 1;
        while (set.contains(missing)) {
            missing++;
        }

        return missing;
    }

    // Method to find the index of target using Binary Search
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return mid; // Target found
            } else if (arr[mid] < target) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }
        
        return -1; // Target not found
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        // Input array elements
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Finding the first missing positive integer using Linear Search
        int missingPositive = findFirstMissingPositive(arr);
        System.out.println("First missing positive integer: " + missingPositive);

        // Sorting array for Binary Search
        Arrays.sort(arr);
        
        // Input target value for Binary Search
        System.out.print("Enter target value to search: ");
        int target = sc.nextInt();

        // Finding target index using Binary Search
        int targetIndex = binarySearch(arr, target);

        if (targetIndex == -1) {
            System.out.println("Target not found.");
        } else {
            System.out.println("Target found at index: " + targetIndex);
        }

        sc.close(); // Close scanner
    }
}
