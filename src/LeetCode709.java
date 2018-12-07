/**
 * 709. To Lower Case
 * <p>
 * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "Hello"
 * Output: "hello"
 * Example 2:
 * <p>
 * Input: "here"
 * Output: "here"
 * Example 3:
 * <p>
 * Input: "LOVELY"
 * Output: "lovely"
 */
public class LeetCode709 {
    /**
     * @param str
     * @return
     */
    public static String toLowerCase(String str) {
        return str.toLowerCase();
    }

    /**
     * 65~90 A-Z
     * 97~122 a-z
     * @param str
     * @return
     */
    public static String toLowerCase_(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c >= 65 && c <= 90) {
                sb.append(Character.toChars(c - 'A' + 'a'));
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(toLowerCase_("Hello"));
        System.out.println(toLowerCase_("aBC"));
    }
}
