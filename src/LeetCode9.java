/**
 * 9. Palindrome Number
 * <p>
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * <p>
 * Example 1:
 * <p>
 * Input: 121
 * Output: true
 * Example 2:
 * <p>
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * <p>
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 */
public class LeetCode9 {
    /**
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        int ret = 0;
        while (x > ret) {
            ret = ret * 10 + x % 10;
            x /= 10;
        }
        return x == ret || x == ret / 10;
    }

    /**
     * @param x
     * @return
     */
    public static boolean isPalindrome_2(int x) {
        int revertX = 0;
        int inputX = x;
        while (inputX > 0) {
            revertX = revertX * 10 + inputX % 10;
            inputX /= 10;
        }
        return revertX == x;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome_2(1221));
        System.out.println(isPalindrome_2(1313));

    }
}
