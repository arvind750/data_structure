import java.util.Scanner;

public class StudentAgeSort {

    public static void countingSort(int[] ages) {
        
        int maxAge = 18;
        int minAge = 10;

        int[] count = new int[maxAge - minAge + 1];

        for (int age : ages) {
            count[age - minAge]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        int[] sortedAges = new int[ages.length];
        for (int i = ages.length - 1; i >= 0; i--) {
            sortedAges[count[ages[i] - minAge] - 1] = ages[i];
            count[ages[i] - minAge]--;
        }

        System.arraycopy(sortedAges, 0, ages, 0, ages.length);
    }

    // Display the array
    public static void displayArray(int[] ages) {
        for (int age : ages) {
            System.out.print(age + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of student ages: ");
        int n = sc.nextInt();

        int[] ages = new int[n];
        System.out.println("Enter the student ages:");
        for (int i = 0; i < n; i++) {
            ages[i] = sc.nextInt();
        }

        System.out.println("\nStudent ages before sorting:");
        displayArray(ages);

        countingSort(ages);

        System.out.println("\nStudent ages after sorting:");
        displayArray(ages);

        sc.close();
    }
}
