package medium;

/**
 * 搜寻名人
 */
public class LeetCode277 {
    static class Solution {
        // 可以直接调用，能够返回 i 是否认识 j
        boolean knows(int i, int j) {
            return false;
        }

        // 请你实现：返回「名人」的编号
        int findCelebrity(int n) {
            int cand = 0;
            for (int i = 1; i < n; i++) {
                if (knows(cand, i) || !knows(i, cand)) {
                    cand = i;
                }
            }

            for (int other = 0; other < n; other++) {
                if (cand != other) {
                    if (!knows(other, cand) || knows(cand, other)) {
                        return -1;
                    }
                }
            }
            return cand;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

    }
}
