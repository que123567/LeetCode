package medium;

/**
 * 947. Most Stones Removed with Same Row or Column
 * .
 * On a 2D plane, we place stones at some integer coordinate points.  Each coordinate point may have at most one stone.
 * .
 * Now, a move consists of removing a stone that shares a column or row with another stone on the grid.
 * .
 * What is the largest possible number of moves we can make?
 * .
 * .
 * .
 * Example 1:
 * .
 * Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
 * Output: 5
 * Example 2:
 * .
 * Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
 * Output: 3
 * Example 3:
 * .
 * Input: stones = [[0,0]]
 * Output: 0
 * .
 * .
 * Note:
 * .
 * 1 <= stones.length <= 1000
 * 0 <= stones[i][j] < 10000
 */
public class LeetCode947 {


//    static Map<Integer, Integer> f = new HashMap<>();
//    static int islands = 0;
//
//    /**
//     * UNION FIND
//     *
//     * @param stones
//     * @return
//     */
//    public static int removeStones(int[][] stones) {
//        for (int i = 0; i < stones.length; ++i)
//            union(stones[i][0], ~stones[i][1]);
//        return stones.length - islands;
//    }
//
//    public static int find(int x) {
//        if (f.putIfAbsent(x, x) == null)
//            islands++;
//        if (x != f.get(x))
//            f.put(x, find(f.get(x)));
//        return f.get(x);
//    }
//
//    public static void union(int x, int y) {
//        x = find(x);
//        y = find(y);
//        if (f.get(x) != y) {
//            f.put(find(x), find(y));
//            islands--;
//        }
//    }
//
//    public static void main(String[] args) {
//        int[][] stone = new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};
//        System.out.println(removeStones(stone));
//    }z
}
