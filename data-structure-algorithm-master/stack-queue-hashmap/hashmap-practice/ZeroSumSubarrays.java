import java.util.*;

class ZeroSumSubarrays {
    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        List<int[]> result = new ArrayList<>();
        int sum = 0;

        sumMap.put(0, new ArrayList<>(Arrays.asList(-1)));

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sumMap.containsKey(sum)) {
                for (int start : sumMap.get(sum)) {
                    result.add(new int[] { start + 1, i });
                }
            }

            sumMap.putIfAbsent(sum, new ArrayList<>());
            sumMap.get(sum).add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 2, -3, 1, 6, -2, -3, 3 };
        List<int[]> subarrays = findZeroSumSubarrays(arr);

        for (int[] range : subarrays) {
            System.out.println("Subarray found from index " + range[0] + " to " + range[1]);
        }
    }
}
