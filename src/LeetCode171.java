/**
 * 171. Excel Sheet Column Number
 * <p>
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * <p>
 * For example:
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * Example 1:
 * <p>
 * Input: "A"
 * Output: 1
 * Example 2:
 * <p>
 * Input: "AB"
 * Output: 28
 * Example 3:
 * <p>
 * Input: "ZY"
 * Output: 701
 */
public class LeetCode171 {
    /**
     * @param s
     * @return
     */
    public static int titleToNumber(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result = result * 26;
            result += (s.charAt(i) - 'A' + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("ZY"));

    }
}
