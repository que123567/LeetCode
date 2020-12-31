package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 寻找右区间
 * <p>
 * 给定一组区间，对于每一个区间 i，检查是否存在一个区间 j，它的起始点大于或等于区间 i 的终点，这可以称为 j 在 i 的“右侧”。
 * <p>
 * 对于任何区间，你需要存储的满足条件的区间 j 的最小索引，这意味着区间 j 有最小的起始点可以使其成为“右侧”区间。如果区间 j 不存在，则将区间 i 存储为 -1。最后，你需要输出一个值为存储的区间值的数组。
 * <p>
 * 注意:
 * <p>
 * 你可以假设区间的终点总是大于它的起始点。
 * 你可以假定这些区间都不具有相同的起始点。
 * 示例 1:
 * <p>
 * 输入: [ [1,2] ]
 * 输出: [-1]
 * <p>
 * 解释:集合中只有一个区间，所以输出-1。
 * 示例 2:
 * <p>
 * 输入: [ [3,4], [2,3], [1,2] ]
 * 输出: [-1, 0, 1]
 * <p>
 * 解释:对于[3,4]，没有满足条件的“右侧”区间。
 * 对于[2,3]，区间[3,4]具有最小的“右”起点;
 * 对于[1,2]，区间[2,3]具有最小的“右”起点。
 * 示例 3:
 * <p>
 * 输入: [ [1,4], [2,3], [3,4] ]
 * 输出: [-1, 2, -1]
 * <p>
 * 解释:对于区间[1,4]和[3,4]，没有满足条件的“右侧”区间。
 * 对于[2,3]，区间[3,4]有最小的“右”起点。
 * <p>
 */
public class LeetCode436 {


    static class Solution {
        public static int[] findRightInterval(int[][] intervals) {
            if (intervals.length == 0) {
                return new int[0];
            }
            Map<int[], Integer> map = new HashMap<>();
            int[] res = new int[intervals.length];
            for (int i = 0; i < intervals.length; i++) {
                map.put(intervals[i], i);
            }
            Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
            for (int i = 0; i < intervals.length; i++) {
                int minIndex = -1;
                for (int j = i + 1; j < intervals.length; j++) {
                    //右侧
                    if (intervals[j][0] >= intervals[i][1]) {
                        minIndex = map.get(intervals[j]);
                        break;
                    }
                }
                res[map.get(intervals[i])] = minIndex;
            }
            return res;
        }

        public static void main(String[] args) {
            int[][] test1 = new int[][]{{3, 4}, {2, 3}, {1, 2}};
            int[] a = findRightInterval(test1);
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }
    }
}
