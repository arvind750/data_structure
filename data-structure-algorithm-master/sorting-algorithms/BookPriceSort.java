import java.util.Scanner;

public class BookPriceSort {
    public static void mergeSort(double[] prices, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

        
            mergeSort(prices, left, mid);
            mergeSort(prices, mid + 1, right);

            merge(prices, left, mid, right);
        }
    }

    public static void merge(double[] prices, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        double[] leftArray = new double[n1];
        double[] rightArray = new double[n2];

        System.arraycopy(prices, left, leftArray, 0, n1);
        System.arraycopy(prices, mid + 1, rightArray, 0, n2);

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                prices[k] = leftArray[i];
                i++;
            } else {
                prices[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            prices[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            prices[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void displayArray(double[] prices) {
        for (double price : prices) {
            System.out.print(price + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of book prices: ");
        int n = sc.nextInt();

        double[] prices = new double[n];
        System.out.println("Enter the book prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextDouble();
        }

        System.out.println("\nBook prices before sorting:");
        displayArray(prices);

        mergeSort(prices, 0, n - 1);

        System.out.println("\nBook prices after sorting:");
        displayArray(prices);

        sc.close();
    }
}
