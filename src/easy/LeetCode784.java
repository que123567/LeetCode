package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 784. Letter Case Permutation
 * .
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.
 * .
 * Examples:
 * Input: S = "a1b2"
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * .
 * Input: S = "3z4"
 * Output: ["3z4", "3Z4"]
 * .
 * Input: S = "12345"
 * Output: ["12345"]
 */
public class LeetCode784 {

    public static List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        bfs(res, S.toCharArray(), 0);
        return res;
    }

    public static void bfs(List<String> list, char[] chars, int index) {
        if (index == chars.length) {
            list.add(new String(chars));
        } else {
            if (Character.isLetter(chars[index])) {
                chars[index] = Character.toUpperCase(chars[index]);
                bfs(list, chars, index + 1);
                chars[index] = Character.toLowerCase(chars[index]);
            }
            bfs(list, chars, index + 1);
        }
    }

    public static void main(String[] args) {
        List<String> list = letterCasePermutation("a1b2");
        for (String i : list) {
            System.out.print(i + " ");
        }

    }
}
