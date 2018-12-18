package easy;

/**
 * 905. Sort Array By Parity
 * .
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
 * .
 * You may return any answer array that satisfies this condition.
 * .
 * .
 * .
 * Example 1:
 * .
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 * .
 * .
 * Note:
 * .
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 */
public class LeetCode905 {

    public static int[] sortArrayByParity(int[] A) {
        int i = 0, j = A.length - 1;
        while (i < j) {
            if (isEven(A[i])) {
                i++;
            }
            if (!isEven(A[j])) {
                j--;
            }
            if (i >= j) {
                break;
            }
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
        return A;
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static void main(String[] args) {
        int[] res = new int[]{3, 1, 2, 4};
        res = sortArrayByParity(res);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

}
