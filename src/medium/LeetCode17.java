package medium;

import java.util.LinkedList;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
 * .
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * .
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * .
 * .
 * .
 * Example:
 * .
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * .
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class LeetCode17 {

    public static List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if (digits.isEmpty())
            return ans;
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        while (ans.peek().length() != digits.length()) {
            String remove = ans.removeFirst();
            String map = mapping[digits.charAt(remove.length()) - '0'];
            for (char c : map.toCharArray()) {
                ans.add(remove + c);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
