package easy;

/**
 * 66. Plus One
 * <p>
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 * <p>
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 * <p>
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 */
public class LeetCode66 {
    /**
     * simple solution 1
     *
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        int res = 0;
        for (int i = 0; i < digits.length; i++) {
            res += digits[i] * Math.pow(10, digits.length - i - 1);
        }
        res += 1;
        String resStr = String.valueOf(res);
        int resInt[] = new int[resStr.length()];
        for (int i = 0; i < resInt.length; i++) {
            resInt[i] = resStr.charAt(i) - '0';
        }
        return resInt;
    }

    /**
     * solution 2
     *
     * @param digits
     */
    public static int[] plusOne_2(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            //有一位不是9,直接+1按返回
            if (digits[i] < 9) {
                ++digits[i];
                return digits;
            }
            digits[i] = 0;
        }
        //执行到这,说明每位全是9
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;
        return newNumber;
    }

    public static void main(String[] args) {
        int[] res = plusOne_2(new int[]{0});
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
        }
    }
}
