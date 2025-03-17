import java.util.*;

public class SortStudentMarks {

    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        boolean swap;
        // traverse through all array elements
        for (int i = 0; i < n - 1; i++) {
            swap = false; // To optimize the loop by breaking early if no swap is made

            // Last i elements are already in place, no need to check them
            for (int j = 0; j < n - 1 - i; j++) {
                if (marks[j] > marks[j + 1]) {
                    // Swap marks[j] and marks[j+1]
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;

                    swap = true;
                }
            }
            // If no two elements were swapped by inner loop, then the array is sorted
            if (!swap) {
                break;
            }
        }
    }
    // Function to display the array elements
    public static void displayMarks(int[] marks) {
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the number of students
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();

        // Create an array to store student marks
        int[] marks = new int[n];

        // Input the marks
        System.out.println("Enter the marks of " + n + " students:");
        for (int i = 0; i < n; i++) {
            marks[i] = sc.nextInt();
        }

        // Display the marks before sorting
        System.out.println("marks before sorting:");
        displayMarks(marks);

        bubbleSort(marks);

        // Display the marks after sorting
        System.out.println("marks after sorting in ascending order:");
        displayMarks(marks);
    }
}
