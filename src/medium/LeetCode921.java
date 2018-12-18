package medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 921. Minimum Add to Make Parentheses Valid
 * .
 * Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')', and in any positions ) so that the resulting parentheses string is valid.
 * .
 * Formally, a parentheses string is valid if and only if:
 * .
 * It is the empty string, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.
 */
public class LeetCode921 {

    /**
     * Loop through the input array.
     * .
     * if encounter '(', push '(' into stack;
     * otherwise, ')', check if there is a matching '(' on top of stack; if no, increase the counter by 1; if yes, pop it out;
     * after the loop, count in the un-matched characters remaining in the stack.
     * Method 1:
     * Time & space: O(n).
     */
    public static int minAddToMakeValid(String S) {
        Deque<Character> deque = new ArrayDeque<>();
        int count = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                deque.push(c);
            } else if (deque.isEmpty()) {
                ++count;
            } else {
                deque.pop();
            }
        }
        return count + deque.size();
    }

    public static void main(String[] args) {
        String a = "((()()";
        System.out.println(minAddToMakeValid(a));

    }
}
