package medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 994. 腐烂的橘子(https://leetcode.cn/problems/rotting-oranges/)
 * <p>
 * 1.https://leetcode.cn/problems/rotting-oranges/solutions/124765/fu-lan-de-ju-zi-by-leetcode-solution/
 * 2.https://leetcode.cn/problems/rotting-oranges/solutions/129831/li-qing-si-lu-wei-shi-yao-yong-bfsyi-ji-ru-he-xie-/
 * <p>
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 * <p>
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 * <p>
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
 * 示例 3：
 * <p>
 * <p>
 * 输入：grid = [[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 10
 * grid[i][j] 仅为 0、1 或 2
 */
public class LeetCode994 {


    //1->fresh 2->ditry
    static class Solution {
        public int orangesRotting(int[][] grid) {
            int M = grid.length;
            int N = grid[0].length;
            int freshCount = 0;
            Queue<int[]> queue = new LinkedList<>();

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (grid[i][j] == 1) {
                        freshCount++;
                    } else if (grid[i][j] == 2) {
                        queue.add(new int[]{i, j});
                    }
                }
            }

            int minute = 0;
            while (!queue.isEmpty() && freshCount > 0) {
                int n = queue.size();
                minute += 1;
                for (int i = 0; i < n; i++) {
                    int[][] next = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
                    int[] orange = queue.poll();
                    for (int[] orientation : next) {
                        int x = orange[0] + orientation[0];
                        int y = orange[1] + orientation[1];
                        if (x >= 0 && y >= 0 && x < M && y < N) {
                            if (grid[x][y] == 1) {
                                grid[x][y] = 2;
                                freshCount--;
                                queue.add(new int[]{x, y});
                            }
                        }
                    }
                }
            }
            return freshCount > 0 ? -1 : minute;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr1 = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int res = solution.orangesRotting(arr1);
        System.out.println(res);
    }
}
