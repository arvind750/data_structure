 import java.util.*;
 public class SortExamScores{
    public static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++){
            // Assume the minimum element is at the current index
            int minIndex = i;
            // inner loop to find the smallest element in the unsorted part of the array
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[minIndex]) {
                    minIndex = j; // update the index of the minimum element
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
    public static void main(String[] args){
        //int[] examScores = {88, 76, 92, 56, 45, 79, 64};
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of subjects: ");
        int n = sc.nextInt();

        int examScores[] = new int[n];
        System.out.println("Enter marks of " + n + " subjects: ");
        for(int i=0; i<n; i++){
            examScores[i] = sc.nextInt();
        }

        // calling the selection sort method
        selectionSort(examScores);

        System.out.println("Sorted exam scores:");
        for (int score : examScores) {
            System.out.print(score + " ");
        }
    }
}
