package medium;

import java.util.Arrays;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 * <p>
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 *  
 * <p>
 * 进阶：
 * <p>
 * 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
 */
public class LeetCode209 {


    public static int minSubArrayLen_new1(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int resLen = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                resLen = Math.min(resLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return resLen == Integer.MAX_VALUE ? 0 : resLen;
    }


    public static int minSubArrayLen_3(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = 0;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                sum -= nums[left];
                res = Math.min(res, right - left + 1);
                left++;
            }
            right++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }


    public static int minSubArrayLen2(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int target = s + sums[i - 1];
            int bound = Arrays.binarySearch(sums, target);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


    public static void main(String[] args) {
        int[] test_1 = new int[]{1, 2, 3, 4, 5};
        int[] test_2 = new int[]{2, 3, 1, 2, 4, 3};
        int a = minSubArrayLen_new1(11, test_1);
        int b = minSubArrayLen_new1(7, test_2);
        System.out.println(a);
        System.out.println(b);

    }
}
