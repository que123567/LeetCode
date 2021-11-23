package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * .
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * .
 * Example:
 * .
 * Given nums = [2, 7, 11, 15], target = 9,
 * .
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

    public static int[] twoSum2(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }


    public static int[] twoSum3(int[] nums, int target) {
        HashMap<Integer, Integer> resMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (resMap.containsKey(target - nums[i])) {
                return new int[]{resMap.get(target-nums[i]), i};
            }
            resMap.put(nums[i], i);
        }
        return new int[2];
    }


    public static void main(String[] args) {
        int test_1[] = new int[4];
        test_1[0] = 13;
        test_1[1] = 2;
        test_1[2] = -1;
        test_1[3] = 0;
        int[] res = twoSum3(test_1, 13);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }


}
