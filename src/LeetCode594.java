import java.util.HashMap;
import java.util.Map;

/**
 * We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.
 * <p>
 * Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.
 * <p>
 * Example 1:
 * Input: [1,3,2,2,5,2,3,7]
 * Output: 5
 * Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 * Note: The length of the input array will not exceed 20,000.
 */
//nums的值作为key，出现次数作为value
public class LeetCode594 {
    static class Solution {
        public static int findLHS(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            int max = 0;
            for (int key : map.keySet()) {
                if (map.containsKey(key + 1)) {
                    int tmp = map.get(key) + map.get(key + 1);
                    max = Math.max(tmp, max);
                }
            }
            return max;
        }

        public static void main(String[] args) {
            System.out.println(findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7}));
        }
    }
}
