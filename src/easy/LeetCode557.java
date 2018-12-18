package easy;

/**
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 * .
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
public class LeetCode557 {
    static public class Solution {
        static public String reverseWords(String s) {
            StringBuilder stringBuilder=new StringBuilder();
            String[] tmpStrings = new String[]{};
            tmpStrings = s.split(" ");

            for (int i = 0; i <tmpStrings.length; i++) {
               tmpStrings[i]=new StringBuilder(tmpStrings[i]).reverse().toString()+" ";
               stringBuilder.append(tmpStrings[i]);
            }
            return stringBuilder.toString().trim();
        }

        public static void main(String[] args) {
            System.out.println(Solution.reverseWords("Let's take LeetCode contest"));
        }
    }
}
