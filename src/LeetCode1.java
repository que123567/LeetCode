import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class LeetCode1 {


    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> indexMap = new HashMap<>();
        //store index
        for (int i = 0; i < nums.length; i++) {
            indexMap.put(nums[i], i);//{[2,0],[7,1],[11,2],[15,3]}
        }

        for (int i = 0; i < nums.length; i++) {
            int targetValue = target - nums[i];
            if (indexMap.containsKey(targetValue)) {
                int value = indexMap.get(targetValue);
                if (i != value) {
                    res[0] = i <= value ? i : value;
                    res[1] = i <= value ? value : i;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] ints = new int[]{2, 7, 11, 15};
        int[] res = twoSum(ints, 9);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
