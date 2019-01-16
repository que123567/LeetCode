package easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 859. Buddy Strings
 * '
 * Given two strings A and B of lowercase letters, return true if and only if we can swap two letters in A so that the result equals B.
 * '
 * Example 1:
 * '
 * Input: A = "ab", B = "ba"
 * Output: true
 * Example 2:
 * '
 * Input: A = "ab", B = "ab"
 * Output: false
 * Example 3:
 * '
 * Input: A = "aa", B = "aa"
 * Output: true
 * Example 4:
 * '
 * Input: A = "aaaaaaabc", B = "aaaaaaacb"
 * Output: true
 * Example 5:
 * '
 * Input: A = "", B = "aa"
 * Output: false
 * '
 * '
 * Note:
 * '
 * 0 <= A.length <= 20000
 * 0 <= B.length <= 20000
 * A and B consist only of lowercase letters.
 */
public class LeetCode859 {
    /**
     * version1
     *
     * @param A
     * @param B
     * @return
     */
    public static boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        if (A.equals(B)) {
            Set<Character> set = new HashSet<>();
            for (char c : A.toCharArray())
                set.add(c);
            return set.size() < A.length();
        }
        List<Integer> difList = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                difList.add(i);
            }
        }
        return difList.size() == 2 && A.charAt(difList.get(0)) == B.charAt(difList.get(1)) && A.charAt(difList.get(1)) == B.charAt(difList.get(0));
    }

    public static void main(String[] args) {
        System.out.println(buddyStrings("AB", "BA"));
        System.out.println(buddyStrings("AC", "CA"));
        System.out.println(buddyStrings("AAACC", "AACCC"));
    }
}
