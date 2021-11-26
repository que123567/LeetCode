package easy;

/**
 * 509. Fibonacci Number
 * '
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 * '
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), for N > 1.
 * Given N, calculate F(N).
 * '
 * '
 * '
 * Example 1:
 * '
 * Input: 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 * Example 2:
 * '
 * Input: 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 * Example 3:
 * '
 * Input: 4
 * Output: 3
 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 * '
 * '
 * Note:
 */
public class LeetCode509 {
    public static int fib(int N) {
        if (N <= 1) {
            return N;
        }
        return fib(N - 1) + fib(N - 2);

    }

    public static int fib_2(int n) {
        if (n == 1 | n == 2) {
            return 1;
        }
        int sum = 0;
        int prev = 1, curr = 1;
        for (int i = 3; i <= n; i++) {
            sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
//        System.out.println(fib(31));
//        System.out.println(fib_2(31));

    }
}
