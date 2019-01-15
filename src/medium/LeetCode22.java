package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 * '
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * '
 * For example, given n = 3, a solution set is:
 * '
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class LeetCode22 {

    /**
     * BackTrack
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> stringList = new ArrayList<>();
        backTrack(stringList, "", 0, 0, n);
        return stringList;
    }

    public void backTrack(List<String> list, String str, int open, int close, int max) {
        if (str.length() == max * 2) {
            list.add(str);
            return;
        }
        if (open < max) {
            backTrack(list, str + "(", open + 1, close, max);
        }
        if (close < open) {//右括号数量要小于左括号,否则出现类似"())""的答案
            backTrack(list, str + ")", open, close + 1, max);
        }
    }

    /**
     * For 2, it should place one "()" and add another one insert it but none tail it,
     * '
     * '(' f(1) ')' f(0)
     * '
     * or add none insert it but tail it by another one,
     * '
     * '(' f(0) ')' f(1)
     * '
     * Thus for n, we can insert f(i) and tail f(j) and i+j=n-1,
     * '
     * '(' f(i) ')' f(j)
     */
    static class Solution2 {
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<String>();
            if (n == 0) {
                result.add("");
            } else {
                for (int i = n - 1; i >= 0; i--) {
                    List<String> insertSub = generateParenthesis(i);
                    List<String> tailSub = generateParenthesis(n - 1 - i);
                    for (String insert : insertSub) {
                        for (String tail : tailSub) {
                            System.out.println(insert + "-" + tail);
                            result.add("(" + insert + ")" + tail);
                        }
                    }

                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        LeetCode22 solution = new LeetCode22();
        var s = solution.generateParenthesis(3);
        for (String i : s) {
            System.out.println(i);
        }

    }
}
