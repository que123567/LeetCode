import java.util.HashSet;
import java.util.Set;

/**
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 * <p>
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * <p>
 * Note:
 * Assume the length of given string will not exceed 1,010.
 * <p>
 * Example:
 * <p>
 * Input:
 * "abccccdd"
 * <p>
 * Output:
 * 7
 * <p>
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 */

/**
 * 扫描出现偶数次的字符，一定可以组成回文
 * 最后统计出现奇数次的字符，作为中心字符 。在偶数统计的结果上+1
 */
public class LeetCode409 {
    static class Solution {
        public static int longestPalindrome(String s) {
            int palindromeConut = 0;
            Set<Character> resSet = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                if (resSet.contains(s.charAt(i))) {
                    resSet.remove(s.charAt(i));//下一轮统计，避免字符在出现3次的情况下，被记为出现4次
                    palindromeConut++;// 
                } else
                    resSet.add(s.charAt(i));
            }
            if (!resSet.isEmpty())//存在出现奇数次的字符
                return palindromeConut * 2 + 1;
            return palindromeConut * 2;
        }

        public static void main(String[] args) {
            String res = "";
            System.out.println(Solution.longestPalindrome(res));
        }
    }

}
