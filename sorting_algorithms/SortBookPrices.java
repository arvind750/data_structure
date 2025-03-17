import java.util.*;
public class SortBookPrices{
    public static void mergeSort(int[] prices, int left, int right){
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(prices, left, mid);
            mergeSort(prices, mid + 1, right);
            merge(prices, left, mid, right);
        }
    }
    public static void merge(int[] prices, int left, int mid, int right){
        int temp[] = new int[right-left+1];
        int i=left;
        int j=mid+1;
        int k=0;
        while(i<=mid && j<=right){
            if(prices[i] < prices[j]){
                temp[k] = prices[i];
                i++;
                k++;
            }else{
                temp[k] = prices[j];
                j++;
                k++;
            }
        }
        while(i<=mid){
            temp[k++] = prices[i++];
        }
        while(j<=right){
            temp[k++] = prices[j++];
        }
        for(k=0,i=left; k<temp.length; k++,i++){
            prices[i] = temp[k];
        }
    }
        
    public static void displayPrices(int[] prices){
        for (int price : prices) {
            System.out.print(price + " ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of books: ");
        int n = sc.nextInt();
        // creat array to store books
        int[] prices = new int[n];
        System.out.println("Enter the prices of " + n + " books:");
        for (int i = 0; i < n; i++){
            prices[i] = sc.nextInt();
        }
        System.out.println("Book prices before sorting:");
        displayPrices(prices);
        mergeSort(prices, 0, n - 1);
        System.out.println("Book prices after sorting in ascending order:");
        displayPrices(prices);
    }
}
