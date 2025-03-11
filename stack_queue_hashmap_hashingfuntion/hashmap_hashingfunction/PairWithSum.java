import java.util.*;

class PairWithSum {
    public static boolean hasPairWithSum(int[] arr, int target) {
        Set<Integer> seen = new HashSet<>();

        for (int num : arr) {
            if (seen.contains(target - num)) {
                return true; // Pair found
            }
            seen.add(num);
        }
        return false; // No pair found
    }

    public static void main(String[] args) {
        int[] arr = {10, 15, 3, 7};
        int target = 17;
        System.out.println(hasPairWithSum(arr, target)); // Output: true (10 + 7)
    }
}

