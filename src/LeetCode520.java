/**
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 * <p>
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 * <p>
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital if it has more than one letter, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 * Example 1:
 * Input: "USA"
 * Output: True
 * Example 2:
 * Input: "FlaG"
 * Output: False
 */
public class LeetCode520 {
    static class Solution {
        public static boolean detectCapitalUse(String word) {
            int upperCaseCount = 0;
            for (int i = 0; i < word.length(); i++) {
                if (Character.isUpperCase(word.charAt(i))) {
                    upperCaseCount++;
                }
            }
            if (upperCaseCount == 1 && !Character.isUpperCase(word.charAt(0))) {
                upperCaseCount = -1;
            }
            return ((upperCaseCount == word.length()) || upperCaseCount == 1 ||upperCaseCount==0);
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.detectCapitalUse("g"));
    }
}
