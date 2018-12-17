package easy;

import java.math.BigInteger;

/**
 * 172. Factorial Trailing Zeroes
 * <p>
 * Given an integer n, return the number of trailing zeroes in n!.
 * <p>
 * Example 1:
 * <p>
 * Input: 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * Example 2:
 * <p>
 * Input: 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 * Note: Your solution should be in logarithmic time complexity.
 */
public class LeetCode172 {

    /**
     * Iterartor
     *
     * @param n
     * @return
     */
    public static int trailingZeroes(int n) {
        int count = 0;
        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }

    /**
     * recursion
     *
     * @param n
     * @return
     */
    public static int trailingZeroes_(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes_(n / 5);
    }


    /**
     * µ
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(trailingZeroes_(1));
        System.out.println(trailingZeroes_(2));
        System.out.println(trailingZeroes_(3));
        System.out.println(trailingZeroes_(4));
        System.out.println(trailingZeroes_(5));
        System.out.println(trailingZeroes_(6));
        System.out.println(trailingZeroes_(7));

        System.err.println(trailingZeroes_(8));
        System.err.println(trailingZeroes_(9));
        System.err.println(trailingZeroes_(10));




    }
}
