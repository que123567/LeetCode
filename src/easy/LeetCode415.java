package easy;

/**
 * 415. Add Strings
 * .
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 * .
 * Note:
 * .
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class LeetCode415 {

    /**
     * 0101
     * +1009
     * ------
     * 1110
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append((x + y + carry) % 10);
            carry = (carry + x + y) / 10;
        }
        return sb.reverse().toString();
    }

    /**
     * z
     *
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings__(String num1, String num2) {
        if (num1 == null || num2 == null)
            return null;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;

        while (l1 >= 0 || l2 >= 0) {
            int n1 = l1 >= 0 ? num1.charAt(l1) - '0' : 0;
            int n2 = l2 >= 0 ? num2.charAt(l2) - '0' : 0;
            int sum = n1 + n2 + carry;
            carry = sum > 9 ? 1 : 0;
            sb.insert(0, sum % 10);
            l1--;
            l2--;
        }
        if (carry == 1) {
            sb.insert(0, 1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("0101", "1009"));

    }
}
