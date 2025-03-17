import java.util.*;

 public class SortProductPrices{
    // partition the array
    public static int partition(int[] prices, int low, int high){
        // Select the pivot element (last element=pivot)
        int pivot = prices[high];
        int i = low - 1;  // Pointer for the smaller element

        // Traverse through the array and rearrange elements based on the pivot
        for (int j = low; j < high; j++){
            // If the current element is smaller than or equal to the pivot, swap it with the smaller element
            if (prices[j] <= pivot){
                i++;
                // Swap prices[i] and prices[j]
                int temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }
        // swap the pivot element with the element at index i+1 so that the pivot is in its correct position
        int temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        // eeturn index of the pivot element
        return i + 1;
    }

    // function to implement Quick Sort
    public static void quickSort(int[] prices, int low, int high){
        if (low < high) {
            // Find the pivot element such that elements smaller than pivot are on the left and greater are on the right
            int pivotIndex = partition(prices, low, high);

            // Recursively apply Quick Sort to the left and right partitions
            quickSort(prices, low, pivotIndex - 1);
            quickSort(prices, pivotIndex + 1, high);
        }
    }
    // 
    public static void displayPrices(int[] prices){
        for (int price : prices) {
            System.out.print(price + " ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();
        // create an array to store product prices
        int[] prices = new int[n];
        System.out.println("Enter the prices of " + n + " products:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }
        System.out.println("Product prices before sorting:");
        displayPrices(prices);
        // Sort the prices using Quick Sort
        quickSort(prices, 0, n - 1);
        System.out.println("Product prices after sorting in ascending order:");
        displayPrices(prices);
    }
}
