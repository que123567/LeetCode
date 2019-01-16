package easy;

/**
 * 189. Rotate Array
 * '
 * Example 1:
 * '
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 * '
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 */
public class LeetCode189 {

    public static void rotate(int[] nums, int k) {
        if (k >= nums.length) {
            return;
        }
        int[] res = new int[nums.length + 2];
        int j = 0;
        for (int i = nums.length - k; i < nums.length; i++) {
            res[j++] = nums[i];
        }

        int l = k;
        for (int i = 0; i < k + 1; i++) {
            res[l++] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = res[i];
        }
    }

    public static void main(String[] args) {
        int[] res = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] res2 = new int[]{1};
        int[] res3 = new int[]{1, 2};
        int[] res4 = new int[]{1, 2, 3};
        rotate(res4, 2);
        for (int i : res4) {
            System.out.println(i);
        }

    }
}
