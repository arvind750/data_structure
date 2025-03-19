import java.util.Scanner;

public class RotationPointFinder {
    // Method to find the index of the smallest element in a rotated sorted array
    public static int findRotationPoint(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2; // Calculate the middle index

            // If mid element is greater than the last element, search in the right half
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            }
            // Otherwise, search in the left half (including mid)
            else {
                right = mid;
            }
        }
        return left; // The left index is the index of the smallest element
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input for array size
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Taking input for the rotated sorted array
        System.out.println("Enter elements of the rotated sorted array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Calling method to find rotation point index
        int rotationIndex = findRotationPoint(arr);

        // Output the index of the smallest element
        System.out.println("Index of the rotation point: " + rotationIndex);

        sc.close(); // Close scanner
    }
}
