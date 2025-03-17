import java.util.*;

 public class SortStudentAges{
    public static void countingSort(int[] arr){
        int min = 10; // Min. possible age
        int max = 18; // Max. possible age
    
        //create a count array
        int[] count = new int[max - min + 1]; //count occurrences of ages from 10 to 18
        
        //count the frequency of each age
        for (int i = 0; i < arr.length; i++){
            count[arr[i] - min]++;
        }
        // compute the cumulative frequency
        for (int i = 1; i < count.length; i++){
            count[i] += count[i - 1];
        }
        //build the output array
        int[] output = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--){
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }
        // copy the sorted values into original array
        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();

        //Initialize an array to store student ages
        int[] ages = new int[n];

        System.out.println("Enter the ages of the students (between 10 and 18):");
        for (int i = 0; i < n; i++) {
            System.out.print("Age of student " + (i + 1) + ": ");
            ages[i] = sc.nextInt();
            // here we check valid age
            while (ages[i] < 10 || ages[i] > 18) {
                System.out.println("Invalid age! Please enter an age between 10 and 18.");
                System.out.print("Age of student " + (i + 1) + ": ");
                ages[i] = sc.nextInt();
            }
        }
        countingSort(ages);
        System.out.println("\nSorted student ages:");
        for (int age : ages) {
            System.out.print(age + " ");
        }
    }
}

