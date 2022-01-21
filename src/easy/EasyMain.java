package easy;

import java.util.LinkedList;
import java.util.List;

public class EasyMain {
    static class Solution1 {
        List<List<Integer>> res = new LinkedList<>();

        /* 主函数，输入一组不重复的数字，返回它们的全排列 */
        List<List<Integer>> permute(int[] nums) {
            // 记录「路径」
            LinkedList<Integer> track = new LinkedList<>();
            backTrack(nums, track);
            return res;
        }


        void backTrack(int[] nums, LinkedList<Integer> track) {
            if (track.size() == nums.length) {
                res.add(new LinkedList<>(track));
            } else {
                for (int num : nums) {
                    if (track.contains(num)) {
                        continue;
                    }
                    track.add(num);
                    backTrack(nums, track);
                    track.removeLast();
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        List<List<Integer>> res = solution1.permute(new int[]{1, 2, 3});
        int i = 1;
    }
}

