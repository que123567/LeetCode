package easy;

/**
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * .
 * Note: Do not use any built-in library function such as sqrt.
 * .
 * Example 1:
 * .
 * Input: 16
 * Returns: True
 * Example 2:
 * .
 * Input: 14
 * Returns: False
 */
//https://leetcode.com/problems/valid-perfect-square/discuss/
//method:1 a square number is consisted of 1+3+5+9+11....；
//method:2 binary search
public class LeetCode367 {
    static class Solution {
        public static boolean isPerfectSquare1(int num) {
            int i = 1;
            while (num > 0) {
                num -= i;
                i += 2;
            }
            return num == 0;
        }

        public static boolean isPerfectSquare2(int num) {
            int low = 1, high = num;
            while (low <= high) {
                long mid = (low + high) >>> 1;
                if (mid * mid == num) {
                    return true;
                } else if (mid * mid < num) {
                    low = (int) mid + 1;
                } else {
                    high = (int) mid - 1;
                }
            }
            return false;
        }

        public static void main(String[] args) {
            System.out.println(isPerfectSquare2(100));

        }
    }
}
