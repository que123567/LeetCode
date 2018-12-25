package easy;

/**
 * 371. Sum of Two Integers
 * .
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 * .
 * Example 1:
 * .
 * Input: a = 1, b = 2
 * Output: 3
 * Example 2:
 * .
 * Input: a = -2, b = 3
 * Output: 1
 */
//https://www.geeksforgeeks.org/add-two-numbers-without-using-arithmetic-operators/
public class LeetCode371 {

    // Iterative
    public static int getSum(int a, int b) {
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }

    public static int Add(int x, int y) {
        if (y == 0)
            return x;
        else
            return Add(x ^ y, (x & y) << 1);
    }


    public static void main(String[] args) {
        System.out.println(getSum(-2, -1));
    }
}
