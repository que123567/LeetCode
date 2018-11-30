/**
 * 268. Missing Number
 * <p>
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,0,1]
 * Output: 2
 * Example 2:
 * <p>
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
public class LeetCode268 {

    public static int missingNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i] - i;
        return nums.length - sum;
    }

    public static int missingNumber_(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        return (nums.length * (nums.length + 1)) / 2 - sum;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber_(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
        //                              _           0,1,2
        System.out.println(missingNumber_(new int[]{0, 2, 3}));
        //                              _           0,1,2,3
        System.out.println(missingNumber_(new int[]{0, 1, 2, 4}));
        //{0,1,2,3}
        //{0,2,3}
    }
}
