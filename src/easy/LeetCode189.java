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
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

    }

    public static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    //初始 1234567
    //①   7654321
    //②   5674321
    //③   5671234
    public static void main(String[] args) {
        int[] res = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] res2 = new int[]{1, 2, 3};
        int[] res3 = new int[]{1, 2};
        int[] res4 = new int[]{1};
        rotate(res, 3);
        for (int i : res) {
            System.out.println(i);
        }

    }
}
