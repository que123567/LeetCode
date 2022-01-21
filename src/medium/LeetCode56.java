package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 
 *  
 * 
 * 示例 1:
 * 
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * 
 * 输入: intervals = [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 
 */
public class LeetCode56 {
    static class Solution {

        public static int[][] merge(int[][] intervals) {
            if (intervals.length == 0) {
                return new int[][]{};
            }
            Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

            int index = 0;
            int[][] finalInts = new int[intervals.length][2];
            finalInts[0] = intervals[0];
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0] <= finalInts[index][1]) {
                    //合并现有区间
                    finalInts[index][1] = Math.max(intervals[i][1], finalInts[index][1]);
                } else {
                    //追加
                    finalInts[++index] = intervals[i];
                }
            }
            return Arrays.copyOf(finalInts, index + 1);
        }


        public static void main(String[] args) {
            int[][] test1 = new int[][]{{1, 4}, {4, 5}};
            int[][] c = merge(test1);
            System.out.println(c[0][0]);
            System.out.println(c[0][1]);

        }
    }


}
