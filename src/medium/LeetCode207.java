package medium;

import java.util.LinkedList;
import java.util.List;

/**
 * 207.课程表
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * 
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 */
public class LeetCode207 {
    static class Solution {

        boolean[] visited;
        boolean[] onPath;
        boolean hasCycle ;

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            List<Integer>[] graph = buildGraph(numCourses, prerequisites);

            visited = new boolean[numCourses];
            onPath = new boolean[numCourses];

            for (int i = 0; i < numCourses; i++) {
                traverse(graph, i);
            }

            return !hasCycle;
        }

        List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
            hasCycle = false;
            List<Integer>[] graph = new LinkedList[numCourses];
            for (int i = 0; i < numCourses; i++) {
                graph[i] = new LinkedList<>();
            }
            for (int[] edge : prerequisites) {
                int from = edge[1];
                int to = edge[0];
                graph[from].add(to);
            }
            return graph;
        }

        public void traverse(List<Integer>[] graph, int s) {
            if (onPath[s]) {
                hasCycle = true;
            }
            if (hasCycle || visited[s]) {
                return;
            }
            visited[s] = true;
            onPath[s] = true;
            for (int t : graph[s]) {
                traverse(graph, t);
            }
            onPath[s] = false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] array1 = new int[][]{{1, 0}, {0, 1}};
        int[][] array2 = new int[][]{{1, 0}};
        boolean res1 = solution.canFinish(2, array1);
        boolean res2 = solution.canFinish(2, array2);
        System.out.println(res1);
        System.out.println(res2);
    }
}
