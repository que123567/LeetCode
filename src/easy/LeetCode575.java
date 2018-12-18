package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array with even length, where different numbers in this array represent different kinds of candies. Each number means one candy of the corresponding kind. You need to distribute these candies equally in number to brother and sister. Return the maximum number of kinds of candies the sister could gain.
 * .
 * Example 1:
 * Input: candies = [1,1,2,2,3,3]
 * Output: 3
 * Explanation:
 * There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
 * Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too.
 * The sister has three different kinds of candies.
 * Example 2:
 * Input: candies = [1,1,2,3]
 * Output: 2
 * Explanation: For example, the sister has candies [2,3] and the brother has candies [1,1].
 * The sister has two different kinds of candies, the brother has only one kind of candies.
 * Note:
 * .
 * The length of the given array is in range [2, 10,000], and will be even.
 * The number in given array is in range [-100,000, 100,000].
 */
public class LeetCode575 {
    static class Solution {
        public static int distributeCandies(int[] candies) {
            Set<Integer> kindsOfCandies = new HashSet<>();
            for (int i : candies)
                kindsOfCandies.add(i);
            return kindsOfCandies.size() >= candies.length / 2 ? candies.length/2 :kindsOfCandies.size();
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.distributeCandies(new int[]{1, 1, 2, 2, 3, 3}));
    }
}
