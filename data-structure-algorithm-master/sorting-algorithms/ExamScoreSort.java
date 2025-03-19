import java.util.Scanner;

public class ExamScoreSort {

    public static void selectionSort(int[] scores) {
        int n = scores.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }

    public static void displayArray(int[] scores) {
        for (int score : scores) {
            System.out.print(score + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of exam scores: ");
        int n = sc.nextInt();

        int[] scores = new int[n];
        System.out.println("Enter the exam scores:");
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        System.out.println("\nExam scores before sorting:");
        displayArray(scores);

        selectionSort(scores);

        System.out.println("\nExam scores after sorting:");
        displayArray(scores);

        sc.close();
    }
}
