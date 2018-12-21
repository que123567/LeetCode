package easy;

/**
 * 917. Reverse Only Letters
 * .
 * Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.
 * .
 * .
 * .
 * Example 1:
 * .
 * Input: "ab-cd"
 * Output: "dc-ba"
 * Example 2:
 * .
 * Input: "a-bC-dEf-ghIj"
 * Output: "j-Ih-gfE-dCba"
 * Example 3:
 * .
 * Input: "Test1ng-Leet=code-Q!"
 * Output: "Qedo1ct-eeLg=ntse-T!"
 * .
 * .
 * Note:
 * .
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122
 * S doesn't contain \ or "
 */
public class LeetCode917 {

    /**
     * judge and swap
     * @param S
     * @return
     */
    public static String reverseOnlyLetters(String S) {
        StringBuilder sb = new StringBuilder(S);
        for (int i = 0, j = S.length() - 1; i < j; i++, j--) {
            while (i < j && !Character.isLetter(S.charAt(i)))
                ++i;
            while (i < j && !Character.isLetter(S.charAt(j)))
                --j;
            char oldChar = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, oldChar);
        }
        return sb.toString();
    }

    /**
     * reverse Character and insert
     * @param S
     * @return
     */
    public String reverseOnlyLetters_version2(String S) {
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (Character.isLetter(c))
                sb.append(c);
        }
        sb.reverse();
        for (int i = 0; i < S.length(); ++i) {
            if (!Character.isLetter(S.charAt(i)))
                sb.insert(i, S.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("a-bC-dEf-ghIj"));
    }
}
