import java.util.Scanner;

public class PeakElementFinder {
    // Method to find a peak element using Binary Search
    public static int findPeakElement(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2; // Calculate the middle index

            // If the middle element is smaller than the next element, peak must be in the right half
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } 
            // Otherwise, the peak must be in the left half (or at mid itself)
            else {
                right = mid;
            }
        }
        return left; // The left index holds the peak element
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input for array size
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Taking input for the array
        System.out.println("Enter elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Finding peak element index
        int peakIndex = findPeakElement(arr);

        // Output the peak element
        System.out.println("Peak element found at index: " + peakIndex + ", Value: " + arr[peakIndex]);

        sc.close(); // Close scanner
    }
}
