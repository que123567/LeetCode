package medium;

/**
 * 31. Next Permutation
 * <p>
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * <p>
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * <p>
 * The replacement must be in-place and use only constant extra memory.
 * <p>
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * <p>
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
//13520
//
public class LeetCode31 {

    public void nextPermutation(int[] A) {
        if (A == null || A.length <= 1)
            return;
        int i = A.length - 2;
        while (i >= 0 && A[i] >= A[i + 1])
            i--; // Find 1st id i that breaks descending order
        if (i >= 0) {                           // If not entirely descending
            int j = A.length - 1;              // Start from the end
            while (A[j] <= A[i])
                j--;           // Find rightmost first larger id j
            swap(A, i, j);                     // Switch i and j
        }
        reverse(A, i + 1, A.length - 1);       // Reverse the descending sequence
    }

    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public void reverse(int[] A, int i, int j) {
        while (i < j)
            swap(A, i++, j--);
    }

    public static void main(String[] args) {

    }

}
