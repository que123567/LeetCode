package easy;

/**
 * 977. Squares of a Sorted Array
 * '
 * Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
 * '
 * '
 * '
 * Example 1:
 * '
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Example 2:
 * '
 * Input: [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 * '
 * '
 * Note:
 * '
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A is sorted in non-decreasing order.
 */
public class LeetCode977 {

    /**
     * version1
     *
     * @param A
     * @return
     */
    public static int[] sortedSquares(int[] A) {
        int left = 0, right = A.length - 1;
        int[] res = new int[A.length];
        for (int i = A.length - 1; i >= 0; i--) {
            if (Math.abs(A[left]) > Math.abs(A[right])) {
                res[i] = A[left] * A[left++];
            } else {
                res[i] = A[right] * A[right--];
            }
        }
        return res;
    }

    /**
     * version2
     *
     * @param A
     * @return
     */
    public static int[] sortedSquares_(int[] A) {
        int[] r = new int[A.length];
        for (int d = A.length - 1, u = 0, i = d; i >= 0; i--)
            r[i] = -A[u] > A[d] ? A[u] * A[u++] : A[d] * A[d--];
        return r;
    }

    public static void main(String[] args) {
        var res = sortedSquares(new int[]{-4, -1, 0, 3, 10});
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
