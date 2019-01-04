package easy;

import java.util.Arrays;

/**
 * 628. Maximum Product of Three Numbers
 * .
 * Given an integer array, find three numbers whose product is maximum and output the maximum product.
 * .
 * Example 1:
 * Input: [1,2,3]
 * Output: 6
 * Example 2:
 * Input: [1,2,3,4]
 * Output: 24
 * Note:
 * The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
 * Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
 */
public class LeetCode628 {

    /**
     * 同时需考虑负数情况
     *
     * @param nums
     * @return
     */
    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length-1], nums[nums.length - 3] * nums[nums.length - 2] * nums[nums.length - 1]);
    }

    /**
     * @param nums
     * @return
     */
    public int maximumProduct_version1(int[] nums) {
        Arrays.sort(nums);
        // if signs of the minimum and maximum number are the same, simply return this.
        // Assume no overflow problem will occur.
        if (nums[0] * nums[nums.length - 1] >= 0)
            return nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        int l = 0, r = nums.length - 1;
        int product = 1;
        // k = 3 in this case. But it should be extended to any number.
        // if count is odd, we should take the rightmost number. Otherwise, we should take the maximum product by comparing
        // the product of two leftmost elements and that of two rightmost elements.
        int count = 3;
        while (count > 0) {
            if (count % 2 == 1) {
                product *= nums[r--];
            } else {
                if (nums[r] * nums[r - 1] > nums[l] * nums[l + 1])
                    product *= nums[r--] * nums[r--];
                else
                    product *= nums[l++] * nums[l++];
                count--;
            }
            count--;
        }
        return product;
    }

    /**
     * @param nums
     * @return
     */
    public static int maximumProduct_version2(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }

            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }

    public static void main(String[] args) {
        System.out.println(maximumProduct_version2(new int[]{-1, -2, -3, -4}));
        System.out.println(maximumProduct_version2(new int[]{1, 2, 3, 4}));
    }
}
