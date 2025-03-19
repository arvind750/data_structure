import java.util.Scanner;

public class ProductPriceSort {
    public static void quickSort(double[] prices, int low, int high) {
        if (low < high) {
            
            int pivotIndex = partition(prices, low, high);

            quickSort(prices, low, pivotIndex - 1);
            quickSort(prices, pivotIndex + 1, high);
        }
    }

    public static int partition(double[] prices, int low, int high) {
        double pivot = prices[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (prices[j] < pivot) {
                i++;
                double temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        double temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1;
    }

    public static void displayArray(double[] prices) {
        for (double price : prices) {
            System.out.print(price + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of product prices: ");
        int n = sc.nextInt();

        double[] prices = new double[n];
        System.out.println("Enter the product prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextDouble();
        }

        System.out.println("\nProduct prices before sorting:");
        displayArray(prices);

        quickSort(prices, 0, n - 1);

        System.out.println("\nProduct prices after sorting:");
        displayArray(prices);

        sc.close();
    }
}
