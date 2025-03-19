import java.util.Scanner;

public class SearchInMatrix {
    // Method to search for the target value in a 2D matrix
    public static boolean search(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int left = 0, right = rows * cols - 1; // Treat as a 1D array

        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate middle index
            int row = mid / cols, col = mid % cols; // Convert 1D index to 2D indices

            if (matrix[row][col] == target) {
                return true; // Target found
            } 
            else if (matrix[row][col] < target) {
                left = mid + 1; // Search right half
            } 
            else {
                right = mid - 1; // Search left half
            }
        }
        return false; // Target not found
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input matrix dimensions
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];

        // Input sorted matrix
        System.out.println("Enter elements of the matrix (sorted row-wise):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Input target value
        System.out.print("Enter target value to search: ");
        int target = sc.nextInt();

        // Perform search and output result
        if (search(matrix, target)) {
            System.out.println("Target found in matrix.");
        } else {
            System.out.println("Target not found in matrix.");
        }

        sc.close(); // Close scanner
    }
}
