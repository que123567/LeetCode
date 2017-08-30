/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * <p>
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * <p>
 * click to show more practice.
 * <p>
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
//learned from-->https://leetcode.com/problems/maximum-subarray/discuss/
public class LeetCode53 {
    public static int maxSubArray(int[] A) {
        int maxRes = A[0];
        int tmpMaxRes = A[0];
        for (int i = 1; i < A.length; i++) {
            tmpMaxRes = Math.max(tmpMaxRes + A[i], A[i]);
            maxRes = Math.max(tmpMaxRes, maxRes);
        }
        return maxRes;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
