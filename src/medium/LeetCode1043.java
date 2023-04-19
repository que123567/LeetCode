package medium;

import java.util.Arrays;

/**
 * 1043. 分隔数组以得到最大和
 * <p>
 * 题解:
 * https://leetcode.cn/problems/partition-array-for-maximum-sum/solutions/2234242/jiao-ni-yi-bu-bu-si-kao-dong-tai-gui-hua-rq5i/
 *
 * <p>
 * 给你一个整数数组 arr，请你将该数组分隔为长度 最多 为 k 的一些（连续）子数组。分隔完成后，每个子数组的中的所有值都会变为该子数组中的最大值。
 * <p>
 * 返回将数组分隔变换后能够得到的元素最大和。本题所用到的测试用例会确保答案是一个 32 位整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = new, k = 3
 * 输出：84
 * 解释：数组变为 [15,15,15,9,10,10,10]
 * <p>
 * 示例 2：
 * <p>
 * 输入：arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4
 * 输出：83
 * <p>
 * 示例 3：
 * 输入：arr = [1], k = 1
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 500
 * 0 <= arr[i] <= 109
 * 1 <= k <= arr.length
 */
public class LeetCode1043 {

    /**
     * recursive and memo
     */
    static class Solution_1 {
        int[] recurveArray;

        public int maxSumAfterPartitioning(int[] arr, int k) {
            recurveArray = new int[arr.length];
            Arrays.fill(recurveArray, -1);
            return recurToGetMax(arr.length - 1, k, arr);
        }

        private int recurToGetMax(int lastIndex, int k, int arr[]) {
            if (lastIndex >= 0 && recurveArray[lastIndex] != -1) {
                return recurveArray[lastIndex];
            }
            int res = 0;
            int max = Integer.MIN_VALUE;
            for (int index = lastIndex; index > lastIndex - k && index >= 0; index--) {
                //current max
                max = Math.max(max, arr[index]);
                res = Math.max(res, recurToGetMax(index - 1, k, arr) + (lastIndex - index + 1) * max);
                recurveArray[lastIndex] = res;
            }
            return res;
        }
    }

    /**
     * 递归转递推
     * //todo 待复习
     */
    static class Solution_2 {
        public int maxSumAfterPartitioning(int[] arr, int k) {
            int n = arr.length;
            var f = new int[n + 1];
            for (int i = 0; i < n; ++i) {
                int max = 0;
                for (int j = i; j > i - k && j >= 0; --j) {
                    max = Math.max(max, arr[j]);
                    f[i + 1] = Math.max(f[i + 1], f[j] + (i - j + 1) * max);
                }
            }
            return f[n];
        }
    }


    public static void main(String[] args) {
        Solution_1 solution1 = new Solution_1();
        int res1 = solution1.maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3);
        System.out.println(res1);

        Solution_2 solution2 = new Solution_2();
        int res2 = solution2.maxSumAfterPartitioning(new int[]{1, 15, 7, 19, 2, 5, 10}, 3);
        System.out.println(res2);


    }
}
