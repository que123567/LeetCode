package easy;

/**
 * 342. Power of Four
 * .
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 * .
 * Example 1:
 * .
 * Input: 16
 * Output: true
 * Example 2:
 * .
 * Input: 5
 * Output: false
 * Follow up: Could you solve it without loops/recursion?
 */
public class LeetCode342 {
    public static boolean isPowerOfFour(int num) {
        return (num > 0 && ((num & (num - 1)) == 0) && ((num & 0x55555555) != 0));

    }

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(1));
        System.out.println(isPowerOfFour(2));
        System.out.println(isPowerOfFour(3));

        System.out.println(isPowerOfFour(4));
        System.out.println(isPowerOfFour(16));
        System.out.println(isPowerOfFour(64));

    }
}
