import java.util.*;

class TwoSum {
    public static int[] findTwoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), i }; // Found the pair
            }

            numMap.put(nums[i], i);
        }
        return new int[] {}; // No solution found
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        int[] result = findTwoSum(nums, target);
        System.out.println(Arrays.toString(result)); // Output: [0, 1]
    }
}
